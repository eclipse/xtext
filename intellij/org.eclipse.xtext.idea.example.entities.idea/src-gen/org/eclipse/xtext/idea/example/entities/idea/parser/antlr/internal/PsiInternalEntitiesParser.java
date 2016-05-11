package org.eclipse.xtext.idea.example.entities.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.idea.example.entities.services.EntitiesGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
@SuppressWarnings("all")
public class PsiInternalEntitiesParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'entity'", "'extends'", "':'", "'op'", "'('", "','", "')'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'<'", "'>'", "'>='", "'||'", "'&&'", "'=='", "'!='", "'==='", "'!=='", "'instanceof'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'++'", "'--'", "'.'", "'::'", "'?.'", "'#'", "'['", "']'", "'|'", "';'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'static'", "'import'", "'extension'", "'super'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'synchronized'", "'catch'", "'?'", "'&'"
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
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__85=85;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
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
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

    // delegates
    // delegators


        public PsiInternalEntitiesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEntitiesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEntitiesParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalEntities.g"; }



    	protected EntitiesGrammarAccess grammarAccess;

    	protected EntitiesElementTypeProvider elementTypeProvider;

    	public PsiInternalEntitiesParser(PsiBuilder builder, TokenStream input, EntitiesElementTypeProvider elementTypeProvider, EntitiesGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
    		this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Entities";
    	}




    // $ANTLR start "entryRuleEntities"
    // PsiInternalEntities.g:56:1: entryRuleEntities returns [Boolean current=false] : iv_ruleEntities= ruleEntities EOF ;
    public final Boolean entryRuleEntities() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntities = null;


        try {
            // PsiInternalEntities.g:56:50: (iv_ruleEntities= ruleEntities EOF )
            // PsiInternalEntities.g:57:2: iv_ruleEntities= ruleEntities EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getEntitiesElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEntities=ruleEntities();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntities; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEntities"


    // $ANTLR start "ruleEntities"
    // PsiInternalEntities.g:63:1: ruleEntities returns [Boolean current=false] : ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleAbstractElement ) )* ) ;
    public final Boolean ruleEntities() throws RecognitionException {
        Boolean current = false;

        Boolean lv_importSection_0_0 = null;

        Boolean lv_elements_1_0 = null;


        try {
            // PsiInternalEntities.g:64:1: ( ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleAbstractElement ) )* ) )
            // PsiInternalEntities.g:65:2: ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleAbstractElement ) )* )
            {
            // PsiInternalEntities.g:65:2: ( ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleAbstractElement ) )* )
            // PsiInternalEntities.g:66:3: ( (lv_importSection_0_0= ruleXImportSection ) )? ( (lv_elements_1_0= ruleAbstractElement ) )*
            {
            // PsiInternalEntities.g:66:3: ( (lv_importSection_0_0= ruleXImportSection ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==74) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalEntities.g:67:4: (lv_importSection_0_0= ruleXImportSection )
                    {
                    // PsiInternalEntities.g:67:4: (lv_importSection_0_0= ruleXImportSection )
                    // PsiInternalEntities.g:68:5: lv_importSection_0_0= ruleXImportSection
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getEntities_ImportSectionXImportSectionParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_3);
                    lv_importSection_0_0=ruleXImportSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalEntities.g:81:3: ( (lv_elements_1_0= ruleAbstractElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13||LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalEntities.g:82:4: (lv_elements_1_0= ruleAbstractElement )
            	    {
            	    // PsiInternalEntities.g:82:4: (lv_elements_1_0= ruleAbstractElement )
            	    // PsiInternalEntities.g:83:5: lv_elements_1_0= ruleAbstractElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getEntities_ElementsAbstractElementParserRuleCall_1_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_elements_1_0=ruleAbstractElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break loop2;
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
    // $ANTLR end "ruleEntities"


    // $ANTLR start "entryRuleAbstractElement"
    // PsiInternalEntities.g:100:1: entryRuleAbstractElement returns [Boolean current=false] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final Boolean entryRuleAbstractElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractElement = null;


        try {
            // PsiInternalEntities.g:100:57: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // PsiInternalEntities.g:101:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAbstractElementElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // PsiInternalEntities.g:107:1: ruleAbstractElement returns [Boolean current=false] : (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity ) ;
    public final Boolean ruleAbstractElement() throws RecognitionException {
        Boolean current = false;

        Boolean this_PackageDeclaration_0 = null;

        Boolean this_Entity_1 = null;


        try {
            // PsiInternalEntities.g:108:1: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity ) )
            // PsiInternalEntities.g:109:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity )
            {
            // PsiInternalEntities.g:109:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_Entity_1= ruleEntity )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalEntities.g:110:3: this_PackageDeclaration_0= rulePackageDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getAbstractElement_PackageDeclarationParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PackageDeclaration_0=rulePackageDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PackageDeclaration_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:119:3: this_Entity_1= ruleEntity
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getAbstractElement_EntityParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Entity_1=ruleEntity();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Entity_1;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRulePackageDeclaration"
    // PsiInternalEntities.g:131:1: entryRulePackageDeclaration returns [Boolean current=false] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final Boolean entryRulePackageDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePackageDeclaration = null;


        try {
            // PsiInternalEntities.g:131:60: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // PsiInternalEntities.g:132:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPackageDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackageDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // PsiInternalEntities.g:138:1: rulePackageDeclaration returns [Boolean current=false] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) ;
    public final Boolean rulePackageDeclaration() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_name_1_0 = null;

        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalEntities.g:139:1: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) )
            // PsiInternalEntities.g:140:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            {
            // PsiInternalEntities.g:140:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            // PsiInternalEntities.g:141:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getPackageDeclaration_PackageKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:148:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // PsiInternalEntities.g:149:4: (lv_name_1_0= ruleQualifiedName )
            {
            // PsiInternalEntities.g:149:4: (lv_name_1_0= ruleQualifiedName )
            // PsiInternalEntities.g:150:5: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPackageDeclaration_NameQualifiedNameParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getPackageDeclaration_LeftCurlyBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:170:3: ( (lv_elements_3_0= ruleAbstractElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13||LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalEntities.g:171:4: (lv_elements_3_0= ruleAbstractElement )
            	    {
            	    // PsiInternalEntities.g:171:4: (lv_elements_3_0= ruleAbstractElement )
            	    // PsiInternalEntities.g:172:5: lv_elements_3_0= ruleAbstractElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getPackageDeclaration_ElementsAbstractElementParserRuleCall_3_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_elements_3_0=ruleAbstractElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break loop4;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getPackageDeclaration_RightCurlyBracketKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
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
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleEntity"
    // PsiInternalEntities.g:196:1: entryRuleEntity returns [Boolean current=false] : iv_ruleEntity= ruleEntity EOF ;
    public final Boolean entryRuleEntity() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntity = null;


        try {
            // PsiInternalEntities.g:196:48: (iv_ruleEntity= ruleEntity EOF )
            // PsiInternalEntities.g:197:2: iv_ruleEntity= ruleEntity EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getEntityElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntity; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // PsiInternalEntities.g:203:1: ruleEntity returns [Boolean current=false] : (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' ) ;
    public final Boolean ruleEntity() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_name_1_0 = null;

        Boolean lv_superType_3_0 = null;

        Boolean lv_features_5_0 = null;


        try {
            // PsiInternalEntities.g:204:1: ( (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' ) )
            // PsiInternalEntities.g:205:2: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' )
            {
            // PsiInternalEntities.g:205:2: (otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}' )
            // PsiInternalEntities.g:206:3: otherlv_0= 'entity' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )? otherlv_4= '{' ( (lv_features_5_0= ruleFeature ) )* otherlv_6= '}'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getEntity_EntityKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:213:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalEntities.g:214:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalEntities.g:214:4: (lv_name_1_0= ruleValidID )
            // PsiInternalEntities.g:215:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getEntity_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalEntities.g:228:3: (otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalEntities.g:229:4: otherlv_2= 'extends' ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getEntity_ExtendsKeyword_2_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    // PsiInternalEntities.g:236:4: ( (lv_superType_3_0= ruleJvmParameterizedTypeReference ) )
                    // PsiInternalEntities.g:237:5: (lv_superType_3_0= ruleJvmParameterizedTypeReference )
                    {
                    // PsiInternalEntities.g:237:5: (lv_superType_3_0= ruleJvmParameterizedTypeReference )
                    // PsiInternalEntities.g:238:6: lv_superType_3_0= ruleJvmParameterizedTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getEntity_SuperTypeJvmParameterizedTypeReferenceParserRuleCall_2_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_5);
                    lv_superType_3_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getEntity_LeftCurlyBracketKeyword_3ElementType());
              		
            }
            otherlv_4=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalEntities.g:259:3: ( (lv_features_5_0= ruleFeature ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalEntities.g:260:4: (lv_features_5_0= ruleFeature )
            	    {
            	    // PsiInternalEntities.g:260:4: (lv_features_5_0= ruleFeature )
            	    // PsiInternalEntities.g:261:5: lv_features_5_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getEntity_FeaturesFeatureParserRuleCall_4_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_features_5_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break loop6;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getEntity_RightCurlyBracketKeyword_5ElementType());
              		
            }
            otherlv_6=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleFeature"
    // PsiInternalEntities.g:285:1: entryRuleFeature returns [Boolean current=false] : iv_ruleFeature= ruleFeature EOF ;
    public final Boolean entryRuleFeature() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFeature = null;


        try {
            // PsiInternalEntities.g:285:49: (iv_ruleFeature= ruleFeature EOF )
            // PsiInternalEntities.g:286:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // PsiInternalEntities.g:292:1: ruleFeature returns [Boolean current=false] : (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) ;
    public final Boolean ruleFeature() throws RecognitionException {
        Boolean current = false;

        Boolean this_Property_0 = null;

        Boolean this_Operation_1 = null;


        try {
            // PsiInternalEntities.g:293:1: ( (this_Property_0= ruleProperty | this_Operation_1= ruleOperation ) )
            // PsiInternalEntities.g:294:2: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            {
            // PsiInternalEntities.g:294:2: (this_Property_0= ruleProperty | this_Operation_1= ruleOperation )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
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
                    // PsiInternalEntities.g:295:3: this_Property_0= ruleProperty
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFeature_PropertyParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Property_0=ruleProperty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Property_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:304:3: this_Operation_1= ruleOperation
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFeature_OperationParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Operation_1=ruleOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Operation_1;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleProperty"
    // PsiInternalEntities.g:316:1: entryRuleProperty returns [Boolean current=false] : iv_ruleProperty= ruleProperty EOF ;
    public final Boolean entryRuleProperty() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleProperty = null;


        try {
            // PsiInternalEntities.g:316:50: (iv_ruleProperty= ruleProperty EOF )
            // PsiInternalEntities.g:317:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPropertyElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // PsiInternalEntities.g:323:1: ruleProperty returns [Boolean current=false] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleProperty() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_name_0_0 = null;

        Boolean lv_type_2_0 = null;


        try {
            // PsiInternalEntities.g:324:1: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalEntities.g:325:2: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalEntities.g:325:2: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) ) )
            // PsiInternalEntities.g:326:3: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleJvmTypeReference ) )
            {
            // PsiInternalEntities.g:326:3: ( (lv_name_0_0= ruleValidID ) )
            // PsiInternalEntities.g:327:4: (lv_name_0_0= ruleValidID )
            {
            // PsiInternalEntities.g:327:4: (lv_name_0_0= ruleValidID )
            // PsiInternalEntities.g:328:5: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getProperty_NameValidIDParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_9);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getProperty_ColonKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:348:3: ( (lv_type_2_0= ruleJvmTypeReference ) )
            // PsiInternalEntities.g:349:4: (lv_type_2_0= ruleJvmTypeReference )
            {
            // PsiInternalEntities.g:349:4: (lv_type_2_0= ruleJvmTypeReference )
            // PsiInternalEntities.g:350:5: lv_type_2_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getProperty_TypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleOperation"
    // PsiInternalEntities.g:367:1: entryRuleOperation returns [Boolean current=false] : iv_ruleOperation= ruleOperation EOF ;
    public final Boolean entryRuleOperation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOperation = null;


        try {
            // PsiInternalEntities.g:367:51: (iv_ruleOperation= ruleOperation EOF )
            // PsiInternalEntities.g:368:2: iv_ruleOperation= ruleOperation EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOperationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // PsiInternalEntities.g:374:1: ruleOperation returns [Boolean current=false] : (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) )? ( (lv_body_9_0= ruleXBlockExpression ) ) ) ;
    public final Boolean ruleOperation() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Boolean lv_name_1_0 = null;

        Boolean lv_params_3_0 = null;

        Boolean lv_params_5_0 = null;

        Boolean lv_type_8_0 = null;

        Boolean lv_body_9_0 = null;


        try {
            // PsiInternalEntities.g:375:1: ( (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) )? ( (lv_body_9_0= ruleXBlockExpression ) ) ) )
            // PsiInternalEntities.g:376:2: (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) )? ( (lv_body_9_0= ruleXBlockExpression ) ) )
            {
            // PsiInternalEntities.g:376:2: (otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) )? ( (lv_body_9_0= ruleXBlockExpression ) ) )
            // PsiInternalEntities.g:377:3: otherlv_0= 'op' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) )? ( (lv_body_9_0= ruleXBlockExpression ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperation_OpKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:384:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalEntities.g:385:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalEntities.g:385:4: (lv_name_1_0= ruleValidID )
            // PsiInternalEntities.g:386:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getOperation_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_11);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperation_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,20,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:406:3: ( ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||LA9_0==20||LA9_0==42) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalEntities.g:407:4: ( (lv_params_3_0= ruleFullJvmFormalParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )*
                    {
                    // PsiInternalEntities.g:407:4: ( (lv_params_3_0= ruleFullJvmFormalParameter ) )
                    // PsiInternalEntities.g:408:5: (lv_params_3_0= ruleFullJvmFormalParameter )
                    {
                    // PsiInternalEntities.g:408:5: (lv_params_3_0= ruleFullJvmFormalParameter )
                    // PsiInternalEntities.g:409:6: lv_params_3_0= ruleFullJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getOperation_ParamsFullJvmFormalParameterParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_params_3_0=ruleFullJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:422:4: (otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==21) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // PsiInternalEntities.g:423:5: otherlv_4= ',' ( (lv_params_5_0= ruleFullJvmFormalParameter ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getOperation_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:430:5: ( (lv_params_5_0= ruleFullJvmFormalParameter ) )
                    	    // PsiInternalEntities.g:431:6: (lv_params_5_0= ruleFullJvmFormalParameter )
                    	    {
                    	    // PsiInternalEntities.g:431:6: (lv_params_5_0= ruleFullJvmFormalParameter )
                    	    // PsiInternalEntities.g:432:7: lv_params_5_0= ruleFullJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getOperation_ParamsFullJvmFormalParameterParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    lv_params_5_0=ruleFullJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperation_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_6=(Token)match(input,22,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
            }
            // PsiInternalEntities.g:454:3: (otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalEntities.g:455:4: otherlv_7= ':' ( (lv_type_8_0= ruleJvmTypeReference ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOperation_ColonKeyword_5_0ElementType());
                      			
                    }
                    otherlv_7=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_7);
                      			
                    }
                    // PsiInternalEntities.g:462:4: ( (lv_type_8_0= ruleJvmTypeReference ) )
                    // PsiInternalEntities.g:463:5: (lv_type_8_0= ruleJvmTypeReference )
                    {
                    // PsiInternalEntities.g:463:5: (lv_type_8_0= ruleJvmTypeReference )
                    // PsiInternalEntities.g:464:6: lv_type_8_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getOperation_TypeJvmTypeReferenceParserRuleCall_5_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_type_8_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalEntities.g:478:3: ( (lv_body_9_0= ruleXBlockExpression ) )
            // PsiInternalEntities.g:479:4: (lv_body_9_0= ruleXBlockExpression )
            {
            // PsiInternalEntities.g:479:4: (lv_body_9_0= ruleXBlockExpression )
            // PsiInternalEntities.g:480:5: lv_body_9_0= ruleXBlockExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getOperation_BodyXBlockExpressionParserRuleCall_6_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_9_0=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleXExpression"
    // PsiInternalEntities.g:497:1: entryRuleXExpression returns [Boolean current=false] : iv_ruleXExpression= ruleXExpression EOF ;
    public final Boolean entryRuleXExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXExpression = null;


        try {
            // PsiInternalEntities.g:497:53: (iv_ruleXExpression= ruleXExpression EOF )
            // PsiInternalEntities.g:498:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // PsiInternalEntities.g:504:1: ruleXExpression returns [Boolean current=false] : this_XAssignment_0= ruleXAssignment ;
    public final Boolean ruleXExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XAssignment_0 = null;


        try {
            // PsiInternalEntities.g:505:1: (this_XAssignment_0= ruleXAssignment )
            // PsiInternalEntities.g:506:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getXExpression_XAssignmentParserRuleCallElementType());
              	
            }
            pushFollow(FOLLOW_2);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_XAssignment_0;
              		doneComposite();
              	
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
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // PsiInternalEntities.g:517:1: entryRuleXAssignment returns [Boolean current=false] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final Boolean entryRuleXAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXAssignment = null;


        try {
            // PsiInternalEntities.g:517:53: (iv_ruleXAssignment= ruleXAssignment EOF )
            // PsiInternalEntities.g:518:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAssignmentElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // PsiInternalEntities.g:524:1: ruleXAssignment returns [Boolean current=false] : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final Boolean ruleXAssignment() throws RecognitionException {
        Boolean current = false;

        Boolean lv_value_3_0 = null;

        Boolean this_XOrExpression_4 = null;

        Boolean lv_rightOperand_7_0 = null;


        try {
            // PsiInternalEntities.g:525:1: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // PsiInternalEntities.g:526:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // PsiInternalEntities.g:526:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt12=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==EOF||(LA12_1>=RULE_STRING && LA12_1<=RULE_ID)||(LA12_1>=14 && LA12_1<=15)||(LA12_1>=17 && LA12_1<=18)||(LA12_1>=20 && LA12_1<=22)||(LA12_1>=24 && LA12_1<=60)||(LA12_1>=62 && LA12_1<=87)) ) {
                    alt12=2;
                }
                else if ( (LA12_1==23) ) {
                    alt12=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==EOF||(LA12_2>=RULE_STRING && LA12_2<=RULE_ID)||(LA12_2>=14 && LA12_2<=15)||(LA12_2>=17 && LA12_2<=18)||(LA12_2>=20 && LA12_2<=22)||(LA12_2>=24 && LA12_2<=60)||(LA12_2>=62 && LA12_2<=87)) ) {
                    alt12=2;
                }
                else if ( (LA12_2==23) ) {
                    alt12=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                int LA12_3 = input.LA(2);

                if ( (LA12_3==23) ) {
                    alt12=1;
                }
                else if ( (LA12_3==EOF||(LA12_3>=RULE_STRING && LA12_3<=RULE_ID)||(LA12_3>=14 && LA12_3<=15)||(LA12_3>=17 && LA12_3<=18)||(LA12_3>=20 && LA12_3<=22)||(LA12_3>=24 && LA12_3<=60)||(LA12_3>=62 && LA12_3<=87)) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;
                }
                }
                break;
            case 74:
                {
                int LA12_4 = input.LA(2);

                if ( (LA12_4==23) ) {
                    alt12=1;
                }
                else if ( (LA12_4==EOF||(LA12_4>=RULE_STRING && LA12_4<=RULE_ID)||(LA12_4>=14 && LA12_4<=15)||(LA12_4>=17 && LA12_4<=18)||(LA12_4>=20 && LA12_4<=22)||(LA12_4>=24 && LA12_4<=60)||(LA12_4>=62 && LA12_4<=87)) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 4, input);

                    throw nvae;
                }
                }
                break;
            case 75:
                {
                int LA12_5 = input.LA(2);

                if ( (LA12_5==EOF||(LA12_5>=RULE_STRING && LA12_5<=RULE_ID)||(LA12_5>=14 && LA12_5<=15)||(LA12_5>=17 && LA12_5<=18)||(LA12_5>=20 && LA12_5<=22)||(LA12_5>=24 && LA12_5<=60)||(LA12_5>=62 && LA12_5<=87)) ) {
                    alt12=2;
                }
                else if ( (LA12_5==23) ) {
                    alt12=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case 14:
            case 20:
            case 29:
            case 45:
            case 46:
            case 51:
            case 58:
            case 59:
            case 63:
            case 65:
            case 68:
            case 69:
            case 70:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 86:
                {
                alt12=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // PsiInternalEntities.g:527:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // PsiInternalEntities.g:527:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // PsiInternalEntities.g:528:4: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // PsiInternalEntities.g:528:4: ()
                    // PsiInternalEntities.g:529:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getXAssignment_XAssignmentAction_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalEntities.g:535:4: ( ( ruleFeatureCallID ) )
                    // PsiInternalEntities.g:536:5: ( ruleFeatureCallID )
                    {
                    // PsiInternalEntities.g:536:5: ( ruleFeatureCallID )
                    // PsiInternalEntities.g:537:6: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_15);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXAssignment_OpSingleAssignParserRuleCall_0_2ElementType());
                      			
                    }
                    pushFollow(FOLLOW_16);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalEntities.g:559:4: ( (lv_value_3_0= ruleXAssignment ) )
                    // PsiInternalEntities.g:560:5: (lv_value_3_0= ruleXAssignment )
                    {
                    // PsiInternalEntities.g:560:5: (lv_value_3_0= ruleXAssignment )
                    // PsiInternalEntities.g:561:6: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXAssignment_ValueXAssignmentParserRuleCall_0_3_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:576:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // PsiInternalEntities.g:576:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // PsiInternalEntities.g:577:4: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXAssignment_XOrExpressionParserRuleCall_1_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_17);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XOrExpression_4;
                      				doneComposite();
                      			
                    }
                    // PsiInternalEntities.g:585:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt11=2;
                    alt11 = dfa11.predict(input);
                    switch (alt11) {
                        case 1 :
                            // PsiInternalEntities.g:586:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // PsiInternalEntities.g:586:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // PsiInternalEntities.g:587:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // PsiInternalEntities.g:597:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // PsiInternalEntities.g:598:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // PsiInternalEntities.g:598:7: ()
                            // PsiInternalEntities.g:599:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								precedeComposite(elementTypeProvider.getXAssignment_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
                              								doneComposite();
                              								associateWithSemanticElement();
                              							
                            }

                            }

                            // PsiInternalEntities.g:605:7: ( ( ruleOpMultiAssign ) )
                            // PsiInternalEntities.g:606:8: ( ruleOpMultiAssign )
                            {
                            // PsiInternalEntities.g:606:8: ( ruleOpMultiAssign )
                            // PsiInternalEntities.g:607:9: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              									if (!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getXAssignment_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
                              								
                            }
                            pushFollow(FOLLOW_16);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }


                            }


                            }

                            // PsiInternalEntities.g:624:5: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // PsiInternalEntities.g:625:6: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // PsiInternalEntities.g:625:6: (lv_rightOperand_7_0= ruleXAssignment )
                            // PsiInternalEntities.g:626:7: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXAssignment_RightOperandXAssignmentParserRuleCall_1_1_1_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // PsiInternalEntities.g:645:1: entryRuleOpSingleAssign returns [Boolean current=false] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final Boolean entryRuleOpSingleAssign() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpSingleAssign = null;


        try {
            // PsiInternalEntities.g:645:56: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // PsiInternalEntities.g:646:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpSingleAssignElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // PsiInternalEntities.g:652:1: ruleOpSingleAssign returns [Boolean current=false] : kw= '=' ;
    public final Boolean ruleOpSingleAssign() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:653:1: (kw= '=' )
            // PsiInternalEntities.g:654:2: kw= '='
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpSingleAssign_EqualsSignKeywordElementType());
              	
            }
            kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(kw);
              	
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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // PsiInternalEntities.g:664:1: entryRuleOpMultiAssign returns [Boolean current=false] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final Boolean entryRuleOpMultiAssign() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpMultiAssign = null;


        try {
            // PsiInternalEntities.g:664:55: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // PsiInternalEntities.g:665:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpMultiAssignElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // PsiInternalEntities.g:671:1: ruleOpMultiAssign returns [Boolean current=false] : (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
    public final Boolean ruleOpMultiAssign() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:672:1: ( (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
            // PsiInternalEntities.g:673:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            {
            // PsiInternalEntities.g:673:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            int alt14=7;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt14=1;
                }
                break;
            case 25:
                {
                alt14=2;
                }
                break;
            case 26:
                {
                alt14=3;
                }
                break;
            case 27:
                {
                alt14=4;
                }
                break;
            case 28:
                {
                alt14=5;
                }
                break;
            case 29:
                {
                alt14=6;
                }
                break;
            case 30:
                {
                alt14=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // PsiInternalEntities.g:674:3: kw= '+='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_PlusSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:682:3: kw= '-='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_HyphenMinusEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:690:3: kw= '*='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_AsteriskEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:698:3: kw= '/='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_SolidusEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalEntities.g:706:3: kw= '%='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMultiAssign_PercentSignEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalEntities.g:714:3: (kw= '<' kw= '<' kw= '=' )
                    {
                    // PsiInternalEntities.g:714:3: (kw= '<' kw= '<' kw= '=' )
                    // PsiInternalEntities.g:715:4: kw= '<' kw= '<' kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_0ElementType());
                      			
                    }
                    kw=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_LessThanSignKeyword_5_1ElementType());
                      			
                    }
                    kw=(Token)match(input,29,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_EqualsSignKeyword_5_2ElementType());
                      			
                    }
                    kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // PsiInternalEntities.g:738:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    {
                    // PsiInternalEntities.g:738:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    // PsiInternalEntities.g:739:4: kw= '>' (kw= '>' )? kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_0ElementType());
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalEntities.g:746:4: (kw= '>' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==30) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // PsiInternalEntities.g:747:5: kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignKeyword_6_1ElementType());
                              				
                            }
                            kw=(Token)match(input,30,FOLLOW_20); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpMultiAssign_GreaterThanSignEqualsSignKeyword_6_2ElementType());
                      			
                    }
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // PsiInternalEntities.g:767:1: entryRuleXOrExpression returns [Boolean current=false] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final Boolean entryRuleXOrExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXOrExpression = null;


        try {
            // PsiInternalEntities.g:767:55: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // PsiInternalEntities.g:768:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXOrExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // PsiInternalEntities.g:774:1: ruleXOrExpression returns [Boolean current=false] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final Boolean ruleXOrExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XAndExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalEntities.g:775:1: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // PsiInternalEntities.g:776:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // PsiInternalEntities.g:776:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // PsiInternalEntities.g:777:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXOrExpression_XAndExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_21);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAndExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:785:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==32) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred2_PsiInternalEntities()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // PsiInternalEntities.g:786:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // PsiInternalEntities.g:786:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // PsiInternalEntities.g:787:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // PsiInternalEntities.g:797:5: ( () ( ( ruleOpOr ) ) )
            	    // PsiInternalEntities.g:798:6: () ( ( ruleOpOr ) )
            	    {
            	    // PsiInternalEntities.g:798:6: ()
            	    // PsiInternalEntities.g:799:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXOrExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalEntities.g:805:6: ( ( ruleOpOr ) )
            	    // PsiInternalEntities.g:806:7: ( ruleOpOr )
            	    {
            	    // PsiInternalEntities.g:806:7: ( ruleOpOr )
            	    // PsiInternalEntities.g:807:8: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXOrExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:824:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // PsiInternalEntities.g:825:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // PsiInternalEntities.g:825:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // PsiInternalEntities.g:826:6: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXOrExpression_RightOperandXAndExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // PsiInternalEntities.g:844:1: entryRuleOpOr returns [Boolean current=false] : iv_ruleOpOr= ruleOpOr EOF ;
    public final Boolean entryRuleOpOr() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpOr = null;


        try {
            // PsiInternalEntities.g:844:46: (iv_ruleOpOr= ruleOpOr EOF )
            // PsiInternalEntities.g:845:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpOrElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // PsiInternalEntities.g:851:1: ruleOpOr returns [Boolean current=false] : kw= '||' ;
    public final Boolean ruleOpOr() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:852:1: (kw= '||' )
            // PsiInternalEntities.g:853:2: kw= '||'
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpOr_VerticalLineVerticalLineKeywordElementType());
              	
            }
            kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(kw);
              	
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // PsiInternalEntities.g:863:1: entryRuleXAndExpression returns [Boolean current=false] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final Boolean entryRuleXAndExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXAndExpression = null;


        try {
            // PsiInternalEntities.g:863:56: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // PsiInternalEntities.g:864:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAndExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // PsiInternalEntities.g:870:1: ruleXAndExpression returns [Boolean current=false] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final Boolean ruleXAndExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XEqualityExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalEntities.g:871:1: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // PsiInternalEntities.g:872:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // PsiInternalEntities.g:872:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // PsiInternalEntities.g:873:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXAndExpression_XEqualityExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_22);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XEqualityExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:881:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==33) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred3_PsiInternalEntities()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // PsiInternalEntities.g:882:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // PsiInternalEntities.g:882:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // PsiInternalEntities.g:883:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // PsiInternalEntities.g:893:5: ( () ( ( ruleOpAnd ) ) )
            	    // PsiInternalEntities.g:894:6: () ( ( ruleOpAnd ) )
            	    {
            	    // PsiInternalEntities.g:894:6: ()
            	    // PsiInternalEntities.g:895:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXAndExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalEntities.g:901:6: ( ( ruleOpAnd ) )
            	    // PsiInternalEntities.g:902:7: ( ruleOpAnd )
            	    {
            	    // PsiInternalEntities.g:902:7: ( ruleOpAnd )
            	    // PsiInternalEntities.g:903:8: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXAndExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:920:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // PsiInternalEntities.g:921:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // PsiInternalEntities.g:921:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // PsiInternalEntities.g:922:6: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXAndExpression_RightOperandXEqualityExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            	default :
            	    break loop16;
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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // PsiInternalEntities.g:940:1: entryRuleOpAnd returns [Boolean current=false] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final Boolean entryRuleOpAnd() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpAnd = null;


        try {
            // PsiInternalEntities.g:940:47: (iv_ruleOpAnd= ruleOpAnd EOF )
            // PsiInternalEntities.g:941:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpAndElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // PsiInternalEntities.g:947:1: ruleOpAnd returns [Boolean current=false] : kw= '&&' ;
    public final Boolean ruleOpAnd() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:948:1: (kw= '&&' )
            // PsiInternalEntities.g:949:2: kw= '&&'
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getOpAnd_AmpersandAmpersandKeywordElementType());
              	
            }
            kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(kw);
              	
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // PsiInternalEntities.g:959:1: entryRuleXEqualityExpression returns [Boolean current=false] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final Boolean entryRuleXEqualityExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXEqualityExpression = null;


        try {
            // PsiInternalEntities.g:959:61: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // PsiInternalEntities.g:960:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXEqualityExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // PsiInternalEntities.g:966:1: ruleXEqualityExpression returns [Boolean current=false] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final Boolean ruleXEqualityExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XRelationalExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalEntities.g:967:1: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // PsiInternalEntities.g:968:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // PsiInternalEntities.g:968:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // PsiInternalEntities.g:969:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXEqualityExpression_XRelationalExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_23);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XRelationalExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:977:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA17_2 = input.LA(2);

                    if ( (synpred4_PsiInternalEntities()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA17_3 = input.LA(2);

                    if ( (synpred4_PsiInternalEntities()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA17_4 = input.LA(2);

                    if ( (synpred4_PsiInternalEntities()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA17_5 = input.LA(2);

                    if ( (synpred4_PsiInternalEntities()) ) {
                        alt17=1;
                    }


                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // PsiInternalEntities.g:978:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // PsiInternalEntities.g:978:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // PsiInternalEntities.g:979:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // PsiInternalEntities.g:989:5: ( () ( ( ruleOpEquality ) ) )
            	    // PsiInternalEntities.g:990:6: () ( ( ruleOpEquality ) )
            	    {
            	    // PsiInternalEntities.g:990:6: ()
            	    // PsiInternalEntities.g:991:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXEqualityExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalEntities.g:997:6: ( ( ruleOpEquality ) )
            	    // PsiInternalEntities.g:998:7: ( ruleOpEquality )
            	    {
            	    // PsiInternalEntities.g:998:7: ( ruleOpEquality )
            	    // PsiInternalEntities.g:999:8: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXEqualityExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:1016:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // PsiInternalEntities.g:1017:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // PsiInternalEntities.g:1017:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // PsiInternalEntities.g:1018:6: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXEqualityExpression_RightOperandXRelationalExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            	default :
            	    break loop17;
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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // PsiInternalEntities.g:1036:1: entryRuleOpEquality returns [Boolean current=false] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final Boolean entryRuleOpEquality() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpEquality = null;


        try {
            // PsiInternalEntities.g:1036:52: (iv_ruleOpEquality= ruleOpEquality EOF )
            // PsiInternalEntities.g:1037:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpEqualityElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // PsiInternalEntities.g:1043:1: ruleOpEquality returns [Boolean current=false] : (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) ;
    public final Boolean ruleOpEquality() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:1044:1: ( (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) )
            // PsiInternalEntities.g:1045:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            {
            // PsiInternalEntities.g:1045:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt18=1;
                }
                break;
            case 35:
                {
                alt18=2;
                }
                break;
            case 36:
                {
                alt18=3;
                }
                break;
            case 37:
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
                    // PsiInternalEntities.g:1046:3: kw= '=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1054:3: kw= '!='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:1062:3: kw= '==='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:1070:3: kw= '!=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpEquality_ExclamationMarkEqualsSignEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // PsiInternalEntities.g:1081:1: entryRuleXRelationalExpression returns [Boolean current=false] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final Boolean entryRuleXRelationalExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXRelationalExpression = null;


        try {
            // PsiInternalEntities.g:1081:63: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // PsiInternalEntities.g:1082:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXRelationalExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // PsiInternalEntities.g:1088:1: ruleXRelationalExpression returns [Boolean current=false] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final Boolean ruleXRelationalExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_XOtherOperatorExpression_0 = null;

        Boolean lv_type_3_0 = null;

        Boolean lv_rightOperand_6_0 = null;


        try {
            // PsiInternalEntities.g:1089:1: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // PsiInternalEntities.g:1090:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // PsiInternalEntities.g:1090:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // PsiInternalEntities.g:1091:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXRelationalExpression_XOtherOperatorExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_24);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XOtherOperatorExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:1099:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop19:
            do {
                int alt19=3;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (synpred6_PsiInternalEntities()) ) {
                        alt19=2;
                    }


                    }
                    break;
                case 30:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (synpred6_PsiInternalEntities()) ) {
                        alt19=2;
                    }


                    }
                    break;
                case 38:
                    {
                    int LA19_4 = input.LA(2);

                    if ( (synpred5_PsiInternalEntities()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 31:
                    {
                    int LA19_5 = input.LA(2);

                    if ( (synpred6_PsiInternalEntities()) ) {
                        alt19=2;
                    }


                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // PsiInternalEntities.g:1100:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // PsiInternalEntities.g:1100:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // PsiInternalEntities.g:1101:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // PsiInternalEntities.g:1101:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // PsiInternalEntities.g:1102:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // PsiInternalEntities.g:1108:6: ( () otherlv_2= 'instanceof' )
            	    // PsiInternalEntities.g:1109:7: () otherlv_2= 'instanceof'
            	    {
            	    // PsiInternalEntities.g:1109:7: ()
            	    // PsiInternalEntities.g:1110:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXRelationalExpression_XInstanceOfExpressionExpressionAction_1_0_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getXRelationalExpression_InstanceofKeyword_1_0_0_0_1ElementType());
            	      						
            	    }
            	    otherlv_2=(Token)match(input,38,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(otherlv_2);
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalEntities.g:1125:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // PsiInternalEntities.g:1126:6: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // PsiInternalEntities.g:1126:6: (lv_type_3_0= ruleJvmTypeReference )
            	    // PsiInternalEntities.g:1127:7: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXRelationalExpression_TypeJvmTypeReferenceParserRuleCall_1_0_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalEntities.g:1142:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // PsiInternalEntities.g:1142:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // PsiInternalEntities.g:1143:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // PsiInternalEntities.g:1143:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // PsiInternalEntities.g:1144:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // PsiInternalEntities.g:1154:6: ( () ( ( ruleOpCompare ) ) )
            	    // PsiInternalEntities.g:1155:7: () ( ( ruleOpCompare ) )
            	    {
            	    // PsiInternalEntities.g:1155:7: ()
            	    // PsiInternalEntities.g:1156:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXRelationalExpression_XBinaryOperationLeftOperandAction_1_1_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    // PsiInternalEntities.g:1162:7: ( ( ruleOpCompare ) )
            	    // PsiInternalEntities.g:1163:8: ( ruleOpCompare )
            	    {
            	    // PsiInternalEntities.g:1163:8: ( ruleOpCompare )
            	    // PsiInternalEntities.g:1164:9: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (!current) {
            	      										associateWithSemanticElement();
            	      										current = true;
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markComposite(elementTypeProvider.getXRelationalExpression_FeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0ElementType());
            	      								
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneComposite();
            	      								
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:1181:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // PsiInternalEntities.g:1182:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // PsiInternalEntities.g:1182:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // PsiInternalEntities.g:1183:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXRelationalExpression_RightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // PsiInternalEntities.g:1202:1: entryRuleOpCompare returns [Boolean current=false] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final Boolean entryRuleOpCompare() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpCompare = null;


        try {
            // PsiInternalEntities.g:1202:51: (iv_ruleOpCompare= ruleOpCompare EOF )
            // PsiInternalEntities.g:1203:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpCompareElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // PsiInternalEntities.g:1209:1: ruleOpCompare returns [Boolean current=false] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final Boolean ruleOpCompare() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:1210:1: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // PsiInternalEntities.g:1211:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // PsiInternalEntities.g:1211:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt20=1;
                }
                break;
            case 29:
                {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==EOF||(LA20_2>=RULE_STRING && LA20_2<=RULE_ID)||LA20_2==14||LA20_2==17||LA20_2==20||LA20_2==29||(LA20_2>=45 && LA20_2<=46)||LA20_2==51||(LA20_2>=58 && LA20_2<=59)||LA20_2==63||LA20_2==65||(LA20_2>=68 && LA20_2<=70)||(LA20_2>=73 && LA20_2<=84)||LA20_2==86) ) {
                    alt20=4;
                }
                else if ( (LA20_2==23) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
                }
                break;
            case 30:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // PsiInternalEntities.g:1212:3: kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1220:3: (kw= '<' kw= '=' )
                    {
                    // PsiInternalEntities.g:1220:3: (kw= '<' kw= '=' )
                    // PsiInternalEntities.g:1221:4: kw= '<' kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    kw=(Token)match(input,29,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpCompare_EqualsSignKeyword_1_1ElementType());
                      			
                    }
                    kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:1237:3: kw= '>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_GreaterThanSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:1245:3: kw= '<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpCompare_LessThanSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // PsiInternalEntities.g:1256:1: entryRuleXOtherOperatorExpression returns [Boolean current=false] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final Boolean entryRuleXOtherOperatorExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXOtherOperatorExpression = null;


        try {
            // PsiInternalEntities.g:1256:66: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // PsiInternalEntities.g:1257:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXOtherOperatorExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // PsiInternalEntities.g:1263:1: ruleXOtherOperatorExpression returns [Boolean current=false] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final Boolean ruleXOtherOperatorExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XAdditiveExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalEntities.g:1264:1: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // PsiInternalEntities.g:1265:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // PsiInternalEntities.g:1265:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // PsiInternalEntities.g:1266:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXOtherOperatorExpression_XAdditiveExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_25);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAdditiveExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:1274:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // PsiInternalEntities.g:1275:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // PsiInternalEntities.g:1275:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // PsiInternalEntities.g:1276:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // PsiInternalEntities.g:1286:5: ( () ( ( ruleOpOther ) ) )
            	    // PsiInternalEntities.g:1287:6: () ( ( ruleOpOther ) )
            	    {
            	    // PsiInternalEntities.g:1287:6: ()
            	    // PsiInternalEntities.g:1288:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXOtherOperatorExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalEntities.g:1294:6: ( ( ruleOpOther ) )
            	    // PsiInternalEntities.g:1295:7: ( ruleOpOther )
            	    {
            	    // PsiInternalEntities.g:1295:7: ( ruleOpOther )
            	    // PsiInternalEntities.g:1296:8: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXOtherOperatorExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:1313:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // PsiInternalEntities.g:1314:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // PsiInternalEntities.g:1314:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // PsiInternalEntities.g:1315:6: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXOtherOperatorExpression_RightOperandXAdditiveExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            	default :
            	    break loop21;
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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // PsiInternalEntities.g:1333:1: entryRuleOpOther returns [Boolean current=false] : iv_ruleOpOther= ruleOpOther EOF ;
    public final Boolean entryRuleOpOther() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpOther = null;


        try {
            // PsiInternalEntities.g:1333:49: (iv_ruleOpOther= ruleOpOther EOF )
            // PsiInternalEntities.g:1334:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpOtherElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // PsiInternalEntities.g:1340:1: ruleOpOther returns [Boolean current=false] : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final Boolean ruleOpOther() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:1341:1: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // PsiInternalEntities.g:1342:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // PsiInternalEntities.g:1342:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt24=9;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // PsiInternalEntities.g:1343:3: kw= '->'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_HyphenMinusGreaterThanSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1351:3: kw= '..<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopLessThanSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:1359:3: (kw= '>' kw= '..' )
                    {
                    // PsiInternalEntities.g:1359:3: (kw= '>' kw= '..' )
                    // PsiInternalEntities.g:1360:4: kw= '>' kw= '..'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_2_0ElementType());
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_2_1ElementType());
                      			
                    }
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:1376:3: kw= '..'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_FullStopFullStopKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalEntities.g:1384:3: kw= '=>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalEntities.g:1392:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // PsiInternalEntities.g:1392:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // PsiInternalEntities.g:1393:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_0ElementType());
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalEntities.g:1400:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==30) ) {
                        int LA22_1 = input.LA(2);

                        if ( (LA22_1==30) && (synpred8_PsiInternalEntities())) {
                            alt22=1;
                        }
                        else if ( (LA22_1==EOF||(LA22_1>=RULE_STRING && LA22_1<=RULE_ID)||LA22_1==14||LA22_1==17||LA22_1==20||LA22_1==29||(LA22_1>=45 && LA22_1<=46)||LA22_1==51||(LA22_1>=58 && LA22_1<=59)||LA22_1==63||LA22_1==65||(LA22_1>=68 && LA22_1<=70)||(LA22_1>=73 && LA22_1<=84)||LA22_1==86) ) {
                            alt22=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 22, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // PsiInternalEntities.g:1401:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // PsiInternalEntities.g:1401:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // PsiInternalEntities.g:1402:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // PsiInternalEntities.g:1407:6: (kw= '>' kw= '>' )
                            // PsiInternalEntities.g:1408:7: kw= '>' kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_0ElementType());
                              						
                            }
                            kw=(Token)match(input,30,FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_0_0_1ElementType());
                              						
                            }
                            kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalEntities.g:1425:5: kw= '>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_GreaterThanSignKeyword_5_1_1ElementType());
                              				
                            }
                            kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalEntities.g:1435:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // PsiInternalEntities.g:1435:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // PsiInternalEntities.g:1436:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_0ElementType());
                      			
                    }
                    kw=(Token)match(input,29,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(kw);
                      			
                    }
                    // PsiInternalEntities.g:1443:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt23=3;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==29) ) {
                        int LA23_1 = input.LA(2);

                        if ( (synpred9_PsiInternalEntities()) ) {
                            alt23=1;
                        }
                        else if ( (true) ) {
                            alt23=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 23, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA23_0==42) ) {
                        alt23=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // PsiInternalEntities.g:1444:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // PsiInternalEntities.g:1444:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // PsiInternalEntities.g:1445:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // PsiInternalEntities.g:1450:6: (kw= '<' kw= '<' )
                            // PsiInternalEntities.g:1451:7: kw= '<' kw= '<'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_0ElementType());
                              						
                            }
                            kw=(Token)match(input,29,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_0_0_1ElementType());
                              						
                            }
                            kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(kw);
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalEntities.g:1468:5: kw= '<'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_LessThanSignKeyword_6_1_1ElementType());
                              				
                            }
                            kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;
                        case 3 :
                            // PsiInternalEntities.g:1476:5: kw= '=>'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getOpOther_EqualsSignGreaterThanSignKeyword_6_1_2ElementType());
                              				
                            }
                            kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalEntities.g:1486:3: kw= '<>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_LessThanSignGreaterThanSignKeyword_7ElementType());
                      		
                    }
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalEntities.g:1494:3: kw= '?:'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpOther_QuestionMarkColonKeyword_8ElementType());
                      		
                    }
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // PsiInternalEntities.g:1505:1: entryRuleXAdditiveExpression returns [Boolean current=false] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final Boolean entryRuleXAdditiveExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXAdditiveExpression = null;


        try {
            // PsiInternalEntities.g:1505:61: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // PsiInternalEntities.g:1506:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXAdditiveExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // PsiInternalEntities.g:1512:1: ruleXAdditiveExpression returns [Boolean current=false] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final Boolean ruleXAdditiveExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XMultiplicativeExpression_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalEntities.g:1513:1: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // PsiInternalEntities.g:1514:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // PsiInternalEntities.g:1514:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // PsiInternalEntities.g:1515:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXAdditiveExpression_XMultiplicativeExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_29);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMultiplicativeExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:1523:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==45) ) {
                    int LA25_2 = input.LA(2);

                    if ( (synpred10_PsiInternalEntities()) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==46) ) {
                    int LA25_3 = input.LA(2);

                    if ( (synpred10_PsiInternalEntities()) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // PsiInternalEntities.g:1524:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // PsiInternalEntities.g:1524:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // PsiInternalEntities.g:1525:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // PsiInternalEntities.g:1535:5: ( () ( ( ruleOpAdd ) ) )
            	    // PsiInternalEntities.g:1536:6: () ( ( ruleOpAdd ) )
            	    {
            	    // PsiInternalEntities.g:1536:6: ()
            	    // PsiInternalEntities.g:1537:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXAdditiveExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalEntities.g:1543:6: ( ( ruleOpAdd ) )
            	    // PsiInternalEntities.g:1544:7: ( ruleOpAdd )
            	    {
            	    // PsiInternalEntities.g:1544:7: ( ruleOpAdd )
            	    // PsiInternalEntities.g:1545:8: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXAdditiveExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:1562:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // PsiInternalEntities.g:1563:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // PsiInternalEntities.g:1563:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // PsiInternalEntities.g:1564:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXAdditiveExpression_RightOperandXMultiplicativeExpressionParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            	default :
            	    break loop25;
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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // PsiInternalEntities.g:1582:1: entryRuleOpAdd returns [Boolean current=false] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final Boolean entryRuleOpAdd() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpAdd = null;


        try {
            // PsiInternalEntities.g:1582:47: (iv_ruleOpAdd= ruleOpAdd EOF )
            // PsiInternalEntities.g:1583:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpAddElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // PsiInternalEntities.g:1589:1: ruleOpAdd returns [Boolean current=false] : (kw= '+' | kw= '-' ) ;
    public final Boolean ruleOpAdd() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:1590:1: ( (kw= '+' | kw= '-' ) )
            // PsiInternalEntities.g:1591:2: (kw= '+' | kw= '-' )
            {
            // PsiInternalEntities.g:1591:2: (kw= '+' | kw= '-' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==45) ) {
                alt26=1;
            }
            else if ( (LA26_0==46) ) {
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
                    // PsiInternalEntities.g:1592:3: kw= '+'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpAdd_PlusSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1600:3: kw= '-'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpAdd_HyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // PsiInternalEntities.g:1611:1: entryRuleXMultiplicativeExpression returns [Boolean current=false] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final Boolean entryRuleXMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXMultiplicativeExpression = null;


        try {
            // PsiInternalEntities.g:1611:67: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // PsiInternalEntities.g:1612:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXMultiplicativeExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // PsiInternalEntities.g:1618:1: ruleXMultiplicativeExpression returns [Boolean current=false] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final Boolean ruleXMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XUnaryOperation_0 = null;

        Boolean lv_rightOperand_3_0 = null;


        try {
            // PsiInternalEntities.g:1619:1: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // PsiInternalEntities.g:1620:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // PsiInternalEntities.g:1620:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // PsiInternalEntities.g:1621:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXMultiplicativeExpression_XUnaryOperationParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_30);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XUnaryOperation_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:1629:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop27:
            do {
                int alt27=2;
                switch ( input.LA(1) ) {
                case 47:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (synpred11_PsiInternalEntities()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case 48:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (synpred11_PsiInternalEntities()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case 49:
                    {
                    int LA27_4 = input.LA(2);

                    if ( (synpred11_PsiInternalEntities()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case 50:
                    {
                    int LA27_5 = input.LA(2);

                    if ( (synpred11_PsiInternalEntities()) ) {
                        alt27=1;
                    }


                    }
                    break;

                }

                switch (alt27) {
            	case 1 :
            	    // PsiInternalEntities.g:1630:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // PsiInternalEntities.g:1630:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // PsiInternalEntities.g:1631:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // PsiInternalEntities.g:1641:5: ( () ( ( ruleOpMulti ) ) )
            	    // PsiInternalEntities.g:1642:6: () ( ( ruleOpMulti ) )
            	    {
            	    // PsiInternalEntities.g:1642:6: ()
            	    // PsiInternalEntities.g:1643:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXMultiplicativeExpression_XBinaryOperationLeftOperandAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    // PsiInternalEntities.g:1649:6: ( ( ruleOpMulti ) )
            	    // PsiInternalEntities.g:1650:7: ( ruleOpMulti )
            	    {
            	    // PsiInternalEntities.g:1650:7: ( ruleOpMulti )
            	    // PsiInternalEntities.g:1651:8: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (!current) {
            	      									associateWithSemanticElement();
            	      									current = true;
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								markComposite(elementTypeProvider.getXMultiplicativeExpression_FeatureJvmIdentifiableElementCrossReference_1_0_0_1_0ElementType());
            	      							
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								doneComposite();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:1668:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // PsiInternalEntities.g:1669:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // PsiInternalEntities.g:1669:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // PsiInternalEntities.g:1670:6: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXMultiplicativeExpression_RightOperandXUnaryOperationParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            	default :
            	    break loop27;
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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // PsiInternalEntities.g:1688:1: entryRuleOpMulti returns [Boolean current=false] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final Boolean entryRuleOpMulti() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpMulti = null;


        try {
            // PsiInternalEntities.g:1688:49: (iv_ruleOpMulti= ruleOpMulti EOF )
            // PsiInternalEntities.g:1689:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpMultiElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // PsiInternalEntities.g:1695:1: ruleOpMulti returns [Boolean current=false] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final Boolean ruleOpMulti() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:1696:1: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // PsiInternalEntities.g:1697:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // PsiInternalEntities.g:1697:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt28=1;
                }
                break;
            case 48:
                {
                alt28=2;
                }
                break;
            case 49:
                {
                alt28=3;
                }
                break;
            case 50:
                {
                alt28=4;
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
                    // PsiInternalEntities.g:1698:3: kw= '*'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_AsteriskKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1706:3: kw= '**'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_AsteriskAsteriskKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:1714:3: kw= '/'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_SolidusKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:1722:3: kw= '%'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpMulti_PercentSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // PsiInternalEntities.g:1733:1: entryRuleXUnaryOperation returns [Boolean current=false] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final Boolean entryRuleXUnaryOperation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXUnaryOperation = null;


        try {
            // PsiInternalEntities.g:1733:57: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // PsiInternalEntities.g:1734:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXUnaryOperationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // PsiInternalEntities.g:1740:1: ruleXUnaryOperation returns [Boolean current=false] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final Boolean ruleXUnaryOperation() throws RecognitionException {
        Boolean current = false;

        Boolean lv_operand_2_0 = null;

        Boolean this_XCastedExpression_3 = null;


        try {
            // PsiInternalEntities.g:1741:1: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // PsiInternalEntities.g:1742:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // PsiInternalEntities.g:1742:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=45 && LA29_0<=46)||LA29_0==51) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_ID)||LA29_0==14||LA29_0==17||LA29_0==20||LA29_0==29||(LA29_0>=58 && LA29_0<=59)||LA29_0==63||LA29_0==65||(LA29_0>=68 && LA29_0<=70)||(LA29_0>=73 && LA29_0<=84)||LA29_0==86) ) {
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
                    // PsiInternalEntities.g:1743:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    {
                    // PsiInternalEntities.g:1743:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    // PsiInternalEntities.g:1744:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    {
                    // PsiInternalEntities.g:1744:4: ()
                    // PsiInternalEntities.g:1745:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getXUnaryOperation_XUnaryOperationAction_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalEntities.g:1751:4: ( ( ruleOpUnary ) )
                    // PsiInternalEntities.g:1752:5: ( ruleOpUnary )
                    {
                    // PsiInternalEntities.g:1752:5: ( ruleOpUnary )
                    // PsiInternalEntities.g:1753:6: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXUnaryOperation_FeatureJvmIdentifiableElementCrossReference_0_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:1768:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    // PsiInternalEntities.g:1769:5: (lv_operand_2_0= ruleXUnaryOperation )
                    {
                    // PsiInternalEntities.g:1769:5: (lv_operand_2_0= ruleXUnaryOperation )
                    // PsiInternalEntities.g:1770:6: lv_operand_2_0= ruleXUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXUnaryOperation_OperandXUnaryOperationParserRuleCall_0_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleXUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1785:3: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXUnaryOperation_XCastedExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCastedExpression_3;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // PsiInternalEntities.g:1797:1: entryRuleOpUnary returns [Boolean current=false] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final Boolean entryRuleOpUnary() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpUnary = null;


        try {
            // PsiInternalEntities.g:1797:49: (iv_ruleOpUnary= ruleOpUnary EOF )
            // PsiInternalEntities.g:1798:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpUnaryElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // PsiInternalEntities.g:1804:1: ruleOpUnary returns [Boolean current=false] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final Boolean ruleOpUnary() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:1805:1: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // PsiInternalEntities.g:1806:2: (kw= '!' | kw= '-' | kw= '+' )
            {
            // PsiInternalEntities.g:1806:2: (kw= '!' | kw= '-' | kw= '+' )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt30=1;
                }
                break;
            case 46:
                {
                alt30=2;
                }
                break;
            case 45:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // PsiInternalEntities.g:1807:3: kw= '!'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_ExclamationMarkKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1815:3: kw= '-'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_HyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:1823:3: kw= '+'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpUnary_PlusSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // PsiInternalEntities.g:1834:1: entryRuleXCastedExpression returns [Boolean current=false] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final Boolean entryRuleXCastedExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCastedExpression = null;


        try {
            // PsiInternalEntities.g:1834:59: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // PsiInternalEntities.g:1835:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCastedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // PsiInternalEntities.g:1841:1: ruleXCastedExpression returns [Boolean current=false] : (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final Boolean ruleXCastedExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_XPostfixOperation_0 = null;

        Boolean lv_type_3_0 = null;


        try {
            // PsiInternalEntities.g:1842:1: ( (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // PsiInternalEntities.g:1843:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // PsiInternalEntities.g:1843:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // PsiInternalEntities.g:1844:3: this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXCastedExpression_XPostfixOperationParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_31);
            this_XPostfixOperation_0=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPostfixOperation_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:1852:3: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==52) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred12_PsiInternalEntities()) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // PsiInternalEntities.g:1853:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // PsiInternalEntities.g:1853:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // PsiInternalEntities.g:1854:5: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // PsiInternalEntities.g:1860:5: ( () otherlv_2= 'as' )
            	    // PsiInternalEntities.g:1861:6: () otherlv_2= 'as'
            	    {
            	    // PsiInternalEntities.g:1861:6: ()
            	    // PsiInternalEntities.g:1862:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							precedeComposite(elementTypeProvider.getXCastedExpression_XCastedExpressionTargetAction_1_0_0_0ElementType());
            	      							doneComposite();
            	      							associateWithSemanticElement();
            	      						
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      						markLeaf(elementTypeProvider.getXCastedExpression_AsKeyword_1_0_0_1ElementType());
            	      					
            	    }
            	    otherlv_2=(Token)match(input,52,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneLeaf(otherlv_2);
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalEntities.g:1877:4: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // PsiInternalEntities.g:1878:5: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // PsiInternalEntities.g:1878:5: (lv_type_3_0= ruleJvmTypeReference )
            	    // PsiInternalEntities.g:1879:6: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXCastedExpression_TypeJvmTypeReferenceParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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

            	default :
            	    break loop31;
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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXPostfixOperation"
    // PsiInternalEntities.g:1897:1: entryRuleXPostfixOperation returns [Boolean current=false] : iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
    public final Boolean entryRuleXPostfixOperation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXPostfixOperation = null;


        try {
            // PsiInternalEntities.g:1897:59: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
            // PsiInternalEntities.g:1898:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXPostfixOperationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPostfixOperation=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPostfixOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPostfixOperation"


    // $ANTLR start "ruleXPostfixOperation"
    // PsiInternalEntities.g:1904:1: ruleXPostfixOperation returns [Boolean current=false] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
    public final Boolean ruleXPostfixOperation() throws RecognitionException {
        Boolean current = false;

        Boolean this_XMemberFeatureCall_0 = null;


        try {
            // PsiInternalEntities.g:1905:1: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
            // PsiInternalEntities.g:1906:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            {
            // PsiInternalEntities.g:1906:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            // PsiInternalEntities.g:1907:3: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXPostfixOperation_XMemberFeatureCallParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_32);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMemberFeatureCall_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:1915:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==53) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred13_PsiInternalEntities()) ) {
                    alt32=1;
                }
            }
            else if ( (LA32_0==54) ) {
                int LA32_2 = input.LA(2);

                if ( (synpred13_PsiInternalEntities()) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalEntities.g:1916:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
                    {
                    // PsiInternalEntities.g:1926:4: ( () ( ( ruleOpPostfix ) ) )
                    // PsiInternalEntities.g:1927:5: () ( ( ruleOpPostfix ) )
                    {
                    // PsiInternalEntities.g:1927:5: ()
                    // PsiInternalEntities.g:1928:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						precedeComposite(elementTypeProvider.getXPostfixOperation_XPostfixOperationOperandAction_1_0_0ElementType());
                      						doneComposite();
                      						associateWithSemanticElement();
                      					
                    }

                    }

                    // PsiInternalEntities.g:1934:5: ( ( ruleOpPostfix ) )
                    // PsiInternalEntities.g:1935:6: ( ruleOpPostfix )
                    {
                    // PsiInternalEntities.g:1935:6: ( ruleOpPostfix )
                    // PsiInternalEntities.g:1936:7: ruleOpPostfix
                    {
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXPostfixOperation_FeatureJvmIdentifiableElementCrossReference_1_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    ruleOpPostfix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

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
    // $ANTLR end "ruleXPostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // PsiInternalEntities.g:1957:1: entryRuleOpPostfix returns [Boolean current=false] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final Boolean entryRuleOpPostfix() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOpPostfix = null;


        try {
            // PsiInternalEntities.g:1957:51: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // PsiInternalEntities.g:1958:2: iv_ruleOpPostfix= ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOpPostfixElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpPostfix=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpPostfix; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // PsiInternalEntities.g:1964:1: ruleOpPostfix returns [Boolean current=false] : (kw= '++' | kw= '--' ) ;
    public final Boolean ruleOpPostfix() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:1965:1: ( (kw= '++' | kw= '--' ) )
            // PsiInternalEntities.g:1966:2: (kw= '++' | kw= '--' )
            {
            // PsiInternalEntities.g:1966:2: (kw= '++' | kw= '--' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==53) ) {
                alt33=1;
            }
            else if ( (LA33_0==54) ) {
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
                    // PsiInternalEntities.g:1967:3: kw= '++'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpPostfix_PlusSignPlusSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:1975:3: kw= '--'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getOpPostfix_HyphenMinusHyphenMinusKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // PsiInternalEntities.g:1986:1: entryRuleXMemberFeatureCall returns [Boolean current=false] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final Boolean entryRuleXMemberFeatureCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXMemberFeatureCall = null;


        try {
            // PsiInternalEntities.g:1986:60: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // PsiInternalEntities.g:1987:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXMemberFeatureCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // PsiInternalEntities.g:1993:1: ruleXMemberFeatureCall returns [Boolean current=false] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
    public final Boolean ruleXMemberFeatureCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token lv_explicitStatic_3_0=null;
        Token otherlv_8=null;
        Token lv_nullSafe_9_0=null;
        Token lv_explicitStatic_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_explicitOperationCall_17_0=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Boolean this_XPrimaryExpression_0 = null;

        Boolean lv_value_6_0 = null;

        Boolean lv_typeArguments_12_0 = null;

        Boolean lv_typeArguments_14_0 = null;

        Boolean lv_memberCallArguments_18_0 = null;

        Boolean lv_memberCallArguments_19_0 = null;

        Boolean lv_memberCallArguments_21_0 = null;

        Boolean lv_memberCallArguments_23_0 = null;


        try {
            // PsiInternalEntities.g:1994:1: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
            // PsiInternalEntities.g:1995:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            {
            // PsiInternalEntities.g:1995:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            // PsiInternalEntities.g:1996:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXMemberFeatureCall_XPrimaryExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_33);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPrimaryExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalEntities.g:2004:3: ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            loop42:
            do {
                int alt42=3;
                switch ( input.LA(1) ) {
                case 55:
                    {
                    int LA42_2 = input.LA(2);

                    if ( (synpred14_PsiInternalEntities()) ) {
                        alt42=1;
                    }
                    else if ( (synpred15_PsiInternalEntities()) ) {
                        alt42=2;
                    }


                    }
                    break;
                case 56:
                    {
                    int LA42_3 = input.LA(2);

                    if ( (synpred14_PsiInternalEntities()) ) {
                        alt42=1;
                    }
                    else if ( (synpred15_PsiInternalEntities()) ) {
                        alt42=2;
                    }


                    }
                    break;
                case 57:
                    {
                    int LA42_4 = input.LA(2);

                    if ( (synpred15_PsiInternalEntities()) ) {
                        alt42=2;
                    }


                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // PsiInternalEntities.g:2005:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    {
            	    // PsiInternalEntities.g:2005:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    // PsiInternalEntities.g:2006:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
            	    {
            	    // PsiInternalEntities.g:2006:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
            	    // PsiInternalEntities.g:2007:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    {
            	    // PsiInternalEntities.g:2027:6: ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    // PsiInternalEntities.g:2028:7: () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
            	    {
            	    // PsiInternalEntities.g:2028:7: ()
            	    // PsiInternalEntities.g:2029:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XAssignmentAssignableAction_1_0_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    // PsiInternalEntities.g:2035:7: (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) )
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==55) ) {
            	        alt34=1;
            	    }
            	    else if ( (LA34_0==56) ) {
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
            	            // PsiInternalEntities.g:2036:8: otherlv_2= '.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_0_0_0_1_0ElementType());
            	              							
            	            }
            	            otherlv_2=(Token)match(input,55,FOLLOW_34); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(otherlv_2);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalEntities.g:2044:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            {
            	            // PsiInternalEntities.g:2044:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            // PsiInternalEntities.g:2045:9: (lv_explicitStatic_3_0= '::' )
            	            {
            	            // PsiInternalEntities.g:2045:9: (lv_explicitStatic_3_0= '::' )
            	            // PsiInternalEntities.g:2046:10: lv_explicitStatic_3_0= '::'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_0_0_0_1_1_0ElementType());
            	              									
            	            }
            	            lv_explicitStatic_3_0=(Token)match(input,56,FOLLOW_34); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_explicitStatic_3_0);
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (!current) {
            	              											associateWithSemanticElement();
            	              											current = true;
            	              										}
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // PsiInternalEntities.g:2062:7: ( ( ruleFeatureCallID ) )
            	    // PsiInternalEntities.g:2063:8: ( ruleFeatureCallID )
            	    {
            	    // PsiInternalEntities.g:2063:8: ( ruleFeatureCallID )
            	    // PsiInternalEntities.g:2064:9: ruleFeatureCallID
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (!current) {
            	      										associateWithSemanticElement();
            	      										current = true;
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0ElementType());
            	      								
            	    }
            	    pushFollow(FOLLOW_15);
            	    ruleFeatureCallID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneComposite();
            	      								
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_OpSingleAssignParserRuleCall_1_0_0_0_3ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_16);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalEntities.g:2088:5: ( (lv_value_6_0= ruleXAssignment ) )
            	    // PsiInternalEntities.g:2089:6: (lv_value_6_0= ruleXAssignment )
            	    {
            	    // PsiInternalEntities.g:2089:6: (lv_value_6_0= ruleXAssignment )
            	    // PsiInternalEntities.g:2090:7: lv_value_6_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_ValueXAssignmentParserRuleCall_1_0_1_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_value_6_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalEntities.g:2105:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    {
            	    // PsiInternalEntities.g:2105:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    // PsiInternalEntities.g:2106:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    {
            	    // PsiInternalEntities.g:2106:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) )
            	    // PsiInternalEntities.g:2107:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    {
            	    // PsiInternalEntities.g:2127:6: ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    // PsiInternalEntities.g:2128:7: () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    {
            	    // PsiInternalEntities.g:2128:7: ()
            	    // PsiInternalEntities.g:2129:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								precedeComposite(elementTypeProvider.getXMemberFeatureCall_XMemberFeatureCallMemberCallTargetAction_1_1_0_0_0ElementType());
            	      								doneComposite();
            	      								associateWithSemanticElement();
            	      							
            	    }

            	    }

            	    // PsiInternalEntities.g:2135:7: (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    int alt35=3;
            	    switch ( input.LA(1) ) {
            	    case 55:
            	        {
            	        alt35=1;
            	        }
            	        break;
            	    case 57:
            	        {
            	        alt35=2;
            	        }
            	        break;
            	    case 56:
            	        {
            	        alt35=3;
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
            	            // PsiInternalEntities.g:2136:8: otherlv_8= '.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_FullStopKeyword_1_1_0_0_1_0ElementType());
            	              							
            	            }
            	            otherlv_8=(Token)match(input,55,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(otherlv_8);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalEntities.g:2144:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            {
            	            // PsiInternalEntities.g:2144:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            // PsiInternalEntities.g:2145:9: (lv_nullSafe_9_0= '?.' )
            	            {
            	            // PsiInternalEntities.g:2145:9: (lv_nullSafe_9_0= '?.' )
            	            // PsiInternalEntities.g:2146:10: lv_nullSafe_9_0= '?.'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_NullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0ElementType());
            	              									
            	            }
            	            lv_nullSafe_9_0=(Token)match(input,57,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_nullSafe_9_0);
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (!current) {
            	              											associateWithSemanticElement();
            	              											current = true;
            	              										}
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // PsiInternalEntities.g:2162:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            {
            	            // PsiInternalEntities.g:2162:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            // PsiInternalEntities.g:2163:9: (lv_explicitStatic_10_0= '::' )
            	            {
            	            // PsiInternalEntities.g:2163:9: (lv_explicitStatic_10_0= '::' )
            	            // PsiInternalEntities.g:2164:10: lv_explicitStatic_10_0= '::'
            	            {
            	            if ( state.backtracking==0 ) {

            	              										markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitStaticColonColonKeyword_1_1_0_0_1_2_0ElementType());
            	              									
            	            }
            	            lv_explicitStatic_10_0=(Token)match(input,56,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										doneLeaf(lv_explicitStatic_10_0);
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (!current) {
            	              											associateWithSemanticElement();
            	              											current = true;
            	              										}
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalEntities.g:2182:5: (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )?
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==29) ) {
            	        alt37=1;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // PsiInternalEntities.g:2183:6: otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>'
            	            {
            	            if ( state.backtracking==0 ) {

            	              						markLeaf(elementTypeProvider.getXMemberFeatureCall_LessThanSignKeyword_1_1_1_0ElementType());
            	              					
            	            }
            	            otherlv_11=(Token)match(input,29,FOLLOW_36); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_11);
            	              					
            	            }
            	            // PsiInternalEntities.g:2190:6: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
            	            // PsiInternalEntities.g:2191:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            {
            	            // PsiInternalEntities.g:2191:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            // PsiInternalEntities.g:2192:8: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0ElementType());
            	              							
            	            }
            	            pushFollow(FOLLOW_37);
            	            lv_typeArguments_12_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneComposite();
            	              								if(!current) {
            	              									associateWithSemanticElement();
            	              									current = true;
            	              								}
            	              							
            	            }

            	            }


            	            }

            	            // PsiInternalEntities.g:2205:6: (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop36:
            	            do {
            	                int alt36=2;
            	                int LA36_0 = input.LA(1);

            	                if ( (LA36_0==21) ) {
            	                    alt36=1;
            	                }


            	                switch (alt36) {
            	            	case 1 :
            	            	    // PsiInternalEntities.g:2206:7: otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      							markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_1_2_0ElementType());
            	            	      						
            	            	    }
            	            	    otherlv_13=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      							doneLeaf(otherlv_13);
            	            	      						
            	            	    }
            	            	    // PsiInternalEntities.g:2213:7: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    // PsiInternalEntities.g:2214:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // PsiInternalEntities.g:2214:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    // PsiInternalEntities.g:2215:9: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      									markComposite(elementTypeProvider.getXMemberFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0ElementType());
            	            	      								
            	            	    }
            	            	    pushFollow(FOLLOW_37);
            	            	    lv_typeArguments_14_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

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

            	            	default :
            	            	    break loop36;
            	                }
            	            } while (true);

            	            if ( state.backtracking==0 ) {

            	              						markLeaf(elementTypeProvider.getXMemberFeatureCall_GreaterThanSignKeyword_1_1_1_3ElementType());
            	              					
            	            }
            	            otherlv_15=(Token)match(input,30,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_15);
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalEntities.g:2237:5: ( ( ruleIdOrSuper ) )
            	    // PsiInternalEntities.g:2238:6: ( ruleIdOrSuper )
            	    {
            	    // PsiInternalEntities.g:2238:6: ( ruleIdOrSuper )
            	    // PsiInternalEntities.g:2239:7: ruleIdOrSuper
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getXMemberFeatureCall_FeatureJvmIdentifiableElementCrossReference_1_1_2_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_38);
            	    ruleIdOrSuper();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }

            	    // PsiInternalEntities.g:2254:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?
            	    int alt40=2;
            	    alt40 = dfa40.predict(input);
            	    switch (alt40) {
            	        case 1 :
            	            // PsiInternalEntities.g:2255:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')'
            	            {
            	            // PsiInternalEntities.g:2255:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) )
            	            // PsiInternalEntities.g:2256:7: ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' )
            	            {
            	            // PsiInternalEntities.g:2260:7: (lv_explicitOperationCall_17_0= '(' )
            	            // PsiInternalEntities.g:2261:8: lv_explicitOperationCall_17_0= '('
            	            {
            	            if ( state.backtracking==0 ) {

            	              								markLeaf(elementTypeProvider.getXMemberFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0ElementType());
            	              							
            	            }
            	            lv_explicitOperationCall_17_0=(Token)match(input,20,FOLLOW_39); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								doneLeaf(lv_explicitOperationCall_17_0);
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (!current) {
            	              									associateWithSemanticElement();
            	              									current = true;
            	              								}
            	              							
            	            }

            	            }


            	            }

            	            // PsiInternalEntities.g:2276:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
            	            int alt39=3;
            	            alt39 = dfa39.predict(input);
            	            switch (alt39) {
            	                case 1 :
            	                    // PsiInternalEntities.g:2277:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    {
            	                    // PsiInternalEntities.g:2277:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    // PsiInternalEntities.g:2278:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    {
            	                    // PsiInternalEntities.g:2303:8: (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    // PsiInternalEntities.g:2304:9: lv_memberCallArguments_18_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0ElementType());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_40);
            	                    lv_memberCallArguments_18_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

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
            	                    // PsiInternalEntities.g:2318:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    {
            	                    // PsiInternalEntities.g:2318:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    // PsiInternalEntities.g:2319:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    {
            	                    // PsiInternalEntities.g:2319:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
            	                    // PsiInternalEntities.g:2320:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    {
            	                    // PsiInternalEntities.g:2320:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    // PsiInternalEntities.g:2321:10: lv_memberCallArguments_19_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      										markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0ElementType());
            	                      									
            	                    }
            	                    pushFollow(FOLLOW_13);
            	                    lv_memberCallArguments_19_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      										doneComposite();
            	                      										if(!current) {
            	                      											associateWithSemanticElement();
            	                      											current = true;
            	                      										}
            	                      									
            	                    }

            	                    }


            	                    }

            	                    // PsiInternalEntities.g:2334:8: (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    loop38:
            	                    do {
            	                        int alt38=2;
            	                        int LA38_0 = input.LA(1);

            	                        if ( (LA38_0==21) ) {
            	                            alt38=1;
            	                        }


            	                        switch (alt38) {
            	                    	case 1 :
            	                    	    // PsiInternalEntities.g:2335:9: otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									markLeaf(elementTypeProvider.getXMemberFeatureCall_CommaKeyword_1_1_3_1_1_1_0ElementType());
            	                    	      								
            	                    	    }
            	                    	    otherlv_20=(Token)match(input,21,FOLLOW_16); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									doneLeaf(otherlv_20);
            	                    	      								
            	                    	    }
            	                    	    // PsiInternalEntities.g:2342:9: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    // PsiInternalEntities.g:2343:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    {
            	                    	    // PsiInternalEntities.g:2343:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    // PsiInternalEntities.g:2344:11: lv_memberCallArguments_21_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0ElementType());
            	                    	      										
            	                    	    }
            	                    	    pushFollow(FOLLOW_13);
            	                    	    lv_memberCallArguments_21_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

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

            	                    	default :
            	                    	    break loop38;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            if ( state.backtracking==0 ) {

            	              						markLeaf(elementTypeProvider.getXMemberFeatureCall_RightParenthesisKeyword_1_1_3_2ElementType());
            	              					
            	            }
            	            otherlv_22=(Token)match(input,22,FOLLOW_41); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneLeaf(otherlv_22);
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // PsiInternalEntities.g:2368:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    int alt41=2;
            	    alt41 = dfa41.predict(input);
            	    switch (alt41) {
            	        case 1 :
            	            // PsiInternalEntities.g:2369:6: ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
            	            {
            	            // PsiInternalEntities.g:2375:6: (lv_memberCallArguments_23_0= ruleXClosure )
            	            // PsiInternalEntities.g:2376:7: lv_memberCallArguments_23_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markComposite(elementTypeProvider.getXMemberFeatureCall_MemberCallArgumentsXClosureParserRuleCall_1_1_4_0ElementType());
            	              						
            	            }
            	            pushFollow(FOLLOW_33);
            	            lv_memberCallArguments_23_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

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


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // PsiInternalEntities.g:2395:1: entryRuleXPrimaryExpression returns [Boolean current=false] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final Boolean entryRuleXPrimaryExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXPrimaryExpression = null;


        try {
            // PsiInternalEntities.g:2395:60: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // PsiInternalEntities.g:2396:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXPrimaryExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // PsiInternalEntities.g:2402:1: ruleXPrimaryExpression returns [Boolean current=false] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) ;
    public final Boolean ruleXPrimaryExpression() throws RecognitionException {
        Boolean current = false;

        Boolean this_XConstructorCall_0 = null;

        Boolean this_XBlockExpression_1 = null;

        Boolean this_XSwitchExpression_2 = null;

        Boolean this_XSynchronizedExpression_3 = null;

        Boolean this_XFeatureCall_4 = null;

        Boolean this_XLiteral_5 = null;

        Boolean this_XIfExpression_6 = null;

        Boolean this_XForLoopExpression_7 = null;

        Boolean this_XBasicForLoopExpression_8 = null;

        Boolean this_XWhileExpression_9 = null;

        Boolean this_XDoWhileExpression_10 = null;

        Boolean this_XThrowExpression_11 = null;

        Boolean this_XReturnExpression_12 = null;

        Boolean this_XTryCatchFinallyExpression_13 = null;

        Boolean this_XParenthesizedExpression_14 = null;


        try {
            // PsiInternalEntities.g:2403:1: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) )
            // PsiInternalEntities.g:2404:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            {
            // PsiInternalEntities.g:2404:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            int alt43=15;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // PsiInternalEntities.g:2405:3: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XConstructorCallParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XConstructorCall_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:2414:3: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XBlockExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBlockExpression_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:2423:3: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XSwitchExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSwitchExpression_2;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:2432:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    {
                    // PsiInternalEntities.g:2432:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    // PsiInternalEntities.g:2433:4: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXPrimaryExpression_XSynchronizedExpressionParserRuleCall_3ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XSynchronizedExpression_3=ruleXSynchronizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XSynchronizedExpression_3;
                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // PsiInternalEntities.g:2450:3: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XFeatureCallParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFeatureCall_4;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalEntities.g:2459:3: this_XLiteral_5= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XLiteralParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XLiteral_5=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XLiteral_5;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalEntities.g:2468:3: this_XIfExpression_6= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XIfExpressionParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XIfExpression_6=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XIfExpression_6;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalEntities.g:2477:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    {
                    // PsiInternalEntities.g:2477:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    // PsiInternalEntities.g:2478:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXPrimaryExpression_XForLoopExpressionParserRuleCall_7ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XForLoopExpression_7=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XForLoopExpression_7;
                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // PsiInternalEntities.g:2501:3: this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XBasicForLoopExpressionParserRuleCall_8ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBasicForLoopExpression_8;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 10 :
                    // PsiInternalEntities.g:2510:3: this_XWhileExpression_9= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XWhileExpressionParserRuleCall_9ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XWhileExpression_9=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XWhileExpression_9;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 11 :
                    // PsiInternalEntities.g:2519:3: this_XDoWhileExpression_10= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XDoWhileExpressionParserRuleCall_10ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XDoWhileExpression_10=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XDoWhileExpression_10;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 12 :
                    // PsiInternalEntities.g:2528:3: this_XThrowExpression_11= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XThrowExpressionParserRuleCall_11ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XThrowExpression_11=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XThrowExpression_11;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 13 :
                    // PsiInternalEntities.g:2537:3: this_XReturnExpression_12= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XReturnExpressionParserRuleCall_12ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XReturnExpression_12=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XReturnExpression_12;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 14 :
                    // PsiInternalEntities.g:2546:3: this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XTryCatchFinallyExpressionParserRuleCall_13ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTryCatchFinallyExpression_13;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 15 :
                    // PsiInternalEntities.g:2555:3: this_XParenthesizedExpression_14= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXPrimaryExpression_XParenthesizedExpressionParserRuleCall_14ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XParenthesizedExpression_14=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XParenthesizedExpression_14;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // PsiInternalEntities.g:2567:1: entryRuleXLiteral returns [Boolean current=false] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final Boolean entryRuleXLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXLiteral = null;


        try {
            // PsiInternalEntities.g:2567:50: (iv_ruleXLiteral= ruleXLiteral EOF )
            // PsiInternalEntities.g:2568:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // PsiInternalEntities.g:2574:1: ruleXLiteral returns [Boolean current=false] : (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) ;
    public final Boolean ruleXLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean this_XCollectionLiteral_0 = null;

        Boolean this_XClosure_1 = null;

        Boolean this_XBooleanLiteral_2 = null;

        Boolean this_XNumberLiteral_3 = null;

        Boolean this_XNullLiteral_4 = null;

        Boolean this_XStringLiteral_5 = null;

        Boolean this_XTypeLiteral_6 = null;


        try {
            // PsiInternalEntities.g:2575:1: ( (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) )
            // PsiInternalEntities.g:2576:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            {
            // PsiInternalEntities.g:2576:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            int alt44=7;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==58) ) {
                alt44=1;
            }
            else if ( (LA44_0==59) && (synpred21_PsiInternalEntities())) {
                alt44=2;
            }
            else if ( ((LA44_0>=78 && LA44_0<=79)) ) {
                alt44=3;
            }
            else if ( ((LA44_0>=RULE_HEX && LA44_0<=RULE_DECIMAL)) ) {
                alt44=4;
            }
            else if ( (LA44_0==80) ) {
                alt44=5;
            }
            else if ( (LA44_0==RULE_STRING) ) {
                alt44=6;
            }
            else if ( (LA44_0==81) ) {
                alt44=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalEntities.g:2577:3: this_XCollectionLiteral_0= ruleXCollectionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XCollectionLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCollectionLiteral_0=ruleXCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCollectionLiteral_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:2586:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    {
                    // PsiInternalEntities.g:2586:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    // PsiInternalEntities.g:2587:4: ( ( () '[' ) )=>this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getXLiteral_XClosureParserRuleCall_1ElementType());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XClosure_1=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XClosure_1;
                      				doneComposite();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:2603:3: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XBooleanLiteralParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBooleanLiteral_2=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBooleanLiteral_2;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:2612:3: this_XNumberLiteral_3= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XNumberLiteralParserRuleCall_3ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNumberLiteral_3=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNumberLiteral_3;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalEntities.g:2621:3: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XNullLiteralParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNullLiteral_4=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNullLiteral_4;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalEntities.g:2630:3: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XStringLiteralParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XStringLiteral_5=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XStringLiteral_5;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalEntities.g:2639:3: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXLiteral_XTypeLiteralParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTypeLiteral_6=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTypeLiteral_6;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXCollectionLiteral"
    // PsiInternalEntities.g:2651:1: entryRuleXCollectionLiteral returns [Boolean current=false] : iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF ;
    public final Boolean entryRuleXCollectionLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCollectionLiteral = null;


        try {
            // PsiInternalEntities.g:2651:60: (iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF )
            // PsiInternalEntities.g:2652:2: iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCollectionLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCollectionLiteral"


    // $ANTLR start "ruleXCollectionLiteral"
    // PsiInternalEntities.g:2658:1: ruleXCollectionLiteral returns [Boolean current=false] : (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) ;
    public final Boolean ruleXCollectionLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean this_XSetLiteral_0 = null;

        Boolean this_XListLiteral_1 = null;


        try {
            // PsiInternalEntities.g:2659:1: ( (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) )
            // PsiInternalEntities.g:2660:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            {
            // PsiInternalEntities.g:2660:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==58) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==59) ) {
                    alt45=2;
                }
                else if ( (LA45_1==14) ) {
                    alt45=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalEntities.g:2661:3: this_XSetLiteral_0= ruleXSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXCollectionLiteral_XSetLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSetLiteral_0=ruleXSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSetLiteral_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:2670:3: this_XListLiteral_1= ruleXListLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXCollectionLiteral_XListLiteralParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XListLiteral_1=ruleXListLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XListLiteral_1;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleXCollectionLiteral"


    // $ANTLR start "entryRuleXSetLiteral"
    // PsiInternalEntities.g:2682:1: entryRuleXSetLiteral returns [Boolean current=false] : iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
    public final Boolean entryRuleXSetLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXSetLiteral = null;


        try {
            // PsiInternalEntities.g:2682:53: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
            // PsiInternalEntities.g:2683:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSetLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSetLiteral=ruleXSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSetLiteral"


    // $ANTLR start "ruleXSetLiteral"
    // PsiInternalEntities.g:2689:1: ruleXSetLiteral returns [Boolean current=false] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
    public final Boolean ruleXSetLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_elements_3_0 = null;

        Boolean lv_elements_5_0 = null;


        try {
            // PsiInternalEntities.g:2690:1: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
            // PsiInternalEntities.g:2691:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            {
            // PsiInternalEntities.g:2691:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            // PsiInternalEntities.g:2692:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
            {
            // PsiInternalEntities.g:2692:3: ()
            // PsiInternalEntities.g:2693:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXSetLiteral_XSetLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_NumberSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,58,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_LeftCurlyBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,14,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:2713:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||LA47_0==14||LA47_0==17||LA47_0==20||LA47_0==29||(LA47_0>=45 && LA47_0<=46)||LA47_0==51||(LA47_0>=58 && LA47_0<=59)||LA47_0==63||LA47_0==65||(LA47_0>=68 && LA47_0<=70)||(LA47_0>=73 && LA47_0<=84)||LA47_0==86) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalEntities.g:2714:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalEntities.g:2714:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // PsiInternalEntities.g:2715:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:2715:5: (lv_elements_3_0= ruleXExpression )
                    // PsiInternalEntities.g:2716:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:2729:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==21) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // PsiInternalEntities.g:2730:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXSetLiteral_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,21,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:2737:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // PsiInternalEntities.g:2738:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // PsiInternalEntities.g:2738:6: (lv_elements_5_0= ruleXExpression )
                    	    // PsiInternalEntities.g:2739:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXSetLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSetLiteral_RightCurlyBracketKeyword_4ElementType());
              		
            }
            otherlv_6=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
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
    // $ANTLR end "ruleXSetLiteral"


    // $ANTLR start "entryRuleXListLiteral"
    // PsiInternalEntities.g:2765:1: entryRuleXListLiteral returns [Boolean current=false] : iv_ruleXListLiteral= ruleXListLiteral EOF ;
    public final Boolean entryRuleXListLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXListLiteral = null;


        try {
            // PsiInternalEntities.g:2765:54: (iv_ruleXListLiteral= ruleXListLiteral EOF )
            // PsiInternalEntities.g:2766:2: iv_ruleXListLiteral= ruleXListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXListLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXListLiteral=ruleXListLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXListLiteral"


    // $ANTLR start "ruleXListLiteral"
    // PsiInternalEntities.g:2772:1: ruleXListLiteral returns [Boolean current=false] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
    public final Boolean ruleXListLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_elements_3_0 = null;

        Boolean lv_elements_5_0 = null;


        try {
            // PsiInternalEntities.g:2773:1: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
            // PsiInternalEntities.g:2774:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            {
            // PsiInternalEntities.g:2774:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            // PsiInternalEntities.g:2775:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
            {
            // PsiInternalEntities.g:2775:3: ()
            // PsiInternalEntities.g:2776:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXListLiteral_XListLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_NumberSignKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,58,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_LeftSquareBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,59,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:2796:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||LA49_0==14||LA49_0==17||LA49_0==20||LA49_0==29||(LA49_0>=45 && LA49_0<=46)||LA49_0==51||(LA49_0>=58 && LA49_0<=59)||LA49_0==63||LA49_0==65||(LA49_0>=68 && LA49_0<=70)||(LA49_0>=73 && LA49_0<=84)||LA49_0==86) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalEntities.g:2797:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalEntities.g:2797:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // PsiInternalEntities.g:2798:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:2798:5: (lv_elements_3_0= ruleXExpression )
                    // PsiInternalEntities.g:2799:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_46);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:2812:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==21) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // PsiInternalEntities.g:2813:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXListLiteral_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,21,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:2820:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // PsiInternalEntities.g:2821:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // PsiInternalEntities.g:2821:6: (lv_elements_5_0= ruleXExpression )
                    	    // PsiInternalEntities.g:2822:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXListLiteral_ElementsXExpressionParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_46);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXListLiteral_RightSquareBracketKeyword_4ElementType());
              		
            }
            otherlv_6=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
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
    // $ANTLR end "ruleXListLiteral"


    // $ANTLR start "entryRuleXClosure"
    // PsiInternalEntities.g:2848:1: entryRuleXClosure returns [Boolean current=false] : iv_ruleXClosure= ruleXClosure EOF ;
    public final Boolean entryRuleXClosure() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXClosure = null;


        try {
            // PsiInternalEntities.g:2848:50: (iv_ruleXClosure= ruleXClosure EOF )
            // PsiInternalEntities.g:2849:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // PsiInternalEntities.g:2855:1: ruleXClosure returns [Boolean current=false] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final Boolean ruleXClosure() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        Boolean lv_declaredFormalParameters_2_0 = null;

        Boolean lv_declaredFormalParameters_4_0 = null;

        Boolean lv_expression_6_0 = null;


        try {
            // PsiInternalEntities.g:2856:1: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // PsiInternalEntities.g:2857:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // PsiInternalEntities.g:2857:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // PsiInternalEntities.g:2858:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // PsiInternalEntities.g:2858:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
            // PsiInternalEntities.g:2859:4: ( ( () '[' ) )=> ( () otherlv_1= '[' )
            {
            // PsiInternalEntities.g:2865:4: ( () otherlv_1= '[' )
            // PsiInternalEntities.g:2866:5: () otherlv_1= '['
            {
            // PsiInternalEntities.g:2866:5: ()
            // PsiInternalEntities.g:2867:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXClosure_XClosureAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXClosure_LeftSquareBracketKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,59,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }

            }


            }

            // PsiInternalEntities.g:2882:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // PsiInternalEntities.g:2883:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // PsiInternalEntities.g:2906:4: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // PsiInternalEntities.g:2907:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // PsiInternalEntities.g:2907:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==RULE_ID||LA51_0==20||LA51_0==42) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // PsiInternalEntities.g:2908:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // PsiInternalEntities.g:2908:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // PsiInternalEntities.g:2909:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // PsiInternalEntities.g:2909:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // PsiInternalEntities.g:2910:8: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_48);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalEntities.g:2923:6: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==21) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // PsiInternalEntities.g:2924:7: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXClosure_CommaKeyword_1_0_0_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_3=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_3);
                            	      						
                            	    }
                            	    // PsiInternalEntities.g:2931:7: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // PsiInternalEntities.g:2932:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // PsiInternalEntities.g:2932:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // PsiInternalEntities.g:2933:9: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_48);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

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

                            	default :
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // PsiInternalEntities.g:2948:5: ( (lv_explicitSyntax_5_0= '|' ) )
                    // PsiInternalEntities.g:2949:6: (lv_explicitSyntax_5_0= '|' )
                    {
                    // PsiInternalEntities.g:2949:6: (lv_explicitSyntax_5_0= '|' )
                    // PsiInternalEntities.g:2950:7: lv_explicitSyntax_5_0= '|'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXClosure_ExplicitSyntaxVerticalLineKeyword_1_0_1_0ElementType());
                      						
                    }
                    lv_explicitSyntax_5_0=(Token)match(input,61,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_explicitSyntax_5_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalEntities.g:2967:3: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // PsiInternalEntities.g:2968:4: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // PsiInternalEntities.g:2968:4: (lv_expression_6_0= ruleXExpressionInClosure )
            // PsiInternalEntities.g:2969:5: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXClosure_ExpressionXExpressionInClosureParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_50);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXClosure_RightSquareBracketKeyword_3ElementType());
              		
            }
            otherlv_7=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_7);
              		
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
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // PsiInternalEntities.g:2993:1: entryRuleXExpressionInClosure returns [Boolean current=false] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final Boolean entryRuleXExpressionInClosure() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXExpressionInClosure = null;


        try {
            // PsiInternalEntities.g:2993:62: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // PsiInternalEntities.g:2994:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionInClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // PsiInternalEntities.g:3000:1: ruleXExpressionInClosure returns [Boolean current=false] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final Boolean ruleXExpressionInClosure() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean lv_expressions_1_0 = null;


        try {
            // PsiInternalEntities.g:3001:1: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // PsiInternalEntities.g:3002:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // PsiInternalEntities.g:3002:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // PsiInternalEntities.g:3003:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // PsiInternalEntities.g:3003:3: ()
            // PsiInternalEntities.g:3004:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXExpressionInClosure_XBlockExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalEntities.g:3010:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=RULE_STRING && LA54_0<=RULE_ID)||LA54_0==14||LA54_0==17||LA54_0==20||LA54_0==29||(LA54_0>=45 && LA54_0<=46)||LA54_0==51||(LA54_0>=58 && LA54_0<=59)||LA54_0==63||LA54_0==65||(LA54_0>=68 && LA54_0<=84)||LA54_0==86) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // PsiInternalEntities.g:3011:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // PsiInternalEntities.g:3011:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalEntities.g:3012:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalEntities.g:3012:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalEntities.g:3013:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXExpressionInClosure_ExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_51);
            	    lv_expressions_1_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalEntities.g:3026:4: (otherlv_2= ';' )?
            	    int alt53=2;
            	    int LA53_0 = input.LA(1);

            	    if ( (LA53_0==62) ) {
            	        alt53=1;
            	    }
            	    switch (alt53) {
            	        case 1 :
            	            // PsiInternalEntities.g:3027:5: otherlv_2= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getXExpressionInClosure_SemicolonKeyword_1_1ElementType());
            	              				
            	            }
            	            otherlv_2=(Token)match(input,62,FOLLOW_52); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_2);
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
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
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // PsiInternalEntities.g:3040:1: entryRuleXShortClosure returns [Boolean current=false] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final Boolean entryRuleXShortClosure() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXShortClosure = null;


        try {
            // PsiInternalEntities.g:3040:55: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // PsiInternalEntities.g:3041:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXShortClosureElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // PsiInternalEntities.g:3047:1: ruleXShortClosure returns [Boolean current=false] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXShortClosure() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        Boolean lv_declaredFormalParameters_1_0 = null;

        Boolean lv_declaredFormalParameters_3_0 = null;

        Boolean lv_expression_5_0 = null;


        try {
            // PsiInternalEntities.g:3048:1: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // PsiInternalEntities.g:3049:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // PsiInternalEntities.g:3049:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // PsiInternalEntities.g:3050:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // PsiInternalEntities.g:3050:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // PsiInternalEntities.g:3051:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // PsiInternalEntities.g:3076:4: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // PsiInternalEntities.g:3077:5: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // PsiInternalEntities.g:3077:5: ()
            // PsiInternalEntities.g:3078:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXShortClosure_XClosureAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            // PsiInternalEntities.g:3084:5: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID||LA56_0==20||LA56_0==42) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // PsiInternalEntities.g:3085:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // PsiInternalEntities.g:3085:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // PsiInternalEntities.g:3086:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // PsiInternalEntities.g:3086:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // PsiInternalEntities.g:3087:8: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_48);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }

                    // PsiInternalEntities.g:3100:6: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==21) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // PsiInternalEntities.g:3101:7: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getXShortClosure_CommaKeyword_0_0_1_1_0ElementType());
                    	      						
                    	    }
                    	    otherlv_2=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_2);
                    	      						
                    	    }
                    	    // PsiInternalEntities.g:3108:7: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // PsiInternalEntities.g:3109:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // PsiInternalEntities.g:3109:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // PsiInternalEntities.g:3110:9: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									markComposite(elementTypeProvider.getXShortClosure_DeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0ElementType());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_48);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            // PsiInternalEntities.g:3125:5: ( (lv_explicitSyntax_4_0= '|' ) )
            // PsiInternalEntities.g:3126:6: (lv_explicitSyntax_4_0= '|' )
            {
            // PsiInternalEntities.g:3126:6: (lv_explicitSyntax_4_0= '|' )
            // PsiInternalEntities.g:3127:7: lv_explicitSyntax_4_0= '|'
            {
            if ( state.backtracking==0 ) {

              							markLeaf(elementTypeProvider.getXShortClosure_ExplicitSyntaxVerticalLineKeyword_0_0_2_0ElementType());
              						
            }
            lv_explicitSyntax_4_0=(Token)match(input,61,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							doneLeaf(lv_explicitSyntax_4_0);
              						
            }
            if ( state.backtracking==0 ) {

              							if (!current) {
              								associateWithSemanticElement();
              								current = true;
              							}
              						
            }

            }


            }


            }


            }

            // PsiInternalEntities.g:3144:3: ( (lv_expression_5_0= ruleXExpression ) )
            // PsiInternalEntities.g:3145:4: (lv_expression_5_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3145:4: (lv_expression_5_0= ruleXExpression )
            // PsiInternalEntities.g:3146:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXShortClosure_ExpressionXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // PsiInternalEntities.g:3163:1: entryRuleXParenthesizedExpression returns [Boolean current=false] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final Boolean entryRuleXParenthesizedExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXParenthesizedExpression = null;


        try {
            // PsiInternalEntities.g:3163:66: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // PsiInternalEntities.g:3164:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXParenthesizedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // PsiInternalEntities.g:3170:1: ruleXParenthesizedExpression returns [Boolean current=false] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final Boolean ruleXParenthesizedExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_XExpression_1 = null;


        try {
            // PsiInternalEntities.g:3171:1: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // PsiInternalEntities.g:3172:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // PsiInternalEntities.g:3172:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // PsiInternalEntities.g:3173:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXParenthesizedExpression_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getXParenthesizedExpression_XExpressionParserRuleCall_1ElementType());
              		
            }
            pushFollow(FOLLOW_40);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XExpression_1;
              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXParenthesizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
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
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // PsiInternalEntities.g:3199:1: entryRuleXIfExpression returns [Boolean current=false] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final Boolean entryRuleXIfExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXIfExpression = null;


        try {
            // PsiInternalEntities.g:3199:55: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // PsiInternalEntities.g:3200:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXIfExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // PsiInternalEntities.g:3206:1: ruleXIfExpression returns [Boolean current=false] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final Boolean ruleXIfExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_if_3_0 = null;

        Boolean lv_then_5_0 = null;

        Boolean lv_else_7_0 = null;


        try {
            // PsiInternalEntities.g:3207:1: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // PsiInternalEntities.g:3208:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // PsiInternalEntities.g:3208:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // PsiInternalEntities.g:3209:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // PsiInternalEntities.g:3209:3: ()
            // PsiInternalEntities.g:3210:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXIfExpression_XIfExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_IfKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,63,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:3230:3: ( (lv_if_3_0= ruleXExpression ) )
            // PsiInternalEntities.g:3231:4: (lv_if_3_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3231:4: (lv_if_3_0= ruleXExpression )
            // PsiInternalEntities.g:3232:5: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXIfExpression_IfXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_40);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXIfExpression_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalEntities.g:3252:3: ( (lv_then_5_0= ruleXExpression ) )
            // PsiInternalEntities.g:3253:4: (lv_then_5_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3253:4: (lv_then_5_0= ruleXExpression )
            // PsiInternalEntities.g:3254:5: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXIfExpression_ThenXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_53);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalEntities.g:3267:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==64) ) {
                int LA57_1 = input.LA(2);

                if ( (synpred25_PsiInternalEntities()) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // PsiInternalEntities.g:3268:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // PsiInternalEntities.g:3268:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // PsiInternalEntities.g:3269:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXIfExpression_ElseKeyword_6_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,64,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }

                    }

                    // PsiInternalEntities.g:3278:4: ( (lv_else_7_0= ruleXExpression ) )
                    // PsiInternalEntities.g:3279:5: (lv_else_7_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3279:5: (lv_else_7_0= ruleXExpression )
                    // PsiInternalEntities.g:3280:6: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXIfExpression_ElseXExpressionParserRuleCall_6_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // PsiInternalEntities.g:3298:1: entryRuleXSwitchExpression returns [Boolean current=false] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final Boolean entryRuleXSwitchExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXSwitchExpression = null;


        try {
            // PsiInternalEntities.g:3298:59: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // PsiInternalEntities.g:3299:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSwitchExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // PsiInternalEntities.g:3305:1: ruleXSwitchExpression returns [Boolean current=false] : ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final Boolean ruleXSwitchExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Boolean lv_declaredParam_3_0 = null;

        Boolean lv_switch_5_0 = null;

        Boolean lv_declaredParam_7_0 = null;

        Boolean lv_switch_9_0 = null;

        Boolean lv_cases_11_0 = null;

        Boolean lv_default_14_0 = null;


        try {
            // PsiInternalEntities.g:3306:1: ( ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // PsiInternalEntities.g:3307:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // PsiInternalEntities.g:3307:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // PsiInternalEntities.g:3308:3: () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // PsiInternalEntities.g:3308:3: ()
            // PsiInternalEntities.g:3309:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXSwitchExpression_XSwitchExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_SwitchKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,65,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:3322:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // PsiInternalEntities.g:3323:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    {
                    // PsiInternalEntities.g:3323:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    // PsiInternalEntities.g:3324:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')'
                    {
                    // PsiInternalEntities.g:3324:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
                    // PsiInternalEntities.g:3325:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    {
                    // PsiInternalEntities.g:3335:6: (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    // PsiInternalEntities.g:3336:7: otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXSwitchExpression_LeftParenthesisKeyword_2_0_0_0_0ElementType());
                      						
                    }
                    otherlv_2=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_2);
                      						
                    }
                    // PsiInternalEntities.g:3343:7: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
                    // PsiInternalEntities.g:3344:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    {
                    // PsiInternalEntities.g:3344:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    // PsiInternalEntities.g:3345:9: lv_declaredParam_3_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0ElementType());
                      								
                    }
                    pushFollow(FOLLOW_9);
                    lv_declaredParam_3_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									doneComposite();
                      									if(!current) {
                      										associateWithSemanticElement();
                      										current = true;
                      									}
                      								
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_0_0_0_2ElementType());
                      						
                    }
                    otherlv_4=(Token)match(input,18,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(otherlv_4);
                      						
                    }

                    }


                    }

                    // PsiInternalEntities.g:3367:5: ( (lv_switch_5_0= ruleXExpression ) )
                    // PsiInternalEntities.g:3368:6: (lv_switch_5_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3368:6: (lv_switch_5_0= ruleXExpression )
                    // PsiInternalEntities.g:3369:7: lv_switch_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_40);
                    lv_switch_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXSwitchExpression_RightParenthesisKeyword_2_0_2ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:3391:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    {
                    // PsiInternalEntities.g:3391:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    // PsiInternalEntities.g:3392:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) )
                    {
                    // PsiInternalEntities.g:3392:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?
                    int alt58=2;
                    alt58 = dfa58.predict(input);
                    switch (alt58) {
                        case 1 :
                            // PsiInternalEntities.g:3393:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            {
                            // PsiInternalEntities.g:3402:6: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            // PsiInternalEntities.g:3403:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':'
                            {
                            // PsiInternalEntities.g:3403:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
                            // PsiInternalEntities.g:3404:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            {
                            // PsiInternalEntities.g:3404:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            // PsiInternalEntities.g:3405:9: lv_declaredParam_7_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getXSwitchExpression_DeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0ElementType());
                              								
                            }
                            pushFollow(FOLLOW_9);
                            lv_declaredParam_7_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_2_1_0_0_1ElementType());
                              						
                            }
                            otherlv_8=(Token)match(input,18,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_8);
                              						
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalEntities.g:3427:5: ( (lv_switch_9_0= ruleXExpression ) )
                    // PsiInternalEntities.g:3428:6: (lv_switch_9_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3428:6: (lv_switch_9_0= ruleXExpression )
                    // PsiInternalEntities.g:3429:7: lv_switch_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXSwitchExpression_SwitchXExpressionParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_5);
                    lv_switch_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_LeftCurlyBracketKeyword_3ElementType());
              		
            }
            otherlv_10=(Token)match(input,14,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalEntities.g:3451:3: ( (lv_cases_11_0= ruleXCasePart ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID||LA60_0==18||(LA60_0>=20 && LA60_0<=21)||LA60_0==42||LA60_0==67) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // PsiInternalEntities.g:3452:4: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // PsiInternalEntities.g:3452:4: (lv_cases_11_0= ruleXCasePart )
            	    // PsiInternalEntities.g:3453:5: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getXSwitchExpression_CasesXCasePartParserRuleCall_4_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_55);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break loop60;
                }
            } while (true);

            // PsiInternalEntities.g:3466:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==66) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // PsiInternalEntities.g:3467:4: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXSwitchExpression_DefaultKeyword_5_0ElementType());
                      			
                    }
                    otherlv_12=(Token)match(input,66,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_12);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXSwitchExpression_ColonKeyword_5_1ElementType());
                      			
                    }
                    otherlv_13=(Token)match(input,18,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_13);
                      			
                    }
                    // PsiInternalEntities.g:3481:4: ( (lv_default_14_0= ruleXExpression ) )
                    // PsiInternalEntities.g:3482:5: (lv_default_14_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3482:5: (lv_default_14_0= ruleXExpression )
                    // PsiInternalEntities.g:3483:6: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXSwitchExpression_DefaultXExpressionParserRuleCall_5_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_56);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSwitchExpression_RightCurlyBracketKeyword_6ElementType());
              		
            }
            otherlv_15=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_15);
              		
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
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // PsiInternalEntities.g:3508:1: entryRuleXCasePart returns [Boolean current=false] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final Boolean entryRuleXCasePart() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCasePart = null;


        try {
            // PsiInternalEntities.g:3508:51: (iv_ruleXCasePart= ruleXCasePart EOF )
            // PsiInternalEntities.g:3509:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCasePartElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // PsiInternalEntities.g:3515:1: ruleXCasePart returns [Boolean current=false] : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) ;
    public final Boolean ruleXCasePart() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_fallThrough_6_0=null;
        Boolean lv_typeGuard_1_0 = null;

        Boolean lv_case_3_0 = null;

        Boolean lv_then_5_0 = null;


        try {
            // PsiInternalEntities.g:3516:1: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) )
            // PsiInternalEntities.g:3517:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            {
            // PsiInternalEntities.g:3517:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            // PsiInternalEntities.g:3518:3: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            {
            // PsiInternalEntities.g:3518:3: ()
            // PsiInternalEntities.g:3519:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXCasePart_XCasePartAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalEntities.g:3525:3: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID||LA62_0==20||LA62_0==42) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // PsiInternalEntities.g:3526:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    {
                    // PsiInternalEntities.g:3526:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    // PsiInternalEntities.g:3527:5: lv_typeGuard_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXCasePart_TypeGuardJvmTypeReferenceParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_57);
                    lv_typeGuard_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalEntities.g:3540:3: (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==67) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // PsiInternalEntities.g:3541:4: otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXCasePart_CaseKeyword_2_0ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,67,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }
                    // PsiInternalEntities.g:3548:4: ( (lv_case_3_0= ruleXExpression ) )
                    // PsiInternalEntities.g:3549:5: (lv_case_3_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3549:5: (lv_case_3_0= ruleXExpression )
                    // PsiInternalEntities.g:3550:6: lv_case_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXCasePart_CaseXExpressionParserRuleCall_2_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_58);
                    lv_case_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalEntities.g:3564:3: ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==18) ) {
                alt64=1;
            }
            else if ( (LA64_0==21) ) {
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
                    // PsiInternalEntities.g:3565:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    {
                    // PsiInternalEntities.g:3565:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    // PsiInternalEntities.g:3566:5: otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXCasePart_ColonKeyword_3_0_0ElementType());
                      				
                    }
                    otherlv_4=(Token)match(input,18,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_4);
                      				
                    }
                    // PsiInternalEntities.g:3573:5: ( (lv_then_5_0= ruleXExpression ) )
                    // PsiInternalEntities.g:3574:6: (lv_then_5_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3574:6: (lv_then_5_0= ruleXExpression )
                    // PsiInternalEntities.g:3575:7: lv_then_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXCasePart_ThenXExpressionParserRuleCall_3_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_then_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:3590:4: ( (lv_fallThrough_6_0= ',' ) )
                    {
                    // PsiInternalEntities.g:3590:4: ( (lv_fallThrough_6_0= ',' ) )
                    // PsiInternalEntities.g:3591:5: (lv_fallThrough_6_0= ',' )
                    {
                    // PsiInternalEntities.g:3591:5: (lv_fallThrough_6_0= ',' )
                    // PsiInternalEntities.g:3592:6: lv_fallThrough_6_0= ','
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXCasePart_FallThroughCommaKeyword_3_1_0ElementType());
                      					
                    }
                    lv_fallThrough_6_0=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_fallThrough_6_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // PsiInternalEntities.g:3612:1: entryRuleXForLoopExpression returns [Boolean current=false] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final Boolean entryRuleXForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXForLoopExpression = null;


        try {
            // PsiInternalEntities.g:3612:60: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // PsiInternalEntities.g:3613:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXForLoopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // PsiInternalEntities.g:3619:1: ruleXForLoopExpression returns [Boolean current=false] : ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_declaredParam_3_0 = null;

        Boolean lv_forExpression_5_0 = null;

        Boolean lv_eachExpression_7_0 = null;


        try {
            // PsiInternalEntities.g:3620:1: ( ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // PsiInternalEntities.g:3621:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // PsiInternalEntities.g:3621:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // PsiInternalEntities.g:3622:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // PsiInternalEntities.g:3622:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
            // PsiInternalEntities.g:3623:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            {
            // PsiInternalEntities.g:3636:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            // PsiInternalEntities.g:3637:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
            {
            // PsiInternalEntities.g:3637:5: ()
            // PsiInternalEntities.g:3638:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXForLoopExpression_XForLoopExpressionAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_ForKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,68,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_LeftParenthesisKeyword_0_0_2ElementType());
              				
            }
            otherlv_2=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_2);
              				
            }
            // PsiInternalEntities.g:3658:5: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // PsiInternalEntities.g:3659:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // PsiInternalEntities.g:3659:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // PsiInternalEntities.g:3660:7: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              							markComposite(elementTypeProvider.getXForLoopExpression_DeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0ElementType());
              						
            }
            pushFollow(FOLLOW_9);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							doneComposite();
              							if(!current) {
              								associateWithSemanticElement();
              								current = true;
              							}
              						
            }

            }


            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXForLoopExpression_ColonKeyword_0_0_4ElementType());
              				
            }
            otherlv_4=(Token)match(input,18,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_4);
              				
            }

            }


            }

            // PsiInternalEntities.g:3682:3: ( (lv_forExpression_5_0= ruleXExpression ) )
            // PsiInternalEntities.g:3683:4: (lv_forExpression_5_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3683:4: (lv_forExpression_5_0= ruleXExpression )
            // PsiInternalEntities.g:3684:5: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXForLoopExpression_ForExpressionXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_40);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXForLoopExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_6=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
            }
            // PsiInternalEntities.g:3704:3: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // PsiInternalEntities.g:3705:4: (lv_eachExpression_7_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3705:4: (lv_eachExpression_7_0= ruleXExpression )
            // PsiInternalEntities.g:3706:5: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXForLoopExpression_EachExpressionXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXBasicForLoopExpression"
    // PsiInternalEntities.g:3723:1: entryRuleXBasicForLoopExpression returns [Boolean current=false] : iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
    public final Boolean entryRuleXBasicForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXBasicForLoopExpression = null;


        try {
            // PsiInternalEntities.g:3723:65: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
            // PsiInternalEntities.g:3724:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBasicForLoopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBasicForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBasicForLoopExpression"


    // $ANTLR start "ruleXBasicForLoopExpression"
    // PsiInternalEntities.g:3730:1: ruleXBasicForLoopExpression returns [Boolean current=false] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXBasicForLoopExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Boolean lv_initExpressions_3_0 = null;

        Boolean lv_initExpressions_5_0 = null;

        Boolean lv_expression_7_0 = null;

        Boolean lv_updateExpressions_9_0 = null;

        Boolean lv_updateExpressions_11_0 = null;

        Boolean lv_eachExpression_13_0 = null;


        try {
            // PsiInternalEntities.g:3731:1: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
            // PsiInternalEntities.g:3732:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            {
            // PsiInternalEntities.g:3732:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            // PsiInternalEntities.g:3733:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) )
            {
            // PsiInternalEntities.g:3733:3: ()
            // PsiInternalEntities.g:3734:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBasicForLoopExpression_XBasicForLoopExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_ForKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,68,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,20,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:3754:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=RULE_STRING && LA66_0<=RULE_ID)||LA66_0==14||LA66_0==17||LA66_0==20||LA66_0==29||(LA66_0>=45 && LA66_0<=46)||LA66_0==51||(LA66_0>=58 && LA66_0<=59)||LA66_0==63||LA66_0==65||(LA66_0>=68 && LA66_0<=84)||LA66_0==86) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // PsiInternalEntities.g:3755:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    {
                    // PsiInternalEntities.g:3755:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
                    // PsiInternalEntities.g:3756:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    {
                    // PsiInternalEntities.g:3756:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    // PsiInternalEntities.g:3757:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_60);
                    lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:3770:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==21) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // PsiInternalEntities.g:3771:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_3_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_4=(Token)match(input,21,FOLLOW_61); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_4);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:3778:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    // PsiInternalEntities.g:3779:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    {
                    	    // PsiInternalEntities.g:3779:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    // PsiInternalEntities.g:3780:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXBasicForLoopExpression_InitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_60);
                    	    lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop65;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_4ElementType());
              		
            }
            otherlv_6=(Token)match(input,62,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
            }
            // PsiInternalEntities.g:3802:3: ( (lv_expression_7_0= ruleXExpression ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_STRING && LA67_0<=RULE_ID)||LA67_0==14||LA67_0==17||LA67_0==20||LA67_0==29||(LA67_0>=45 && LA67_0<=46)||LA67_0==51||(LA67_0>=58 && LA67_0<=59)||LA67_0==63||LA67_0==65||(LA67_0>=68 && LA67_0<=70)||(LA67_0>=73 && LA67_0<=84)||LA67_0==86) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // PsiInternalEntities.g:3803:4: (lv_expression_7_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3803:4: (lv_expression_7_0= ruleXExpression )
                    // PsiInternalEntities.g:3804:5: lv_expression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXBasicForLoopExpression_ExpressionXExpressionParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_63);
                    lv_expression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_SemicolonKeyword_6ElementType());
              		
            }
            otherlv_8=(Token)match(input,62,FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_8);
              		
            }
            // PsiInternalEntities.g:3824:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_ID)||LA69_0==14||LA69_0==17||LA69_0==20||LA69_0==29||(LA69_0>=45 && LA69_0<=46)||LA69_0==51||(LA69_0>=58 && LA69_0<=59)||LA69_0==63||LA69_0==65||(LA69_0>=68 && LA69_0<=70)||(LA69_0>=73 && LA69_0<=84)||LA69_0==86) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // PsiInternalEntities.g:3825:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    {
                    // PsiInternalEntities.g:3825:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
                    // PsiInternalEntities.g:3826:5: (lv_updateExpressions_9_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:3826:5: (lv_updateExpressions_9_0= ruleXExpression )
                    // PsiInternalEntities.g:3827:6: lv_updateExpressions_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_0_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_updateExpressions_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:3840:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==21) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // PsiInternalEntities.g:3841:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXBasicForLoopExpression_CommaKeyword_7_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_10=(Token)match(input,21,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_10);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:3848:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    // PsiInternalEntities.g:3849:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    {
                    	    // PsiInternalEntities.g:3849:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    // PsiInternalEntities.g:3850:7: lv_updateExpressions_11_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXBasicForLoopExpression_UpdateExpressionsXExpressionParserRuleCall_7_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    lv_updateExpressions_11_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBasicForLoopExpression_RightParenthesisKeyword_8ElementType());
              		
            }
            otherlv_12=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_12);
              		
            }
            // PsiInternalEntities.g:3872:3: ( (lv_eachExpression_13_0= ruleXExpression ) )
            // PsiInternalEntities.g:3873:4: (lv_eachExpression_13_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3873:4: (lv_eachExpression_13_0= ruleXExpression )
            // PsiInternalEntities.g:3874:5: lv_eachExpression_13_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXBasicForLoopExpression_EachExpressionXExpressionParserRuleCall_9_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_13_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXBasicForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // PsiInternalEntities.g:3891:1: entryRuleXWhileExpression returns [Boolean current=false] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final Boolean entryRuleXWhileExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXWhileExpression = null;


        try {
            // PsiInternalEntities.g:3891:58: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // PsiInternalEntities.g:3892:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXWhileExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // PsiInternalEntities.g:3898:1: ruleXWhileExpression returns [Boolean current=false] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXWhileExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_predicate_3_0 = null;

        Boolean lv_body_5_0 = null;


        try {
            // PsiInternalEntities.g:3899:1: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // PsiInternalEntities.g:3900:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // PsiInternalEntities.g:3900:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // PsiInternalEntities.g:3901:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // PsiInternalEntities.g:3901:3: ()
            // PsiInternalEntities.g:3902:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXWhileExpression_XWhileExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_WhileKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,69,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:3922:3: ( (lv_predicate_3_0= ruleXExpression ) )
            // PsiInternalEntities.g:3923:4: (lv_predicate_3_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3923:4: (lv_predicate_3_0= ruleXExpression )
            // PsiInternalEntities.g:3924:5: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXWhileExpression_PredicateXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_40);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXWhileExpression_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalEntities.g:3944:3: ( (lv_body_5_0= ruleXExpression ) )
            // PsiInternalEntities.g:3945:4: (lv_body_5_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3945:4: (lv_body_5_0= ruleXExpression )
            // PsiInternalEntities.g:3946:5: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXWhileExpression_BodyXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // PsiInternalEntities.g:3963:1: entryRuleXDoWhileExpression returns [Boolean current=false] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final Boolean entryRuleXDoWhileExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXDoWhileExpression = null;


        try {
            // PsiInternalEntities.g:3963:60: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // PsiInternalEntities.g:3964:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXDoWhileExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // PsiInternalEntities.g:3970:1: ruleXDoWhileExpression returns [Boolean current=false] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final Boolean ruleXDoWhileExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_body_2_0 = null;

        Boolean lv_predicate_5_0 = null;


        try {
            // PsiInternalEntities.g:3971:1: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // PsiInternalEntities.g:3972:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // PsiInternalEntities.g:3972:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // PsiInternalEntities.g:3973:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // PsiInternalEntities.g:3973:3: ()
            // PsiInternalEntities.g:3974:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXDoWhileExpression_XDoWhileExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_DoKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,70,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:3987:3: ( (lv_body_2_0= ruleXExpression ) )
            // PsiInternalEntities.g:3988:4: (lv_body_2_0= ruleXExpression )
            {
            // PsiInternalEntities.g:3988:4: (lv_body_2_0= ruleXExpression )
            // PsiInternalEntities.g:3989:5: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXDoWhileExpression_BodyXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_65);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_WhileKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,69,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_LeftParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalEntities.g:4016:3: ( (lv_predicate_5_0= ruleXExpression ) )
            // PsiInternalEntities.g:4017:4: (lv_predicate_5_0= ruleXExpression )
            {
            // PsiInternalEntities.g:4017:4: (lv_predicate_5_0= ruleXExpression )
            // PsiInternalEntities.g:4018:5: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXDoWhileExpression_PredicateXExpressionParserRuleCall_5_0ElementType());
              				
            }
            pushFollow(FOLLOW_40);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXDoWhileExpression_RightParenthesisKeyword_6ElementType());
              		
            }
            otherlv_6=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_6);
              		
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
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // PsiInternalEntities.g:4042:1: entryRuleXBlockExpression returns [Boolean current=false] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final Boolean entryRuleXBlockExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXBlockExpression = null;


        try {
            // PsiInternalEntities.g:4042:58: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // PsiInternalEntities.g:4043:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBlockExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // PsiInternalEntities.g:4049:1: ruleXBlockExpression returns [Boolean current=false] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final Boolean ruleXBlockExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_expressions_2_0 = null;


        try {
            // PsiInternalEntities.g:4050:1: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // PsiInternalEntities.g:4051:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // PsiInternalEntities.g:4051:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // PsiInternalEntities.g:4052:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // PsiInternalEntities.g:4052:3: ()
            // PsiInternalEntities.g:4053:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBlockExpression_XBlockExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:4066:3: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>=RULE_STRING && LA71_0<=RULE_ID)||LA71_0==14||LA71_0==17||LA71_0==20||LA71_0==29||(LA71_0>=45 && LA71_0<=46)||LA71_0==51||(LA71_0>=58 && LA71_0<=59)||LA71_0==63||LA71_0==65||(LA71_0>=68 && LA71_0<=84)||LA71_0==86) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // PsiInternalEntities.g:4067:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
            	    {
            	    // PsiInternalEntities.g:4067:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
            	    // PsiInternalEntities.g:4068:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // PsiInternalEntities.g:4068:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    // PsiInternalEntities.g:4069:6: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getXBlockExpression_ExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_67);
            	    lv_expressions_2_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalEntities.g:4082:4: (otherlv_3= ';' )?
            	    int alt70=2;
            	    int LA70_0 = input.LA(1);

            	    if ( (LA70_0==62) ) {
            	        alt70=1;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // PsiInternalEntities.g:4083:5: otherlv_3= ';'
            	            {
            	            if ( state.backtracking==0 ) {

            	              					markLeaf(elementTypeProvider.getXBlockExpression_SemicolonKeyword_2_1ElementType());
            	              				
            	            }
            	            otherlv_3=(Token)match(input,62,FOLLOW_66); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					doneLeaf(otherlv_3);
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXBlockExpression_RightCurlyBracketKeyword_3ElementType());
              		
            }
            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
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
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionOrVarDeclaration"
    // PsiInternalEntities.g:4103:1: entryRuleXExpressionOrVarDeclaration returns [Boolean current=false] : iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
    public final Boolean entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXExpressionOrVarDeclaration = null;


        try {
            // PsiInternalEntities.g:4103:69: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
            // PsiInternalEntities.g:4104:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXExpressionOrVarDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionOrVarDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionOrVarDeclaration"


    // $ANTLR start "ruleXExpressionOrVarDeclaration"
    // PsiInternalEntities.g:4110:1: ruleXExpressionOrVarDeclaration returns [Boolean current=false] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final Boolean ruleXExpressionOrVarDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean this_XVariableDeclaration_0 = null;

        Boolean this_XExpression_1 = null;


        try {
            // PsiInternalEntities.g:4111:1: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // PsiInternalEntities.g:4112:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // PsiInternalEntities.g:4112:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=71 && LA72_0<=72)) ) {
                alt72=1;
            }
            else if ( ((LA72_0>=RULE_STRING && LA72_0<=RULE_ID)||LA72_0==14||LA72_0==17||LA72_0==20||LA72_0==29||(LA72_0>=45 && LA72_0<=46)||LA72_0==51||(LA72_0>=58 && LA72_0<=59)||LA72_0==63||LA72_0==65||(LA72_0>=68 && LA72_0<=70)||(LA72_0>=73 && LA72_0<=84)||LA72_0==86) ) {
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
                    // PsiInternalEntities.g:4113:3: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XVariableDeclarationParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XVariableDeclaration_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:4122:3: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getXExpressionOrVarDeclaration_XExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XExpression_1;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleXExpressionOrVarDeclaration"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // PsiInternalEntities.g:4134:1: entryRuleXVariableDeclaration returns [Boolean current=false] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final Boolean entryRuleXVariableDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXVariableDeclaration = null;


        try {
            // PsiInternalEntities.g:4134:62: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // PsiInternalEntities.g:4135:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXVariableDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // PsiInternalEntities.g:4141:1: ruleXVariableDeclaration returns [Boolean current=false] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final Boolean ruleXVariableDeclaration() throws RecognitionException {
        Boolean current = false;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_name_4_0 = null;

        Boolean lv_name_5_0 = null;

        Boolean lv_right_7_0 = null;


        try {
            // PsiInternalEntities.g:4142:1: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // PsiInternalEntities.g:4143:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // PsiInternalEntities.g:4143:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // PsiInternalEntities.g:4144:3: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // PsiInternalEntities.g:4144:3: ()
            // PsiInternalEntities.g:4145:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXVariableDeclaration_XVariableDeclarationAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalEntities.g:4151:3: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==71) ) {
                alt73=1;
            }
            else if ( (LA73_0==72) ) {
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
                    // PsiInternalEntities.g:4152:4: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // PsiInternalEntities.g:4152:4: ( (lv_writeable_1_0= 'var' ) )
                    // PsiInternalEntities.g:4153:5: (lv_writeable_1_0= 'var' )
                    {
                    // PsiInternalEntities.g:4153:5: (lv_writeable_1_0= 'var' )
                    // PsiInternalEntities.g:4154:6: lv_writeable_1_0= 'var'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXVariableDeclaration_WriteableVarKeyword_1_0_0ElementType());
                      					
                    }
                    lv_writeable_1_0=(Token)match(input,71,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_writeable_1_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:4170:4: otherlv_2= 'val'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXVariableDeclaration_ValKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,72,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalEntities.g:4178:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                int LA74_1 = input.LA(2);

                if ( (synpred29_PsiInternalEntities()) ) {
                    alt74=1;
                }
                else if ( (true) ) {
                    alt74=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA74_0==20) && (synpred29_PsiInternalEntities())) {
                alt74=1;
            }
            else if ( (LA74_0==42) && (synpred29_PsiInternalEntities())) {
                alt74=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // PsiInternalEntities.g:4179:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // PsiInternalEntities.g:4179:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // PsiInternalEntities.g:4180:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // PsiInternalEntities.g:4193:5: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // PsiInternalEntities.g:4194:6: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // PsiInternalEntities.g:4194:6: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // PsiInternalEntities.g:4195:7: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // PsiInternalEntities.g:4195:7: (lv_type_3_0= ruleJvmTypeReference )
                    // PsiInternalEntities.g:4196:8: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXVariableDeclaration_TypeJvmTypeReferenceParserRuleCall_2_0_0_0_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_4);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }

                    // PsiInternalEntities.g:4209:6: ( (lv_name_4_0= ruleValidID ) )
                    // PsiInternalEntities.g:4210:7: (lv_name_4_0= ruleValidID )
                    {
                    // PsiInternalEntities.g:4210:7: (lv_name_4_0= ruleValidID )
                    // PsiInternalEntities.g:4211:8: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_0_0_1_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_68);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:4227:4: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // PsiInternalEntities.g:4227:4: ( (lv_name_5_0= ruleValidID ) )
                    // PsiInternalEntities.g:4228:5: (lv_name_5_0= ruleValidID )
                    {
                    // PsiInternalEntities.g:4228:5: (lv_name_5_0= ruleValidID )
                    // PsiInternalEntities.g:4229:6: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXVariableDeclaration_NameValidIDParserRuleCall_2_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_68);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalEntities.g:4243:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==23) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // PsiInternalEntities.g:4244:4: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXVariableDeclaration_EqualsSignKeyword_3_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalEntities.g:4251:4: ( (lv_right_7_0= ruleXExpression ) )
                    // PsiInternalEntities.g:4252:5: (lv_right_7_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:4252:5: (lv_right_7_0= ruleXExpression )
                    // PsiInternalEntities.g:4253:6: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXVariableDeclaration_RightXExpressionParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // PsiInternalEntities.g:4271:1: entryRuleJvmFormalParameter returns [Boolean current=false] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final Boolean entryRuleJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmFormalParameter = null;


        try {
            // PsiInternalEntities.g:4271:60: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // PsiInternalEntities.g:4272:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmFormalParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // PsiInternalEntities.g:4278:1: ruleJvmFormalParameter returns [Boolean current=false] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final Boolean ruleJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean lv_parameterType_0_0 = null;

        Boolean lv_name_1_0 = null;


        try {
            // PsiInternalEntities.g:4279:1: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // PsiInternalEntities.g:4280:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // PsiInternalEntities.g:4280:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // PsiInternalEntities.g:4281:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // PsiInternalEntities.g:4281:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==RULE_ID||LA76_1==29||LA76_1==55||LA76_1==59) ) {
                    alt76=1;
                }
            }
            else if ( (LA76_0==20||LA76_0==42) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // PsiInternalEntities.g:4282:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // PsiInternalEntities.g:4282:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // PsiInternalEntities.g:4283:5: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_4);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalEntities.g:4296:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalEntities.g:4297:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalEntities.g:4297:4: (lv_name_1_0= ruleValidID )
            // PsiInternalEntities.g:4298:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // PsiInternalEntities.g:4315:1: entryRuleFullJvmFormalParameter returns [Boolean current=false] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final Boolean entryRuleFullJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFullJvmFormalParameter = null;


        try {
            // PsiInternalEntities.g:4315:64: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // PsiInternalEntities.g:4316:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFullJvmFormalParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // PsiInternalEntities.g:4322:1: ruleFullJvmFormalParameter returns [Boolean current=false] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final Boolean ruleFullJvmFormalParameter() throws RecognitionException {
        Boolean current = false;

        Boolean lv_parameterType_0_0 = null;

        Boolean lv_name_1_0 = null;


        try {
            // PsiInternalEntities.g:4323:1: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // PsiInternalEntities.g:4324:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // PsiInternalEntities.g:4324:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // PsiInternalEntities.g:4325:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // PsiInternalEntities.g:4325:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // PsiInternalEntities.g:4326:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // PsiInternalEntities.g:4326:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            // PsiInternalEntities.g:4327:5: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getFullJvmFormalParameter_ParameterTypeJvmTypeReferenceParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_4);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalEntities.g:4340:3: ( (lv_name_1_0= ruleValidID ) )
            // PsiInternalEntities.g:4341:4: (lv_name_1_0= ruleValidID )
            {
            // PsiInternalEntities.g:4341:4: (lv_name_1_0= ruleValidID )
            // PsiInternalEntities.g:4342:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getFullJvmFormalParameter_NameValidIDParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // PsiInternalEntities.g:4359:1: entryRuleXFeatureCall returns [Boolean current=false] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final Boolean entryRuleXFeatureCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXFeatureCall = null;


        try {
            // PsiInternalEntities.g:4359:54: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // PsiInternalEntities.g:4360:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFeatureCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // PsiInternalEntities.g:4366:1: ruleXFeatureCall returns [Boolean current=false] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
    public final Boolean ruleXFeatureCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_explicitOperationCall_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Boolean lv_typeArguments_2_0 = null;

        Boolean lv_typeArguments_4_0 = null;

        Boolean lv_featureCallArguments_8_0 = null;

        Boolean lv_featureCallArguments_9_0 = null;

        Boolean lv_featureCallArguments_11_0 = null;

        Boolean lv_featureCallArguments_13_0 = null;


        try {
            // PsiInternalEntities.g:4367:1: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
            // PsiInternalEntities.g:4368:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            {
            // PsiInternalEntities.g:4368:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            // PsiInternalEntities.g:4369:3: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            {
            // PsiInternalEntities.g:4369:3: ()
            // PsiInternalEntities.g:4370:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXFeatureCall_XFeatureCallAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalEntities.g:4376:3: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==29) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // PsiInternalEntities.g:4377:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFeatureCall_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,29,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalEntities.g:4384:4: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalEntities.g:4385:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalEntities.g:4385:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // PsiInternalEntities.g:4386:6: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_37);
                    lv_typeArguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:4399:4: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==21) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // PsiInternalEntities.g:4400:5: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:4407:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalEntities.g:4408:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalEntities.g:4408:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalEntities.g:4409:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXFeatureCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_37);
                    	    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFeatureCall_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,30,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalEntities.g:4431:3: ( ( ruleIdOrSuper ) )
            // PsiInternalEntities.g:4432:4: ( ruleIdOrSuper )
            {
            // PsiInternalEntities.g:4432:4: ( ruleIdOrSuper )
            // PsiInternalEntities.g:4433:5: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_69);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalEntities.g:4448:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // PsiInternalEntities.g:4449:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
                    {
                    // PsiInternalEntities.g:4449:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
                    // PsiInternalEntities.g:4450:5: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
                    {
                    // PsiInternalEntities.g:4454:5: (lv_explicitOperationCall_7_0= '(' )
                    // PsiInternalEntities.g:4455:6: lv_explicitOperationCall_7_0= '('
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXFeatureCall_ExplicitOperationCallLeftParenthesisKeyword_3_0_0ElementType());
                      					
                    }
                    lv_explicitOperationCall_7_0=(Token)match(input,20,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_explicitOperationCall_7_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:4470:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt80=3;
                    alt80 = dfa80.predict(input);
                    switch (alt80) {
                        case 1 :
                            // PsiInternalEntities.g:4471:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // PsiInternalEntities.g:4471:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // PsiInternalEntities.g:4472:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // PsiInternalEntities.g:4497:6: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // PsiInternalEntities.g:4498:7: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_40);
                            lv_featureCallArguments_8_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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
                            // PsiInternalEntities.g:4512:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // PsiInternalEntities.g:4512:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // PsiInternalEntities.g:4513:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // PsiInternalEntities.g:4513:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // PsiInternalEntities.g:4514:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // PsiInternalEntities.g:4514:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            // PsiInternalEntities.g:4515:8: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_13);
                            lv_featureCallArguments_9_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalEntities.g:4528:6: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop79:
                            do {
                                int alt79=2;
                                int LA79_0 = input.LA(1);

                                if ( (LA79_0==21) ) {
                                    alt79=1;
                                }


                                switch (alt79) {
                            	case 1 :
                            	    // PsiInternalEntities.g:4529:7: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXFeatureCall_CommaKeyword_3_1_1_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_10=(Token)match(input,21,FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_10);
                            	      						
                            	    }
                            	    // PsiInternalEntities.g:4536:7: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // PsiInternalEntities.g:4537:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // PsiInternalEntities.g:4537:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // PsiInternalEntities.g:4538:9: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_13);
                            	    lv_featureCallArguments_11_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

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

                            	default :
                            	    break loop79;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFeatureCall_RightParenthesisKeyword_3_2ElementType());
                      			
                    }
                    otherlv_12=(Token)match(input,22,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_12);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalEntities.g:4562:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // PsiInternalEntities.g:4563:4: ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
                    {
                    // PsiInternalEntities.g:4569:4: (lv_featureCallArguments_13_0= ruleXClosure )
                    // PsiInternalEntities.g:4570:5: lv_featureCallArguments_13_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXFeatureCall_FeatureCallArgumentsXClosureParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_featureCallArguments_13_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleFeatureCallID"
    // PsiInternalEntities.g:4587:1: entryRuleFeatureCallID returns [Boolean current=false] : iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
    public final Boolean entryRuleFeatureCallID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFeatureCallID = null;


        try {
            // PsiInternalEntities.g:4587:55: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
            // PsiInternalEntities.g:4588:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureCallIDElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallID=ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallID; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // PsiInternalEntities.g:4594:1: ruleFeatureCallID returns [Boolean current=false] : ( ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' ) ;
    public final Boolean ruleFeatureCallID() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:4595:1: ( ( ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' ) )
            // PsiInternalEntities.g:4596:2: ( ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' )
            {
            // PsiInternalEntities.g:4596:2: ( ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' )
            int alt83=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt83=1;
                }
                break;
            case 17:
                {
                alt83=2;
                }
                break;
            case 73:
                {
                alt83=3;
                }
                break;
            case 74:
                {
                alt83=4;
                }
                break;
            case 75:
                {
                alt83=5;
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
                    // PsiInternalEntities.g:4597:3: ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFeatureCallID_ValidIDParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:4605:3: kw= 'extends'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getFeatureCallID_ExtendsKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:4613:3: kw= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getFeatureCallID_StaticKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalEntities.g:4621:3: kw= 'import'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getFeatureCallID_ImportKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalEntities.g:4629:3: kw= 'extension'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getFeatureCallID_ExtensionKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRuleIdOrSuper"
    // PsiInternalEntities.g:4640:1: entryRuleIdOrSuper returns [Boolean current=false] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final Boolean entryRuleIdOrSuper() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIdOrSuper = null;


        try {
            // PsiInternalEntities.g:4640:51: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // PsiInternalEntities.g:4641:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getIdOrSuperElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // PsiInternalEntities.g:4647:1: ruleIdOrSuper returns [Boolean current=false] : ( ruleFeatureCallID | kw= 'super' ) ;
    public final Boolean ruleIdOrSuper() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:4648:1: ( ( ruleFeatureCallID | kw= 'super' ) )
            // PsiInternalEntities.g:4649:2: ( ruleFeatureCallID | kw= 'super' )
            {
            // PsiInternalEntities.g:4649:2: ( ruleFeatureCallID | kw= 'super' )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ID||LA84_0==17||(LA84_0>=73 && LA84_0<=75)) ) {
                alt84=1;
            }
            else if ( (LA84_0==76) ) {
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
                    // PsiInternalEntities.g:4650:3: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getIdOrSuper_FeatureCallIDParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:4658:3: kw= 'super'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getIdOrSuper_SuperKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleXConstructorCall"
    // PsiInternalEntities.g:4669:1: entryRuleXConstructorCall returns [Boolean current=false] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final Boolean entryRuleXConstructorCall() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXConstructorCall = null;


        try {
            // PsiInternalEntities.g:4669:58: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // PsiInternalEntities.g:4670:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXConstructorCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // PsiInternalEntities.g:4676:1: ruleXConstructorCall returns [Boolean current=false] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final Boolean ruleXConstructorCall() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_explicitConstructorCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Boolean lv_typeArguments_4_0 = null;

        Boolean lv_typeArguments_6_0 = null;

        Boolean lv_arguments_9_0 = null;

        Boolean lv_arguments_10_0 = null;

        Boolean lv_arguments_12_0 = null;

        Boolean lv_arguments_14_0 = null;


        try {
            // PsiInternalEntities.g:4677:1: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // PsiInternalEntities.g:4678:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // PsiInternalEntities.g:4678:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // PsiInternalEntities.g:4679:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // PsiInternalEntities.g:4679:3: ()
            // PsiInternalEntities.g:4680:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXConstructorCall_XConstructorCallAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXConstructorCall_NewKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,77,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:4693:3: ( ( ruleQualifiedName ) )
            // PsiInternalEntities.g:4694:4: ( ruleQualifiedName )
            {
            // PsiInternalEntities.g:4694:4: ( ruleQualifiedName )
            // PsiInternalEntities.g:4695:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXConstructorCall_ConstructorJvmConstructorCrossReference_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_71);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalEntities.g:4710:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // PsiInternalEntities.g:4711:4: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // PsiInternalEntities.g:4711:4: ( ( '<' )=>otherlv_3= '<' )
                    // PsiInternalEntities.g:4712:5: ( '<' )=>otherlv_3= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXConstructorCall_LessThanSignKeyword_3_0ElementType());
                      				
                    }
                    otherlv_3=(Token)match(input,29,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_3);
                      				
                    }

                    }

                    // PsiInternalEntities.g:4721:4: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalEntities.g:4722:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalEntities.g:4722:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // PsiInternalEntities.g:4723:6: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_37);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:4736:4: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==21) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // PsiInternalEntities.g:4737:5: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getXConstructorCall_CommaKeyword_3_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_5=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_5);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:4744:5: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalEntities.g:4745:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalEntities.g:4745:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalEntities.g:4746:7: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXConstructorCall_TypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_37);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop85;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXConstructorCall_GreaterThanSignKeyword_3_3ElementType());
                      			
                    }
                    otherlv_7=(Token)match(input,30,FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_7);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalEntities.g:4768:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt89=2;
            alt89 = dfa89.predict(input);
            switch (alt89) {
                case 1 :
                    // PsiInternalEntities.g:4769:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // PsiInternalEntities.g:4769:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
                    // PsiInternalEntities.g:4770:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
                    {
                    // PsiInternalEntities.g:4774:5: (lv_explicitConstructorCall_8_0= '(' )
                    // PsiInternalEntities.g:4775:6: lv_explicitConstructorCall_8_0= '('
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXConstructorCall_ExplicitConstructorCallLeftParenthesisKeyword_4_0_0ElementType());
                      					
                    }
                    lv_explicitConstructorCall_8_0=(Token)match(input,20,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_explicitConstructorCall_8_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:4790:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt88=3;
                    alt88 = dfa88.predict(input);
                    switch (alt88) {
                        case 1 :
                            // PsiInternalEntities.g:4791:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // PsiInternalEntities.g:4791:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // PsiInternalEntities.g:4792:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // PsiInternalEntities.g:4817:6: (lv_arguments_9_0= ruleXShortClosure )
                            // PsiInternalEntities.g:4818:7: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXShortClosureParserRuleCall_4_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_40);
                            lv_arguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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
                            // PsiInternalEntities.g:4832:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // PsiInternalEntities.g:4832:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // PsiInternalEntities.g:4833:6: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // PsiInternalEntities.g:4833:6: ( (lv_arguments_10_0= ruleXExpression ) )
                            // PsiInternalEntities.g:4834:7: (lv_arguments_10_0= ruleXExpression )
                            {
                            // PsiInternalEntities.g:4834:7: (lv_arguments_10_0= ruleXExpression )
                            // PsiInternalEntities.g:4835:8: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_13);
                            lv_arguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalEntities.g:4848:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( (LA87_0==21) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // PsiInternalEntities.g:4849:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getXConstructorCall_CommaKeyword_4_1_1_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_11=(Token)match(input,21,FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_11);
                            	      						
                            	    }
                            	    // PsiInternalEntities.g:4856:7: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // PsiInternalEntities.g:4857:8: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // PsiInternalEntities.g:4857:8: (lv_arguments_12_0= ruleXExpression )
                            	    // PsiInternalEntities.g:4858:9: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXExpressionParserRuleCall_4_1_1_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_13);
                            	    lv_arguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

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

                            	default :
                            	    break loop87;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXConstructorCall_RightParenthesisKeyword_4_2ElementType());
                      			
                    }
                    otherlv_13=(Token)match(input,22,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_13);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalEntities.g:4882:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt90=2;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // PsiInternalEntities.g:4883:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // PsiInternalEntities.g:4889:4: (lv_arguments_14_0= ruleXClosure )
                    // PsiInternalEntities.g:4890:5: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXConstructorCall_ArgumentsXClosureParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // PsiInternalEntities.g:4907:1: entryRuleXBooleanLiteral returns [Boolean current=false] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final Boolean entryRuleXBooleanLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXBooleanLiteral = null;


        try {
            // PsiInternalEntities.g:4907:57: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // PsiInternalEntities.g:4908:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXBooleanLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // PsiInternalEntities.g:4914:1: ruleXBooleanLiteral returns [Boolean current=false] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final Boolean ruleXBooleanLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;

        try {
            // PsiInternalEntities.g:4915:1: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // PsiInternalEntities.g:4916:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // PsiInternalEntities.g:4916:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // PsiInternalEntities.g:4917:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // PsiInternalEntities.g:4917:3: ()
            // PsiInternalEntities.g:4918:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXBooleanLiteral_XBooleanLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalEntities.g:4924:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==78) ) {
                alt91=1;
            }
            else if ( (LA91_0==79) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // PsiInternalEntities.g:4925:4: otherlv_1= 'false'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXBooleanLiteral_FalseKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:4933:4: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // PsiInternalEntities.g:4933:4: ( (lv_isTrue_2_0= 'true' ) )
                    // PsiInternalEntities.g:4934:5: (lv_isTrue_2_0= 'true' )
                    {
                    // PsiInternalEntities.g:4934:5: (lv_isTrue_2_0= 'true' )
                    // PsiInternalEntities.g:4935:6: lv_isTrue_2_0= 'true'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getXBooleanLiteral_IsTrueTrueKeyword_1_1_0ElementType());
                      					
                    }
                    lv_isTrue_2_0=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_isTrue_2_0);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
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
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // PsiInternalEntities.g:4955:1: entryRuleXNullLiteral returns [Boolean current=false] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final Boolean entryRuleXNullLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXNullLiteral = null;


        try {
            // PsiInternalEntities.g:4955:54: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // PsiInternalEntities.g:4956:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXNullLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // PsiInternalEntities.g:4962:1: ruleXNullLiteral returns [Boolean current=false] : ( () otherlv_1= 'null' ) ;
    public final Boolean ruleXNullLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalEntities.g:4963:1: ( ( () otherlv_1= 'null' ) )
            // PsiInternalEntities.g:4964:2: ( () otherlv_1= 'null' )
            {
            // PsiInternalEntities.g:4964:2: ( () otherlv_1= 'null' )
            // PsiInternalEntities.g:4965:3: () otherlv_1= 'null'
            {
            // PsiInternalEntities.g:4965:3: ()
            // PsiInternalEntities.g:4966:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXNullLiteral_XNullLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXNullLiteral_NullKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
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
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // PsiInternalEntities.g:4983:1: entryRuleXNumberLiteral returns [Boolean current=false] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final Boolean entryRuleXNumberLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXNumberLiteral = null;


        try {
            // PsiInternalEntities.g:4983:56: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // PsiInternalEntities.g:4984:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXNumberLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // PsiInternalEntities.g:4990:1: ruleXNumberLiteral returns [Boolean current=false] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final Boolean ruleXNumberLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean lv_value_1_0 = null;


        try {
            // PsiInternalEntities.g:4991:1: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // PsiInternalEntities.g:4992:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // PsiInternalEntities.g:4992:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // PsiInternalEntities.g:4993:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // PsiInternalEntities.g:4993:3: ()
            // PsiInternalEntities.g:4994:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXNumberLiteral_XNumberLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalEntities.g:5000:3: ( (lv_value_1_0= ruleNumber ) )
            // PsiInternalEntities.g:5001:4: (lv_value_1_0= ruleNumber )
            {
            // PsiInternalEntities.g:5001:4: (lv_value_1_0= ruleNumber )
            // PsiInternalEntities.g:5002:5: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXNumberLiteral_ValueNumberParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // PsiInternalEntities.g:5019:1: entryRuleXStringLiteral returns [Boolean current=false] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final Boolean entryRuleXStringLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXStringLiteral = null;


        try {
            // PsiInternalEntities.g:5019:56: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // PsiInternalEntities.g:5020:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXStringLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // PsiInternalEntities.g:5026:1: ruleXStringLiteral returns [Boolean current=false] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final Boolean ruleXStringLiteral() throws RecognitionException {
        Boolean current = false;

        Token lv_value_1_0=null;

        try {
            // PsiInternalEntities.g:5027:1: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // PsiInternalEntities.g:5028:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // PsiInternalEntities.g:5028:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // PsiInternalEntities.g:5029:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // PsiInternalEntities.g:5029:3: ()
            // PsiInternalEntities.g:5030:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXStringLiteral_XStringLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalEntities.g:5036:3: ( (lv_value_1_0= RULE_STRING ) )
            // PsiInternalEntities.g:5037:4: (lv_value_1_0= RULE_STRING )
            {
            // PsiInternalEntities.g:5037:4: (lv_value_1_0= RULE_STRING )
            // PsiInternalEntities.g:5038:5: lv_value_1_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXStringLiteral_ValueSTRINGTerminalRuleCall_1_0ElementType());
              				
            }
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_value_1_0);
              				
            }

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
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // PsiInternalEntities.g:5057:1: entryRuleXTypeLiteral returns [Boolean current=false] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final Boolean entryRuleXTypeLiteral() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXTypeLiteral = null;


        try {
            // PsiInternalEntities.g:5057:54: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // PsiInternalEntities.g:5058:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXTypeLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // PsiInternalEntities.g:5064:1: ruleXTypeLiteral returns [Boolean current=false] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
    public final Boolean ruleXTypeLiteral() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Boolean lv_arrayDimensions_4_0 = null;


        try {
            // PsiInternalEntities.g:5065:1: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
            // PsiInternalEntities.g:5066:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            {
            // PsiInternalEntities.g:5066:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            // PsiInternalEntities.g:5067:3: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
            {
            // PsiInternalEntities.g:5067:3: ()
            // PsiInternalEntities.g:5068:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXTypeLiteral_XTypeLiteralAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_TypeofKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,81,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalEntities.g:5088:3: ( ( ruleQualifiedName ) )
            // PsiInternalEntities.g:5089:4: ( ruleQualifiedName )
            {
            // PsiInternalEntities.g:5089:4: ( ruleQualifiedName )
            // PsiInternalEntities.g:5090:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXTypeLiteral_TypeJvmTypeCrossReference_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_72);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalEntities.g:5105:3: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==59) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // PsiInternalEntities.g:5106:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    {
            	    // PsiInternalEntities.g:5106:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    // PsiInternalEntities.g:5107:5: lv_arrayDimensions_4_0= ruleArrayBrackets
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markComposite(elementTypeProvider.getXTypeLiteral_ArrayDimensionsArrayBracketsParserRuleCall_4_0ElementType());
            	      				
            	    }
            	    pushFollow(FOLLOW_72);
            	    lv_arrayDimensions_4_0=ruleArrayBrackets();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    break loop92;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTypeLiteral_RightParenthesisKeyword_5ElementType());
              		
            }
            otherlv_5=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
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
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // PsiInternalEntities.g:5131:1: entryRuleXThrowExpression returns [Boolean current=false] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final Boolean entryRuleXThrowExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXThrowExpression = null;


        try {
            // PsiInternalEntities.g:5131:58: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // PsiInternalEntities.g:5132:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXThrowExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // PsiInternalEntities.g:5138:1: ruleXThrowExpression returns [Boolean current=false] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXThrowExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_expression_2_0 = null;


        try {
            // PsiInternalEntities.g:5139:1: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // PsiInternalEntities.g:5140:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // PsiInternalEntities.g:5140:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // PsiInternalEntities.g:5141:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // PsiInternalEntities.g:5141:3: ()
            // PsiInternalEntities.g:5142:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXThrowExpression_XThrowExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXThrowExpression_ThrowKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,82,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:5155:3: ( (lv_expression_2_0= ruleXExpression ) )
            // PsiInternalEntities.g:5156:4: (lv_expression_2_0= ruleXExpression )
            {
            // PsiInternalEntities.g:5156:4: (lv_expression_2_0= ruleXExpression )
            // PsiInternalEntities.g:5157:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXThrowExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // PsiInternalEntities.g:5174:1: entryRuleXReturnExpression returns [Boolean current=false] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final Boolean entryRuleXReturnExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXReturnExpression = null;


        try {
            // PsiInternalEntities.g:5174:59: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // PsiInternalEntities.g:5175:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXReturnExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // PsiInternalEntities.g:5181:1: ruleXReturnExpression returns [Boolean current=false] : ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final Boolean ruleXReturnExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_expression_2_0 = null;


        try {
            // PsiInternalEntities.g:5182:1: ( ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // PsiInternalEntities.g:5183:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // PsiInternalEntities.g:5183:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            // PsiInternalEntities.g:5184:3: () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // PsiInternalEntities.g:5184:3: ()
            // PsiInternalEntities.g:5185:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXReturnExpression_XReturnExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXReturnExpression_ReturnKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,83,FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:5198:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt93=2;
            alt93 = dfa93.predict(input);
            switch (alt93) {
                case 1 :
                    // PsiInternalEntities.g:5199:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:5200:4: (lv_expression_2_0= ruleXExpression )
                    // PsiInternalEntities.g:5201:5: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getXReturnExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // PsiInternalEntities.g:5218:1: entryRuleXTryCatchFinallyExpression returns [Boolean current=false] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final Boolean entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXTryCatchFinallyExpression = null;


        try {
            // PsiInternalEntities.g:5218:68: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // PsiInternalEntities.g:5219:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXTryCatchFinallyExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // PsiInternalEntities.g:5225:1: ruleXTryCatchFinallyExpression returns [Boolean current=false] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final Boolean ruleXTryCatchFinallyExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_expression_2_0 = null;

        Boolean lv_catchClauses_3_0 = null;

        Boolean lv_finallyExpression_5_0 = null;

        Boolean lv_finallyExpression_7_0 = null;


        try {
            // PsiInternalEntities.g:5226:1: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // PsiInternalEntities.g:5227:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // PsiInternalEntities.g:5227:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // PsiInternalEntities.g:5228:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // PsiInternalEntities.g:5228:3: ()
            // PsiInternalEntities.g:5229:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getXTryCatchFinallyExpression_XTryCatchFinallyExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_TryKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,84,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:5242:3: ( (lv_expression_2_0= ruleXExpression ) )
            // PsiInternalEntities.g:5243:4: (lv_expression_2_0= ruleXExpression )
            {
            // PsiInternalEntities.g:5243:4: (lv_expression_2_0= ruleXExpression )
            // PsiInternalEntities.g:5244:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXTryCatchFinallyExpression_ExpressionXExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_74);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalEntities.g:5257:3: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==87) ) {
                alt96=1;
            }
            else if ( (LA96_0==85) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // PsiInternalEntities.g:5258:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // PsiInternalEntities.g:5258:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // PsiInternalEntities.g:5259:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // PsiInternalEntities.g:5259:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt94=0;
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==87) ) {
                            int LA94_2 = input.LA(2);

                            if ( (synpred38_PsiInternalEntities()) ) {
                                alt94=1;
                            }


                        }


                        switch (alt94) {
                    	case 1 :
                    	    // PsiInternalEntities.g:5260:6: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // PsiInternalEntities.g:5261:6: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // PsiInternalEntities.g:5262:7: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_CatchClausesXCatchClauseParserRuleCall_3_0_0_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_75);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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
                    	    if ( cnt94 >= 1 ) break loop94;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(94, input);
                                throw eee;
                        }
                        cnt94++;
                    } while (true);

                    // PsiInternalEntities.g:5275:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==85) ) {
                        int LA95_1 = input.LA(2);

                        if ( (synpred39_PsiInternalEntities()) ) {
                            alt95=1;
                        }
                    }
                    switch (alt95) {
                        case 1 :
                            // PsiInternalEntities.g:5276:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // PsiInternalEntities.g:5276:6: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // PsiInternalEntities.g:5277:7: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_0_1_0ElementType());
                              						
                            }
                            otherlv_4=(Token)match(input,85,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_4);
                              						
                            }

                            }

                            // PsiInternalEntities.g:5286:6: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // PsiInternalEntities.g:5287:7: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // PsiInternalEntities.g:5287:7: (lv_finallyExpression_5_0= ruleXExpression )
                            // PsiInternalEntities.g:5288:8: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_0_1_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:5304:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // PsiInternalEntities.g:5304:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // PsiInternalEntities.g:5305:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getXTryCatchFinallyExpression_FinallyKeyword_3_1_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,85,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }
                    // PsiInternalEntities.g:5312:5: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // PsiInternalEntities.g:5313:6: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // PsiInternalEntities.g:5313:6: (lv_finallyExpression_7_0= ruleXExpression )
                    // PsiInternalEntities.g:5314:7: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXTryCatchFinallyExpression_FinallyExpressionXExpressionParserRuleCall_3_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

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
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXSynchronizedExpression"
    // PsiInternalEntities.g:5333:1: entryRuleXSynchronizedExpression returns [Boolean current=false] : iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
    public final Boolean entryRuleXSynchronizedExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXSynchronizedExpression = null;


        try {
            // PsiInternalEntities.g:5333:65: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
            // PsiInternalEntities.g:5334:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXSynchronizedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSynchronizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSynchronizedExpression"


    // $ANTLR start "ruleXSynchronizedExpression"
    // PsiInternalEntities.g:5340:1: ruleXSynchronizedExpression returns [Boolean current=false] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXSynchronizedExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_param_3_0 = null;

        Boolean lv_expression_5_0 = null;


        try {
            // PsiInternalEntities.g:5341:1: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // PsiInternalEntities.g:5342:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // PsiInternalEntities.g:5342:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            // PsiInternalEntities.g:5343:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // PsiInternalEntities.g:5343:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
            // PsiInternalEntities.g:5344:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            {
            // PsiInternalEntities.g:5351:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            // PsiInternalEntities.g:5352:5: () otherlv_1= 'synchronized' otherlv_2= '('
            {
            // PsiInternalEntities.g:5352:5: ()
            // PsiInternalEntities.g:5353:6: 
            {
            if ( state.backtracking==0 ) {

              						precedeComposite(elementTypeProvider.getXSynchronizedExpression_XSynchronizedExpressionAction_0_0_0ElementType());
              						doneComposite();
              						associateWithSemanticElement();
              					
            }

            }

            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXSynchronizedExpression_SynchronizedKeyword_0_0_1ElementType());
              				
            }
            otherlv_1=(Token)match(input,86,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_1);
              				
            }
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getXSynchronizedExpression_LeftParenthesisKeyword_0_0_2ElementType());
              				
            }
            otherlv_2=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(otherlv_2);
              				
            }

            }


            }

            // PsiInternalEntities.g:5375:3: ( (lv_param_3_0= ruleXExpression ) )
            // PsiInternalEntities.g:5376:4: (lv_param_3_0= ruleXExpression )
            {
            // PsiInternalEntities.g:5376:4: (lv_param_3_0= ruleXExpression )
            // PsiInternalEntities.g:5377:5: lv_param_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXSynchronizedExpression_ParamXExpressionParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_40);
            lv_param_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXSynchronizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_4=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }
            // PsiInternalEntities.g:5397:3: ( (lv_expression_5_0= ruleXExpression ) )
            // PsiInternalEntities.g:5398:4: (lv_expression_5_0= ruleXExpression )
            {
            // PsiInternalEntities.g:5398:4: (lv_expression_5_0= ruleXExpression )
            // PsiInternalEntities.g:5399:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXSynchronizedExpression_ExpressionXExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXSynchronizedExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // PsiInternalEntities.g:5416:1: entryRuleXCatchClause returns [Boolean current=false] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final Boolean entryRuleXCatchClause() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXCatchClause = null;


        try {
            // PsiInternalEntities.g:5416:54: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // PsiInternalEntities.g:5417:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXCatchClauseElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // PsiInternalEntities.g:5423:1: ruleXCatchClause returns [Boolean current=false] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final Boolean ruleXCatchClause() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_declaredParam_2_0 = null;

        Boolean lv_expression_4_0 = null;


        try {
            // PsiInternalEntities.g:5424:1: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // PsiInternalEntities.g:5425:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // PsiInternalEntities.g:5425:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // PsiInternalEntities.g:5426:3: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // PsiInternalEntities.g:5426:3: ( ( 'catch' )=>otherlv_0= 'catch' )
            // PsiInternalEntities.g:5427:4: ( 'catch' )=>otherlv_0= 'catch'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getXCatchClause_CatchKeyword_0ElementType());
              			
            }
            otherlv_0=(Token)match(input,87,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_0);
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXCatchClause_LeftParenthesisKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:5443:3: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // PsiInternalEntities.g:5444:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // PsiInternalEntities.g:5444:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // PsiInternalEntities.g:5445:5: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXCatchClause_DeclaredParamFullJvmFormalParameterParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_40);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXCatchClause_RightParenthesisKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,22,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            // PsiInternalEntities.g:5465:3: ( (lv_expression_4_0= ruleXExpression ) )
            // PsiInternalEntities.g:5466:4: (lv_expression_4_0= ruleXExpression )
            {
            // PsiInternalEntities.g:5466:4: (lv_expression_4_0= ruleXExpression )
            // PsiInternalEntities.g:5467:5: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXCatchClause_ExpressionXExpressionParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // PsiInternalEntities.g:5484:1: entryRuleQualifiedName returns [Boolean current=false] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final Boolean entryRuleQualifiedName() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedName = null;


        try {
            // PsiInternalEntities.g:5484:55: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // PsiInternalEntities.g:5485:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // PsiInternalEntities.g:5491:1: ruleQualifiedName returns [Boolean current=false] : ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* ) ;
    public final Boolean ruleQualifiedName() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:5492:1: ( ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* ) )
            // PsiInternalEntities.g:5493:2: ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* )
            {
            // PsiInternalEntities.g:5493:2: ( ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )* )
            // PsiInternalEntities.g:5494:3: ruleValidID ( ( ( '.' )=>kw= '.' ) ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_76);
            ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalEntities.g:5501:3: ( ( ( '.' )=>kw= '.' ) ruleValidID )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==55) ) {
                    int LA97_2 = input.LA(2);

                    if ( (LA97_2==RULE_ID) ) {
                        int LA97_3 = input.LA(3);

                        if ( (synpred42_PsiInternalEntities()) ) {
                            alt97=1;
                        }


                    }


                }


                switch (alt97) {
            	case 1 :
            	    // PsiInternalEntities.g:5502:4: ( ( '.' )=>kw= '.' ) ruleValidID
            	    {
            	    // PsiInternalEntities.g:5502:4: ( ( '.' )=>kw= '.' )
            	    // PsiInternalEntities.g:5503:5: ( '.' )=>kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	      				
            	    }
            	    kw=(Token)match(input,55,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(kw);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getQualifiedName_ValidIDParserRuleCall_1_1ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_76);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneComposite();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop97;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // PsiInternalEntities.g:5524:1: entryRuleNumber returns [Boolean current=false] : iv_ruleNumber= ruleNumber EOF ;
    public final Boolean entryRuleNumber() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalEntities.g:5526:2: (iv_ruleNumber= ruleNumber EOF )
            // PsiInternalEntities.g:5527:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getNumberElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // PsiInternalEntities.g:5536:1: ruleNumber returns [Boolean current=false] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final Boolean ruleNumber() throws RecognitionException {
        Boolean current = false;

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalEntities.g:5539:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // PsiInternalEntities.g:5540:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // PsiInternalEntities.g:5540:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==RULE_HEX) ) {
                alt101=1;
            }
            else if ( ((LA101_0>=RULE_INT && LA101_0<=RULE_DECIMAL)) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // PsiInternalEntities.g:5541:3: this_HEX_0= RULE_HEX
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getNumber_HEXTerminalRuleCall_0ElementType());
                      		
                    }
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(this_HEX_0);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:5549:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // PsiInternalEntities.g:5549:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // PsiInternalEntities.g:5550:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // PsiInternalEntities.g:5550:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt98=2;
                    int LA98_0 = input.LA(1);

                    if ( (LA98_0==RULE_INT) ) {
                        alt98=1;
                    }
                    else if ( (LA98_0==RULE_DECIMAL) ) {
                        alt98=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 98, 0, input);

                        throw nvae;
                    }
                    switch (alt98) {
                        case 1 :
                            // PsiInternalEntities.g:5551:5: this_INT_1= RULE_INT
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_0_0ElementType());
                              				
                            }
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_76); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(this_INT_1);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // PsiInternalEntities.g:5559:5: this_DECIMAL_2= RULE_DECIMAL
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_0_1ElementType());
                              				
                            }
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_76); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(this_DECIMAL_2);
                              				
                            }

                            }
                            break;

                    }

                    // PsiInternalEntities.g:5567:4: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==55) ) {
                        int LA100_1 = input.LA(2);

                        if ( ((LA100_1>=RULE_INT && LA100_1<=RULE_DECIMAL)) ) {
                            alt100=1;
                        }
                    }
                    switch (alt100) {
                        case 1 :
                            // PsiInternalEntities.g:5568:5: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getNumber_FullStopKeyword_1_1_0ElementType());
                              				
                            }
                            kw=(Token)match(input,55,FOLLOW_77); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }
                            // PsiInternalEntities.g:5575:5: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt99=2;
                            int LA99_0 = input.LA(1);

                            if ( (LA99_0==RULE_INT) ) {
                                alt99=1;
                            }
                            else if ( (LA99_0==RULE_DECIMAL) ) {
                                alt99=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 99, 0, input);

                                throw nvae;
                            }
                            switch (alt99) {
                                case 1 :
                                    // PsiInternalEntities.g:5576:6: this_INT_4= RULE_INT
                                    {
                                    if ( state.backtracking==0 ) {

                                      						markLeaf(elementTypeProvider.getNumber_INTTerminalRuleCall_1_1_1_0ElementType());
                                      					
                                    }
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						doneLeaf(this_INT_4);
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // PsiInternalEntities.g:5584:6: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    if ( state.backtracking==0 ) {

                                      						markLeaf(elementTypeProvider.getNumber_DECIMALTerminalRuleCall_1_1_1_1ElementType());
                                      					
                                    }
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						doneLeaf(this_DECIMAL_5);
                                      					
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // PsiInternalEntities.g:5601:1: entryRuleJvmTypeReference returns [Boolean current=false] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final Boolean entryRuleJvmTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmTypeReference = null;


        try {
            // PsiInternalEntities.g:5601:58: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // PsiInternalEntities.g:5602:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // PsiInternalEntities.g:5608:1: ruleJvmTypeReference returns [Boolean current=false] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
    public final Boolean ruleJvmTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean this_JvmParameterizedTypeReference_0 = null;

        Boolean this_XFunctionTypeRef_3 = null;


        try {
            // PsiInternalEntities.g:5609:1: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
            // PsiInternalEntities.g:5610:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            {
            // PsiInternalEntities.g:5610:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_ID) ) {
                alt103=1;
            }
            else if ( (LA103_0==20||LA103_0==42) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // PsiInternalEntities.g:5611:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // PsiInternalEntities.g:5611:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // PsiInternalEntities.g:5612:4: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getJvmTypeReference_JvmParameterizedTypeReferenceParserRuleCall_0_0ElementType());
                      			
                    }
                    pushFollow(FOLLOW_70);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_JvmParameterizedTypeReference_0;
                      				doneComposite();
                      			
                    }
                    // PsiInternalEntities.g:5620:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==59) ) {
                            int LA102_2 = input.LA(2);

                            if ( (LA102_2==60) ) {
                                int LA102_3 = input.LA(3);

                                if ( (synpred43_PsiInternalEntities()) ) {
                                    alt102=1;
                                }


                            }


                        }


                        switch (alt102) {
                    	case 1 :
                    	    // PsiInternalEntities.g:5621:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // PsiInternalEntities.g:5627:5: ( () ruleArrayBrackets )
                    	    // PsiInternalEntities.g:5628:6: () ruleArrayBrackets
                    	    {
                    	    // PsiInternalEntities.g:5628:6: ()
                    	    // PsiInternalEntities.g:5629:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							precedeComposite(elementTypeProvider.getJvmTypeReference_JvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0ElementType());
                    	      							doneComposite();
                    	      							associateWithSemanticElement();
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						markComposite(elementTypeProvider.getJvmTypeReference_ArrayBracketsParserRuleCall_0_1_0_1ElementType());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_70);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						doneComposite();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop102;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:5646:3: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmTypeReference_XFunctionTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFunctionTypeRef_3=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFunctionTypeRef_3;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // PsiInternalEntities.g:5658:1: entryRuleArrayBrackets returns [Boolean current=false] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final Boolean entryRuleArrayBrackets() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleArrayBrackets = null;


        try {
            // PsiInternalEntities.g:5658:55: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // PsiInternalEntities.g:5659:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getArrayBracketsElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // PsiInternalEntities.g:5665:1: ruleArrayBrackets returns [Boolean current=false] : (kw= '[' kw= ']' ) ;
    public final Boolean ruleArrayBrackets() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:5666:1: ( (kw= '[' kw= ']' ) )
            // PsiInternalEntities.g:5667:2: (kw= '[' kw= ']' )
            {
            // PsiInternalEntities.g:5667:2: (kw= '[' kw= ']' )
            // PsiInternalEntities.g:5668:3: kw= '[' kw= ']'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_LeftSquareBracketKeyword_0ElementType());
              		
            }
            kw=(Token)match(input,59,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getArrayBrackets_RightSquareBracketKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
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
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // PsiInternalEntities.g:5686:1: entryRuleXFunctionTypeRef returns [Boolean current=false] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final Boolean entryRuleXFunctionTypeRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXFunctionTypeRef = null;


        try {
            // PsiInternalEntities.g:5686:58: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // PsiInternalEntities.g:5687:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXFunctionTypeRefElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // PsiInternalEntities.g:5693:1: ruleXFunctionTypeRef returns [Boolean current=false] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleXFunctionTypeRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Boolean lv_paramTypes_1_0 = null;

        Boolean lv_paramTypes_3_0 = null;

        Boolean lv_returnType_6_0 = null;


        try {
            // PsiInternalEntities.g:5694:1: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalEntities.g:5695:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalEntities.g:5695:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // PsiInternalEntities.g:5696:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // PsiInternalEntities.g:5696:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==20) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // PsiInternalEntities.g:5697:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFunctionTypeRef_LeftParenthesisKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,20,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalEntities.g:5704:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==RULE_ID||LA105_0==20||LA105_0==42) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // PsiInternalEntities.g:5705:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // PsiInternalEntities.g:5705:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // PsiInternalEntities.g:5706:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // PsiInternalEntities.g:5706:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // PsiInternalEntities.g:5707:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0ElementType());
                              						
                            }
                            pushFollow(FOLLOW_13);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneComposite();
                              							if(!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }


                            }

                            // PsiInternalEntities.g:5720:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop104:
                            do {
                                int alt104=2;
                                int LA104_0 = input.LA(1);

                                if ( (LA104_0==21) ) {
                                    alt104=1;
                                }


                                switch (alt104) {
                            	case 1 :
                            	    // PsiInternalEntities.g:5721:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      						markLeaf(elementTypeProvider.getXFunctionTypeRef_CommaKeyword_0_1_1_0ElementType());
                            	      					
                            	    }
                            	    otherlv_2=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						doneLeaf(otherlv_2);
                            	      					
                            	    }
                            	    // PsiInternalEntities.g:5728:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // PsiInternalEntities.g:5729:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // PsiInternalEntities.g:5729:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // PsiInternalEntities.g:5730:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								markComposite(elementTypeProvider.getXFunctionTypeRef_ParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0ElementType());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_13);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

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

                            	default :
                            	    break loop104;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXFunctionTypeRef_RightParenthesisKeyword_0_2ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,22,FOLLOW_78); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXFunctionTypeRef_EqualsSignGreaterThanSignKeyword_1ElementType());
              		
            }
            otherlv_5=(Token)match(input,42,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalEntities.g:5760:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // PsiInternalEntities.g:5761:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // PsiInternalEntities.g:5761:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // PsiInternalEntities.g:5762:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getXFunctionTypeRef_ReturnTypeJvmTypeReferenceParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // PsiInternalEntities.g:5779:1: entryRuleJvmParameterizedTypeReference returns [Boolean current=false] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final Boolean entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmParameterizedTypeReference = null;


        try {
            // PsiInternalEntities.g:5779:71: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // PsiInternalEntities.g:5780:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmParameterizedTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // PsiInternalEntities.g:5786:1: ruleJvmParameterizedTypeReference returns [Boolean current=false] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final Boolean ruleJvmParameterizedTypeReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Boolean lv_arguments_2_0 = null;

        Boolean lv_arguments_4_0 = null;

        Boolean lv_arguments_10_0 = null;

        Boolean lv_arguments_12_0 = null;


        try {
            // PsiInternalEntities.g:5787:1: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // PsiInternalEntities.g:5788:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // PsiInternalEntities.g:5788:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // PsiInternalEntities.g:5789:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // PsiInternalEntities.g:5789:3: ( ( ruleQualifiedName ) )
            // PsiInternalEntities.g:5790:4: ( ruleQualifiedName )
            {
            // PsiInternalEntities.g:5790:4: ( ruleQualifiedName )
            // PsiInternalEntities.g:5791:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_79);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalEntities.g:5806:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt111=2;
            alt111 = dfa111.predict(input);
            switch (alt111) {
                case 1 :
                    // PsiInternalEntities.g:5807:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // PsiInternalEntities.g:5807:4: ( ( '<' )=>otherlv_1= '<' )
                    // PsiInternalEntities.g:5808:5: ( '<' )=>otherlv_1= '<'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_0ElementType());
                      				
                    }
                    otherlv_1=(Token)match(input,29,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_1);
                      				
                    }

                    }

                    // PsiInternalEntities.g:5817:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // PsiInternalEntities.g:5818:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // PsiInternalEntities.g:5818:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // PsiInternalEntities.g:5819:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_37);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalEntities.g:5832:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==21) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // PsiInternalEntities.g:5833:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalEntities.g:5840:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // PsiInternalEntities.g:5841:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // PsiInternalEntities.g:5841:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // PsiInternalEntities.g:5842:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_37);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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

                    	default :
                    	    break loop107;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,30,FOLLOW_76); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // PsiInternalEntities.g:5863:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop110:
                    do {
                        int alt110=2;
                        int LA110_0 = input.LA(1);

                        if ( (LA110_0==55) ) {
                            int LA110_2 = input.LA(2);

                            if ( (LA110_2==RULE_ID) ) {
                                int LA110_3 = input.LA(3);

                                if ( (synpred45_PsiInternalEntities()) ) {
                                    alt110=1;
                                }


                            }


                        }


                        switch (alt110) {
                    	case 1 :
                    	    // PsiInternalEntities.g:5864:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // PsiInternalEntities.g:5864:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // PsiInternalEntities.g:5865:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // PsiInternalEntities.g:5871:6: ( () otherlv_7= '.' )
                    	    // PsiInternalEntities.g:5872:7: () otherlv_7= '.'
                    	    {
                    	    // PsiInternalEntities.g:5872:7: ()
                    	    // PsiInternalEntities.g:5873:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								precedeComposite(elementTypeProvider.getJvmParameterizedTypeReference_JvmInnerTypeReferenceOuterAction_1_4_0_0_0ElementType());
                    	      								doneComposite();
                    	      								associateWithSemanticElement();
                    	      							
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_FullStopKeyword_1_4_0_0_1ElementType());
                    	      						
                    	    }
                    	    otherlv_7=(Token)match(input,55,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_7);
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // PsiInternalEntities.g:5888:5: ( ( ruleValidID ) )
                    	    // PsiInternalEntities.g:5889:6: ( ruleValidID )
                    	    {
                    	    // PsiInternalEntities.g:5889:6: ( ruleValidID )
                    	    // PsiInternalEntities.g:5890:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmParameterizedTypeReference_TypeJvmTypeCrossReference_1_4_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_80);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // PsiInternalEntities.g:5905:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt109=2;
                    	    alt109 = dfa109.predict(input);
                    	    switch (alt109) {
                    	        case 1 :
                    	            // PsiInternalEntities.g:5906:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // PsiInternalEntities.g:5906:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // PsiInternalEntities.g:5907:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_LessThanSignKeyword_1_4_2_0ElementType());
                    	              						
                    	            }
                    	            otherlv_9=(Token)match(input,29,FOLLOW_36); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							doneLeaf(otherlv_9);
                    	              						
                    	            }

                    	            }

                    	            // PsiInternalEntities.g:5916:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // PsiInternalEntities.g:5917:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // PsiInternalEntities.g:5917:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // PsiInternalEntities.g:5918:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0ElementType());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_37);
                    	            lv_arguments_10_0=ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								doneComposite();
                    	              								if(!current) {
                    	              									associateWithSemanticElement();
                    	              									current = true;
                    	              								}
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // PsiInternalEntities.g:5931:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop108:
                    	            do {
                    	                int alt108=2;
                    	                int LA108_0 = input.LA(1);

                    	                if ( (LA108_0==21) ) {
                    	                    alt108=1;
                    	                }


                    	                switch (alt108) {
                    	            	case 1 :
                    	            	    // PsiInternalEntities.g:5932:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_CommaKeyword_1_4_2_2_0ElementType());
                    	            	      						
                    	            	    }
                    	            	    otherlv_11=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							doneLeaf(otherlv_11);
                    	            	      						
                    	            	    }
                    	            	    // PsiInternalEntities.g:5939:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // PsiInternalEntities.g:5940:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // PsiInternalEntities.g:5940:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // PsiInternalEntities.g:5941:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									markComposite(elementTypeProvider.getJvmParameterizedTypeReference_ArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0ElementType());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_37);
                    	            	    lv_arguments_12_0=ruleJvmArgumentTypeReference();

                    	            	    state._fsp--;
                    	            	    if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

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

                    	            	default :
                    	            	    break loop108;
                    	                }
                    	            } while (true);

                    	            if ( state.backtracking==0 ) {

                    	              						markLeaf(elementTypeProvider.getJvmParameterizedTypeReference_GreaterThanSignKeyword_1_4_2_3ElementType());
                    	              					
                    	            }
                    	            otherlv_13=(Token)match(input,30,FOLLOW_76); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						doneLeaf(otherlv_13);
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop110;
                        }
                    } while (true);


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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // PsiInternalEntities.g:5969:1: entryRuleJvmArgumentTypeReference returns [Boolean current=false] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final Boolean entryRuleJvmArgumentTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmArgumentTypeReference = null;


        try {
            // PsiInternalEntities.g:5969:66: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // PsiInternalEntities.g:5970:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmArgumentTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // PsiInternalEntities.g:5976:1: ruleJvmArgumentTypeReference returns [Boolean current=false] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final Boolean ruleJvmArgumentTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean this_JvmTypeReference_0 = null;

        Boolean this_JvmWildcardTypeReference_1 = null;


        try {
            // PsiInternalEntities.g:5977:1: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // PsiInternalEntities.g:5978:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // PsiInternalEntities.g:5978:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==RULE_ID||LA112_0==20||LA112_0==42) ) {
                alt112=1;
            }
            else if ( (LA112_0==88) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // PsiInternalEntities.g:5979:3: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmTypeReferenceParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmTypeReference_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:5988:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getJvmArgumentTypeReference_JvmWildcardTypeReferenceParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmWildcardTypeReference_1;
                      			doneComposite();
                      		
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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // PsiInternalEntities.g:6000:1: entryRuleJvmWildcardTypeReference returns [Boolean current=false] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final Boolean entryRuleJvmWildcardTypeReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmWildcardTypeReference = null;


        try {
            // PsiInternalEntities.g:6000:66: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // PsiInternalEntities.g:6001:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmWildcardTypeReferenceElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // PsiInternalEntities.g:6007:1: ruleJvmWildcardTypeReference returns [Boolean current=false] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final Boolean ruleJvmWildcardTypeReference() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_constraints_2_0 = null;

        Boolean lv_constraints_3_0 = null;

        Boolean lv_constraints_4_0 = null;

        Boolean lv_constraints_5_0 = null;


        try {
            // PsiInternalEntities.g:6008:1: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // PsiInternalEntities.g:6009:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // PsiInternalEntities.g:6009:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // PsiInternalEntities.g:6010:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // PsiInternalEntities.g:6010:3: ()
            // PsiInternalEntities.g:6011:4: 
            {
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getJvmWildcardTypeReference_JvmWildcardTypeReferenceAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmWildcardTypeReference_QuestionMarkKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,88,FOLLOW_81); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalEntities.g:6024:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            int alt115=3;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==17) ) {
                alt115=1;
            }
            else if ( (LA115_0==76) ) {
                alt115=2;
            }
            switch (alt115) {
                case 1 :
                    // PsiInternalEntities.g:6025:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // PsiInternalEntities.g:6025:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // PsiInternalEntities.g:6026:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // PsiInternalEntities.g:6026:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // PsiInternalEntities.g:6027:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // PsiInternalEntities.g:6027:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // PsiInternalEntities.g:6028:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundParserRuleCall_2_0_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_82);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalEntities.g:6041:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==89) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // PsiInternalEntities.g:6042:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // PsiInternalEntities.g:6042:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // PsiInternalEntities.g:6043:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_82);
                    	    lv_constraints_3_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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
                    	    break loop113;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:6058:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // PsiInternalEntities.g:6058:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // PsiInternalEntities.g:6059:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // PsiInternalEntities.g:6059:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // PsiInternalEntities.g:6060:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // PsiInternalEntities.g:6060:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // PsiInternalEntities.g:6061:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundParserRuleCall_2_1_0_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_82);
                    lv_constraints_4_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalEntities.g:6074:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop114:
                    do {
                        int alt114=2;
                        int LA114_0 = input.LA(1);

                        if ( (LA114_0==89) ) {
                            alt114=1;
                        }


                        switch (alt114) {
                    	case 1 :
                    	    // PsiInternalEntities.g:6075:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // PsiInternalEntities.g:6075:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // PsiInternalEntities.g:6076:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getJvmWildcardTypeReference_ConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_82);
                    	    lv_constraints_5_0=ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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
                    	    break loop114;
                        }
                    } while (true);


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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // PsiInternalEntities.g:6095:1: entryRuleJvmUpperBound returns [Boolean current=false] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final Boolean entryRuleJvmUpperBound() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmUpperBound = null;


        try {
            // PsiInternalEntities.g:6095:55: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // PsiInternalEntities.g:6096:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // PsiInternalEntities.g:6102:1: ruleJvmUpperBound returns [Boolean current=false] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmUpperBound() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalEntities.g:6103:1: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalEntities.g:6104:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalEntities.g:6104:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalEntities.g:6105:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBound_ExtendsKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,17,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:6112:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalEntities.g:6113:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalEntities.g:6113:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalEntities.g:6114:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // PsiInternalEntities.g:6131:1: entryRuleJvmUpperBoundAnded returns [Boolean current=false] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final Boolean entryRuleJvmUpperBoundAnded() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmUpperBoundAnded = null;


        try {
            // PsiInternalEntities.g:6131:60: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // PsiInternalEntities.g:6132:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmUpperBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // PsiInternalEntities.g:6138:1: ruleJvmUpperBoundAnded returns [Boolean current=false] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmUpperBoundAnded() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalEntities.g:6139:1: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalEntities.g:6140:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalEntities.g:6140:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalEntities.g:6141:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmUpperBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,89,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:6148:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalEntities.g:6149:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalEntities.g:6149:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalEntities.g:6150:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmUpperBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // PsiInternalEntities.g:6167:1: entryRuleJvmLowerBound returns [Boolean current=false] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final Boolean entryRuleJvmLowerBound() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmLowerBound = null;


        try {
            // PsiInternalEntities.g:6167:55: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // PsiInternalEntities.g:6168:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // PsiInternalEntities.g:6174:1: ruleJvmLowerBound returns [Boolean current=false] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmLowerBound() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalEntities.g:6175:1: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalEntities.g:6176:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalEntities.g:6176:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalEntities.g:6177:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBound_SuperKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,76,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:6184:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalEntities.g:6185:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalEntities.g:6185:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalEntities.g:6186:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBound_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // PsiInternalEntities.g:6203:1: entryRuleJvmLowerBoundAnded returns [Boolean current=false] : iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
    public final Boolean entryRuleJvmLowerBoundAnded() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleJvmLowerBoundAnded = null;


        try {
            // PsiInternalEntities.g:6203:60: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
            // PsiInternalEntities.g:6204:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getJvmLowerBoundAndedElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // PsiInternalEntities.g:6210:1: ruleJvmLowerBoundAnded returns [Boolean current=false] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final Boolean ruleJvmLowerBoundAnded() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_typeReference_1_0 = null;


        try {
            // PsiInternalEntities.g:6211:1: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // PsiInternalEntities.g:6212:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // PsiInternalEntities.g:6212:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // PsiInternalEntities.g:6213:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getJvmLowerBoundAnded_AmpersandKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,89,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:6220:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // PsiInternalEntities.g:6221:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // PsiInternalEntities.g:6221:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // PsiInternalEntities.g:6222:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getJvmLowerBoundAnded_TypeReferenceJvmTypeReferenceParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // PsiInternalEntities.g:6239:1: entryRuleQualifiedNameWithWildcard returns [Boolean current=false] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final Boolean entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedNameWithWildcard = null;


        try {
            // PsiInternalEntities.g:6239:67: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // PsiInternalEntities.g:6240:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameWithWildcardElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // PsiInternalEntities.g:6246:1: ruleQualifiedNameWithWildcard returns [Boolean current=false] : ( ruleQualifiedName kw= '.' kw= '*' ) ;
    public final Boolean ruleQualifiedNameWithWildcard() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:6247:1: ( ( ruleQualifiedName kw= '.' kw= '*' ) )
            // PsiInternalEntities.g:6248:2: ( ruleQualifiedName kw= '.' kw= '*' )
            {
            // PsiInternalEntities.g:6248:2: ( ruleQualifiedName kw= '.' kw= '*' )
            // PsiInternalEntities.g:6249:3: ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getQualifiedNameWithWildcard_QualifiedNameParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_83);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_FullStopKeyword_1ElementType());
              		
            }
            kw=(Token)match(input,55,FOLLOW_84); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQualifiedNameWithWildcard_AsteriskKeyword_2ElementType());
              		
            }
            kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(kw);
              		
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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // PsiInternalEntities.g:6274:1: entryRuleValidID returns [Boolean current=false] : iv_ruleValidID= ruleValidID EOF ;
    public final Boolean entryRuleValidID() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleValidID = null;


        try {
            // PsiInternalEntities.g:6274:49: (iv_ruleValidID= ruleValidID EOF )
            // PsiInternalEntities.g:6275:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValidIDElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // PsiInternalEntities.g:6281:1: ruleValidID returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleValidID() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalEntities.g:6282:1: (this_ID_0= RULE_ID )
            // PsiInternalEntities.g:6283:2: this_ID_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              		markLeaf(elementTypeProvider.getValidID_IDTerminalRuleCallElementType());
              	
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		doneLeaf(this_ID_0);
              	
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
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportSection"
    // PsiInternalEntities.g:6293:1: entryRuleXImportSection returns [Boolean current=false] : iv_ruleXImportSection= ruleXImportSection EOF ;
    public final Boolean entryRuleXImportSection() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXImportSection = null;


        try {
            // PsiInternalEntities.g:6293:56: (iv_ruleXImportSection= ruleXImportSection EOF )
            // PsiInternalEntities.g:6294:2: iv_ruleXImportSection= ruleXImportSection EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportSectionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportSection=ruleXImportSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportSection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXImportSection"


    // $ANTLR start "ruleXImportSection"
    // PsiInternalEntities.g:6300:1: ruleXImportSection returns [Boolean current=false] : ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ ;
    public final Boolean ruleXImportSection() throws RecognitionException {
        Boolean current = false;

        Boolean lv_importDeclarations_0_0 = null;


        try {
            // PsiInternalEntities.g:6301:1: ( ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ )
            // PsiInternalEntities.g:6302:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            {
            // PsiInternalEntities.g:6302:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            int cnt116=0;
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==74) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // PsiInternalEntities.g:6303:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    {
            	    // PsiInternalEntities.g:6303:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    // PsiInternalEntities.g:6304:4: lv_importDeclarations_0_0= ruleXImportDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markComposite(elementTypeProvider.getXImportSection_ImportDeclarationsXImportDeclarationParserRuleCall_0ElementType());
            	      			
            	    }
            	    pushFollow(FOLLOW_85);
            	    lv_importDeclarations_0_0=ruleXImportDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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
            	    if ( cnt116 >= 1 ) break loop116;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(116, input);
                        throw eee;
                }
                cnt116++;
            } while (true);


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
    // $ANTLR end "ruleXImportSection"


    // $ANTLR start "entryRuleXImportDeclaration"
    // PsiInternalEntities.g:6320:1: entryRuleXImportDeclaration returns [Boolean current=false] : iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
    public final Boolean entryRuleXImportDeclaration() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleXImportDeclaration = null;


        try {
            // PsiInternalEntities.g:6320:60: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
            // PsiInternalEntities.g:6321:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getXImportDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // PsiInternalEntities.g:6327:1: ruleXImportDeclaration returns [Boolean current=false] : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final Boolean ruleXImportDeclaration() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;
        Boolean lv_memberName_5_0 = null;

        Boolean lv_importedNamespace_7_0 = null;


        try {
            // PsiInternalEntities.g:6328:1: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // PsiInternalEntities.g:6329:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // PsiInternalEntities.g:6329:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // PsiInternalEntities.g:6330:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getXImportDeclaration_ImportKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,74,FOLLOW_86); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalEntities.g:6337:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt119=3;
            alt119 = dfa119.predict(input);
            switch (alt119) {
                case 1 :
                    // PsiInternalEntities.g:6338:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // PsiInternalEntities.g:6338:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // PsiInternalEntities.g:6339:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // PsiInternalEntities.g:6339:5: ( (lv_static_1_0= 'static' ) )
                    // PsiInternalEntities.g:6340:6: (lv_static_1_0= 'static' )
                    {
                    // PsiInternalEntities.g:6340:6: (lv_static_1_0= 'static' )
                    // PsiInternalEntities.g:6341:7: lv_static_1_0= 'static'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getXImportDeclaration_StaticStaticKeyword_1_0_0_0ElementType());
                      						
                    }
                    lv_static_1_0=(Token)match(input,73,FOLLOW_87); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_static_1_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalEntities.g:6356:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt117=2;
                    int LA117_0 = input.LA(1);

                    if ( (LA117_0==75) ) {
                        alt117=1;
                    }
                    switch (alt117) {
                        case 1 :
                            // PsiInternalEntities.g:6357:6: (lv_extension_2_0= 'extension' )
                            {
                            // PsiInternalEntities.g:6357:6: (lv_extension_2_0= 'extension' )
                            // PsiInternalEntities.g:6358:7: lv_extension_2_0= 'extension'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getXImportDeclaration_ExtensionExtensionKeyword_1_0_1_0ElementType());
                              						
                            }
                            lv_extension_2_0=(Token)match(input,75,FOLLOW_87); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_extension_2_0);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }


                            }
                            break;

                    }

                    // PsiInternalEntities.g:6373:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // PsiInternalEntities.g:6374:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // PsiInternalEntities.g:6374:6: ( ruleQualifiedNameInStaticImport )
                    // PsiInternalEntities.g:6375:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_88);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    // PsiInternalEntities.g:6390:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==47) ) {
                        alt118=1;
                    }
                    else if ( (LA118_0==RULE_ID) ) {
                        alt118=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 118, 0, input);

                        throw nvae;
                    }
                    switch (alt118) {
                        case 1 :
                            // PsiInternalEntities.g:6391:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // PsiInternalEntities.g:6391:6: ( (lv_wildcard_4_0= '*' ) )
                            // PsiInternalEntities.g:6392:7: (lv_wildcard_4_0= '*' )
                            {
                            // PsiInternalEntities.g:6392:7: (lv_wildcard_4_0= '*' )
                            // PsiInternalEntities.g:6393:8: lv_wildcard_4_0= '*'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getXImportDeclaration_WildcardAsteriskKeyword_1_0_3_0_0ElementType());
                              							
                            }
                            lv_wildcard_4_0=(Token)match(input,47,FOLLOW_89); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_wildcard_4_0);
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalEntities.g:6409:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // PsiInternalEntities.g:6409:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // PsiInternalEntities.g:6410:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // PsiInternalEntities.g:6410:7: (lv_memberName_5_0= ruleValidID )
                            // PsiInternalEntities.g:6411:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getXImportDeclaration_MemberNameValidIDParserRuleCall_1_0_3_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_89);
                            lv_memberName_5_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEntities.g:6427:4: ( ( ruleQualifiedName ) )
                    {
                    // PsiInternalEntities.g:6427:4: ( ( ruleQualifiedName ) )
                    // PsiInternalEntities.g:6428:5: ( ruleQualifiedName )
                    {
                    // PsiInternalEntities.g:6428:5: ( ruleQualifiedName )
                    // PsiInternalEntities.g:6429:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedTypeJvmDeclaredTypeCrossReference_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_89);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEntities.g:6445:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // PsiInternalEntities.g:6445:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // PsiInternalEntities.g:6446:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // PsiInternalEntities.g:6446:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // PsiInternalEntities.g:6447:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getXImportDeclaration_ImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_89);
                    lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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

            // PsiInternalEntities.g:6461:3: (otherlv_8= ';' )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==62) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // PsiInternalEntities.g:6462:4: otherlv_8= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getXImportDeclaration_SemicolonKeyword_2ElementType());
                      			
                    }
                    otherlv_8=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_8);
                      			
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
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // PsiInternalEntities.g:6474:1: entryRuleQualifiedNameInStaticImport returns [Boolean current=false] : iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
    public final Boolean entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedNameInStaticImport = null;


        try {
            // PsiInternalEntities.g:6474:69: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
            // PsiInternalEntities.g:6475:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQualifiedNameInStaticImportElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameInStaticImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // PsiInternalEntities.g:6481:1: ruleQualifiedNameInStaticImport returns [Boolean current=false] : ( ruleValidID kw= '.' )+ ;
    public final Boolean ruleQualifiedNameInStaticImport() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalEntities.g:6482:1: ( ( ruleValidID kw= '.' )+ )
            // PsiInternalEntities.g:6483:2: ( ruleValidID kw= '.' )+
            {
            // PsiInternalEntities.g:6483:2: ( ruleValidID kw= '.' )+
            int cnt121=0;
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==RULE_ID) ) {
                    int LA121_2 = input.LA(2);

                    if ( (LA121_2==55) ) {
                        alt121=1;
                    }


                }


                switch (alt121) {
            	case 1 :
            	    // PsiInternalEntities.g:6484:3: ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			markComposite(elementTypeProvider.getQualifiedNameInStaticImport_ValidIDParserRuleCall_0ElementType());
            	      		
            	    }
            	    pushFollow(FOLLOW_83);
            	    ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			doneComposite();
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			markLeaf(elementTypeProvider.getQualifiedNameInStaticImport_FullStopKeyword_1ElementType());
            	      		
            	    }
            	    kw=(Token)match(input,55,FOLLOW_90); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			doneLeaf(kw);
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt121 >= 1 ) break loop121;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(121, input);
                        throw eee;
                }
                cnt121++;
            } while (true);


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
    // $ANTLR end "ruleQualifiedNameInStaticImport"

    // $ANTLR start synpred1_PsiInternalEntities
    public final void synpred1_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:587:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // PsiInternalEntities.g:587:7: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // PsiInternalEntities.g:587:7: ( () ( ( ruleOpMultiAssign ) ) )
        // PsiInternalEntities.g:588:7: () ( ( ruleOpMultiAssign ) )
        {
        // PsiInternalEntities.g:588:7: ()
        // PsiInternalEntities.g:589:7: 
        {
        }

        // PsiInternalEntities.g:590:7: ( ( ruleOpMultiAssign ) )
        // PsiInternalEntities.g:591:8: ( ruleOpMultiAssign )
        {
        // PsiInternalEntities.g:591:8: ( ruleOpMultiAssign )
        // PsiInternalEntities.g:592:9: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_2);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_PsiInternalEntities

    // $ANTLR start synpred2_PsiInternalEntities
    public final void synpred2_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:787:5: ( ( () ( ( ruleOpOr ) ) ) )
        // PsiInternalEntities.g:787:6: ( () ( ( ruleOpOr ) ) )
        {
        // PsiInternalEntities.g:787:6: ( () ( ( ruleOpOr ) ) )
        // PsiInternalEntities.g:788:6: () ( ( ruleOpOr ) )
        {
        // PsiInternalEntities.g:788:6: ()
        // PsiInternalEntities.g:789:6: 
        {
        }

        // PsiInternalEntities.g:790:6: ( ( ruleOpOr ) )
        // PsiInternalEntities.g:791:7: ( ruleOpOr )
        {
        // PsiInternalEntities.g:791:7: ( ruleOpOr )
        // PsiInternalEntities.g:792:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_PsiInternalEntities

    // $ANTLR start synpred3_PsiInternalEntities
    public final void synpred3_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:883:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // PsiInternalEntities.g:883:6: ( () ( ( ruleOpAnd ) ) )
        {
        // PsiInternalEntities.g:883:6: ( () ( ( ruleOpAnd ) ) )
        // PsiInternalEntities.g:884:6: () ( ( ruleOpAnd ) )
        {
        // PsiInternalEntities.g:884:6: ()
        // PsiInternalEntities.g:885:6: 
        {
        }

        // PsiInternalEntities.g:886:6: ( ( ruleOpAnd ) )
        // PsiInternalEntities.g:887:7: ( ruleOpAnd )
        {
        // PsiInternalEntities.g:887:7: ( ruleOpAnd )
        // PsiInternalEntities.g:888:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_PsiInternalEntities

    // $ANTLR start synpred4_PsiInternalEntities
    public final void synpred4_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:979:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // PsiInternalEntities.g:979:6: ( () ( ( ruleOpEquality ) ) )
        {
        // PsiInternalEntities.g:979:6: ( () ( ( ruleOpEquality ) ) )
        // PsiInternalEntities.g:980:6: () ( ( ruleOpEquality ) )
        {
        // PsiInternalEntities.g:980:6: ()
        // PsiInternalEntities.g:981:6: 
        {
        }

        // PsiInternalEntities.g:982:6: ( ( ruleOpEquality ) )
        // PsiInternalEntities.g:983:7: ( ruleOpEquality )
        {
        // PsiInternalEntities.g:983:7: ( ruleOpEquality )
        // PsiInternalEntities.g:984:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_PsiInternalEntities

    // $ANTLR start synpred5_PsiInternalEntities
    public final void synpred5_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1102:6: ( ( () 'instanceof' ) )
        // PsiInternalEntities.g:1102:7: ( () 'instanceof' )
        {
        // PsiInternalEntities.g:1102:7: ( () 'instanceof' )
        // PsiInternalEntities.g:1103:7: () 'instanceof'
        {
        // PsiInternalEntities.g:1103:7: ()
        // PsiInternalEntities.g:1104:7: 
        {
        }

        match(input,38,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_PsiInternalEntities

    // $ANTLR start synpred6_PsiInternalEntities
    public final void synpred6_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1144:6: ( ( () ( ( ruleOpCompare ) ) ) )
        // PsiInternalEntities.g:1144:7: ( () ( ( ruleOpCompare ) ) )
        {
        // PsiInternalEntities.g:1144:7: ( () ( ( ruleOpCompare ) ) )
        // PsiInternalEntities.g:1145:7: () ( ( ruleOpCompare ) )
        {
        // PsiInternalEntities.g:1145:7: ()
        // PsiInternalEntities.g:1146:7: 
        {
        }

        // PsiInternalEntities.g:1147:7: ( ( ruleOpCompare ) )
        // PsiInternalEntities.g:1148:8: ( ruleOpCompare )
        {
        // PsiInternalEntities.g:1148:8: ( ruleOpCompare )
        // PsiInternalEntities.g:1149:9: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_PsiInternalEntities

    // $ANTLR start synpred7_PsiInternalEntities
    public final void synpred7_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1276:5: ( ( () ( ( ruleOpOther ) ) ) )
        // PsiInternalEntities.g:1276:6: ( () ( ( ruleOpOther ) ) )
        {
        // PsiInternalEntities.g:1276:6: ( () ( ( ruleOpOther ) ) )
        // PsiInternalEntities.g:1277:6: () ( ( ruleOpOther ) )
        {
        // PsiInternalEntities.g:1277:6: ()
        // PsiInternalEntities.g:1278:6: 
        {
        }

        // PsiInternalEntities.g:1279:6: ( ( ruleOpOther ) )
        // PsiInternalEntities.g:1280:7: ( ruleOpOther )
        {
        // PsiInternalEntities.g:1280:7: ( ruleOpOther )
        // PsiInternalEntities.g:1281:8: ruleOpOther
        {
        pushFollow(FOLLOW_2);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_PsiInternalEntities

    // $ANTLR start synpred8_PsiInternalEntities
    public final void synpred8_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1402:6: ( ( '>' '>' ) )
        // PsiInternalEntities.g:1402:7: ( '>' '>' )
        {
        // PsiInternalEntities.g:1402:7: ( '>' '>' )
        // PsiInternalEntities.g:1403:7: '>' '>'
        {
        match(input,30,FOLLOW_27); if (state.failed) return ;
        match(input,30,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_PsiInternalEntities

    // $ANTLR start synpred9_PsiInternalEntities
    public final void synpred9_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1445:6: ( ( '<' '<' ) )
        // PsiInternalEntities.g:1445:7: ( '<' '<' )
        {
        // PsiInternalEntities.g:1445:7: ( '<' '<' )
        // PsiInternalEntities.g:1446:7: '<' '<'
        {
        match(input,29,FOLLOW_18); if (state.failed) return ;
        match(input,29,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_PsiInternalEntities

    // $ANTLR start synpred10_PsiInternalEntities
    public final void synpred10_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1525:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // PsiInternalEntities.g:1525:6: ( () ( ( ruleOpAdd ) ) )
        {
        // PsiInternalEntities.g:1525:6: ( () ( ( ruleOpAdd ) ) )
        // PsiInternalEntities.g:1526:6: () ( ( ruleOpAdd ) )
        {
        // PsiInternalEntities.g:1526:6: ()
        // PsiInternalEntities.g:1527:6: 
        {
        }

        // PsiInternalEntities.g:1528:6: ( ( ruleOpAdd ) )
        // PsiInternalEntities.g:1529:7: ( ruleOpAdd )
        {
        // PsiInternalEntities.g:1529:7: ( ruleOpAdd )
        // PsiInternalEntities.g:1530:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred10_PsiInternalEntities

    // $ANTLR start synpred11_PsiInternalEntities
    public final void synpred11_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1631:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // PsiInternalEntities.g:1631:6: ( () ( ( ruleOpMulti ) ) )
        {
        // PsiInternalEntities.g:1631:6: ( () ( ( ruleOpMulti ) ) )
        // PsiInternalEntities.g:1632:6: () ( ( ruleOpMulti ) )
        {
        // PsiInternalEntities.g:1632:6: ()
        // PsiInternalEntities.g:1633:6: 
        {
        }

        // PsiInternalEntities.g:1634:6: ( ( ruleOpMulti ) )
        // PsiInternalEntities.g:1635:7: ( ruleOpMulti )
        {
        // PsiInternalEntities.g:1635:7: ( ruleOpMulti )
        // PsiInternalEntities.g:1636:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred11_PsiInternalEntities

    // $ANTLR start synpred12_PsiInternalEntities
    public final void synpred12_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1854:5: ( ( () 'as' ) )
        // PsiInternalEntities.g:1854:6: ( () 'as' )
        {
        // PsiInternalEntities.g:1854:6: ( () 'as' )
        // PsiInternalEntities.g:1855:6: () 'as'
        {
        // PsiInternalEntities.g:1855:6: ()
        // PsiInternalEntities.g:1856:6: 
        {
        }

        match(input,52,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_PsiInternalEntities

    // $ANTLR start synpred13_PsiInternalEntities
    public final void synpred13_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:1916:4: ( ( () ( ( ruleOpPostfix ) ) ) )
        // PsiInternalEntities.g:1916:5: ( () ( ( ruleOpPostfix ) ) )
        {
        // PsiInternalEntities.g:1916:5: ( () ( ( ruleOpPostfix ) ) )
        // PsiInternalEntities.g:1917:5: () ( ( ruleOpPostfix ) )
        {
        // PsiInternalEntities.g:1917:5: ()
        // PsiInternalEntities.g:1918:5: 
        {
        }

        // PsiInternalEntities.g:1919:5: ( ( ruleOpPostfix ) )
        // PsiInternalEntities.g:1920:6: ( ruleOpPostfix )
        {
        // PsiInternalEntities.g:1920:6: ( ruleOpPostfix )
        // PsiInternalEntities.g:1921:7: ruleOpPostfix
        {
        pushFollow(FOLLOW_2);
        ruleOpPostfix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred13_PsiInternalEntities

    // $ANTLR start synpred14_PsiInternalEntities
    public final void synpred14_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2007:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
        // PsiInternalEntities.g:2007:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        {
        // PsiInternalEntities.g:2007:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        // PsiInternalEntities.g:2008:7: () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
        {
        // PsiInternalEntities.g:2008:7: ()
        // PsiInternalEntities.g:2009:7: 
        {
        }

        // PsiInternalEntities.g:2010:7: ( '.' | ( ( '::' ) ) )
        int alt122=2;
        int LA122_0 = input.LA(1);

        if ( (LA122_0==55) ) {
            alt122=1;
        }
        else if ( (LA122_0==56) ) {
            alt122=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 122, 0, input);

            throw nvae;
        }
        switch (alt122) {
            case 1 :
                // PsiInternalEntities.g:2011:8: '.'
                {
                match(input,55,FOLLOW_34); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalEntities.g:2013:8: ( ( '::' ) )
                {
                // PsiInternalEntities.g:2013:8: ( ( '::' ) )
                // PsiInternalEntities.g:2014:9: ( '::' )
                {
                // PsiInternalEntities.g:2014:9: ( '::' )
                // PsiInternalEntities.g:2015:10: '::'
                {
                match(input,56,FOLLOW_34); if (state.failed) return ;

                }


                }


                }
                break;

        }

        // PsiInternalEntities.g:2019:7: ( ( ruleFeatureCallID ) )
        // PsiInternalEntities.g:2020:8: ( ruleFeatureCallID )
        {
        // PsiInternalEntities.g:2020:8: ( ruleFeatureCallID )
        // PsiInternalEntities.g:2021:9: ruleFeatureCallID
        {
        pushFollow(FOLLOW_15);
        ruleFeatureCallID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_2);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_PsiInternalEntities

    // $ANTLR start synpred15_PsiInternalEntities
    public final void synpred15_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2107:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )
        // PsiInternalEntities.g:2107:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        {
        // PsiInternalEntities.g:2107:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        // PsiInternalEntities.g:2108:7: () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        {
        // PsiInternalEntities.g:2108:7: ()
        // PsiInternalEntities.g:2109:7: 
        {
        }

        // PsiInternalEntities.g:2110:7: ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        int alt123=3;
        switch ( input.LA(1) ) {
        case 55:
            {
            alt123=1;
            }
            break;
        case 57:
            {
            alt123=2;
            }
            break;
        case 56:
            {
            alt123=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 123, 0, input);

            throw nvae;
        }

        switch (alt123) {
            case 1 :
                // PsiInternalEntities.g:2111:8: '.'
                {
                match(input,55,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalEntities.g:2113:8: ( ( '?.' ) )
                {
                // PsiInternalEntities.g:2113:8: ( ( '?.' ) )
                // PsiInternalEntities.g:2114:9: ( '?.' )
                {
                // PsiInternalEntities.g:2114:9: ( '?.' )
                // PsiInternalEntities.g:2115:10: '?.'
                {
                match(input,57,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // PsiInternalEntities.g:2119:8: ( ( '::' ) )
                {
                // PsiInternalEntities.g:2119:8: ( ( '::' ) )
                // PsiInternalEntities.g:2120:9: ( '::' )
                {
                // PsiInternalEntities.g:2120:9: ( '::' )
                // PsiInternalEntities.g:2121:10: '::'
                {
                match(input,56,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred15_PsiInternalEntities

    // $ANTLR start synpred16_PsiInternalEntities
    public final void synpred16_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2256:7: ( ( '(' ) )
        // PsiInternalEntities.g:2256:8: ( '(' )
        {
        // PsiInternalEntities.g:2256:8: ( '(' )
        // PsiInternalEntities.g:2257:8: '('
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_PsiInternalEntities

    // $ANTLR start synpred17_PsiInternalEntities
    public final void synpred17_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2278:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalEntities.g:2278:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalEntities.g:2278:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalEntities.g:2279:9: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalEntities.g:2279:9: ()
        // PsiInternalEntities.g:2280:9: 
        {
        }

        // PsiInternalEntities.g:2281:9: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt125=2;
        int LA125_0 = input.LA(1);

        if ( (LA125_0==RULE_ID||LA125_0==20||LA125_0==42) ) {
            alt125=1;
        }
        switch (alt125) {
            case 1 :
                // PsiInternalEntities.g:2282:10: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalEntities.g:2282:10: ( ( ruleJvmFormalParameter ) )
                // PsiInternalEntities.g:2283:11: ( ruleJvmFormalParameter )
                {
                // PsiInternalEntities.g:2283:11: ( ruleJvmFormalParameter )
                // PsiInternalEntities.g:2284:12: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_48);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalEntities.g:2287:10: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop124:
                do {
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==21) ) {
                        alt124=1;
                    }


                    switch (alt124) {
                	case 1 :
                	    // PsiInternalEntities.g:2288:11: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,21,FOLLOW_10); if (state.failed) return ;
                	    // PsiInternalEntities.g:2289:11: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalEntities.g:2290:12: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalEntities.g:2290:12: ( ruleJvmFormalParameter )
                	    // PsiInternalEntities.g:2291:13: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_48);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop124;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalEntities.g:2296:9: ( ( '|' ) )
        // PsiInternalEntities.g:2297:10: ( '|' )
        {
        // PsiInternalEntities.g:2297:10: ( '|' )
        // PsiInternalEntities.g:2298:11: '|'
        {
        match(input,61,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred17_PsiInternalEntities

    // $ANTLR start synpred18_PsiInternalEntities
    public final void synpred18_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2369:6: ( ( () '[' ) )
        // PsiInternalEntities.g:2369:7: ( () '[' )
        {
        // PsiInternalEntities.g:2369:7: ( () '[' )
        // PsiInternalEntities.g:2370:7: () '['
        {
        // PsiInternalEntities.g:2370:7: ()
        // PsiInternalEntities.g:2371:7: 
        {
        }

        match(input,59,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_PsiInternalEntities

    // $ANTLR start synpred19_PsiInternalEntities
    public final void synpred19_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2433:4: ( ( () 'synchronized' '(' ) )
        // PsiInternalEntities.g:2433:5: ( () 'synchronized' '(' )
        {
        // PsiInternalEntities.g:2433:5: ( () 'synchronized' '(' )
        // PsiInternalEntities.g:2434:5: () 'synchronized' '('
        {
        // PsiInternalEntities.g:2434:5: ()
        // PsiInternalEntities.g:2435:5: 
        {
        }

        match(input,86,FOLLOW_11); if (state.failed) return ;
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_PsiInternalEntities

    // $ANTLR start synpred20_PsiInternalEntities
    public final void synpred20_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2478:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalEntities.g:2478:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalEntities.g:2478:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalEntities.g:2479:5: () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        // PsiInternalEntities.g:2479:5: ()
        // PsiInternalEntities.g:2480:5: 
        {
        }

        match(input,68,FOLLOW_11); if (state.failed) return ;
        match(input,20,FOLLOW_10); if (state.failed) return ;
        // PsiInternalEntities.g:2483:5: ( ( ruleJvmFormalParameter ) )
        // PsiInternalEntities.g:2484:6: ( ruleJvmFormalParameter )
        {
        // PsiInternalEntities.g:2484:6: ( ruleJvmFormalParameter )
        // PsiInternalEntities.g:2485:7: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_9);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_PsiInternalEntities

    // $ANTLR start synpred21_PsiInternalEntities
    public final void synpred21_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2587:4: ( ( () '[' ) )
        // PsiInternalEntities.g:2587:5: ( () '[' )
        {
        // PsiInternalEntities.g:2587:5: ( () '[' )
        // PsiInternalEntities.g:2588:5: () '['
        {
        // PsiInternalEntities.g:2588:5: ()
        // PsiInternalEntities.g:2589:5: 
        {
        }

        match(input,59,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_PsiInternalEntities

    // $ANTLR start synpred23_PsiInternalEntities
    public final void synpred23_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:2883:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalEntities.g:2883:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalEntities.g:2883:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalEntities.g:2884:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalEntities.g:2884:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( (LA127_0==RULE_ID||LA127_0==20||LA127_0==42) ) {
            alt127=1;
        }
        switch (alt127) {
            case 1 :
                // PsiInternalEntities.g:2885:6: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalEntities.g:2885:6: ( ( ruleJvmFormalParameter ) )
                // PsiInternalEntities.g:2886:7: ( ruleJvmFormalParameter )
                {
                // PsiInternalEntities.g:2886:7: ( ruleJvmFormalParameter )
                // PsiInternalEntities.g:2887:8: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_48);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalEntities.g:2890:6: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop126:
                do {
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( (LA126_0==21) ) {
                        alt126=1;
                    }


                    switch (alt126) {
                	case 1 :
                	    // PsiInternalEntities.g:2891:7: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,21,FOLLOW_10); if (state.failed) return ;
                	    // PsiInternalEntities.g:2892:7: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalEntities.g:2893:8: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalEntities.g:2893:8: ( ruleJvmFormalParameter )
                	    // PsiInternalEntities.g:2894:9: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_48);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop126;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalEntities.g:2899:5: ( ( '|' ) )
        // PsiInternalEntities.g:2900:6: ( '|' )
        {
        // PsiInternalEntities.g:2900:6: ( '|' )
        // PsiInternalEntities.g:2901:7: '|'
        {
        match(input,61,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred23_PsiInternalEntities

    // $ANTLR start synpred25_PsiInternalEntities
    public final void synpred25_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:3269:5: ( 'else' )
        // PsiInternalEntities.g:3269:6: 'else'
        {
        match(input,64,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_PsiInternalEntities

    // $ANTLR start synpred26_PsiInternalEntities
    public final void synpred26_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:3325:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalEntities.g:3325:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalEntities.g:3325:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalEntities.g:3326:7: '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        match(input,20,FOLLOW_10); if (state.failed) return ;
        // PsiInternalEntities.g:3327:7: ( ( ruleJvmFormalParameter ) )
        // PsiInternalEntities.g:3328:8: ( ruleJvmFormalParameter )
        {
        // PsiInternalEntities.g:3328:8: ( ruleJvmFormalParameter )
        // PsiInternalEntities.g:3329:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_9);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_PsiInternalEntities

    // $ANTLR start synpred27_PsiInternalEntities
    public final void synpred27_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:3393:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )
        // PsiInternalEntities.g:3393:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // PsiInternalEntities.g:3393:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        // PsiInternalEntities.g:3394:7: ( ( ruleJvmFormalParameter ) ) ':'
        {
        // PsiInternalEntities.g:3394:7: ( ( ruleJvmFormalParameter ) )
        // PsiInternalEntities.g:3395:8: ( ruleJvmFormalParameter )
        {
        // PsiInternalEntities.g:3395:8: ( ruleJvmFormalParameter )
        // PsiInternalEntities.g:3396:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_9);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_PsiInternalEntities

    // $ANTLR start synpred29_PsiInternalEntities
    public final void synpred29_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4180:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // PsiInternalEntities.g:4180:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // PsiInternalEntities.g:4180:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // PsiInternalEntities.g:4181:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // PsiInternalEntities.g:4181:6: ( ( ruleJvmTypeReference ) )
        // PsiInternalEntities.g:4182:7: ( ruleJvmTypeReference )
        {
        // PsiInternalEntities.g:4182:7: ( ruleJvmTypeReference )
        // PsiInternalEntities.g:4183:8: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_4);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalEntities.g:4186:6: ( ( ruleValidID ) )
        // PsiInternalEntities.g:4187:7: ( ruleValidID )
        {
        // PsiInternalEntities.g:4187:7: ( ruleValidID )
        // PsiInternalEntities.g:4188:8: ruleValidID
        {
        pushFollow(FOLLOW_2);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred29_PsiInternalEntities

    // $ANTLR start synpred30_PsiInternalEntities
    public final void synpred30_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4450:5: ( ( '(' ) )
        // PsiInternalEntities.g:4450:6: ( '(' )
        {
        // PsiInternalEntities.g:4450:6: ( '(' )
        // PsiInternalEntities.g:4451:6: '('
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_PsiInternalEntities

    // $ANTLR start synpred31_PsiInternalEntities
    public final void synpred31_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4472:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalEntities.g:4472:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalEntities.g:4472:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalEntities.g:4473:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalEntities.g:4473:7: ()
        // PsiInternalEntities.g:4474:7: 
        {
        }

        // PsiInternalEntities.g:4475:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt131=2;
        int LA131_0 = input.LA(1);

        if ( (LA131_0==RULE_ID||LA131_0==20||LA131_0==42) ) {
            alt131=1;
        }
        switch (alt131) {
            case 1 :
                // PsiInternalEntities.g:4476:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalEntities.g:4476:8: ( ( ruleJvmFormalParameter ) )
                // PsiInternalEntities.g:4477:9: ( ruleJvmFormalParameter )
                {
                // PsiInternalEntities.g:4477:9: ( ruleJvmFormalParameter )
                // PsiInternalEntities.g:4478:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_48);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalEntities.g:4481:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop130:
                do {
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==21) ) {
                        alt130=1;
                    }


                    switch (alt130) {
                	case 1 :
                	    // PsiInternalEntities.g:4482:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,21,FOLLOW_10); if (state.failed) return ;
                	    // PsiInternalEntities.g:4483:9: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalEntities.g:4484:10: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalEntities.g:4484:10: ( ruleJvmFormalParameter )
                	    // PsiInternalEntities.g:4485:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_48);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop130;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalEntities.g:4490:7: ( ( '|' ) )
        // PsiInternalEntities.g:4491:8: ( '|' )
        {
        // PsiInternalEntities.g:4491:8: ( '|' )
        // PsiInternalEntities.g:4492:9: '|'
        {
        match(input,61,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred31_PsiInternalEntities

    // $ANTLR start synpred32_PsiInternalEntities
    public final void synpred32_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4563:4: ( ( () '[' ) )
        // PsiInternalEntities.g:4563:5: ( () '[' )
        {
        // PsiInternalEntities.g:4563:5: ( () '[' )
        // PsiInternalEntities.g:4564:5: () '['
        {
        // PsiInternalEntities.g:4564:5: ()
        // PsiInternalEntities.g:4565:5: 
        {
        }

        match(input,59,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_PsiInternalEntities

    // $ANTLR start synpred33_PsiInternalEntities
    public final void synpred33_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4712:5: ( '<' )
        // PsiInternalEntities.g:4712:6: '<'
        {
        match(input,29,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_PsiInternalEntities

    // $ANTLR start synpred34_PsiInternalEntities
    public final void synpred34_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4770:5: ( ( '(' ) )
        // PsiInternalEntities.g:4770:6: ( '(' )
        {
        // PsiInternalEntities.g:4770:6: ( '(' )
        // PsiInternalEntities.g:4771:6: '('
        {
        match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_PsiInternalEntities

    // $ANTLR start synpred35_PsiInternalEntities
    public final void synpred35_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4792:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // PsiInternalEntities.g:4792:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // PsiInternalEntities.g:4792:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // PsiInternalEntities.g:4793:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // PsiInternalEntities.g:4793:7: ()
        // PsiInternalEntities.g:4794:7: 
        {
        }

        // PsiInternalEntities.g:4795:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==RULE_ID||LA133_0==20||LA133_0==42) ) {
            alt133=1;
        }
        switch (alt133) {
            case 1 :
                // PsiInternalEntities.g:4796:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // PsiInternalEntities.g:4796:8: ( ( ruleJvmFormalParameter ) )
                // PsiInternalEntities.g:4797:9: ( ruleJvmFormalParameter )
                {
                // PsiInternalEntities.g:4797:9: ( ruleJvmFormalParameter )
                // PsiInternalEntities.g:4798:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_48);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // PsiInternalEntities.g:4801:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop132:
                do {
                    int alt132=2;
                    int LA132_0 = input.LA(1);

                    if ( (LA132_0==21) ) {
                        alt132=1;
                    }


                    switch (alt132) {
                	case 1 :
                	    // PsiInternalEntities.g:4802:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,21,FOLLOW_10); if (state.failed) return ;
                	    // PsiInternalEntities.g:4803:9: ( ( ruleJvmFormalParameter ) )
                	    // PsiInternalEntities.g:4804:10: ( ruleJvmFormalParameter )
                	    {
                	    // PsiInternalEntities.g:4804:10: ( ruleJvmFormalParameter )
                	    // PsiInternalEntities.g:4805:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_48);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop132;
                    }
                } while (true);


                }
                break;

        }

        // PsiInternalEntities.g:4810:7: ( ( '|' ) )
        // PsiInternalEntities.g:4811:8: ( '|' )
        {
        // PsiInternalEntities.g:4811:8: ( '|' )
        // PsiInternalEntities.g:4812:9: '|'
        {
        match(input,61,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred35_PsiInternalEntities

    // $ANTLR start synpred36_PsiInternalEntities
    public final void synpred36_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:4883:4: ( ( () '[' ) )
        // PsiInternalEntities.g:4883:5: ( () '[' )
        {
        // PsiInternalEntities.g:4883:5: ( () '[' )
        // PsiInternalEntities.g:4884:5: () '['
        {
        // PsiInternalEntities.g:4884:5: ()
        // PsiInternalEntities.g:4885:5: 
        {
        }

        match(input,59,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred36_PsiInternalEntities

    // $ANTLR start synpred37_PsiInternalEntities
    public final void synpred37_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5199:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
        // PsiInternalEntities.g:
        {
        if ( (input.LA(1)>=RULE_STRING && input.LA(1)<=RULE_ID)||input.LA(1)==14||input.LA(1)==17||input.LA(1)==20||input.LA(1)==29||(input.LA(1)>=45 && input.LA(1)<=46)||input.LA(1)==51||(input.LA(1)>=58 && input.LA(1)<=59)||input.LA(1)==63||input.LA(1)==65||(input.LA(1)>=68 && input.LA(1)<=70)||(input.LA(1)>=73 && input.LA(1)<=84)||input.LA(1)==86 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred37_PsiInternalEntities

    // $ANTLR start synpred38_PsiInternalEntities
    public final void synpred38_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5260:6: ( 'catch' )
        // PsiInternalEntities.g:5260:7: 'catch'
        {
        match(input,87,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_PsiInternalEntities

    // $ANTLR start synpred39_PsiInternalEntities
    public final void synpred39_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5277:7: ( 'finally' )
        // PsiInternalEntities.g:5277:8: 'finally'
        {
        match(input,85,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_PsiInternalEntities

    // $ANTLR start synpred42_PsiInternalEntities
    public final void synpred42_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5503:5: ( '.' )
        // PsiInternalEntities.g:5503:6: '.'
        {
        match(input,55,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_PsiInternalEntities

    // $ANTLR start synpred43_PsiInternalEntities
    public final void synpred43_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5621:5: ( ( () ruleArrayBrackets ) )
        // PsiInternalEntities.g:5621:6: ( () ruleArrayBrackets )
        {
        // PsiInternalEntities.g:5621:6: ( () ruleArrayBrackets )
        // PsiInternalEntities.g:5622:6: () ruleArrayBrackets
        {
        // PsiInternalEntities.g:5622:6: ()
        // PsiInternalEntities.g:5623:6: 
        {
        }

        pushFollow(FOLLOW_2);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred43_PsiInternalEntities

    // $ANTLR start synpred44_PsiInternalEntities
    public final void synpred44_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5808:5: ( '<' )
        // PsiInternalEntities.g:5808:6: '<'
        {
        match(input,29,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_PsiInternalEntities

    // $ANTLR start synpred45_PsiInternalEntities
    public final void synpred45_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5865:6: ( ( () '.' ) )
        // PsiInternalEntities.g:5865:7: ( () '.' )
        {
        // PsiInternalEntities.g:5865:7: ( () '.' )
        // PsiInternalEntities.g:5866:7: () '.'
        {
        // PsiInternalEntities.g:5866:7: ()
        // PsiInternalEntities.g:5867:7: 
        {
        }

        match(input,55,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred45_PsiInternalEntities

    // $ANTLR start synpred46_PsiInternalEntities
    public final void synpred46_PsiInternalEntities_fragment() throws RecognitionException {   
        // PsiInternalEntities.g:5907:7: ( '<' )
        // PsiInternalEntities.g:5907:8: '<'
        {
        match(input,29,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_PsiInternalEntities

    // Delegated rules

    public final boolean synpred43_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_PsiInternalEntities() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_PsiInternalEntities_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA111 dfa111 = new DFA111(this);
    protected DFA109 dfa109 = new DFA109(this);
    protected DFA119 dfa119 = new DFA119(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\10\11\uffff";
    static final String dfa_3s = "\1\4\7\0\2\uffff";
    static final String dfa_4s = "\1\127\7\0\2\uffff";
    static final String dfa_5s = "\10\uffff\1\2\1\1";
    static final String dfa_6s = "\1\uffff\1\0\1\1\1\5\1\2\1\3\1\4\1\6\2\uffff}>";
    static final String[] dfa_7s = {
            "\5\10\5\uffff\2\10\1\uffff\2\10\1\uffff\3\10\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\36\10\1\uffff\32\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "585:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalEntities()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalEntities()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_4 = input.LA(1);

                         
                        int index11_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalEntities()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalEntities()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalEntities()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalEntities()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA11_7 = input.LA(1);

                         
                        int index11_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_PsiInternalEntities()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\13\uffff";
    static final String dfa_9s = "\1\1\12\uffff";
    static final String dfa_10s = "\1\4\1\uffff\10\0\1\uffff";
    static final String dfa_11s = "\1\127\1\uffff\10\0\1\uffff";
    static final String dfa_12s = "\1\uffff\1\2\10\uffff\1\1";
    static final String dfa_13s = "\2\uffff\1\5\1\0\1\4\1\1\1\6\1\2\1\7\1\3\1\uffff}>";
    static final String[] dfa_14s = {
            "\5\1\5\uffff\2\1\1\uffff\2\1\1\uffff\3\1\1\uffff\5\1\1\2\1\3\10\1\1\4\1\5\1\6\1\7\1\10\1\11\20\1\1\uffff\32\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 1274:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_3 = input.LA(1);

                         
                        int index21_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_2 = input.LA(1);

                         
                        int index21_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_2);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_8 = input.LA(1);

                         
                        int index21_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_PsiInternalEntities()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\1\35\2\uffff\1\36\7\uffff";
    static final String dfa_16s = "\1\54\2\uffff\1\51\7\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\3\1\6";
    static final String dfa_18s = "\13\uffff}>";
    static final String[] dfa_19s = {
            "\1\6\1\3\10\uffff\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\12\12\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1342:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
        }
    }
    static final String dfa_20s = "\116\uffff";
    static final String dfa_21s = "\1\2\115\uffff";
    static final String dfa_22s = "\1\4\1\0\114\uffff";
    static final String dfa_23s = "\1\127\1\0\114\uffff";
    static final String dfa_24s = "\2\uffff\1\2\112\uffff\1\1";
    static final String dfa_25s = "\1\uffff\1\0\114\uffff}>";
    static final String[] dfa_26s = {
            "\5\2\5\uffff\2\2\1\uffff\2\2\1\uffff\1\1\2\2\1\uffff\45\2\1\uffff\32\2",
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
            "",
            "",
            "",
            "",
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

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2254:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_1 = input.LA(1);

                         
                        int index40_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index40_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_27s = "\44\uffff";
    static final String dfa_28s = "\1\4\2\0\41\uffff";
    static final String dfa_29s = "\1\126\2\0\41\uffff";
    static final String dfa_30s = "\3\uffff\2\1\1\2\35\uffff\1\3";
    static final String dfa_31s = "\1\0\1\1\1\2\41\uffff}>";
    static final String[] dfa_32s = {
            "\4\5\1\1\5\uffff\1\5\2\uffff\1\5\2\uffff\1\2\1\uffff\1\43\6\uffff\1\5\14\uffff\1\3\2\uffff\2\5\4\uffff\1\5\6\uffff\2\5\1\uffff\1\4\1\uffff\1\5\1\uffff\1\5\2\uffff\3\5\2\uffff\14\5\1\uffff\1\5",
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
            ""
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "2276:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?";
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

                        else if ( (LA39_0==20) ) {s = 2;}

                        else if ( (LA39_0==42) && (synpred17_PsiInternalEntities())) {s = 3;}

                        else if ( (LA39_0==61) && (synpred17_PsiInternalEntities())) {s = 4;}

                        else if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_DECIMAL)||LA39_0==14||LA39_0==17||LA39_0==29||(LA39_0>=45 && LA39_0<=46)||LA39_0==51||(LA39_0>=58 && LA39_0<=59)||LA39_0==63||LA39_0==65||(LA39_0>=68 && LA39_0<=70)||(LA39_0>=73 && LA39_0<=84)||LA39_0==86) ) {s = 5;}

                        else if ( (LA39_0==22) ) {s = 35;}

                         
                        input.seek(index39_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_PsiInternalEntities()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_PsiInternalEntities()) ) {s = 4;}

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
    static final String[] dfa_33s = {
            "\5\2\5\uffff\2\2\1\uffff\2\2\1\uffff\3\2\1\uffff\43\2\1\1\1\2\1\uffff\32\2",
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
            "",
            "",
            "",
            "",
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
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "2368:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_1 = input.LA(1);

                         
                        int index41_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_34s = "\40\uffff";
    static final String dfa_35s = "\1\4\26\uffff\1\0\10\uffff";
    static final String dfa_36s = "\1\126\26\uffff\1\0\10\uffff";
    static final String dfa_37s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\6\uffff\1\6\11\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\10\1\11";
    static final String dfa_38s = "\1\0\26\uffff\1\1\10\uffff}>";
    static final String[] dfa_39s = {
            "\4\14\1\5\5\uffff\1\2\2\uffff\1\5\2\uffff\1\35\10\uffff\1\5\34\uffff\2\14\3\uffff\1\26\1\uffff\1\3\2\uffff\1\27\1\30\1\31\2\uffff\4\5\1\1\4\14\1\32\1\33\1\34\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_34;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "2404:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_0 = input.LA(1);

                         
                        int index43_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA43_0==77) ) {s = 1;}

                        else if ( (LA43_0==14) ) {s = 2;}

                        else if ( (LA43_0==65) ) {s = 3;}

                        else if ( (LA43_0==86) && (synpred19_PsiInternalEntities())) {s = 4;}

                        else if ( (LA43_0==RULE_ID||LA43_0==17||LA43_0==29||(LA43_0>=73 && LA43_0<=76)) ) {s = 5;}

                        else if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_DECIMAL)||(LA43_0>=58 && LA43_0<=59)||(LA43_0>=78 && LA43_0<=81)) ) {s = 12;}

                        else if ( (LA43_0==63) ) {s = 22;}

                        else if ( (LA43_0==68) ) {s = 23;}

                        else if ( (LA43_0==69) ) {s = 24;}

                        else if ( (LA43_0==70) ) {s = 25;}

                        else if ( (LA43_0==82) ) {s = 26;}

                        else if ( (LA43_0==83) ) {s = 27;}

                        else if ( (LA43_0==84) ) {s = 28;}

                        else if ( (LA43_0==20) ) {s = 29;}

                         
                        input.seek(index43_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_23 = input.LA(1);

                         
                        int index43_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_PsiInternalEntities()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index43_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_40s = "\46\uffff";
    static final String dfa_41s = "\1\4\2\0\43\uffff";
    static final String dfa_42s = "\1\126\2\0\43\uffff";
    static final String dfa_43s = "\3\uffff\2\1\1\2\40\uffff";
    static final String dfa_44s = "\1\0\1\1\1\2\43\uffff}>";
    static final String[] dfa_45s = {
            "\4\5\1\1\5\uffff\1\5\2\uffff\1\5\2\uffff\1\2\10\uffff\1\5\14\uffff\1\3\2\uffff\2\5\4\uffff\1\5\6\uffff\3\5\1\4\1\uffff\1\5\1\uffff\1\5\2\uffff\21\5\1\uffff\1\5",
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

    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_40;
            this.eof = dfa_40;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_44;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "2882:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_0 = input.LA(1);

                         
                        int index52_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA52_0==RULE_ID) ) {s = 1;}

                        else if ( (LA52_0==20) ) {s = 2;}

                        else if ( (LA52_0==42) && (synpred23_PsiInternalEntities())) {s = 3;}

                        else if ( (LA52_0==61) && (synpred23_PsiInternalEntities())) {s = 4;}

                        else if ( ((LA52_0>=RULE_STRING && LA52_0<=RULE_DECIMAL)||LA52_0==14||LA52_0==17||LA52_0==29||(LA52_0>=45 && LA52_0<=46)||LA52_0==51||(LA52_0>=58 && LA52_0<=60)||LA52_0==63||LA52_0==65||(LA52_0>=68 && LA52_0<=84)||LA52_0==86) ) {s = 5;}

                         
                        input.seek(index52_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA52_1 = input.LA(1);

                         
                        int index52_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_PsiInternalEntities()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index52_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA52_2 = input.LA(1);

                         
                        int index52_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_PsiInternalEntities()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index52_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_46s = "\43\uffff";
    static final String dfa_47s = "\1\4\1\0\41\uffff";
    static final String dfa_48s = "\1\126\1\0\41\uffff";
    static final String dfa_49s = "\2\uffff\1\2\37\uffff\1\1";
    static final String dfa_50s = "\1\uffff\1\0\41\uffff}>";
    static final String[] dfa_51s = {
            "\5\2\5\uffff\1\2\2\uffff\1\2\2\uffff\1\1\10\uffff\1\2\14\uffff\1\2\2\uffff\2\2\4\uffff\1\2\6\uffff\2\2\3\uffff\1\2\1\uffff\1\2\2\uffff\3\2\2\uffff\14\2\1\uffff\1\2",
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
            ""
    };

    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_46;
            this.eof = dfa_46;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "3322:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )";
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
                        if ( (synpred26_PsiInternalEntities()) ) {s = 34;}

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
    static final String dfa_52s = "\42\uffff";
    static final String dfa_53s = "\1\4\2\0\37\uffff";
    static final String dfa_54s = "\1\126\2\0\37\uffff";
    static final String dfa_55s = "\3\uffff\1\1\1\2\35\uffff";
    static final String dfa_56s = "\1\0\1\1\1\2\37\uffff}>";
    static final String[] dfa_57s = {
            "\4\4\1\1\5\uffff\1\4\2\uffff\1\4\2\uffff\1\2\10\uffff\1\4\14\uffff\1\3\2\uffff\2\4\4\uffff\1\4\6\uffff\2\4\3\uffff\1\4\1\uffff\1\4\2\uffff\3\4\2\uffff\14\4\1\uffff\1\4",
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
            ""
    };

    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_52;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_56;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "3392:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?";
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

                        else if ( (LA58_0==20) ) {s = 2;}

                        else if ( (LA58_0==42) && (synpred27_PsiInternalEntities())) {s = 3;}

                        else if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_DECIMAL)||LA58_0==14||LA58_0==17||LA58_0==29||(LA58_0>=45 && LA58_0<=46)||LA58_0==51||(LA58_0>=58 && LA58_0<=59)||LA58_0==63||LA58_0==65||(LA58_0>=68 && LA58_0<=70)||(LA58_0>=73 && LA58_0<=84)||LA58_0==86) ) {s = 4;}

                         
                        input.seek(index58_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_1 = input.LA(1);

                         
                        int index58_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_PsiInternalEntities()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index58_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_PsiInternalEntities()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
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

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "4448:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_1 = input.LA(1);

                         
                        int index81_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index81_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 81, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "4470:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_0 = input.LA(1);

                         
                        int index80_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA80_0==RULE_ID) ) {s = 1;}

                        else if ( (LA80_0==20) ) {s = 2;}

                        else if ( (LA80_0==42) && (synpred31_PsiInternalEntities())) {s = 3;}

                        else if ( (LA80_0==61) && (synpred31_PsiInternalEntities())) {s = 4;}

                        else if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_DECIMAL)||LA80_0==14||LA80_0==17||LA80_0==29||(LA80_0>=45 && LA80_0<=46)||LA80_0==51||(LA80_0>=58 && LA80_0<=59)||LA80_0==63||LA80_0==65||(LA80_0>=68 && LA80_0<=70)||(LA80_0>=73 && LA80_0<=84)||LA80_0==86) ) {s = 5;}

                        else if ( (LA80_0==22) ) {s = 35;}

                         
                        input.seek(index80_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_PsiInternalEntities()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index80_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA80_2 = input.LA(1);

                         
                        int index80_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_PsiInternalEntities()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index80_2);
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

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "4562:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_58s = {
            "\5\2\5\uffff\2\2\1\uffff\2\2\1\uffff\3\2\1\uffff\5\2\1\1\37\2\1\uffff\32\2",
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
            "",
            "",
            "",
            "",
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
    static final short[][] dfa_58 = unpackEncodedStringArray(dfa_58s);

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_58;
        }
        public String getDescription() {
            return "4710:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
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
                        if ( (synpred33_PsiInternalEntities()) ) {s = 77;}

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

    class DFA89 extends DFA {

        public DFA89(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 89;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "4768:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA89_1 = input.LA(1);

                         
                        int index89_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index89_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 89, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "4790:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA88_0 = input.LA(1);

                         
                        int index88_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA88_0==RULE_ID) ) {s = 1;}

                        else if ( (LA88_0==20) ) {s = 2;}

                        else if ( (LA88_0==42) && (synpred35_PsiInternalEntities())) {s = 3;}

                        else if ( (LA88_0==61) && (synpred35_PsiInternalEntities())) {s = 4;}

                        else if ( ((LA88_0>=RULE_STRING && LA88_0<=RULE_DECIMAL)||LA88_0==14||LA88_0==17||LA88_0==29||(LA88_0>=45 && LA88_0<=46)||LA88_0==51||(LA88_0>=58 && LA88_0<=59)||LA88_0==63||LA88_0==65||(LA88_0>=68 && LA88_0<=70)||(LA88_0>=73 && LA88_0<=84)||LA88_0==86) ) {s = 5;}

                        else if ( (LA88_0==22) ) {s = 35;}

                         
                        input.seek(index88_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA88_1 = input.LA(1);

                         
                        int index88_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_PsiInternalEntities()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index88_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA88_2 = input.LA(1);

                         
                        int index88_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_PsiInternalEntities()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index88_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 88, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "4882:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_1 = input.LA(1);

                         
                        int index90_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index90_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 90, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_59s = "\1\41\115\uffff";
    static final String dfa_60s = "\1\4\40\0\55\uffff";
    static final String dfa_61s = "\1\127\40\0\55\uffff";
    static final String dfa_62s = "\41\uffff\1\2\53\uffff\1\1";
    static final String dfa_63s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\55\uffff}>";
    static final String[] dfa_64s = {
            "\1\27\1\23\1\24\1\25\1\1\5\uffff\1\12\1\41\1\uffff\1\2\1\41\1\uffff\1\40\2\41\1\uffff\5\41\1\15\17\41\1\10\1\7\4\41\1\6\6\41\1\17\1\20\1\41\1\uffff\1\41\1\31\1\41\1\13\2\41\1\32\1\33\1\34\2\41\1\3\1\4\1\5\1\16\1\11\1\21\1\22\1\26\1\30\1\35\1\36\1\37\1\41\1\14\1\41",
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
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final char[] dfa_60 = DFA.unpackEncodedStringToUnsignedChars(dfa_60s);
    static final char[] dfa_61 = DFA.unpackEncodedStringToUnsignedChars(dfa_61s);
    static final short[] dfa_62 = DFA.unpackEncodedString(dfa_62s);
    static final short[] dfa_63 = DFA.unpackEncodedString(dfa_63s);
    static final short[][] dfa_64 = unpackEncodedStringArray(dfa_64s);

    class DFA93 extends DFA {

        public DFA93(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 93;
            this.eot = dfa_20;
            this.eof = dfa_59;
            this.min = dfa_60;
            this.max = dfa_61;
            this.accept = dfa_62;
            this.special = dfa_63;
            this.transition = dfa_64;
        }
        public String getDescription() {
            return "5198:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA93_1 = input.LA(1);

                         
                        int index93_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA93_2 = input.LA(1);

                         
                        int index93_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA93_3 = input.LA(1);

                         
                        int index93_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA93_4 = input.LA(1);

                         
                        int index93_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA93_5 = input.LA(1);

                         
                        int index93_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA93_6 = input.LA(1);

                         
                        int index93_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA93_7 = input.LA(1);

                         
                        int index93_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA93_8 = input.LA(1);

                         
                        int index93_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA93_9 = input.LA(1);

                         
                        int index93_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA93_10 = input.LA(1);

                         
                        int index93_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA93_11 = input.LA(1);

                         
                        int index93_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA93_12 = input.LA(1);

                         
                        int index93_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA93_13 = input.LA(1);

                         
                        int index93_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA93_14 = input.LA(1);

                         
                        int index93_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA93_15 = input.LA(1);

                         
                        int index93_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA93_16 = input.LA(1);

                         
                        int index93_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA93_17 = input.LA(1);

                         
                        int index93_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA93_18 = input.LA(1);

                         
                        int index93_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA93_19 = input.LA(1);

                         
                        int index93_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA93_20 = input.LA(1);

                         
                        int index93_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA93_21 = input.LA(1);

                         
                        int index93_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA93_22 = input.LA(1);

                         
                        int index93_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA93_23 = input.LA(1);

                         
                        int index93_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA93_24 = input.LA(1);

                         
                        int index93_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA93_25 = input.LA(1);

                         
                        int index93_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA93_26 = input.LA(1);

                         
                        int index93_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA93_27 = input.LA(1);

                         
                        int index93_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA93_28 = input.LA(1);

                         
                        int index93_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA93_29 = input.LA(1);

                         
                        int index93_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA93_30 = input.LA(1);

                         
                        int index93_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA93_31 = input.LA(1);

                         
                        int index93_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA93_32 = input.LA(1);

                         
                        int index93_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_PsiInternalEntities()) ) {s = 77;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index93_32);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 93, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_65s = "\120\uffff";
    static final String dfa_66s = "\1\2\117\uffff";
    static final String dfa_67s = "\1\4\1\0\116\uffff";
    static final String dfa_68s = "\1\131\1\0\116\uffff";
    static final String dfa_69s = "\2\uffff\1\2\114\uffff\1\1";
    static final String dfa_70s = "\1\uffff\1\0\116\uffff}>";
    static final String[] dfa_71s = {
            "\5\2\5\uffff\2\2\1\uffff\6\2\1\uffff\5\2\1\1\37\2\1\uffff\32\2\1\uffff\1\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[] dfa_69 = DFA.unpackEncodedString(dfa_69s);
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA111 extends DFA {

        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "5806:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA111_1 = input.LA(1);

                         
                        int index111_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_PsiInternalEntities()) ) {s = 79;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index111_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 111, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA109 extends DFA {

        public DFA109(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 109;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "5905:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA109_1 = input.LA(1);

                         
                        int index109_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_PsiInternalEntities()) ) {s = 79;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index109_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 109, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_72s = "\7\uffff";
    static final String dfa_73s = "\2\uffff\1\4\3\uffff\1\4";
    static final String dfa_74s = "\1\10\1\uffff\1\15\1\10\2\uffff\1\15";
    static final String dfa_75s = "\1\111\1\uffff\1\112\1\57\2\uffff\1\112";
    static final String dfa_76s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String dfa_77s = "\7\uffff}>";
    static final String[] dfa_78s = {
            "\1\2\100\uffff\1\1",
            "",
            "\1\4\2\uffff\1\4\46\uffff\1\3\6\uffff\1\4\13\uffff\1\4",
            "\1\6\46\uffff\1\5",
            "",
            "",
            "\1\4\2\uffff\1\4\46\uffff\1\3\6\uffff\1\4\13\uffff\1\4"
    };

    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final char[] dfa_74 = DFA.unpackEncodedStringToUnsignedChars(dfa_74s);
    static final char[] dfa_75 = DFA.unpackEncodedStringToUnsignedChars(dfa_75s);
    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final short[] dfa_77 = DFA.unpackEncodedString(dfa_77s);
    static final short[][] dfa_78 = unpackEncodedStringArray(dfa_78s);

    class DFA119 extends DFA {

        public DFA119(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 119;
            this.eot = dfa_72;
            this.eof = dfa_73;
            this.min = dfa_74;
            this.max = dfa_75;
            this.accept = dfa_76;
            this.special = dfa_77;
            this.transition = dfa_78;
        }
        public String getDescription() {
            return "6337:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000012002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000001A000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000088100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000040000100100L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000040000500100L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x8C086000201641F0L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000007F000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000003C00000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000040E0000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00001F8060000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000040020000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0007800000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0380000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000020100L,0x0000000000000E00L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000020020100L,0x0000000000001E00L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000100100L,0x0000000001000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000040200000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0B80000000100002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xAC086400205641F0L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0B80000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x8C0860002016C1F0L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x9C086000201641F0L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x1000000000200000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0xBC086400201641F0L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x2000000000200000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x9C086000201641F0L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0xCC086000201641F2L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x8C086000201641F2L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8C086400201641F0L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000040000348100L,0x000000000000000CL});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000240000L,0x0000000000000008L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xCC086000201641F0L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x4000000000200000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x8C086000201641F0L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0xCC086000201641F0L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x8C086000205641F0L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x8C0860002016C1F0L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0xCC0860002016C1F0L,0x00000000005FFFF2L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0800000000100002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0800000020100002L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0800000000400000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x8C086000201641F2L,0x00000000005FFE72L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A00000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A00000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0080000020000002L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000020002L,0x0000000000001000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000200L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000800L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000800000000100L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000102L});

}
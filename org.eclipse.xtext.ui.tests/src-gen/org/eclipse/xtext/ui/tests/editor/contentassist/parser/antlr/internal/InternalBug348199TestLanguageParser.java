package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348199TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalBug348199TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'define'", "'timeperiod'", "'1'", "'{'", "'timeperiod_name'", "'otherelement'", "'}'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'july'", "'august'", "'september'"
    };
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_NL=4;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug348199TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug348199TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug348199TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug348199TestLanguage.g"; }



     	private Bug348199TestLanguageGrammarAccess grammarAccess;

        public InternalBug348199TestLanguageParser(TokenStream input, Bug348199TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Timeperiod";
       	}

       	@Override
       	protected Bug348199TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTimeperiod"
    // InternalBug348199TestLanguage.g:69:1: entryRuleTimeperiod returns [EObject current=null] : iv_ruleTimeperiod= ruleTimeperiod EOF ;
    public final EObject entryRuleTimeperiod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeperiod = null;


        try {
            // InternalBug348199TestLanguage.g:69:51: (iv_ruleTimeperiod= ruleTimeperiod EOF )
            // InternalBug348199TestLanguage.g:70:2: iv_ruleTimeperiod= ruleTimeperiod EOF
            {
             newCompositeNode(grammarAccess.getTimeperiodRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTimeperiod=ruleTimeperiod();

            state._fsp--;

             current =iv_ruleTimeperiod; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeperiod"


    // $ANTLR start "ruleTimeperiod"
    // InternalBug348199TestLanguage.g:76:1: ruleTimeperiod returns [EObject current=null] : ( () otherlv_1= 'define' otherlv_2= 'timeperiod' ( (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' ) | (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' ) | (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' ) | (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' ) | (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' ) | (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' ) | (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' ) | (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' ) ) ) ;
    public final EObject ruleTimeperiod() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_NL_5=null;
        Token this_NL_8=null;
        Token otherlv_9=null;
        Token lv_name_10_0=null;
        Token this_NL_11=null;
        Token this_NL_13=null;
        Token otherlv_14=null;
        Token lv_alias_15_0=null;
        Token this_NL_16=null;
        Token this_NL_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token this_NL_22=null;
        Token this_NL_24=null;
        Token otherlv_25=null;
        Token lv_name_26_0=null;
        Token this_NL_27=null;
        Token this_NL_29=null;
        Token otherlv_30=null;
        Token lv_alias_31_0=null;
        Token this_NL_32=null;
        Token this_NL_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token this_NL_38=null;
        Token this_NL_40=null;
        Token otherlv_41=null;
        Token lv_name_42_0=null;
        Token this_NL_43=null;
        Token this_NL_45=null;
        Token otherlv_46=null;
        Token lv_alias_47_0=null;
        Token this_NL_48=null;
        Token this_NL_50=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token otherlv_53=null;
        Token this_NL_54=null;
        Token this_NL_56=null;
        Token otherlv_57=null;
        Token lv_name_58_0=null;
        Token this_NL_59=null;
        Token this_NL_61=null;
        Token otherlv_62=null;
        Token lv_alias_63_0=null;
        Token this_NL_64=null;
        Token this_NL_66=null;
        Token otherlv_67=null;
        Token otherlv_68=null;
        Token otherlv_69=null;
        Token this_NL_70=null;
        Token this_NL_72=null;
        Token otherlv_74=null;
        Token lv_name_75_0=null;
        Token this_NL_76=null;
        Token this_NL_78=null;
        Token otherlv_79=null;
        Token lv_alias_80_0=null;
        Token this_NL_81=null;
        Token this_NL_83=null;
        Token otherlv_84=null;
        Token otherlv_85=null;
        Token otherlv_86=null;
        Token this_NL_87=null;
        Token this_NL_89=null;
        Token otherlv_90=null;
        Token lv_name_91_0=null;
        Token this_NL_92=null;
        Token this_NL_94=null;
        Token otherlv_95=null;
        Token lv_alias_96_0=null;
        Token this_NL_97=null;
        Token this_NL_99=null;
        Token otherlv_100=null;
        Token otherlv_101=null;
        Token otherlv_102=null;
        Token this_NL_103=null;
        Token this_NL_105=null;
        Token otherlv_106=null;
        Token lv_name_107_0=null;
        Token this_NL_108=null;
        Token this_NL_110=null;
        Token otherlv_111=null;
        Token lv_alias_112_0=null;
        Token this_NL_113=null;
        Token this_NL_115=null;
        Token otherlv_116=null;
        Token otherlv_117=null;
        Token otherlv_118=null;
        Token this_NL_119=null;
        Token this_NL_121=null;
        Token otherlv_122=null;
        Token lv_name_123_0=null;
        Token this_NL_124=null;
        Token this_NL_126=null;
        Token otherlv_127=null;
        Token lv_alias_128_0=null;
        Token this_NL_129=null;
        Token this_NL_131=null;
        Token otherlv_132=null;
        EObject lv_time_6_0 = null;

        EObject lv_time_12_0 = null;

        EObject lv_time_17_0 = null;

        EObject lv_time_23_0 = null;

        EObject lv_time_28_0 = null;

        EObject lv_time_33_0 = null;

        EObject lv_time_39_0 = null;

        EObject lv_time_44_0 = null;

        EObject lv_time_49_0 = null;

        EObject lv_time_55_0 = null;

        EObject lv_time_60_0 = null;

        EObject lv_time_65_0 = null;

        EObject lv_time_71_0 = null;

        EObject lv_time_77_0 = null;

        EObject lv_time_82_0 = null;

        EObject lv_time_88_0 = null;

        EObject lv_time_93_0 = null;

        EObject lv_time_98_0 = null;

        EObject lv_time_104_0 = null;

        EObject lv_time_109_0 = null;

        EObject lv_time_114_0 = null;

        EObject lv_time_120_0 = null;

        EObject lv_time_125_0 = null;

        EObject lv_time_130_0 = null;



        	enterRule();

        try {
            // InternalBug348199TestLanguage.g:82:2: ( ( () otherlv_1= 'define' otherlv_2= 'timeperiod' ( (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' ) | (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' ) | (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' ) | (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' ) | (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' ) | (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' ) | (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' ) | (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' ) ) ) )
            // InternalBug348199TestLanguage.g:83:2: ( () otherlv_1= 'define' otherlv_2= 'timeperiod' ( (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' ) | (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' ) | (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' ) | (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' ) | (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' ) | (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' ) | (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' ) | (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' ) ) )
            {
            // InternalBug348199TestLanguage.g:83:2: ( () otherlv_1= 'define' otherlv_2= 'timeperiod' ( (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' ) | (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' ) | (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' ) | (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' ) | (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' ) | (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' ) | (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' ) | (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' ) ) )
            // InternalBug348199TestLanguage.g:84:3: () otherlv_1= 'define' otherlv_2= 'timeperiod' ( (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' ) | (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' ) | (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' ) | (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' ) | (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' ) | (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' ) | (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' ) | (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' ) )
            {
            // InternalBug348199TestLanguage.g:84:3: ()
            // InternalBug348199TestLanguage.g:85:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeperiodAccess().getTimeperiodAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeperiodAccess().getDefineKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeperiodAccess().getTimeperiodKeyword_2());
            		
            // InternalBug348199TestLanguage.g:99:3: ( (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' ) | (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' ) | (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' ) | (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' ) | (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' ) | (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' ) | (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' ) | (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' ) )
            int alt83=8;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt83=1;
                }
                break;
            case 19:
                {
                alt83=2;
                }
                break;
            case 20:
                {
                alt83=3;
                }
                break;
            case 21:
                {
                alt83=4;
                }
                break;
            case 22:
                {
                alt83=5;
                }
                break;
            case 23:
                {
                alt83=6;
                }
                break;
            case 24:
                {
                alt83=7;
                }
                break;
            case 25:
                {
                alt83=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalBug348199TestLanguage.g:100:4: (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' )
                    {
                    // InternalBug348199TestLanguage.g:100:4: (otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}' )
                    // InternalBug348199TestLanguage.g:101:5: otherlv_3= '1' otherlv_4= '{' ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )* ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) ) (this_NL_18= RULE_NL )+ otherlv_19= '}'
                    {
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_3, grammarAccess.getTimeperiodAccess().getDigitOneKeyword_3_0_0());
                    				
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_4, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_0_1());
                    				
                    // InternalBug348199TestLanguage.g:109:5: ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        alt2 = dfa2.predict(input);
                        switch (alt2) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:110:6: (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:110:6: (this_NL_5= RULE_NL )+
                    	    int cnt1=0;
                    	    loop1:
                    	    do {
                    	        int alt1=2;
                    	        int LA1_0 = input.LA(1);

                    	        if ( (LA1_0==RULE_NL) ) {
                    	            alt1=1;
                    	        }


                    	        switch (alt1) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:111:7: this_NL_5= RULE_NL
                    	    	    {
                    	    	    this_NL_5=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_7); 

                    	    	    							newLeafNode(this_NL_5, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_2_0());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt1 >= 1 ) break loop1;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(1, input);
                    	                throw eee;
                    	        }
                    	        cnt1++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:116:6: ( (lv_time_6_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:117:7: (lv_time_6_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:117:7: (lv_time_6_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:118:8: lv_time_6_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_0_2_1_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_6_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_6_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:136:5: ( ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) ) )
                    // InternalBug348199TestLanguage.g:137:6: ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) )
                    {
                    // InternalBug348199TestLanguage.g:137:6: ( ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?) )
                    // InternalBug348199TestLanguage.g:138:7: ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?)
                    {
                     
                    						  getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
                    						
                    // InternalBug348199TestLanguage.g:141:7: ( ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?)
                    // InternalBug348199TestLanguage.g:142:8: ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+ {...}?
                    {
                    // InternalBug348199TestLanguage.g:142:8: ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=3;
                        alt9 = dfa9.predict(input);
                        switch (alt9) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:143:6: ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:143:6: ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) )
                    	    // InternalBug348199TestLanguage.g:144:7: {...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0)");
                    	    }
                    	    // InternalBug348199TestLanguage.g:144:113: ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) )
                    	    // InternalBug348199TestLanguage.g:145:8: ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0);
                    	    							
                    	    // InternalBug348199TestLanguage.g:148:11: ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) )
                    	    // InternalBug348199TestLanguage.g:148:12: {...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "true");
                    	    }
                    	    // InternalBug348199TestLanguage.g:148:21: ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* )
                    	    // InternalBug348199TestLanguage.g:148:22: (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )*
                    	    {
                    	    // InternalBug348199TestLanguage.g:148:22: (this_NL_8= RULE_NL )+
                    	    int cnt3=0;
                    	    loop3:
                    	    do {
                    	        int alt3=2;
                    	        int LA3_0 = input.LA(1);

                    	        if ( (LA3_0==RULE_NL) ) {
                    	            alt3=1;
                    	        }


                    	        switch (alt3) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:149:12: this_NL_8= RULE_NL
                    	    	    {
                    	    	    this_NL_8=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_8); 

                    	    	    												newLeafNode(this_NL_8, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_0());
                    	    	    											

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt3 >= 1 ) break loop3;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(3, input);
                    	                throw eee;
                    	        }
                    	        cnt3++;
                    	    } while (true);

                    	    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    	    											newLeafNode(otherlv_9, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_0_3_0_1());
                    	    										
                    	    // InternalBug348199TestLanguage.g:158:11: ( (lv_name_10_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:159:12: (lv_name_10_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:159:12: (lv_name_10_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:160:13: lv_name_10_0= RULE_ID
                    	    {
                    	    lv_name_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    													newLeafNode(lv_name_10_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_0_3_0_2_0());
                    	    												

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    													}
                    	    													addWithLastConsumed(
                    	    														current,
                    	    														"name",
                    	    														lv_name_10_0,
                    	    														"org.eclipse.xtext.common.Terminals.ID");
                    	    												

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:176:11: ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )*
                    	    loop5:
                    	    do {
                    	        int alt5=2;
                    	        alt5 = dfa5.predict(input);
                    	        switch (alt5) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:177:12: (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:177:12: (this_NL_11= RULE_NL )+
                    	    	    int cnt4=0;
                    	    	    loop4:
                    	    	    do {
                    	    	        int alt4=2;
                    	    	        int LA4_0 = input.LA(1);

                    	    	        if ( (LA4_0==RULE_NL) ) {
                    	    	            alt4=1;
                    	    	        }


                    	    	        switch (alt4) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:178:13: this_NL_11= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_11=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_10); 

                    	    	    	    													newLeafNode(this_NL_11, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_0_3_0());
                    	    	    	    												

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt4 >= 1 ) break loop4;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(4, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt4++;
                    	    	    } while (true);

                    	    	    // InternalBug348199TestLanguage.g:183:12: ( (lv_time_12_0= ruleTimeDef2 ) )
                    	    	    // InternalBug348199TestLanguage.g:184:13: (lv_time_12_0= ruleTimeDef2 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:184:13: (lv_time_12_0= ruleTimeDef2 )
                    	    	    // InternalBug348199TestLanguage.g:185:14: lv_time_12_0= ruleTimeDef2
                    	    	    {

                    	    	    														newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_0_3_0_3_1_0());
                    	    	    													
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_12_0=ruleTimeDef2();

                    	    	    state._fsp--;


                    	    	    														if (current==null) {
                    	    	    															current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    														}
                    	    	    														add(
                    	    	    															current,
                    	    	    															"time",
                    	    	    															lv_time_12_0,
                    	    	    															"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                    	    	    														afterParserOrEnumRuleCall();
                    	    	    													

                    	    	    }


                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop5;
                    	        }
                    	    } while (true);


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:209:6: ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:209:6: ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) )
                    	    // InternalBug348199TestLanguage.g:210:7: {...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1)");
                    	    }
                    	    // InternalBug348199TestLanguage.g:210:113: ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) )
                    	    // InternalBug348199TestLanguage.g:211:8: ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1);
                    	    							
                    	    // InternalBug348199TestLanguage.g:214:11: ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) )
                    	    // InternalBug348199TestLanguage.g:214:12: {...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "true");
                    	    }
                    	    // InternalBug348199TestLanguage.g:214:21: ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* )
                    	    // InternalBug348199TestLanguage.g:214:22: (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )*
                    	    {
                    	    // InternalBug348199TestLanguage.g:214:22: (this_NL_13= RULE_NL )+
                    	    int cnt6=0;
                    	    loop6:
                    	    do {
                    	        int alt6=2;
                    	        int LA6_0 = input.LA(1);

                    	        if ( (LA6_0==RULE_NL) ) {
                    	            alt6=1;
                    	        }


                    	        switch (alt6) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:215:12: this_NL_13= RULE_NL
                    	    	    {
                    	    	    this_NL_13=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_11); 

                    	    	    												newLeafNode(this_NL_13, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_0());
                    	    	    											

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt6 >= 1 ) break loop6;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(6, input);
                    	                throw eee;
                    	        }
                    	        cnt6++;
                    	    } while (true);

                    	    otherlv_14=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                    	    											newLeafNode(otherlv_14, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_0_3_1_1());
                    	    										
                    	    // InternalBug348199TestLanguage.g:224:11: ( (lv_alias_15_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:225:12: (lv_alias_15_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:225:12: (lv_alias_15_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:226:13: lv_alias_15_0= RULE_ID
                    	    {
                    	    lv_alias_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    													newLeafNode(lv_alias_15_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_0_3_1_2_0());
                    	    												

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    													}
                    	    													addWithLastConsumed(
                    	    														current,
                    	    														"alias",
                    	    														lv_alias_15_0,
                    	    														"org.eclipse.xtext.common.Terminals.ID");
                    	    												

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:242:11: ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )*
                    	    loop8:
                    	    do {
                    	        int alt8=2;
                    	        alt8 = dfa8.predict(input);
                    	        switch (alt8) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:243:12: (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:243:12: (this_NL_16= RULE_NL )+
                    	    	    int cnt7=0;
                    	    	    loop7:
                    	    	    do {
                    	    	        int alt7=2;
                    	    	        int LA7_0 = input.LA(1);

                    	    	        if ( (LA7_0==RULE_NL) ) {
                    	    	            alt7=1;
                    	    	        }


                    	    	        switch (alt7) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:244:13: this_NL_16= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_16=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_12); 

                    	    	    	    													newLeafNode(this_NL_16, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_3_1_3_0());
                    	    	    	    												

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt7 >= 1 ) break loop7;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(7, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt7++;
                    	    	    } while (true);

                    	    	    // InternalBug348199TestLanguage.g:249:12: ( (lv_time_17_0= ruleTimeDef3 ) )
                    	    	    // InternalBug348199TestLanguage.g:250:13: (lv_time_17_0= ruleTimeDef3 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:250:13: (lv_time_17_0= ruleTimeDef3 )
                    	    	    // InternalBug348199TestLanguage.g:251:14: lv_time_17_0= ruleTimeDef3
                    	    	    {

                    	    	    														newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_0_3_1_3_1_0());
                    	    	    													
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_17_0=ruleTimeDef3();

                    	    	    state._fsp--;


                    	    	    														if (current==null) {
                    	    	    															current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    														}
                    	    	    														add(
                    	    	    															current,
                    	    	    															"time",
                    	    	    															lv_time_17_0,
                    	    	    															"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
                    	    	    														afterParserOrEnumRuleCall();
                    	    	    													

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

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3()) ) {
                        throw new FailedPredicateException(input, "ruleTimeperiod", "getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3())");
                    }

                    }


                    }

                     
                    						  getUnorderedGroupHelper().leave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3());
                    						

                    }

                    // InternalBug348199TestLanguage.g:283:5: (this_NL_18= RULE_NL )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_NL) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:284:6: this_NL_18= RULE_NL
                    	    {
                    	    this_NL_18=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_13); 

                    	    						newLeafNode(this_NL_18, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_0_4());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    otherlv_19=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_19, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_0_5());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalBug348199TestLanguage.g:295:4: (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' )
                    {
                    // InternalBug348199TestLanguage.g:295:4: (otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}' )
                    // InternalBug348199TestLanguage.g:296:5: otherlv_20= '2' otherlv_21= '{' ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )* ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? ) (this_NL_34= RULE_NL )+ otherlv_35= '}'
                    {
                    otherlv_20=(Token)match(input,19,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_20, grammarAccess.getTimeperiodAccess().getDigitTwoKeyword_3_1_0());
                    				
                    otherlv_21=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_21, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_1_1());
                    				
                    // InternalBug348199TestLanguage.g:304:5: ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        alt12 = dfa12.predict(input);
                        switch (alt12) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:305:6: (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:305:6: (this_NL_22= RULE_NL )+
                    	    int cnt11=0;
                    	    loop11:
                    	    do {
                    	        int alt11=2;
                    	        int LA11_0 = input.LA(1);

                    	        if ( (LA11_0==RULE_NL) ) {
                    	            alt11=1;
                    	        }


                    	        switch (alt11) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:306:7: this_NL_22= RULE_NL
                    	    	    {
                    	    	    this_NL_22=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_7); 

                    	    	    							newLeafNode(this_NL_22, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_2_0());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt11 >= 1 ) break loop11;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(11, input);
                    	                throw eee;
                    	        }
                    	        cnt11++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:311:6: ( (lv_time_23_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:312:7: (lv_time_23_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:312:7: (lv_time_23_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:313:8: lv_time_23_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_1_2_1_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_23_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_23_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:331:5: ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? )
                    int alt20=2;
                    alt20 = dfa20.predict(input);
                    switch (alt20) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:332:6: ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* )
                            {
                            // InternalBug348199TestLanguage.g:332:6: ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* )
                            // InternalBug348199TestLanguage.g:333:7: (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )*
                            {
                            // InternalBug348199TestLanguage.g:333:7: (this_NL_24= RULE_NL )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_NL) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // InternalBug348199TestLanguage.g:334:8: this_NL_24= RULE_NL
                            	    {
                            	    this_NL_24=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_8); 

                            	    								newLeafNode(this_NL_24, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_0());
                            	    							

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt13 >= 1 ) break loop13;
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);

                            otherlv_25=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                            							newLeafNode(otherlv_25, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_1_3_0_1());
                            						
                            // InternalBug348199TestLanguage.g:343:7: ( (lv_name_26_0= RULE_ID ) )
                            // InternalBug348199TestLanguage.g:344:8: (lv_name_26_0= RULE_ID )
                            {
                            // InternalBug348199TestLanguage.g:344:8: (lv_name_26_0= RULE_ID )
                            // InternalBug348199TestLanguage.g:345:9: lv_name_26_0= RULE_ID
                            {
                            lv_name_26_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                            									newLeafNode(lv_name_26_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_1_3_0_2_0());
                            								

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getTimeperiodRule());
                            									}
                            									addWithLastConsumed(
                            										current,
                            										"name",
                            										lv_name_26_0,
                            										"org.eclipse.xtext.common.Terminals.ID");
                            								

                            }


                            }

                            // InternalBug348199TestLanguage.g:361:7: ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )*
                            loop15:
                            do {
                                int alt15=2;
                                alt15 = dfa15.predict(input);
                                switch (alt15) {
                            	case 1 :
                            	    // InternalBug348199TestLanguage.g:362:8: (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) )
                            	    {
                            	    // InternalBug348199TestLanguage.g:362:8: (this_NL_27= RULE_NL )+
                            	    int cnt14=0;
                            	    loop14:
                            	    do {
                            	        int alt14=2;
                            	        int LA14_0 = input.LA(1);

                            	        if ( (LA14_0==RULE_NL) ) {
                            	            alt14=1;
                            	        }


                            	        switch (alt14) {
                            	    	case 1 :
                            	    	    // InternalBug348199TestLanguage.g:363:9: this_NL_27= RULE_NL
                            	    	    {
                            	    	    this_NL_27=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_10); 

                            	    	    									newLeafNode(this_NL_27, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_0_3_0());
                            	    	    								

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt14 >= 1 ) break loop14;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(14, input);
                            	                throw eee;
                            	        }
                            	        cnt14++;
                            	    } while (true);

                            	    // InternalBug348199TestLanguage.g:368:8: ( (lv_time_28_0= ruleTimeDef2 ) )
                            	    // InternalBug348199TestLanguage.g:369:9: (lv_time_28_0= ruleTimeDef2 )
                            	    {
                            	    // InternalBug348199TestLanguage.g:369:9: (lv_time_28_0= ruleTimeDef2 )
                            	    // InternalBug348199TestLanguage.g:370:10: lv_time_28_0= ruleTimeDef2
                            	    {

                            	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_1_3_0_3_1_0());
                            	    									
                            	    pushFollow(FollowSets000.FOLLOW_6);
                            	    lv_time_28_0=ruleTimeDef2();

                            	    state._fsp--;


                            	    										if (current==null) {
                            	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                            	    										}
                            	    										add(
                            	    											current,
                            	    											"time",
                            	    											lv_time_28_0,
                            	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                            	    										afterParserOrEnumRuleCall();
                            	    									

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
                            break;
                        case 2 :
                            // InternalBug348199TestLanguage.g:390:6: ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )?
                            {
                            // InternalBug348199TestLanguage.g:390:6: ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )?
                            int alt19=2;
                            alt19 = dfa19.predict(input);
                            switch (alt19) {
                                case 1 :
                                    // InternalBug348199TestLanguage.g:391:7: (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )*
                                    {
                                    // InternalBug348199TestLanguage.g:391:7: (this_NL_29= RULE_NL )+
                                    int cnt16=0;
                                    loop16:
                                    do {
                                        int alt16=2;
                                        int LA16_0 = input.LA(1);

                                        if ( (LA16_0==RULE_NL) ) {
                                            alt16=1;
                                        }


                                        switch (alt16) {
                                    	case 1 :
                                    	    // InternalBug348199TestLanguage.g:392:8: this_NL_29= RULE_NL
                                    	    {
                                    	    this_NL_29=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_11); 

                                    	    								newLeafNode(this_NL_29, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_0());
                                    	    							

                                    	    }
                                    	    break;

                                    	default :
                                    	    if ( cnt16 >= 1 ) break loop16;
                                                EarlyExitException eee =
                                                    new EarlyExitException(16, input);
                                                throw eee;
                                        }
                                        cnt16++;
                                    } while (true);

                                    otherlv_30=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                                    							newLeafNode(otherlv_30, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_1_3_1_1());
                                    						
                                    // InternalBug348199TestLanguage.g:401:7: ( (lv_alias_31_0= RULE_ID ) )
                                    // InternalBug348199TestLanguage.g:402:8: (lv_alias_31_0= RULE_ID )
                                    {
                                    // InternalBug348199TestLanguage.g:402:8: (lv_alias_31_0= RULE_ID )
                                    // InternalBug348199TestLanguage.g:403:9: lv_alias_31_0= RULE_ID
                                    {
                                    lv_alias_31_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                                    									newLeafNode(lv_alias_31_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_1_3_1_2_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTimeperiodRule());
                                    									}
                                    									addWithLastConsumed(
                                    										current,
                                    										"alias",
                                    										lv_alias_31_0,
                                    										"org.eclipse.xtext.common.Terminals.ID");
                                    								

                                    }


                                    }

                                    // InternalBug348199TestLanguage.g:419:7: ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )*
                                    loop18:
                                    do {
                                        int alt18=2;
                                        alt18 = dfa18.predict(input);
                                        switch (alt18) {
                                    	case 1 :
                                    	    // InternalBug348199TestLanguage.g:420:8: (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) )
                                    	    {
                                    	    // InternalBug348199TestLanguage.g:420:8: (this_NL_32= RULE_NL )+
                                    	    int cnt17=0;
                                    	    loop17:
                                    	    do {
                                    	        int alt17=2;
                                    	        int LA17_0 = input.LA(1);

                                    	        if ( (LA17_0==RULE_NL) ) {
                                    	            alt17=1;
                                    	        }


                                    	        switch (alt17) {
                                    	    	case 1 :
                                    	    	    // InternalBug348199TestLanguage.g:421:9: this_NL_32= RULE_NL
                                    	    	    {
                                    	    	    this_NL_32=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_12); 

                                    	    	    									newLeafNode(this_NL_32, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_3_1_3_0());
                                    	    	    								

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    if ( cnt17 >= 1 ) break loop17;
                                    	                EarlyExitException eee =
                                    	                    new EarlyExitException(17, input);
                                    	                throw eee;
                                    	        }
                                    	        cnt17++;
                                    	    } while (true);

                                    	    // InternalBug348199TestLanguage.g:426:8: ( (lv_time_33_0= ruleTimeDef3 ) )
                                    	    // InternalBug348199TestLanguage.g:427:9: (lv_time_33_0= ruleTimeDef3 )
                                    	    {
                                    	    // InternalBug348199TestLanguage.g:427:9: (lv_time_33_0= ruleTimeDef3 )
                                    	    // InternalBug348199TestLanguage.g:428:10: lv_time_33_0= ruleTimeDef3
                                    	    {

                                    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_1_3_1_3_1_0());
                                    	    									
                                    	    pushFollow(FollowSets000.FOLLOW_6);
                                    	    lv_time_33_0=ruleTimeDef3();

                                    	    state._fsp--;


                                    	    										if (current==null) {
                                    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                                    	    										}
                                    	    										add(
                                    	    											current,
                                    	    											"time",
                                    	    											lv_time_33_0,
                                    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
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


                            }
                            break;

                    }

                    // InternalBug348199TestLanguage.g:448:5: (this_NL_34= RULE_NL )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_NL) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:449:6: this_NL_34= RULE_NL
                    	    {
                    	    this_NL_34=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_13); 

                    	    						newLeafNode(this_NL_34, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_1_4());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    otherlv_35=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_35, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_1_5());
                    				

                    }


                    }
                    break;
                case 3 :
                    // InternalBug348199TestLanguage.g:460:4: (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' )
                    {
                    // InternalBug348199TestLanguage.g:460:4: (otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}' )
                    // InternalBug348199TestLanguage.g:461:5: otherlv_36= '3' otherlv_37= '{' ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )* ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+ (this_NL_50= RULE_NL )+ otherlv_51= '}'
                    {
                    otherlv_36=(Token)match(input,20,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_36, grammarAccess.getTimeperiodAccess().getDigitThreeKeyword_3_2_0());
                    				
                    otherlv_37=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_37, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_2_1());
                    				
                    // InternalBug348199TestLanguage.g:469:5: ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        alt23 = dfa23.predict(input);
                        switch (alt23) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:470:6: (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:470:6: (this_NL_38= RULE_NL )+
                    	    int cnt22=0;
                    	    loop22:
                    	    do {
                    	        int alt22=2;
                    	        int LA22_0 = input.LA(1);

                    	        if ( (LA22_0==RULE_NL) ) {
                    	            alt22=1;
                    	        }


                    	        switch (alt22) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:471:7: this_NL_38= RULE_NL
                    	    	    {
                    	    	    this_NL_38=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_7); 

                    	    	    							newLeafNode(this_NL_38, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_2_0());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt22 >= 1 ) break loop22;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(22, input);
                    	                throw eee;
                    	        }
                    	        cnt22++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:476:6: ( (lv_time_39_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:477:7: (lv_time_39_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:477:7: (lv_time_39_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:478:8: lv_time_39_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_2_2_1_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_39_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_39_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:496:5: ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=3;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:497:6: ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:497:6: ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* )
                    	    // InternalBug348199TestLanguage.g:498:7: (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )*
                    	    {
                    	    // InternalBug348199TestLanguage.g:498:7: (this_NL_40= RULE_NL )+
                    	    int cnt24=0;
                    	    loop24:
                    	    do {
                    	        int alt24=2;
                    	        int LA24_0 = input.LA(1);

                    	        if ( (LA24_0==RULE_NL) ) {
                    	            alt24=1;
                    	        }


                    	        switch (alt24) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:499:8: this_NL_40= RULE_NL
                    	    	    {
                    	    	    this_NL_40=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_8); 

                    	    	    								newLeafNode(this_NL_40, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_0());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt24 >= 1 ) break loop24;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(24, input);
                    	                throw eee;
                    	        }
                    	        cnt24++;
                    	    } while (true);

                    	    otherlv_41=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_41, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_2_3_0_1());
                    	    						
                    	    // InternalBug348199TestLanguage.g:508:7: ( (lv_name_42_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:509:8: (lv_name_42_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:509:8: (lv_name_42_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:510:9: lv_name_42_0= RULE_ID
                    	    {
                    	    lv_name_42_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_name_42_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_2_3_0_2_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"name",
                    	    										lv_name_42_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:526:7: ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )*
                    	    loop26:
                    	    do {
                    	        int alt26=2;
                    	        alt26 = dfa26.predict(input);
                    	        switch (alt26) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:527:8: (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:527:8: (this_NL_43= RULE_NL )+
                    	    	    int cnt25=0;
                    	    	    loop25:
                    	    	    do {
                    	    	        int alt25=2;
                    	    	        int LA25_0 = input.LA(1);

                    	    	        if ( (LA25_0==RULE_NL) ) {
                    	    	            alt25=1;
                    	    	        }


                    	    	        switch (alt25) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:528:9: this_NL_43= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_43=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_10); 

                    	    	    	    									newLeafNode(this_NL_43, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_0_3_0());
                    	    	    	    								

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt25 >= 1 ) break loop25;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(25, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt25++;
                    	    	    } while (true);

                    	    	    // InternalBug348199TestLanguage.g:533:8: ( (lv_time_44_0= ruleTimeDef2 ) )
                    	    	    // InternalBug348199TestLanguage.g:534:9: (lv_time_44_0= ruleTimeDef2 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:534:9: (lv_time_44_0= ruleTimeDef2 )
                    	    	    // InternalBug348199TestLanguage.g:535:10: lv_time_44_0= ruleTimeDef2
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_2_3_0_3_1_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_44_0=ruleTimeDef2();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_44_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

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
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:555:6: ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:555:6: ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* )
                    	    // InternalBug348199TestLanguage.g:556:7: (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )*
                    	    {
                    	    // InternalBug348199TestLanguage.g:556:7: (this_NL_45= RULE_NL )+
                    	    int cnt27=0;
                    	    loop27:
                    	    do {
                    	        int alt27=2;
                    	        int LA27_0 = input.LA(1);

                    	        if ( (LA27_0==RULE_NL) ) {
                    	            alt27=1;
                    	        }


                    	        switch (alt27) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:557:8: this_NL_45= RULE_NL
                    	    	    {
                    	    	    this_NL_45=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_11); 

                    	    	    								newLeafNode(this_NL_45, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_0());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt27 >= 1 ) break loop27;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(27, input);
                    	                throw eee;
                    	        }
                    	        cnt27++;
                    	    } while (true);

                    	    otherlv_46=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_46, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_2_3_1_1());
                    	    						
                    	    // InternalBug348199TestLanguage.g:566:7: ( (lv_alias_47_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:567:8: (lv_alias_47_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:567:8: (lv_alias_47_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:568:9: lv_alias_47_0= RULE_ID
                    	    {
                    	    lv_alias_47_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_alias_47_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_2_3_1_2_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"alias",
                    	    										lv_alias_47_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:584:7: ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )*
                    	    loop29:
                    	    do {
                    	        int alt29=2;
                    	        alt29 = dfa29.predict(input);
                    	        switch (alt29) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:585:8: (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:585:8: (this_NL_48= RULE_NL )+
                    	    	    int cnt28=0;
                    	    	    loop28:
                    	    	    do {
                    	    	        int alt28=2;
                    	    	        int LA28_0 = input.LA(1);

                    	    	        if ( (LA28_0==RULE_NL) ) {
                    	    	            alt28=1;
                    	    	        }


                    	    	        switch (alt28) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:586:9: this_NL_48= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_48=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_12); 

                    	    	    	    									newLeafNode(this_NL_48, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_3_1_3_0());
                    	    	    	    								

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt28 >= 1 ) break loop28;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(28, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt28++;
                    	    	    } while (true);

                    	    	    // InternalBug348199TestLanguage.g:591:8: ( (lv_time_49_0= ruleTimeDef3 ) )
                    	    	    // InternalBug348199TestLanguage.g:592:9: (lv_time_49_0= ruleTimeDef3 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:592:9: (lv_time_49_0= ruleTimeDef3 )
                    	    	    // InternalBug348199TestLanguage.g:593:10: lv_time_49_0= ruleTimeDef3
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_2_3_1_3_1_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_49_0=ruleTimeDef3();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_49_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

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
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);

                    // InternalBug348199TestLanguage.g:613:5: (this_NL_50= RULE_NL )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_NL) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:614:6: this_NL_50= RULE_NL
                    	    {
                    	    this_NL_50=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_13); 

                    	    						newLeafNode(this_NL_50, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_2_4());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);

                    otherlv_51=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_51, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_2_5());
                    				

                    }


                    }
                    break;
                case 4 :
                    // InternalBug348199TestLanguage.g:625:4: (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' )
                    {
                    // InternalBug348199TestLanguage.g:625:4: (otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}' )
                    // InternalBug348199TestLanguage.g:626:5: otherlv_52= '4' otherlv_53= '{' ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )* ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )* (this_NL_66= RULE_NL )+ otherlv_67= '}'
                    {
                    otherlv_52=(Token)match(input,21,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_52, grammarAccess.getTimeperiodAccess().getDigitFourKeyword_3_3_0());
                    				
                    otherlv_53=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_53, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_3_1());
                    				
                    // InternalBug348199TestLanguage.g:634:5: ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        alt33 = dfa33.predict(input);
                        switch (alt33) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:635:6: (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:635:6: (this_NL_54= RULE_NL )+
                    	    int cnt32=0;
                    	    loop32:
                    	    do {
                    	        int alt32=2;
                    	        int LA32_0 = input.LA(1);

                    	        if ( (LA32_0==RULE_NL) ) {
                    	            alt32=1;
                    	        }


                    	        switch (alt32) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:636:7: this_NL_54= RULE_NL
                    	    	    {
                    	    	    this_NL_54=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_7); 

                    	    	    							newLeafNode(this_NL_54, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_2_0());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt32 >= 1 ) break loop32;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(32, input);
                    	                throw eee;
                    	        }
                    	        cnt32++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:641:6: ( (lv_time_55_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:642:7: (lv_time_55_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:642:7: (lv_time_55_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:643:8: lv_time_55_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_3_2_1_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_55_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_55_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:661:5: ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )*
                    loop40:
                    do {
                        int alt40=3;
                        alt40 = dfa40.predict(input);
                        switch (alt40) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:662:6: ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:662:6: ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* )
                    	    // InternalBug348199TestLanguage.g:663:7: (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )*
                    	    {
                    	    // InternalBug348199TestLanguage.g:663:7: (this_NL_56= RULE_NL )+
                    	    int cnt34=0;
                    	    loop34:
                    	    do {
                    	        int alt34=2;
                    	        int LA34_0 = input.LA(1);

                    	        if ( (LA34_0==RULE_NL) ) {
                    	            alt34=1;
                    	        }


                    	        switch (alt34) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:664:8: this_NL_56= RULE_NL
                    	    	    {
                    	    	    this_NL_56=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_8); 

                    	    	    								newLeafNode(this_NL_56, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_0());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt34 >= 1 ) break loop34;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(34, input);
                    	                throw eee;
                    	        }
                    	        cnt34++;
                    	    } while (true);

                    	    otherlv_57=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_57, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_3_3_0_1());
                    	    						
                    	    // InternalBug348199TestLanguage.g:673:7: ( (lv_name_58_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:674:8: (lv_name_58_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:674:8: (lv_name_58_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:675:9: lv_name_58_0= RULE_ID
                    	    {
                    	    lv_name_58_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_name_58_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_3_3_0_2_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"name",
                    	    										lv_name_58_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:691:7: ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )*
                    	    loop36:
                    	    do {
                    	        int alt36=2;
                    	        alt36 = dfa36.predict(input);
                    	        switch (alt36) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:692:8: (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:692:8: (this_NL_59= RULE_NL )+
                    	    	    int cnt35=0;
                    	    	    loop35:
                    	    	    do {
                    	    	        int alt35=2;
                    	    	        int LA35_0 = input.LA(1);

                    	    	        if ( (LA35_0==RULE_NL) ) {
                    	    	            alt35=1;
                    	    	        }


                    	    	        switch (alt35) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:693:9: this_NL_59= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_59=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_10); 

                    	    	    	    									newLeafNode(this_NL_59, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_0_3_0());
                    	    	    	    								

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

                    	    	    // InternalBug348199TestLanguage.g:698:8: ( (lv_time_60_0= ruleTimeDef2 ) )
                    	    	    // InternalBug348199TestLanguage.g:699:9: (lv_time_60_0= ruleTimeDef2 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:699:9: (lv_time_60_0= ruleTimeDef2 )
                    	    	    // InternalBug348199TestLanguage.g:700:10: lv_time_60_0= ruleTimeDef2
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_3_3_0_3_1_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_60_0=ruleTimeDef2();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_60_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

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
                    	    break;
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:720:6: ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:720:6: ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* )
                    	    // InternalBug348199TestLanguage.g:721:7: (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )*
                    	    {
                    	    // InternalBug348199TestLanguage.g:721:7: (this_NL_61= RULE_NL )+
                    	    int cnt37=0;
                    	    loop37:
                    	    do {
                    	        int alt37=2;
                    	        int LA37_0 = input.LA(1);

                    	        if ( (LA37_0==RULE_NL) ) {
                    	            alt37=1;
                    	        }


                    	        switch (alt37) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:722:8: this_NL_61= RULE_NL
                    	    	    {
                    	    	    this_NL_61=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_11); 

                    	    	    								newLeafNode(this_NL_61, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_0());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt37 >= 1 ) break loop37;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(37, input);
                    	                throw eee;
                    	        }
                    	        cnt37++;
                    	    } while (true);

                    	    otherlv_62=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_62, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_3_3_1_1());
                    	    						
                    	    // InternalBug348199TestLanguage.g:731:7: ( (lv_alias_63_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:732:8: (lv_alias_63_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:732:8: (lv_alias_63_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:733:9: lv_alias_63_0= RULE_ID
                    	    {
                    	    lv_alias_63_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_alias_63_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_3_3_1_2_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"alias",
                    	    										lv_alias_63_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:749:7: ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )*
                    	    loop39:
                    	    do {
                    	        int alt39=2;
                    	        alt39 = dfa39.predict(input);
                    	        switch (alt39) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:750:8: (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:750:8: (this_NL_64= RULE_NL )+
                    	    	    int cnt38=0;
                    	    	    loop38:
                    	    	    do {
                    	    	        int alt38=2;
                    	    	        int LA38_0 = input.LA(1);

                    	    	        if ( (LA38_0==RULE_NL) ) {
                    	    	            alt38=1;
                    	    	        }


                    	    	        switch (alt38) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:751:9: this_NL_64= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_64=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_12); 

                    	    	    	    									newLeafNode(this_NL_64, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_3_1_3_0());
                    	    	    	    								

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt38 >= 1 ) break loop38;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(38, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt38++;
                    	    	    } while (true);

                    	    	    // InternalBug348199TestLanguage.g:756:8: ( (lv_time_65_0= ruleTimeDef3 ) )
                    	    	    // InternalBug348199TestLanguage.g:757:9: (lv_time_65_0= ruleTimeDef3 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:757:9: (lv_time_65_0= ruleTimeDef3 )
                    	    	    // InternalBug348199TestLanguage.g:758:10: lv_time_65_0= ruleTimeDef3
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_3_3_1_3_1_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_65_0=ruleTimeDef3();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_65_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

                    	    	    }


                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop39;
                    	        }
                    	    } while (true);


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:778:5: (this_NL_66= RULE_NL )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==RULE_NL) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:779:6: this_NL_66= RULE_NL
                    	    {
                    	    this_NL_66=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_13); 

                    	    						newLeafNode(this_NL_66, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_3_4());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    otherlv_67=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_67, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_3_5());
                    				

                    }


                    }
                    break;
                case 5 :
                    // InternalBug348199TestLanguage.g:790:4: (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' )
                    {
                    // InternalBug348199TestLanguage.g:790:4: (otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}' )
                    // InternalBug348199TestLanguage.g:791:5: otherlv_68= '5' otherlv_69= '{' (this_NL_70= RULE_NL )+ ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) ) otherlv_84= '}'
                    {
                    otherlv_68=(Token)match(input,22,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_68, grammarAccess.getTimeperiodAccess().getDigitFiveKeyword_3_4_0());
                    				
                    otherlv_69=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_69, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_4_1());
                    				
                    // InternalBug348199TestLanguage.g:799:5: (this_NL_70= RULE_NL )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_NL) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:800:6: this_NL_70= RULE_NL
                    	    {
                    	    this_NL_70=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_14); 

                    	    						newLeafNode(this_NL_70, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_2());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);

                    // InternalBug348199TestLanguage.g:805:5: ( ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+ )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==26) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:806:6: ( (lv_time_71_0= ruleTimeDef1 ) ) (this_NL_72= RULE_NL )+
                    	    {
                    	    // InternalBug348199TestLanguage.g:806:6: ( (lv_time_71_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:807:7: (lv_time_71_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:807:7: (lv_time_71_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:808:8: lv_time_71_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_4_3_0_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_71_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_71_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:825:6: (this_NL_72= RULE_NL )+
                    	    int cnt43=0;
                    	    loop43:
                    	    do {
                    	        int alt43=2;
                    	        int LA43_0 = input.LA(1);

                    	        if ( (LA43_0==RULE_NL) ) {
                    	            alt43=1;
                    	        }


                    	        switch (alt43) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:826:7: this_NL_72= RULE_NL
                    	    	    {
                    	    	    this_NL_72=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_14); 

                    	    	    							newLeafNode(this_NL_72, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_3_1());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt43 >= 1 ) break loop43;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(43, input);
                    	                throw eee;
                    	        }
                    	        cnt43++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:832:5: ( ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) ) )
                    // InternalBug348199TestLanguage.g:833:6: ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) )
                    {
                    // InternalBug348199TestLanguage.g:833:6: ( ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?) )
                    // InternalBug348199TestLanguage.g:834:7: ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?)
                    {
                     
                    						  getUnorderedGroupHelper().enter(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
                    						
                    // InternalBug348199TestLanguage.g:837:7: ( ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?)
                    // InternalBug348199TestLanguage.g:838:8: ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+ {...}?
                    {
                    // InternalBug348199TestLanguage.g:838:8: ( ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) ) )+
                    int cnt51=0;
                    loop51:
                    do {
                        int alt51=3;
                        int LA51_0 = input.LA(1);

                        if ( LA51_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0) ) {
                            alt51=1;
                        }
                        else if ( LA51_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1) ) {
                            alt51=2;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:839:6: ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:839:6: ({...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) ) )
                    	    // InternalBug348199TestLanguage.g:840:7: {...}? => ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0)");
                    	    }
                    	    // InternalBug348199TestLanguage.g:840:113: ( ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) ) )
                    	    // InternalBug348199TestLanguage.g:841:8: ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 0);
                    	    							
                    	    // InternalBug348199TestLanguage.g:844:11: ({...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* ) )
                    	    // InternalBug348199TestLanguage.g:844:12: {...}? => (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "true");
                    	    }
                    	    // InternalBug348199TestLanguage.g:844:21: (otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )* )
                    	    // InternalBug348199TestLanguage.g:844:22: otherlv_74= 'timeperiod_name' ( (lv_name_75_0= RULE_ID ) ) (this_NL_76= RULE_NL )+ ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )*
                    	    {
                    	    otherlv_74=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    	    											newLeafNode(otherlv_74, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_4_4_0_0());
                    	    										
                    	    // InternalBug348199TestLanguage.g:848:11: ( (lv_name_75_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:849:12: (lv_name_75_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:849:12: (lv_name_75_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:850:13: lv_name_75_0= RULE_ID
                    	    {
                    	    lv_name_75_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    													newLeafNode(lv_name_75_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_4_4_0_1_0());
                    	    												

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    													}
                    	    													addWithLastConsumed(
                    	    														current,
                    	    														"name",
                    	    														lv_name_75_0,
                    	    														"org.eclipse.xtext.common.Terminals.ID");
                    	    												

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:866:11: (this_NL_76= RULE_NL )+
                    	    int cnt45=0;
                    	    loop45:
                    	    do {
                    	        int alt45=2;
                    	        int LA45_0 = input.LA(1);

                    	        if ( (LA45_0==RULE_NL) ) {
                    	            alt45=1;
                    	        }


                    	        switch (alt45) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:867:12: this_NL_76= RULE_NL
                    	    	    {
                    	    	    this_NL_76=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_15); 

                    	    	    												newLeafNode(this_NL_76, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_2());
                    	    	    											

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt45 >= 1 ) break loop45;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(45, input);
                    	                throw eee;
                    	        }
                    	        cnt45++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:872:11: ( ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+ )*
                    	    loop47:
                    	    do {
                    	        int alt47=2;
                    	        int LA47_0 = input.LA(1);

                    	        if ( (LA47_0==27) ) {
                    	            alt47=1;
                    	        }


                    	        switch (alt47) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:873:12: ( (lv_time_77_0= ruleTimeDef2 ) ) (this_NL_78= RULE_NL )+
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:873:12: ( (lv_time_77_0= ruleTimeDef2 ) )
                    	    	    // InternalBug348199TestLanguage.g:874:13: (lv_time_77_0= ruleTimeDef2 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:874:13: (lv_time_77_0= ruleTimeDef2 )
                    	    	    // InternalBug348199TestLanguage.g:875:14: lv_time_77_0= ruleTimeDef2
                    	    	    {

                    	    	    														newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_4_4_0_3_0_0());
                    	    	    													
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_77_0=ruleTimeDef2();

                    	    	    state._fsp--;


                    	    	    														if (current==null) {
                    	    	    															current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    														}
                    	    	    														add(
                    	    	    															current,
                    	    	    															"time",
                    	    	    															lv_time_77_0,
                    	    	    															"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                    	    	    														afterParserOrEnumRuleCall();
                    	    	    													

                    	    	    }


                    	    	    }

                    	    	    // InternalBug348199TestLanguage.g:892:12: (this_NL_78= RULE_NL )+
                    	    	    int cnt46=0;
                    	    	    loop46:
                    	    	    do {
                    	    	        int alt46=2;
                    	    	        int LA46_0 = input.LA(1);

                    	    	        if ( (LA46_0==RULE_NL) ) {
                    	    	            alt46=1;
                    	    	        }


                    	    	        switch (alt46) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:893:13: this_NL_78= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_78=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_15); 

                    	    	    	    													newLeafNode(this_NL_78, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_0_3_1());
                    	    	    	    												

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt46 >= 1 ) break loop46;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(46, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt46++;
                    	    	    } while (true);


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop47;
                    	        }
                    	    } while (true);


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:905:6: ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) )
                    	    {
                    	    // InternalBug348199TestLanguage.g:905:6: ({...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) ) )
                    	    // InternalBug348199TestLanguage.g:906:7: {...}? => ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1)");
                    	    }
                    	    // InternalBug348199TestLanguage.g:906:113: ( ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) ) )
                    	    // InternalBug348199TestLanguage.g:907:8: ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4(), 1);
                    	    							
                    	    // InternalBug348199TestLanguage.g:910:11: ({...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* ) )
                    	    // InternalBug348199TestLanguage.g:910:12: {...}? => (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleTimeperiod", "true");
                    	    }
                    	    // InternalBug348199TestLanguage.g:910:21: (otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )* )
                    	    // InternalBug348199TestLanguage.g:910:22: otherlv_79= 'otherelement' ( (lv_alias_80_0= RULE_ID ) ) (this_NL_81= RULE_NL )+ ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )*
                    	    {
                    	    otherlv_79=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                    	    											newLeafNode(otherlv_79, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_4_4_1_0());
                    	    										
                    	    // InternalBug348199TestLanguage.g:914:11: ( (lv_alias_80_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:915:12: (lv_alias_80_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:915:12: (lv_alias_80_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:916:13: lv_alias_80_0= RULE_ID
                    	    {
                    	    lv_alias_80_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    													newLeafNode(lv_alias_80_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_4_4_1_1_0());
                    	    												

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    													}
                    	    													addWithLastConsumed(
                    	    														current,
                    	    														"alias",
                    	    														lv_alias_80_0,
                    	    														"org.eclipse.xtext.common.Terminals.ID");
                    	    												

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:932:11: (this_NL_81= RULE_NL )+
                    	    int cnt48=0;
                    	    loop48:
                    	    do {
                    	        int alt48=2;
                    	        int LA48_0 = input.LA(1);

                    	        if ( (LA48_0==RULE_NL) ) {
                    	            alt48=1;
                    	        }


                    	        switch (alt48) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:933:12: this_NL_81= RULE_NL
                    	    	    {
                    	    	    this_NL_81=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_16); 

                    	    	    												newLeafNode(this_NL_81, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_2());
                    	    	    											

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt48 >= 1 ) break loop48;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(48, input);
                    	                throw eee;
                    	        }
                    	        cnt48++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:938:11: ( ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+ )*
                    	    loop50:
                    	    do {
                    	        int alt50=2;
                    	        int LA50_0 = input.LA(1);

                    	        if ( (LA50_0==28) ) {
                    	            alt50=1;
                    	        }


                    	        switch (alt50) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:939:12: ( (lv_time_82_0= ruleTimeDef3 ) ) (this_NL_83= RULE_NL )+
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:939:12: ( (lv_time_82_0= ruleTimeDef3 ) )
                    	    	    // InternalBug348199TestLanguage.g:940:13: (lv_time_82_0= ruleTimeDef3 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:940:13: (lv_time_82_0= ruleTimeDef3 )
                    	    	    // InternalBug348199TestLanguage.g:941:14: lv_time_82_0= ruleTimeDef3
                    	    	    {

                    	    	    														newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_4_4_1_3_0_0());
                    	    	    													
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_82_0=ruleTimeDef3();

                    	    	    state._fsp--;


                    	    	    														if (current==null) {
                    	    	    															current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    														}
                    	    	    														add(
                    	    	    															current,
                    	    	    															"time",
                    	    	    															lv_time_82_0,
                    	    	    															"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
                    	    	    														afterParserOrEnumRuleCall();
                    	    	    													

                    	    	    }


                    	    	    }

                    	    	    // InternalBug348199TestLanguage.g:958:12: (this_NL_83= RULE_NL )+
                    	    	    int cnt49=0;
                    	    	    loop49:
                    	    	    do {
                    	    	        int alt49=2;
                    	    	        int LA49_0 = input.LA(1);

                    	    	        if ( (LA49_0==RULE_NL) ) {
                    	    	            alt49=1;
                    	    	        }


                    	    	        switch (alt49) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:959:13: this_NL_83= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_83=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_16); 

                    	    	    	    													newLeafNode(this_NL_83, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_4_4_1_3_1());
                    	    	    	    												

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt49 >= 1 ) break loop49;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(49, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt49++;
                    	    	    } while (true);


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop50;
                    	        }
                    	    } while (true);


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt51 >= 1 ) break loop51;
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4()) ) {
                        throw new FailedPredicateException(input, "ruleTimeperiod", "getUnorderedGroupHelper().canLeave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4())");
                    }

                    }


                    }

                     
                    						  getUnorderedGroupHelper().leave(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_4_4());
                    						

                    }

                    otherlv_84=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_84, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_4_5());
                    				

                    }


                    }
                    break;
                case 6 :
                    // InternalBug348199TestLanguage.g:985:4: (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' )
                    {
                    // InternalBug348199TestLanguage.g:985:4: (otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}' )
                    // InternalBug348199TestLanguage.g:986:5: otherlv_85= '6' otherlv_86= '{' (this_NL_87= RULE_NL )+ ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )* ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? ) otherlv_100= '}'
                    {
                    otherlv_85=(Token)match(input,23,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_85, grammarAccess.getTimeperiodAccess().getDigitSixKeyword_3_5_0());
                    				
                    otherlv_86=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_86, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_5_1());
                    				
                    // InternalBug348199TestLanguage.g:994:5: (this_NL_87= RULE_NL )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==RULE_NL) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:995:6: this_NL_87= RULE_NL
                    	    {
                    	    this_NL_87=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_17); 

                    	    						newLeafNode(this_NL_87, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_2());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);

                    // InternalBug348199TestLanguage.g:1000:5: ( ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+ )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==26) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:1001:6: ( (lv_time_88_0= ruleTimeDef1 ) ) (this_NL_89= RULE_NL )+
                    	    {
                    	    // InternalBug348199TestLanguage.g:1001:6: ( (lv_time_88_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:1002:7: (lv_time_88_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1002:7: (lv_time_88_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:1003:8: lv_time_88_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_5_3_0_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_88_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_88_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:1020:6: (this_NL_89= RULE_NL )+
                    	    int cnt53=0;
                    	    loop53:
                    	    do {
                    	        int alt53=2;
                    	        int LA53_0 = input.LA(1);

                    	        if ( (LA53_0==RULE_NL) ) {
                    	            alt53=1;
                    	        }


                    	        switch (alt53) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1021:7: this_NL_89= RULE_NL
                    	    	    {
                    	    	    this_NL_89=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_17); 

                    	    	    							newLeafNode(this_NL_89, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_3_1());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt53 >= 1 ) break loop53;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(53, input);
                    	                throw eee;
                    	        }
                    	        cnt53++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:1027:5: ( (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* ) | (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )? )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==16) ) {
                        alt62=1;
                    }
                    else if ( ((LA62_0>=17 && LA62_0<=18)) ) {
                        alt62=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalBug348199TestLanguage.g:1028:6: (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* )
                            {
                            // InternalBug348199TestLanguage.g:1028:6: (otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )* )
                            // InternalBug348199TestLanguage.g:1029:7: otherlv_90= 'timeperiod_name' ( (lv_name_91_0= RULE_ID ) ) (this_NL_92= RULE_NL )+ ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )*
                            {
                            otherlv_90=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                            							newLeafNode(otherlv_90, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_5_4_0_0());
                            						
                            // InternalBug348199TestLanguage.g:1033:7: ( (lv_name_91_0= RULE_ID ) )
                            // InternalBug348199TestLanguage.g:1034:8: (lv_name_91_0= RULE_ID )
                            {
                            // InternalBug348199TestLanguage.g:1034:8: (lv_name_91_0= RULE_ID )
                            // InternalBug348199TestLanguage.g:1035:9: lv_name_91_0= RULE_ID
                            {
                            lv_name_91_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                            									newLeafNode(lv_name_91_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_5_4_0_1_0());
                            								

                            									if (current==null) {
                            										current = createModelElement(grammarAccess.getTimeperiodRule());
                            									}
                            									addWithLastConsumed(
                            										current,
                            										"name",
                            										lv_name_91_0,
                            										"org.eclipse.xtext.common.Terminals.ID");
                            								

                            }


                            }

                            // InternalBug348199TestLanguage.g:1051:7: (this_NL_92= RULE_NL )+
                            int cnt55=0;
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==RULE_NL) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // InternalBug348199TestLanguage.g:1052:8: this_NL_92= RULE_NL
                            	    {
                            	    this_NL_92=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_18); 

                            	    								newLeafNode(this_NL_92, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_2());
                            	    							

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt55 >= 1 ) break loop55;
                                        EarlyExitException eee =
                                            new EarlyExitException(55, input);
                                        throw eee;
                                }
                                cnt55++;
                            } while (true);

                            // InternalBug348199TestLanguage.g:1057:7: ( ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+ )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==27) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // InternalBug348199TestLanguage.g:1058:8: ( (lv_time_93_0= ruleTimeDef2 ) ) (this_NL_94= RULE_NL )+
                            	    {
                            	    // InternalBug348199TestLanguage.g:1058:8: ( (lv_time_93_0= ruleTimeDef2 ) )
                            	    // InternalBug348199TestLanguage.g:1059:9: (lv_time_93_0= ruleTimeDef2 )
                            	    {
                            	    // InternalBug348199TestLanguage.g:1059:9: (lv_time_93_0= ruleTimeDef2 )
                            	    // InternalBug348199TestLanguage.g:1060:10: lv_time_93_0= ruleTimeDef2
                            	    {

                            	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_5_4_0_3_0_0());
                            	    									
                            	    pushFollow(FollowSets000.FOLLOW_6);
                            	    lv_time_93_0=ruleTimeDef2();

                            	    state._fsp--;


                            	    										if (current==null) {
                            	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                            	    										}
                            	    										add(
                            	    											current,
                            	    											"time",
                            	    											lv_time_93_0,
                            	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                            	    										afterParserOrEnumRuleCall();
                            	    									

                            	    }


                            	    }

                            	    // InternalBug348199TestLanguage.g:1077:8: (this_NL_94= RULE_NL )+
                            	    int cnt56=0;
                            	    loop56:
                            	    do {
                            	        int alt56=2;
                            	        int LA56_0 = input.LA(1);

                            	        if ( (LA56_0==RULE_NL) ) {
                            	            alt56=1;
                            	        }


                            	        switch (alt56) {
                            	    	case 1 :
                            	    	    // InternalBug348199TestLanguage.g:1078:9: this_NL_94= RULE_NL
                            	    	    {
                            	    	    this_NL_94=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_18); 

                            	    	    									newLeafNode(this_NL_94, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_0_3_1());
                            	    	    								

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt56 >= 1 ) break loop56;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(56, input);
                            	                throw eee;
                            	        }
                            	        cnt56++;
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop57;
                                }
                            } while (true);


                            }


                            }
                            break;
                        case 2 :
                            // InternalBug348199TestLanguage.g:1086:6: (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )?
                            {
                            // InternalBug348199TestLanguage.g:1086:6: (otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )* )?
                            int alt61=2;
                            int LA61_0 = input.LA(1);

                            if ( (LA61_0==17) ) {
                                alt61=1;
                            }
                            switch (alt61) {
                                case 1 :
                                    // InternalBug348199TestLanguage.g:1087:7: otherlv_95= 'otherelement' ( (lv_alias_96_0= RULE_ID ) ) (this_NL_97= RULE_NL )+ ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )*
                                    {
                                    otherlv_95=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                                    							newLeafNode(otherlv_95, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_5_4_1_0());
                                    						
                                    // InternalBug348199TestLanguage.g:1091:7: ( (lv_alias_96_0= RULE_ID ) )
                                    // InternalBug348199TestLanguage.g:1092:8: (lv_alias_96_0= RULE_ID )
                                    {
                                    // InternalBug348199TestLanguage.g:1092:8: (lv_alias_96_0= RULE_ID )
                                    // InternalBug348199TestLanguage.g:1093:9: lv_alias_96_0= RULE_ID
                                    {
                                    lv_alias_96_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                                    									newLeafNode(lv_alias_96_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_5_4_1_1_0());
                                    								

                                    									if (current==null) {
                                    										current = createModelElement(grammarAccess.getTimeperiodRule());
                                    									}
                                    									addWithLastConsumed(
                                    										current,
                                    										"alias",
                                    										lv_alias_96_0,
                                    										"org.eclipse.xtext.common.Terminals.ID");
                                    								

                                    }


                                    }

                                    // InternalBug348199TestLanguage.g:1109:7: (this_NL_97= RULE_NL )+
                                    int cnt58=0;
                                    loop58:
                                    do {
                                        int alt58=2;
                                        int LA58_0 = input.LA(1);

                                        if ( (LA58_0==RULE_NL) ) {
                                            alt58=1;
                                        }


                                        switch (alt58) {
                                    	case 1 :
                                    	    // InternalBug348199TestLanguage.g:1110:8: this_NL_97= RULE_NL
                                    	    {
                                    	    this_NL_97=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_19); 

                                    	    								newLeafNode(this_NL_97, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_2());
                                    	    							

                                    	    }
                                    	    break;

                                    	default :
                                    	    if ( cnt58 >= 1 ) break loop58;
                                                EarlyExitException eee =
                                                    new EarlyExitException(58, input);
                                                throw eee;
                                        }
                                        cnt58++;
                                    } while (true);

                                    // InternalBug348199TestLanguage.g:1115:7: ( ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+ )*
                                    loop60:
                                    do {
                                        int alt60=2;
                                        int LA60_0 = input.LA(1);

                                        if ( (LA60_0==28) ) {
                                            alt60=1;
                                        }


                                        switch (alt60) {
                                    	case 1 :
                                    	    // InternalBug348199TestLanguage.g:1116:8: ( (lv_time_98_0= ruleTimeDef3 ) ) (this_NL_99= RULE_NL )+
                                    	    {
                                    	    // InternalBug348199TestLanguage.g:1116:8: ( (lv_time_98_0= ruleTimeDef3 ) )
                                    	    // InternalBug348199TestLanguage.g:1117:9: (lv_time_98_0= ruleTimeDef3 )
                                    	    {
                                    	    // InternalBug348199TestLanguage.g:1117:9: (lv_time_98_0= ruleTimeDef3 )
                                    	    // InternalBug348199TestLanguage.g:1118:10: lv_time_98_0= ruleTimeDef3
                                    	    {

                                    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_5_4_1_3_0_0());
                                    	    									
                                    	    pushFollow(FollowSets000.FOLLOW_6);
                                    	    lv_time_98_0=ruleTimeDef3();

                                    	    state._fsp--;


                                    	    										if (current==null) {
                                    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                                    	    										}
                                    	    										add(
                                    	    											current,
                                    	    											"time",
                                    	    											lv_time_98_0,
                                    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
                                    	    										afterParserOrEnumRuleCall();
                                    	    									

                                    	    }


                                    	    }

                                    	    // InternalBug348199TestLanguage.g:1135:8: (this_NL_99= RULE_NL )+
                                    	    int cnt59=0;
                                    	    loop59:
                                    	    do {
                                    	        int alt59=2;
                                    	        int LA59_0 = input.LA(1);

                                    	        if ( (LA59_0==RULE_NL) ) {
                                    	            alt59=1;
                                    	        }


                                    	        switch (alt59) {
                                    	    	case 1 :
                                    	    	    // InternalBug348199TestLanguage.g:1136:9: this_NL_99= RULE_NL
                                    	    	    {
                                    	    	    this_NL_99=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_19); 

                                    	    	    									newLeafNode(this_NL_99, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_5_4_1_3_1());
                                    	    	    								

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    if ( cnt59 >= 1 ) break loop59;
                                    	                EarlyExitException eee =
                                    	                    new EarlyExitException(59, input);
                                    	                throw eee;
                                    	        }
                                    	        cnt59++;
                                    	    } while (true);


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop60;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    otherlv_100=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_100, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_5_5());
                    				

                    }


                    }
                    break;
                case 7 :
                    // InternalBug348199TestLanguage.g:1150:4: (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' )
                    {
                    // InternalBug348199TestLanguage.g:1150:4: (otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}' )
                    // InternalBug348199TestLanguage.g:1151:5: otherlv_101= '7' otherlv_102= '{' (this_NL_103= RULE_NL )+ ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )* ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+ otherlv_116= '}'
                    {
                    otherlv_101=(Token)match(input,24,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_101, grammarAccess.getTimeperiodAccess().getDigitSevenKeyword_3_6_0());
                    				
                    otherlv_102=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_102, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_6_1());
                    				
                    // InternalBug348199TestLanguage.g:1159:5: (this_NL_103= RULE_NL )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==RULE_NL) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:1160:6: this_NL_103= RULE_NL
                    	    {
                    	    this_NL_103=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_14); 

                    	    						newLeafNode(this_NL_103, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_2());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);

                    // InternalBug348199TestLanguage.g:1165:5: ( ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+ )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==26) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:1166:6: ( (lv_time_104_0= ruleTimeDef1 ) ) (this_NL_105= RULE_NL )+
                    	    {
                    	    // InternalBug348199TestLanguage.g:1166:6: ( (lv_time_104_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:1167:7: (lv_time_104_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1167:7: (lv_time_104_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:1168:8: lv_time_104_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_6_3_0_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_104_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_104_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:1185:6: (this_NL_105= RULE_NL )+
                    	    int cnt64=0;
                    	    loop64:
                    	    do {
                    	        int alt64=2;
                    	        int LA64_0 = input.LA(1);

                    	        if ( (LA64_0==RULE_NL) ) {
                    	            alt64=1;
                    	        }


                    	        switch (alt64) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1186:7: this_NL_105= RULE_NL
                    	    	    {
                    	    	    this_NL_105=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_14); 

                    	    	    							newLeafNode(this_NL_105, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_3_1());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt64 >= 1 ) break loop64;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(64, input);
                    	                throw eee;
                    	        }
                    	        cnt64++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:1192:5: ( (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* ) | (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* ) )+
                    int cnt72=0;
                    loop72:
                    do {
                        int alt72=3;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==16) ) {
                            alt72=1;
                        }
                        else if ( (LA72_0==17) ) {
                            alt72=2;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:1193:6: (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1193:6: (otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )* )
                    	    // InternalBug348199TestLanguage.g:1194:7: otherlv_106= 'timeperiod_name' ( (lv_name_107_0= RULE_ID ) ) (this_NL_108= RULE_NL )+ ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )*
                    	    {
                    	    otherlv_106=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_106, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_6_4_0_0());
                    	    						
                    	    // InternalBug348199TestLanguage.g:1198:7: ( (lv_name_107_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:1199:8: (lv_name_107_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1199:8: (lv_name_107_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:1200:9: lv_name_107_0= RULE_ID
                    	    {
                    	    lv_name_107_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_name_107_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_6_4_0_1_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"name",
                    	    										lv_name_107_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:1216:7: (this_NL_108= RULE_NL )+
                    	    int cnt66=0;
                    	    loop66:
                    	    do {
                    	        int alt66=2;
                    	        int LA66_0 = input.LA(1);

                    	        if ( (LA66_0==RULE_NL) ) {
                    	            alt66=1;
                    	        }


                    	        switch (alt66) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1217:8: this_NL_108= RULE_NL
                    	    	    {
                    	    	    this_NL_108=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_15); 

                    	    	    								newLeafNode(this_NL_108, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_2());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt66 >= 1 ) break loop66;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(66, input);
                    	                throw eee;
                    	        }
                    	        cnt66++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:1222:7: ( ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+ )*
                    	    loop68:
                    	    do {
                    	        int alt68=2;
                    	        int LA68_0 = input.LA(1);

                    	        if ( (LA68_0==27) ) {
                    	            alt68=1;
                    	        }


                    	        switch (alt68) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1223:8: ( (lv_time_109_0= ruleTimeDef2 ) ) (this_NL_110= RULE_NL )+
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1223:8: ( (lv_time_109_0= ruleTimeDef2 ) )
                    	    	    // InternalBug348199TestLanguage.g:1224:9: (lv_time_109_0= ruleTimeDef2 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1224:9: (lv_time_109_0= ruleTimeDef2 )
                    	    	    // InternalBug348199TestLanguage.g:1225:10: lv_time_109_0= ruleTimeDef2
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_6_4_0_3_0_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_109_0=ruleTimeDef2();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_109_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

                    	    	    }


                    	    	    }

                    	    	    // InternalBug348199TestLanguage.g:1242:8: (this_NL_110= RULE_NL )+
                    	    	    int cnt67=0;
                    	    	    loop67:
                    	    	    do {
                    	    	        int alt67=2;
                    	    	        int LA67_0 = input.LA(1);

                    	    	        if ( (LA67_0==RULE_NL) ) {
                    	    	            alt67=1;
                    	    	        }


                    	    	        switch (alt67) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:1243:9: this_NL_110= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_110=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_15); 

                    	    	    	    									newLeafNode(this_NL_110, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_0_3_1());
                    	    	    	    								

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt67 >= 1 ) break loop67;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(67, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt67++;
                    	    	    } while (true);


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop68;
                    	        }
                    	    } while (true);


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:1251:6: (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1251:6: (otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )* )
                    	    // InternalBug348199TestLanguage.g:1252:7: otherlv_111= 'otherelement' ( (lv_alias_112_0= RULE_ID ) ) (this_NL_113= RULE_NL )+ ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )*
                    	    {
                    	    otherlv_111=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_111, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_6_4_1_0());
                    	    						
                    	    // InternalBug348199TestLanguage.g:1256:7: ( (lv_alias_112_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:1257:8: (lv_alias_112_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1257:8: (lv_alias_112_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:1258:9: lv_alias_112_0= RULE_ID
                    	    {
                    	    lv_alias_112_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_alias_112_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_6_4_1_1_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"alias",
                    	    										lv_alias_112_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:1274:7: (this_NL_113= RULE_NL )+
                    	    int cnt69=0;
                    	    loop69:
                    	    do {
                    	        int alt69=2;
                    	        int LA69_0 = input.LA(1);

                    	        if ( (LA69_0==RULE_NL) ) {
                    	            alt69=1;
                    	        }


                    	        switch (alt69) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1275:8: this_NL_113= RULE_NL
                    	    	    {
                    	    	    this_NL_113=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_16); 

                    	    	    								newLeafNode(this_NL_113, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_2());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt69 >= 1 ) break loop69;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(69, input);
                    	                throw eee;
                    	        }
                    	        cnt69++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:1280:7: ( ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+ )*
                    	    loop71:
                    	    do {
                    	        int alt71=2;
                    	        int LA71_0 = input.LA(1);

                    	        if ( (LA71_0==28) ) {
                    	            alt71=1;
                    	        }


                    	        switch (alt71) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1281:8: ( (lv_time_114_0= ruleTimeDef3 ) ) (this_NL_115= RULE_NL )+
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1281:8: ( (lv_time_114_0= ruleTimeDef3 ) )
                    	    	    // InternalBug348199TestLanguage.g:1282:9: (lv_time_114_0= ruleTimeDef3 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1282:9: (lv_time_114_0= ruleTimeDef3 )
                    	    	    // InternalBug348199TestLanguage.g:1283:10: lv_time_114_0= ruleTimeDef3
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_6_4_1_3_0_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_114_0=ruleTimeDef3();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_114_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

                    	    	    }


                    	    	    }

                    	    	    // InternalBug348199TestLanguage.g:1300:8: (this_NL_115= RULE_NL )+
                    	    	    int cnt70=0;
                    	    	    loop70:
                    	    	    do {
                    	    	        int alt70=2;
                    	    	        int LA70_0 = input.LA(1);

                    	    	        if ( (LA70_0==RULE_NL) ) {
                    	    	            alt70=1;
                    	    	        }


                    	    	        switch (alt70) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:1301:9: this_NL_115= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_115=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_16); 

                    	    	    	    									newLeafNode(this_NL_115, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_6_4_1_3_1());
                    	    	    	    								

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt70 >= 1 ) break loop70;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(70, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt70++;
                    	    	    } while (true);


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop71;
                    	        }
                    	    } while (true);


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt72 >= 1 ) break loop72;
                                EarlyExitException eee =
                                    new EarlyExitException(72, input);
                                throw eee;
                        }
                        cnt72++;
                    } while (true);

                    otherlv_116=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_116, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_6_5());
                    				

                    }


                    }
                    break;
                case 8 :
                    // InternalBug348199TestLanguage.g:1315:4: (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' )
                    {
                    // InternalBug348199TestLanguage.g:1315:4: (otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}' )
                    // InternalBug348199TestLanguage.g:1316:5: otherlv_117= '8' otherlv_118= '{' (this_NL_119= RULE_NL )+ ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )* ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )* otherlv_132= '}'
                    {
                    otherlv_117=(Token)match(input,25,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_117, grammarAccess.getTimeperiodAccess().getDigitEightKeyword_3_7_0());
                    				
                    otherlv_118=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    					newLeafNode(otherlv_118, grammarAccess.getTimeperiodAccess().getLeftCurlyBracketKeyword_3_7_1());
                    				
                    // InternalBug348199TestLanguage.g:1324:5: (this_NL_119= RULE_NL )+
                    int cnt73=0;
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==RULE_NL) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:1325:6: this_NL_119= RULE_NL
                    	    {
                    	    this_NL_119=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_17); 

                    	    						newLeafNode(this_NL_119, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_2());
                    	    					

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt73 >= 1 ) break loop73;
                                EarlyExitException eee =
                                    new EarlyExitException(73, input);
                                throw eee;
                        }
                        cnt73++;
                    } while (true);

                    // InternalBug348199TestLanguage.g:1330:5: ( ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+ )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==26) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:1331:6: ( (lv_time_120_0= ruleTimeDef1 ) ) (this_NL_121= RULE_NL )+
                    	    {
                    	    // InternalBug348199TestLanguage.g:1331:6: ( (lv_time_120_0= ruleTimeDef1 ) )
                    	    // InternalBug348199TestLanguage.g:1332:7: (lv_time_120_0= ruleTimeDef1 )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1332:7: (lv_time_120_0= ruleTimeDef1 )
                    	    // InternalBug348199TestLanguage.g:1333:8: lv_time_120_0= ruleTimeDef1
                    	    {

                    	    								newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef1ParserRuleCall_3_7_3_0_0());
                    	    							
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_time_120_0=ruleTimeDef1();

                    	    state._fsp--;


                    	    								if (current==null) {
                    	    									current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    								}
                    	    								add(
                    	    									current,
                    	    									"time",
                    	    									lv_time_120_0,
                    	    									"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef1");
                    	    								afterParserOrEnumRuleCall();
                    	    							

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:1350:6: (this_NL_121= RULE_NL )+
                    	    int cnt74=0;
                    	    loop74:
                    	    do {
                    	        int alt74=2;
                    	        int LA74_0 = input.LA(1);

                    	        if ( (LA74_0==RULE_NL) ) {
                    	            alt74=1;
                    	        }


                    	        switch (alt74) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1351:7: this_NL_121= RULE_NL
                    	    	    {
                    	    	    this_NL_121=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_17); 

                    	    	    							newLeafNode(this_NL_121, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_3_1());
                    	    	    						

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt74 >= 1 ) break loop74;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(74, input);
                    	                throw eee;
                    	        }
                    	        cnt74++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);

                    // InternalBug348199TestLanguage.g:1357:5: ( (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* ) | (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* ) )*
                    loop82:
                    do {
                        int alt82=3;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==16) ) {
                            alt82=1;
                        }
                        else if ( (LA82_0==17) ) {
                            alt82=2;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalBug348199TestLanguage.g:1358:6: (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1358:6: (otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )* )
                    	    // InternalBug348199TestLanguage.g:1359:7: otherlv_122= 'timeperiod_name' ( (lv_name_123_0= RULE_ID ) ) (this_NL_124= RULE_NL )+ ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )*
                    	    {
                    	    otherlv_122=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_122, grammarAccess.getTimeperiodAccess().getTimeperiod_nameKeyword_3_7_4_0_0());
                    	    						
                    	    // InternalBug348199TestLanguage.g:1363:7: ( (lv_name_123_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:1364:8: (lv_name_123_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1364:8: (lv_name_123_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:1365:9: lv_name_123_0= RULE_ID
                    	    {
                    	    lv_name_123_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_name_123_0, grammarAccess.getTimeperiodAccess().getNameIDTerminalRuleCall_3_7_4_0_1_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"name",
                    	    										lv_name_123_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:1381:7: (this_NL_124= RULE_NL )+
                    	    int cnt76=0;
                    	    loop76:
                    	    do {
                    	        int alt76=2;
                    	        int LA76_0 = input.LA(1);

                    	        if ( (LA76_0==RULE_NL) ) {
                    	            alt76=1;
                    	        }


                    	        switch (alt76) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1382:8: this_NL_124= RULE_NL
                    	    	    {
                    	    	    this_NL_124=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_15); 

                    	    	    								newLeafNode(this_NL_124, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_2());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt76 >= 1 ) break loop76;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(76, input);
                    	                throw eee;
                    	        }
                    	        cnt76++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:1387:7: ( ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+ )*
                    	    loop78:
                    	    do {
                    	        int alt78=2;
                    	        int LA78_0 = input.LA(1);

                    	        if ( (LA78_0==27) ) {
                    	            alt78=1;
                    	        }


                    	        switch (alt78) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1388:8: ( (lv_time_125_0= ruleTimeDef2 ) ) (this_NL_126= RULE_NL )+
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1388:8: ( (lv_time_125_0= ruleTimeDef2 ) )
                    	    	    // InternalBug348199TestLanguage.g:1389:9: (lv_time_125_0= ruleTimeDef2 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1389:9: (lv_time_125_0= ruleTimeDef2 )
                    	    	    // InternalBug348199TestLanguage.g:1390:10: lv_time_125_0= ruleTimeDef2
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef2ParserRuleCall_3_7_4_0_3_0_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_125_0=ruleTimeDef2();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_125_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef2");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

                    	    	    }


                    	    	    }

                    	    	    // InternalBug348199TestLanguage.g:1407:8: (this_NL_126= RULE_NL )+
                    	    	    int cnt77=0;
                    	    	    loop77:
                    	    	    do {
                    	    	        int alt77=2;
                    	    	        int LA77_0 = input.LA(1);

                    	    	        if ( (LA77_0==RULE_NL) ) {
                    	    	            alt77=1;
                    	    	        }


                    	    	        switch (alt77) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:1408:9: this_NL_126= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_126=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_15); 

                    	    	    	    									newLeafNode(this_NL_126, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_0_3_1());
                    	    	    	    								

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt77 >= 1 ) break loop77;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(77, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt77++;
                    	    	    } while (true);


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop78;
                    	        }
                    	    } while (true);


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBug348199TestLanguage.g:1416:6: (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1416:6: (otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )* )
                    	    // InternalBug348199TestLanguage.g:1417:7: otherlv_127= 'otherelement' ( (lv_alias_128_0= RULE_ID ) ) (this_NL_129= RULE_NL )+ ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )*
                    	    {
                    	    otherlv_127=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                    	    							newLeafNode(otherlv_127, grammarAccess.getTimeperiodAccess().getOtherelementKeyword_3_7_4_1_0());
                    	    						
                    	    // InternalBug348199TestLanguage.g:1421:7: ( (lv_alias_128_0= RULE_ID ) )
                    	    // InternalBug348199TestLanguage.g:1422:8: (lv_alias_128_0= RULE_ID )
                    	    {
                    	    // InternalBug348199TestLanguage.g:1422:8: (lv_alias_128_0= RULE_ID )
                    	    // InternalBug348199TestLanguage.g:1423:9: lv_alias_128_0= RULE_ID
                    	    {
                    	    lv_alias_128_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    	    									newLeafNode(lv_alias_128_0, grammarAccess.getTimeperiodAccess().getAliasIDTerminalRuleCall_3_7_4_1_1_0());
                    	    								

                    	    									if (current==null) {
                    	    										current = createModelElement(grammarAccess.getTimeperiodRule());
                    	    									}
                    	    									addWithLastConsumed(
                    	    										current,
                    	    										"alias",
                    	    										lv_alias_128_0,
                    	    										"org.eclipse.xtext.common.Terminals.ID");
                    	    								

                    	    }


                    	    }

                    	    // InternalBug348199TestLanguage.g:1439:7: (this_NL_129= RULE_NL )+
                    	    int cnt79=0;
                    	    loop79:
                    	    do {
                    	        int alt79=2;
                    	        int LA79_0 = input.LA(1);

                    	        if ( (LA79_0==RULE_NL) ) {
                    	            alt79=1;
                    	        }


                    	        switch (alt79) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1440:8: this_NL_129= RULE_NL
                    	    	    {
                    	    	    this_NL_129=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_16); 

                    	    	    								newLeafNode(this_NL_129, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_2());
                    	    	    							

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt79 >= 1 ) break loop79;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(79, input);
                    	                throw eee;
                    	        }
                    	        cnt79++;
                    	    } while (true);

                    	    // InternalBug348199TestLanguage.g:1445:7: ( ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+ )*
                    	    loop81:
                    	    do {
                    	        int alt81=2;
                    	        int LA81_0 = input.LA(1);

                    	        if ( (LA81_0==28) ) {
                    	            alt81=1;
                    	        }


                    	        switch (alt81) {
                    	    	case 1 :
                    	    	    // InternalBug348199TestLanguage.g:1446:8: ( (lv_time_130_0= ruleTimeDef3 ) ) (this_NL_131= RULE_NL )+
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1446:8: ( (lv_time_130_0= ruleTimeDef3 ) )
                    	    	    // InternalBug348199TestLanguage.g:1447:9: (lv_time_130_0= ruleTimeDef3 )
                    	    	    {
                    	    	    // InternalBug348199TestLanguage.g:1447:9: (lv_time_130_0= ruleTimeDef3 )
                    	    	    // InternalBug348199TestLanguage.g:1448:10: lv_time_130_0= ruleTimeDef3
                    	    	    {

                    	    	    										newCompositeNode(grammarAccess.getTimeperiodAccess().getTimeTimeDef3ParserRuleCall_3_7_4_1_3_0_0());
                    	    	    									
                    	    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    	    lv_time_130_0=ruleTimeDef3();

                    	    	    state._fsp--;


                    	    	    										if (current==null) {
                    	    	    											current = createModelElementForParent(grammarAccess.getTimeperiodRule());
                    	    	    										}
                    	    	    										add(
                    	    	    											current,
                    	    	    											"time",
                    	    	    											lv_time_130_0,
                    	    	    											"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348199TestLanguage.TimeDef3");
                    	    	    										afterParserOrEnumRuleCall();
                    	    	    									

                    	    	    }


                    	    	    }

                    	    	    // InternalBug348199TestLanguage.g:1465:8: (this_NL_131= RULE_NL )+
                    	    	    int cnt80=0;
                    	    	    loop80:
                    	    	    do {
                    	    	        int alt80=2;
                    	    	        int LA80_0 = input.LA(1);

                    	    	        if ( (LA80_0==RULE_NL) ) {
                    	    	            alt80=1;
                    	    	        }


                    	    	        switch (alt80) {
                    	    	    	case 1 :
                    	    	    	    // InternalBug348199TestLanguage.g:1466:9: this_NL_131= RULE_NL
                    	    	    	    {
                    	    	    	    this_NL_131=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_16); 

                    	    	    	    									newLeafNode(this_NL_131, grammarAccess.getTimeperiodAccess().getNLTerminalRuleCall_3_7_4_1_3_1());
                    	    	    	    								

                    	    	    	    }
                    	    	    	    break;

                    	    	    	default :
                    	    	    	    if ( cnt80 >= 1 ) break loop80;
                    	    	                EarlyExitException eee =
                    	    	                    new EarlyExitException(80, input);
                    	    	                throw eee;
                    	    	        }
                    	    	        cnt80++;
                    	    	    } while (true);


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop81;
                    	        }
                    	    } while (true);


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop82;
                        }
                    } while (true);

                    otherlv_132=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_132, grammarAccess.getTimeperiodAccess().getRightCurlyBracketKeyword_3_7_5());
                    				

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
    // $ANTLR end "ruleTimeperiod"


    // $ANTLR start "entryRuleTimeDef1"
    // InternalBug348199TestLanguage.g:1484:1: entryRuleTimeDef1 returns [EObject current=null] : iv_ruleTimeDef1= ruleTimeDef1 EOF ;
    public final EObject entryRuleTimeDef1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeDef1 = null;


        try {
            // InternalBug348199TestLanguage.g:1484:49: (iv_ruleTimeDef1= ruleTimeDef1 EOF )
            // InternalBug348199TestLanguage.g:1485:2: iv_ruleTimeDef1= ruleTimeDef1 EOF
            {
             newCompositeNode(grammarAccess.getTimeDef1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTimeDef1=ruleTimeDef1();

            state._fsp--;

             current =iv_ruleTimeDef1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeDef1"


    // $ANTLR start "ruleTimeDef1"
    // InternalBug348199TestLanguage.g:1491:1: ruleTimeDef1 returns [EObject current=null] : (otherlv_0= 'july' ( (lv_day_1_0= RULE_INT ) ) ) ;
    public final EObject ruleTimeDef1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_day_1_0=null;


        	enterRule();

        try {
            // InternalBug348199TestLanguage.g:1497:2: ( (otherlv_0= 'july' ( (lv_day_1_0= RULE_INT ) ) ) )
            // InternalBug348199TestLanguage.g:1498:2: (otherlv_0= 'july' ( (lv_day_1_0= RULE_INT ) ) )
            {
            // InternalBug348199TestLanguage.g:1498:2: (otherlv_0= 'july' ( (lv_day_1_0= RULE_INT ) ) )
            // InternalBug348199TestLanguage.g:1499:3: otherlv_0= 'july' ( (lv_day_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeDef1Access().getJulyKeyword_0());
            		
            // InternalBug348199TestLanguage.g:1503:3: ( (lv_day_1_0= RULE_INT ) )
            // InternalBug348199TestLanguage.g:1504:4: (lv_day_1_0= RULE_INT )
            {
            // InternalBug348199TestLanguage.g:1504:4: (lv_day_1_0= RULE_INT )
            // InternalBug348199TestLanguage.g:1505:5: lv_day_1_0= RULE_INT
            {
            lv_day_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_day_1_0, grammarAccess.getTimeDef1Access().getDayINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeDef1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"day",
            						lv_day_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // $ANTLR end "ruleTimeDef1"


    // $ANTLR start "entryRuleTimeDef2"
    // InternalBug348199TestLanguage.g:1525:1: entryRuleTimeDef2 returns [EObject current=null] : iv_ruleTimeDef2= ruleTimeDef2 EOF ;
    public final EObject entryRuleTimeDef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeDef2 = null;


        try {
            // InternalBug348199TestLanguage.g:1525:49: (iv_ruleTimeDef2= ruleTimeDef2 EOF )
            // InternalBug348199TestLanguage.g:1526:2: iv_ruleTimeDef2= ruleTimeDef2 EOF
            {
             newCompositeNode(grammarAccess.getTimeDef2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTimeDef2=ruleTimeDef2();

            state._fsp--;

             current =iv_ruleTimeDef2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeDef2"


    // $ANTLR start "ruleTimeDef2"
    // InternalBug348199TestLanguage.g:1532:1: ruleTimeDef2 returns [EObject current=null] : (otherlv_0= 'august' ( (lv_day_1_0= RULE_INT ) ) ) ;
    public final EObject ruleTimeDef2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_day_1_0=null;


        	enterRule();

        try {
            // InternalBug348199TestLanguage.g:1538:2: ( (otherlv_0= 'august' ( (lv_day_1_0= RULE_INT ) ) ) )
            // InternalBug348199TestLanguage.g:1539:2: (otherlv_0= 'august' ( (lv_day_1_0= RULE_INT ) ) )
            {
            // InternalBug348199TestLanguage.g:1539:2: (otherlv_0= 'august' ( (lv_day_1_0= RULE_INT ) ) )
            // InternalBug348199TestLanguage.g:1540:3: otherlv_0= 'august' ( (lv_day_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeDef2Access().getAugustKeyword_0());
            		
            // InternalBug348199TestLanguage.g:1544:3: ( (lv_day_1_0= RULE_INT ) )
            // InternalBug348199TestLanguage.g:1545:4: (lv_day_1_0= RULE_INT )
            {
            // InternalBug348199TestLanguage.g:1545:4: (lv_day_1_0= RULE_INT )
            // InternalBug348199TestLanguage.g:1546:5: lv_day_1_0= RULE_INT
            {
            lv_day_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_day_1_0, grammarAccess.getTimeDef2Access().getDayINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeDef2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"day",
            						lv_day_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // $ANTLR end "ruleTimeDef2"


    // $ANTLR start "entryRuleTimeDef3"
    // InternalBug348199TestLanguage.g:1566:1: entryRuleTimeDef3 returns [EObject current=null] : iv_ruleTimeDef3= ruleTimeDef3 EOF ;
    public final EObject entryRuleTimeDef3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeDef3 = null;


        try {
            // InternalBug348199TestLanguage.g:1566:49: (iv_ruleTimeDef3= ruleTimeDef3 EOF )
            // InternalBug348199TestLanguage.g:1567:2: iv_ruleTimeDef3= ruleTimeDef3 EOF
            {
             newCompositeNode(grammarAccess.getTimeDef3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTimeDef3=ruleTimeDef3();

            state._fsp--;

             current =iv_ruleTimeDef3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeDef3"


    // $ANTLR start "ruleTimeDef3"
    // InternalBug348199TestLanguage.g:1573:1: ruleTimeDef3 returns [EObject current=null] : (otherlv_0= 'september' ( (lv_day_1_0= RULE_INT ) ) ) ;
    public final EObject ruleTimeDef3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_day_1_0=null;


        	enterRule();

        try {
            // InternalBug348199TestLanguage.g:1579:2: ( (otherlv_0= 'september' ( (lv_day_1_0= RULE_INT ) ) ) )
            // InternalBug348199TestLanguage.g:1580:2: (otherlv_0= 'september' ( (lv_day_1_0= RULE_INT ) ) )
            {
            // InternalBug348199TestLanguage.g:1580:2: (otherlv_0= 'september' ( (lv_day_1_0= RULE_INT ) ) )
            // InternalBug348199TestLanguage.g:1581:3: otherlv_0= 'september' ( (lv_day_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeDef3Access().getSeptemberKeyword_0());
            		
            // InternalBug348199TestLanguage.g:1585:3: ( (lv_day_1_0= RULE_INT ) )
            // InternalBug348199TestLanguage.g:1586:4: (lv_day_1_0= RULE_INT )
            {
            // InternalBug348199TestLanguage.g:1586:4: (lv_day_1_0= RULE_INT )
            // InternalBug348199TestLanguage.g:1587:5: lv_day_1_0= RULE_INT
            {
            lv_day_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_day_1_0, grammarAccess.getTimeDef3Access().getDayINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeDef3Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"day",
            						lv_day_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // $ANTLR end "ruleTimeDef3"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA39 dfa39 = new DFA39(this);
    static final String dfa_1s = "\4\uffff";
    static final String dfa_2s = "\2\4\2\uffff";
    static final String dfa_3s = "\1\4\1\32\2\uffff";
    static final String dfa_4s = "\2\uffff\1\2\1\1";
    static final String dfa_5s = "\4\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\1\13\uffff\2\2\10\uffff\1\3",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 109:5: ( (this_NL_5= RULE_NL )+ ( (lv_time_6_0= ruleTimeDef1 ) ) )*";
        }
    }
    static final String dfa_7s = "\5\uffff";
    static final String dfa_8s = "\2\4\3\uffff";
    static final String dfa_9s = "\1\4\1\22\3\uffff";
    static final String dfa_10s = "\2\uffff\1\3\1\1\1\2";
    static final String dfa_11s = "\1\uffff\1\0\3\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\1\13\uffff\1\3\1\4\1\2",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "()+ loopback of 142:8: ( ({...}? => ( ({...}? => ( (this_NL_8= RULE_NL )+ otherlv_9= 'timeperiod_name' ( (lv_name_10_0= RULE_ID ) ) ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (this_NL_13= RULE_NL )+ otherlv_14= 'otherelement' ( (lv_alias_15_0= RULE_ID ) ) ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )* ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_1 = input.LA(1);

                         
                        int index9_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA9_1==18) ) {s = 2;}

                        else if ( (LA9_1==RULE_NL) ) {s = 1;}

                        else if ( LA9_1 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 0) ) {s = 3;}

                        else if ( LA9_1 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeperiodAccess().getUnorderedGroup_3_0_3(), 1) ) {s = 4;}

                         
                        input.seek(index9_1);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\1\4\1\33\2\uffff";
    static final String[] dfa_14s = {
            "\1\1",
            "\1\1\13\uffff\3\2\10\uffff\1\3",
            "",
            ""
    };
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 176:11: ( (this_NL_11= RULE_NL )+ ( (lv_time_12_0= ruleTimeDef2 ) ) )*";
        }
    }
    static final String dfa_15s = "\1\4\1\34\2\uffff";
    static final String[] dfa_16s = {
            "\1\1",
            "\1\1\13\uffff\3\2\11\uffff\1\3",
            "",
            ""
    };
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[][] dfa_16 = unpackEncodedStringArray(dfa_16s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_15;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_16;
        }
        public String getDescription() {
            return "()* loopback of 242:11: ( (this_NL_16= RULE_NL )+ ( (lv_time_17_0= ruleTimeDef3 ) ) )*";
        }
    }
    static final String[] dfa_17s = {
            "\1\1",
            "\1\1\13\uffff\3\2\7\uffff\1\3",
            "",
            ""
    };
    static final short[][] dfa_17 = unpackEncodedStringArray(dfa_17s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_17;
        }
        public String getDescription() {
            return "()* loopback of 304:5: ( (this_NL_22= RULE_NL )+ ( (lv_time_23_0= ruleTimeDef1 ) ) )*";
        }
    }
    static final String dfa_18s = "\1\4\1\22\2\uffff";
    static final String[] dfa_19s = {
            "\1\1",
            "\1\1\13\uffff\1\3\2\2",
            "",
            ""
    };
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_18;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "331:5: ( ( (this_NL_24= RULE_NL )+ otherlv_25= 'timeperiod_name' ( (lv_name_26_0= RULE_ID ) ) ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )? )";
        }
    }
    static final String[] dfa_20s = {
            "\1\1",
            "\1\1\15\uffff\1\2\10\uffff\1\3",
            "",
            ""
    };
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "()* loopback of 361:7: ( (this_NL_27= RULE_NL )+ ( (lv_time_28_0= ruleTimeDef2 ) ) )*";
        }
    }
    static final String[] dfa_21s = {
            "\1\1",
            "\1\1\14\uffff\1\3\1\2",
            "",
            ""
    };
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_18;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "390:6: ( (this_NL_29= RULE_NL )+ otherlv_30= 'otherelement' ( (lv_alias_31_0= RULE_ID ) ) ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )* )?";
        }
    }
    static final String[] dfa_22s = {
            "\1\1",
            "\1\1\15\uffff\1\2\11\uffff\1\3",
            "",
            ""
    };
    static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_15;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_22;
        }
        public String getDescription() {
            return "()* loopback of 419:7: ( (this_NL_32= RULE_NL )+ ( (lv_time_33_0= ruleTimeDef3 ) ) )*";
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 469:5: ( (this_NL_38= RULE_NL )+ ( (lv_time_39_0= ruleTimeDef1 ) ) )*";
        }
    }
    static final String dfa_23s = "\2\uffff\1\2\1\1\1\3";
    static final String dfa_24s = "\5\uffff}>";
    static final String[] dfa_25s = {
            "\1\1",
            "\1\1\13\uffff\1\3\1\2\1\4",
            "",
            "",
            ""
    };
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "()+ loopback of 496:5: ( ( (this_NL_40= RULE_NL )+ otherlv_41= 'timeperiod_name' ( (lv_name_42_0= RULE_ID ) ) ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_45= RULE_NL )+ otherlv_46= 'otherelement' ( (lv_alias_47_0= RULE_ID ) ) ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )* ) )+";
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 526:7: ( (this_NL_43= RULE_NL )+ ( (lv_time_44_0= ruleTimeDef2 ) ) )*";
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_15;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_16;
        }
        public String getDescription() {
            return "()* loopback of 584:7: ( (this_NL_48= RULE_NL )+ ( (lv_time_49_0= ruleTimeDef3 ) ) )*";
        }
    }
    static final String dfa_26s = "\2\uffff\1\1\1\2";
    static final String[] dfa_27s = {
            "\1\1",
            "\1\1\13\uffff\3\3\7\uffff\1\2",
            "",
            ""
    };
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_26;
            this.special = dfa_5;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "()* loopback of 634:5: ( (this_NL_54= RULE_NL )+ ( (lv_time_55_0= ruleTimeDef1 ) ) )*";
        }
    }
    static final String dfa_28s = "\2\uffff\1\1\1\3\1\2";
    static final String[] dfa_29s = {
            "\1\1",
            "\1\1\13\uffff\1\2\1\4\1\3",
            "",
            "",
            ""
    };
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_28;
            this.special = dfa_24;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "()* loopback of 661:5: ( ( (this_NL_56= RULE_NL )+ otherlv_57= 'timeperiod_name' ( (lv_name_58_0= RULE_ID ) ) ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )* ) | ( (this_NL_61= RULE_NL )+ otherlv_62= 'otherelement' ( (lv_alias_63_0= RULE_ID ) ) ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )* ) )*";
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_13;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 691:7: ( (this_NL_59= RULE_NL )+ ( (lv_time_60_0= ruleTimeDef2 ) ) )*";
        }
    }
    static final String[] dfa_30s = {
            "\1\1",
            "\1\1\13\uffff\3\3\11\uffff\1\2",
            "",
            ""
    };
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_15;
            this.accept = dfa_26;
            this.special = dfa_5;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "()* loopback of 749:7: ( (this_NL_64= RULE_NL )+ ( (lv_time_65_0= ruleTimeDef3 ) ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000003F84000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000010000010L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004030010L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008070010L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010070010L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004070010L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008040010L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010040010L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});
    }


}
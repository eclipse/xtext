package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistNoTerminalExtensionTestLanguageGrammarAccess;



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
public class InternalContentAssistNoTerminalExtensionTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "'octagon'", "'oval'", "'parallelogram'", "'pentagon'", "'plain'", "'plaintext'", "'point'", "'polygon'", "'primersite'", "'promoter'", "'proteasesite'", "'proteinstab'", "'rarrow'", "'record'", "'rect'", "'rectangle'", "'restrictionsite'", "'ribosite'", "'rnastab'", "'rpromoter'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int T__6=6;
    public static final int RULE_WS=4;
    public static final int T__5=5;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalContentAssistNoTerminalExtensionTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistNoTerminalExtensionTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistNoTerminalExtensionTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistNoTerminalExtensionTestLanguage.g"; }


    	private ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRulePolygonBasedShape"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:58:1: entryRulePolygonBasedShape : rulePolygonBasedShape EOF ;
    public final void entryRulePolygonBasedShape() throws RecognitionException {
        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:59:1: ( rulePolygonBasedShape EOF )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:60:1: rulePolygonBasedShape EOF
            {
             before(grammarAccess.getPolygonBasedShapeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePolygonBasedShape();

            state._fsp--;

             after(grammarAccess.getPolygonBasedShapeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePolygonBasedShape"


    // $ANTLR start "rulePolygonBasedShape"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:67:1: rulePolygonBasedShape : ( ( ( rule__PolygonBasedShape__ShapeAssignment ) ) ( ( rule__PolygonBasedShape__ShapeAssignment )* ) ) ;
    public final void rulePolygonBasedShape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:71:2: ( ( ( ( rule__PolygonBasedShape__ShapeAssignment ) ) ( ( rule__PolygonBasedShape__ShapeAssignment )* ) ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:72:2: ( ( ( rule__PolygonBasedShape__ShapeAssignment ) ) ( ( rule__PolygonBasedShape__ShapeAssignment )* ) )
            {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:72:2: ( ( ( rule__PolygonBasedShape__ShapeAssignment ) ) ( ( rule__PolygonBasedShape__ShapeAssignment )* ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:73:3: ( ( rule__PolygonBasedShape__ShapeAssignment ) ) ( ( rule__PolygonBasedShape__ShapeAssignment )* )
            {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:73:3: ( ( rule__PolygonBasedShape__ShapeAssignment ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:74:4: ( rule__PolygonBasedShape__ShapeAssignment )
            {
             before(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); 
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:75:4: ( rule__PolygonBasedShape__ShapeAssignment )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:75:5: rule__PolygonBasedShape__ShapeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__PolygonBasedShape__ShapeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); 

            }

            // InternalContentAssistNoTerminalExtensionTestLanguage.g:78:3: ( ( rule__PolygonBasedShape__ShapeAssignment )* )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:79:4: ( rule__PolygonBasedShape__ShapeAssignment )*
            {
             before(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); 
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:80:4: ( rule__PolygonBasedShape__ShapeAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=5 && LA1_0<=24)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistNoTerminalExtensionTestLanguage.g:80:5: rule__PolygonBasedShape__ShapeAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__PolygonBasedShape__ShapeAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePolygonBasedShape"


    // $ANTLR start "rulePolygonBasedNodeShape"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:90:1: rulePolygonBasedNodeShape : ( ( rule__PolygonBasedNodeShape__Alternatives ) ) ;
    public final void rulePolygonBasedNodeShape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:94:1: ( ( ( rule__PolygonBasedNodeShape__Alternatives ) ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:95:2: ( ( rule__PolygonBasedNodeShape__Alternatives ) )
            {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:95:2: ( ( rule__PolygonBasedNodeShape__Alternatives ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:96:3: ( rule__PolygonBasedNodeShape__Alternatives )
            {
             before(grammarAccess.getPolygonBasedNodeShapeAccess().getAlternatives()); 
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:97:3: ( rule__PolygonBasedNodeShape__Alternatives )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:97:4: rule__PolygonBasedNodeShape__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PolygonBasedNodeShape__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPolygonBasedNodeShapeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePolygonBasedNodeShape"


    // $ANTLR start "rule__PolygonBasedNodeShape__Alternatives"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:105:1: rule__PolygonBasedNodeShape__Alternatives : ( ( ( 'octagon' ) ) | ( ( 'oval' ) ) | ( ( 'parallelogram' ) ) | ( ( 'pentagon' ) ) | ( ( 'plain' ) ) | ( ( 'plaintext' ) ) | ( ( 'point' ) ) | ( ( 'polygon' ) ) | ( ( 'primersite' ) ) | ( ( 'promoter' ) ) | ( ( 'proteasesite' ) ) | ( ( 'proteinstab' ) ) | ( ( 'rarrow' ) ) | ( ( 'record' ) ) | ( ( 'rect' ) ) | ( ( 'rectangle' ) ) | ( ( 'restrictionsite' ) ) | ( ( 'ribosite' ) ) | ( ( 'rnastab' ) ) | ( ( 'rpromoter' ) ) );
    public final void rule__PolygonBasedNodeShape__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:109:1: ( ( ( 'octagon' ) ) | ( ( 'oval' ) ) | ( ( 'parallelogram' ) ) | ( ( 'pentagon' ) ) | ( ( 'plain' ) ) | ( ( 'plaintext' ) ) | ( ( 'point' ) ) | ( ( 'polygon' ) ) | ( ( 'primersite' ) ) | ( ( 'promoter' ) ) | ( ( 'proteasesite' ) ) | ( ( 'proteinstab' ) ) | ( ( 'rarrow' ) ) | ( ( 'record' ) ) | ( ( 'rect' ) ) | ( ( 'rectangle' ) ) | ( ( 'restrictionsite' ) ) | ( ( 'ribosite' ) ) | ( ( 'rnastab' ) ) | ( ( 'rpromoter' ) ) )
            int alt2=20;
            switch ( input.LA(1) ) {
            case 5:
                {
                alt2=1;
                }
                break;
            case 6:
                {
                alt2=2;
                }
                break;
            case 7:
                {
                alt2=3;
                }
                break;
            case 8:
                {
                alt2=4;
                }
                break;
            case 9:
                {
                alt2=5;
                }
                break;
            case 10:
                {
                alt2=6;
                }
                break;
            case 11:
                {
                alt2=7;
                }
                break;
            case 12:
                {
                alt2=8;
                }
                break;
            case 13:
                {
                alt2=9;
                }
                break;
            case 14:
                {
                alt2=10;
                }
                break;
            case 15:
                {
                alt2=11;
                }
                break;
            case 16:
                {
                alt2=12;
                }
                break;
            case 17:
                {
                alt2=13;
                }
                break;
            case 18:
                {
                alt2=14;
                }
                break;
            case 19:
                {
                alt2=15;
                }
                break;
            case 20:
                {
                alt2=16;
                }
                break;
            case 21:
                {
                alt2=17;
                }
                break;
            case 22:
                {
                alt2=18;
                }
                break;
            case 23:
                {
                alt2=19;
                }
                break;
            case 24:
                {
                alt2=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:110:2: ( ( 'octagon' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:110:2: ( ( 'octagon' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:111:3: ( 'octagon' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:112:3: ( 'octagon' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:112:4: 'octagon'
                    {
                    match(input,5,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:116:2: ( ( 'oval' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:116:2: ( ( 'oval' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:117:3: ( 'oval' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:118:3: ( 'oval' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:118:4: 'oval'
                    {
                    match(input,6,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:122:2: ( ( 'parallelogram' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:122:2: ( ( 'parallelogram' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:123:3: ( 'parallelogram' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:124:3: ( 'parallelogram' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:124:4: 'parallelogram'
                    {
                    match(input,7,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:128:2: ( ( 'pentagon' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:128:2: ( ( 'pentagon' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:129:3: ( 'pentagon' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:130:3: ( 'pentagon' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:130:4: 'pentagon'
                    {
                    match(input,8,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:134:2: ( ( 'plain' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:134:2: ( ( 'plain' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:135:3: ( 'plain' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:136:3: ( 'plain' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:136:4: 'plain'
                    {
                    match(input,9,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:140:2: ( ( 'plaintext' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:140:2: ( ( 'plaintext' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:141:3: ( 'plaintext' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:142:3: ( 'plaintext' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:142:4: 'plaintext'
                    {
                    match(input,10,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:146:2: ( ( 'point' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:146:2: ( ( 'point' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:147:3: ( 'point' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:148:3: ( 'point' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:148:4: 'point'
                    {
                    match(input,11,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:152:2: ( ( 'polygon' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:152:2: ( ( 'polygon' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:153:3: ( 'polygon' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:154:3: ( 'polygon' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:154:4: 'polygon'
                    {
                    match(input,12,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:158:2: ( ( 'primersite' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:158:2: ( ( 'primersite' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:159:3: ( 'primersite' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:160:3: ( 'primersite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:160:4: 'primersite'
                    {
                    match(input,13,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:164:2: ( ( 'promoter' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:164:2: ( ( 'promoter' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:165:3: ( 'promoter' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:166:3: ( 'promoter' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:166:4: 'promoter'
                    {
                    match(input,14,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:170:2: ( ( 'proteasesite' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:170:2: ( ( 'proteasesite' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:171:3: ( 'proteasesite' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:172:3: ( 'proteasesite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:172:4: 'proteasesite'
                    {
                    match(input,15,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:176:2: ( ( 'proteinstab' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:176:2: ( ( 'proteinstab' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:177:3: ( 'proteinstab' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:178:3: ( 'proteinstab' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:178:4: 'proteinstab'
                    {
                    match(input,16,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:182:2: ( ( 'rarrow' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:182:2: ( ( 'rarrow' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:183:3: ( 'rarrow' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:184:3: ( 'rarrow' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:184:4: 'rarrow'
                    {
                    match(input,17,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:188:2: ( ( 'record' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:188:2: ( ( 'record' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:189:3: ( 'record' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:190:3: ( 'record' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:190:4: 'record'
                    {
                    match(input,18,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:194:2: ( ( 'rect' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:194:2: ( ( 'rect' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:195:3: ( 'rect' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:196:3: ( 'rect' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:196:4: 'rect'
                    {
                    match(input,19,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:200:2: ( ( 'rectangle' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:200:2: ( ( 'rectangle' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:201:3: ( 'rectangle' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:202:3: ( 'rectangle' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:202:4: 'rectangle'
                    {
                    match(input,20,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:206:2: ( ( 'restrictionsite' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:206:2: ( ( 'restrictionsite' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:207:3: ( 'restrictionsite' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:208:3: ( 'restrictionsite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:208:4: 'restrictionsite'
                    {
                    match(input,21,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:212:2: ( ( 'ribosite' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:212:2: ( ( 'ribosite' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:213:3: ( 'ribosite' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:214:3: ( 'ribosite' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:214:4: 'ribosite'
                    {
                    match(input,22,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:218:2: ( ( 'rnastab' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:218:2: ( ( 'rnastab' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:219:3: ( 'rnastab' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:220:3: ( 'rnastab' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:220:4: 'rnastab'
                    {
                    match(input,23,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:224:2: ( ( 'rpromoter' ) )
                    {
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:224:2: ( ( 'rpromoter' ) )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:225:3: ( 'rpromoter' )
                    {
                     before(grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19()); 
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:226:3: ( 'rpromoter' )
                    // InternalContentAssistNoTerminalExtensionTestLanguage.g:226:4: 'rpromoter'
                    {
                    match(input,24,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolygonBasedNodeShape__Alternatives"


    // $ANTLR start "rule__PolygonBasedShape__ShapeAssignment"
    // InternalContentAssistNoTerminalExtensionTestLanguage.g:234:1: rule__PolygonBasedShape__ShapeAssignment : ( rulePolygonBasedNodeShape ) ;
    public final void rule__PolygonBasedShape__ShapeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:238:1: ( ( rulePolygonBasedNodeShape ) )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:239:2: ( rulePolygonBasedNodeShape )
            {
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:239:2: ( rulePolygonBasedNodeShape )
            // InternalContentAssistNoTerminalExtensionTestLanguage.g:240:3: rulePolygonBasedNodeShape
            {
             before(grammarAccess.getPolygonBasedShapeAccess().getShapePolygonBasedNodeShapeEnumRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            rulePolygonBasedNodeShape();

            state._fsp--;

             after(grammarAccess.getPolygonBasedShapeAccess().getShapePolygonBasedNodeShapeEnumRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PolygonBasedShape__ShapeAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001FFFFE2L});
    }


}
/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.splitting;

import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.internal.LexerSpecialStateTransitionSplitter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerSpecialStateTransitionSplitterTest extends Assert {

	private String original = 
			"public class InternalMyDslLexer extends Lexer {\n" +
			"    class DFA12 extends DFA {\n" + 
			"\n" + 
			"        public DFA12(BaseRecognizer recognizer) {\n" + 
			"            this.recognizer = recognizer;\n" + 
			"            this.decisionNumber = 12;\n" + 
			"            this.eot = DFA12_eot;\n" + 
			"            this.eof = DFA12_eof;\n" + 
			"            this.min = DFA12_min;\n" + 
			"            this.max = DFA12_max;\n" + 
			"            this.accept = DFA12_accept;\n" + 
			"            this.special = DFA12_special;\n" + 
			"            this.transition = DFA12_transition;\n" + 
			"        }\n" + 
			"        public String getDescription() {\n" + 
			"            return \"1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | T__159 | T__160 | T__161 | T__162 | T__163 | T__164 | T__165 | T__166 | T__167 | T__168 | T__169 | T__170 | T__171 | T__172 | T__173 | T__174 | T__175 | T__176 | T__177 | T__178 | T__179 | T__180 | T__181 | T__182 | T__183 | T__184 | T__185 | T__186 | T__187 | T__188 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );\";\n" + 
			"        }\n" + 
			"        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {\n" + 
			"            IntStream input = _input;\n" + 
			"        \tint _s = s;\n" + 
			"            switch ( s ) {\n" + 
			"                    case 0 : \n" + 
			"                        int LA12_144 = input.LA(1);\n" + 
			"\n" + 
			"                        s = -1;\n" + 
			"                        if ( (LA12_144=='p') ) {s = 276;}\n" + 
			"\n" + 
			"                        else if ( ((LA12_144>='\\u0000' && LA12_144<='o')||(LA12_144>='q' && LA12_144<='$')) ) {s = 51;}\n" + 
			"\n" + 
			"                        if ( s>=0 ) return s;\n" + 
			"                        break;\n" + 
			"                    case 1 : \n" + 
			"                        int LA12_176 = input.LA(1);\n" + 
			"\n" + 
			"                        s = -1;\n" + 
			"                        if ( (LA12_176=='t') ) {s = 306;}\n" + 
			"\n" + 
			"                        else if ( ((LA12_176>='\\u0000' && LA12_176<='s')||(LA12_176>='u' && LA12_176<='\\uFFFF')) ) {s = 51;}\n" + 
			"\n" + 
			"                        else s = 50;\n" +
			"\n" + 
			"                        if ( s>=0 ) return s;\n" + 
			"                        break;\n" +
			"                    case 2 : \n" +
			"                        int LA12_0 = input.LA(1);\n" +
			"\n" +
			"                        s = -1;" +
			"                        if ( (LA12_0=='+'||LA12_0=='-') && (( currentState() == State.STATE_A ))) {s = 125;}\n" +
			"\n" +
			"                        else if ( ((LA12_0>='0' && LA12_0<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"\n" +
			"                        else if ( (LA12_0=='.') && (( currentState() == State.STATE_A ))) {s = 127;}\n" +
			"\n" +
			"\n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"                    case 3 : \n" +
			"                        int LA12_2 = input.LA(1);\n" +
			"\n" +
			"                        s = -1;\n" +
			"                        if ( (LA12_2=='.') && (( currentState() == State.STATE_A ))) {s = 128;}\n" +
			"\n" +
			"                        else if ( ((LA12_2>='0' && LA12_2<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"\n" +
			"                        else if ( (LA12_2=='E'||LA12_2=='e') && (( currentState() == State.STATE_A ))) {s = 128;}\n" +
			"\n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"                    case 4 : \n" +
			"                        int LA12_1 = input.LA(1);\n" +
			"\n" +
			"                        s = -1;\n" +
			"                        if ( ((LA12_1>='0' && LA12_1<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"\n" +
			"                        else if ( (LA12_1=='.') && (( currentState() == State.STATE_A ))) {s = 127;}\n" +
			"\n" +
			"                        else if ( (LA12_1=='+'||LA12_1=='-') && (( currentState() == State.STATE_A ))) {s = 125;}\n" +
			"\n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"            }\n" + 
			"            NoViableAltException nvae =\n" + 
			"                new NoViableAltException(getDescription(), 12, _s, input);\n" + 
			"            error(nvae);\n" + 
			"            throw nvae;\n" + 
			"        }\n" + 
			"    }\n" +
			"}";
	
	private String transformed = 
			"public class InternalMyDslLexer extends Lexer {\n" +
			"    static class DFA12 extends DFA {\n" + 
			"\n" + 
			"        public DFA12(BaseRecognizer recognizer) {\n" + 
			"            this.recognizer = recognizer;\n" + 
			"            this.decisionNumber = 12;\n" + 
			"            this.eot = DFA12_eot;\n" + 
			"            this.eof = DFA12_eof;\n" + 
			"            this.min = DFA12_min;\n" + 
			"            this.max = DFA12_max;\n" + 
			"            this.accept = DFA12_accept;\n" + 
			"            this.special = DFA12_special;\n" + 
			"            this.transition = DFA12_transition;\n" + 
			"        }\n" + 
			"        public String getDescription() {\n" + 
			"            return \"1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | T__159 | T__160 | T__161 | T__162 | T__163 | T__164 | T__165 | T__166 | T__167 | T__168 | T__169 | T__170 | T__171 | T__172 | T__173 | T__174 | T__175 | T__176 | T__177 | T__178 | T__179 | T__180 | T__181 | T__182 | T__183 | T__184 | T__185 | T__186 | T__187 | T__188 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );\";\n" + 
			"        }\n" + 
			"        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {\n" + 
			"            IntStream input = _input;\n" + 
			"        \tint _s = s;\n" + 
			"            switch ( s ) {\n" + 
			"                    case 0 : \n" + 
			"                        s = specialStateTransition0(input); \n" +
			"                        if ( s>=0 ) return s;\n" + 
			"                        break;\n" + 
			"                    case 1 : \n" + 
			"                        s = specialStateTransition1(input); \n" +
			"                        if ( s>=0 ) return s;\n" + 
			"                        break;\n" +
			"                    case 2 : \n" +
			"                        s = specialStateTransition2(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"                    case 3 : \n" +
			"                        s = specialStateTransition3(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"                    case 4 : \n" +
			"                        s = specialStateTransition4(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"            }\n" + 
			"            NoViableAltException nvae =\n" + 
			"                new NoViableAltException(getDescription(), 12, _s, input);\n" + 
			"            error(nvae);\n" + 
			"            throw nvae;\n" + 
			"        }\n" +
			"        protected int specialStateTransition0(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_144 = input.LA(1);\n" + 
			"            if ( (LA12_144=='p') ) {s = 276;}\n" + 
			"            else if ( ((LA12_144>='\\u0000' && LA12_144<='o')||(LA12_144>='q' && LA12_144<='$')) ) {s = 51;}\n" +
			"            return s;\n" +
			"        }\n" + 
			"        protected int specialStateTransition1(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_176 = input.LA(1);\n" + 
			"            if ( (LA12_176=='t') ) {s = 306;}\n" + 
			"            else if ( ((LA12_176>='\\u0000' && LA12_176<='s')||(LA12_176>='u' && LA12_176<='\\uFFFF')) ) {s = 51;}\n" +
			"            else s = 50;\n" +
			"            return s;\n" +
			"        }\n" +
			"        protected int specialStateTransition2(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_0 = input.LA(1);\n" +
			"            if ( (LA12_0=='+'||LA12_0=='-') && (( currentState() == State.STATE_A ))) {s = 125;}\n" +
			"            else if ( ((LA12_0>='0' && LA12_0<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"            else if ( (LA12_0=='.') && (( currentState() == State.STATE_A ))) {s = 127;}\n" +
			"            return s;\n" +
			"        }\n" +
			"        protected int specialStateTransition3(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_2 = input.LA(1);\n" +
			"            if ( (LA12_2=='.') && (( currentState() == State.STATE_A ))) {s = 128;}\n" +
			"            else if ( ((LA12_2>='0' && LA12_2<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"            else if ( (LA12_2=='E'||LA12_2=='e') && (( currentState() == State.STATE_A ))) {s = 128;}\n" +
			"            return s;\n" +
			"        }\n" +
			"        protected int specialStateTransition4(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_1 = input.LA(1);\n" +
			"            if ( ((LA12_1>='0' && LA12_1<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"            else if ( (LA12_1=='.') && (( currentState() == State.STATE_A ))) {s = 127;}\n" +
			"            else if ( (LA12_1=='+'||LA12_1=='-') && (( currentState() == State.STATE_A ))) {s = 125;}\n" +
			"            return s;\n" +
			"        }\n" +
			"\n" +
			"    }\n" +
			"}";
	
	private String transformedSpecialStateSplit = "public class InternalMyDslLexer extends Lexer {\n" +
			"    static class DFA12 extends DFA {\n" +
			"\n" +
			"        public DFA12(BaseRecognizer recognizer) {\n" +
			"            this.recognizer = recognizer;\n" +
			"            this.decisionNumber = 12;\n" +
			"            this.eot = DFA12_eot;\n" +
			"            this.eof = DFA12_eof;\n" +
			"            this.min = DFA12_min;\n" +
			"            this.max = DFA12_max;\n" +
			"            this.accept = DFA12_accept;\n" +
			"            this.special = DFA12_special;\n" +
			"            this.transition = DFA12_transition;\n" +
			"        }\n" +
			"        public String getDescription() {\n" +
			"            return \"1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | T__148 | T__149 | T__150 | T__151 | T__152 | T__153 | T__154 | T__155 | T__156 | T__157 | T__158 | T__159 | T__160 | T__161 | T__162 | T__163 | T__164 | T__165 | T__166 | T__167 | T__168 | T__169 | T__170 | T__171 | T__172 | T__173 | T__174 | T__175 | T__176 | T__177 | T__178 | T__179 | T__180 | T__181 | T__182 | T__183 | T__184 | T__185 | T__186 | T__187 | T__188 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );\";\n" +
			"        }\n" +
			"        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {\n" +
			"            IntStream input = _input;\n" +
			"        \tint _s = s;\n" +
			"            \n" +
			"            s = specialStateTransitionFrom0To2( _s, input );\n" +
			"            if ( s >= 0 ) return s;\n" +
			"            s = specialStateTransitionFrom3To4( _s, input );\n" +
			"            if ( s >= 0 ) return s;\n" +
			"\n" +
			"            NoViableAltException nvae =\n" +
			"                new NoViableAltException(getDescription(), 12, _s, input);\n" +
			"            error(nvae);\n" +
			"            throw nvae;\n" +
			"        }\n" +
			"        protected int specialStateTransitionFrom0To2(int s, IntStream input) {\n" +
			"            int _s = s;\n" +
			"            switch( s ) {\n" +
			"                    case 0 : \n" +
			"                        s = specialStateTransition0(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"                    case 1 : \n" +
			"                        s = specialStateTransition1(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"                    case 2 : \n" +
			"                        s = specialStateTransition2(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"            }\n" +
			"            return -1;\n" +
			"        }\n" +
			"\n" +
			"        protected int specialStateTransitionFrom3To4(int s, IntStream input) {\n" +
			"            int _s = s;\n" +
			"            switch( s ) {\n" +
			"                    case 3 : \n" +
			"                        s = specialStateTransition3(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"                    case 4 : \n" +
			"                        s = specialStateTransition4(input); \n" +
			"                        if ( s>=0 ) return s;\n" +
			"                        break;\n" +
			"            }\n" +
			"            return -1;\n" +
			"        }\n" +
			"\n" +
			"        protected int specialStateTransition0(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_144 = input.LA(1);\n" +
			"            if ( (LA12_144=='p') ) {s = 276;}\n" +
			"            else if ( ((LA12_144>='\\u0000' && LA12_144<='o')||(LA12_144>='q' && LA12_144<='$')) ) {s = 51;}\n" +
			"            return s;\n" +
			"        }\n" +
			"        protected int specialStateTransition1(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_176 = input.LA(1);\n" +
			"            if ( (LA12_176=='t') ) {s = 306;}\n" +
			"            else if ( ((LA12_176>='\\u0000' && LA12_176<='s')||(LA12_176>='u' && LA12_176<='\\uFFFF')) ) {s = 51;}\n" +
			"            else s = 50;\n" +
			"            return s;\n" +
			"        }\n" +
			"        protected int specialStateTransition2(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_0 = input.LA(1);\n" +
			"            if ( (LA12_0=='+'||LA12_0=='-') && (( currentState() == State.STATE_A ))) {s = 125;}\n" +
			"            else if ( ((LA12_0>='0' && LA12_0<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"            else if ( (LA12_0=='.') && (( currentState() == State.STATE_A ))) {s = 127;}\n" +
			"            return s;\n" +
			"        }\n" +
			"        protected int specialStateTransition3(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_2 = input.LA(1);\n" +
			"            if ( (LA12_2=='.') && (( currentState() == State.STATE_A ))) {s = 128;}\n" +
			"            else if ( ((LA12_2>='0' && LA12_2<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"            else if ( (LA12_2=='E'||LA12_2=='e') && (( currentState() == State.STATE_A ))) {s = 128;}\n" +
			"            return s;\n" +
			"        }\n" +
			"        protected int specialStateTransition4(IntStream input) {\n" +
			"            int s = -1;\n" +
			"            int LA12_1 = input.LA(1);\n" +
			"            if ( ((LA12_1>='0' && LA12_1<='9')) && (( currentState() == State.STATE_A ))) {s = 126;}\n" +
			"            else if ( (LA12_1=='.') && (( currentState() == State.STATE_A ))) {s = 127;}\n" +
			"            else if ( (LA12_1=='+'||LA12_1=='-') && (( currentState() == State.STATE_A ))) {s = 125;}\n" +
			"            return s;\n" +
			"        }\n" +
			"\n" +
			"    }\n" +
			"}";

	private LexerSpecialStateTransitionSplitter testMe;

	@Before
	public void setUp() throws Exception {
		testMe = new LexerSpecialStateTransitionSplitter(true);
	}
	
	@After
	public void tearDown() throws Exception {
		original = null;
		transformed = null;
	}
	
	@Test public void testTransformation() {
		String actual = testMe.transform(original);
		assertEquals(transformed, actual);
	}
	
	@Test public void testSpecialStateSwitchTransformation(){
		int tmpCasesLimit = testMe.getCasesPerSpecialStateSwitch();
		
		testMe.setCasesPerSpecialStateSwitch(3);
		String actualSpecialStateSwitchSplit = testMe.transform(original);
		assertEquals(transformedSpecialStateSplit,actualSpecialStateSwitchSplit);
		
		testMe.setCasesPerSpecialStateSwitch(tmpCasesLimit);
	}


}

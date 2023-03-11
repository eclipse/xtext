/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.contentassist.antlr.internal;

import static org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendParser.*;

import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.TokenSource;

@SuppressWarnings({"all"})
%%

%{

  public InternalXtendFlexer() {
    this((java.io.Reader)null);
  }

  public int getTokenLength() {
    return yylength();
  }
  
  public String getTokenText() {
    return yytext();
  }
  
%}

%unicode
%implements org.eclipse.xtend.core.parser.InternalFlexer
%class InternalXtendFlexer
%function advance
%int
%eofval{
return Token.EOF;
%eofval}
	
WS=[\ \n\r\t]+
ANY_OTHER=.

ID="^"? ( [:jletter:] | {UNICODE_ESCAPE} ) ( [:jletterdigit:] | {UNICODE_ESCAPE} )*
UNICODE_ESCAPE=\\ "u" ( {HEX_DIGIT} ( {HEX_DIGIT} ( {HEX_DIGIT} {HEX_DIGIT}? )? )? )?
HEX_DIGIT = [0-9A-Fa-f]

ML_COMMENT="/*" ~"*/"
COMMENT_ERROR_PATTERN="/*" [^*]* ("*"+ [^/*] [^*]*)* "*"?
SL_COMMENT="/""/"[^\r\n]*(\r?\n)?

DIGIT = [0-9]
DIGIT_OR_UNDERSCORE = [_0-9]
INT = {DIGIT} | {DIGIT} {DIGIT_OR_UNDERSCORE}*
HEX_DIGIT_OR_UNDERSCORE = [_0-9A-Fa-f]

DECIMAL_ERROR_PATTERN = {INT} (([eE] ([^0-9] | [bB])) ([bB][^iIdD])? | ([bB][^iIdD]))
DECIMAL = {INT} ([eE] [+-]? {INT})? ([bB][iIdD] | [lLdDfF])?
HEX = 0 [Xx] ( {HEX_DIGIT_OR_UNDERSCORE}+ ("#" ([bB][iI] | [lL] ))? )?
			 
STRING=("'"([^\\\']|{ESCAPE_SEQUENCE})*"'"?)|(\"([^\\\"]|{ESCAPE_SEQUENCE})*\"?)
ESCAPE_SEQUENCE=\\{ANY_OTHER}

RICH_TEXT_START="'''" {IN_RICH_STRING}? {RICH_TEXT_DELIM}
RICH_TEXT_INBETWEEN="╗" {IN_RICH_STRING}? {RICH_TEXT_DELIM}
RICH_TEXT="'''" {IN_RICH_STRING}? {RICH_TEXT_FINISH}?
RICH_TEXT_END="╗" {IN_RICH_STRING}? {RICH_TEXT_FINISH}?

COMMENT_RICH_TEXT_INBETWEEN="лл"[^\r\n]*("\r"?"\n"{IN_RICH_STRING}? {RICH_TEXT_DELIM})
COMMENT_RICH_TEXT_END="лл"[^\r\n]*(("\r"?"\n"{IN_RICH_STRING}? {RICH_TEXT_FINISH}?))

IN_RICH_STRING=([^л\']|("'""'"?[^л\']))+

RICH_TEXT_DELIM=("'""'"?)?"л"
RICH_TEXT_FINISH="'"("'"("'")?)?

%%


<YYINITIAL> "!" { return KW_ExclamationMark; }
<YYINITIAL> "!=" { return KW_ExclamationMarkEqualsSign; }
<YYINITIAL> "!==" { return KW_ExclamationMarkEqualsSignEqualsSign; }
<YYINITIAL> "#" { return KW_NumberSign; }
<YYINITIAL> "%" { return KW_PercentSign; }
<YYINITIAL> "%=" { return KW_PercentSignEqualsSign; }
<YYINITIAL> "&" { return KW_Ampersand; }
<YYINITIAL> "&&" { return KW_AmpersandAmpersand; }
<YYINITIAL> "(" { return KW_LeftParenthesis; }
<YYINITIAL> ")" { return KW_RightParenthesis; }
<YYINITIAL> "*" { return KW_Asterisk; }
<YYINITIAL> "**" { return KW_AsteriskAsterisk; }
<YYINITIAL> "*=" { return KW_AsteriskEqualsSign; }
<YYINITIAL> "+" { return KW_PlusSign; }
<YYINITIAL> "++" { return KW_PlusSignPlusSign; }
<YYINITIAL> "+=" { return KW_PlusSignEqualsSign; }
<YYINITIAL> "," { return KW_Comma; }
<YYINITIAL> "-" { return KW_HyphenMinus; }
<YYINITIAL> "--" { return KW_HyphenMinusHyphenMinus; }
<YYINITIAL> "-=" { return KW_HyphenMinusEqualsSign; }
<YYINITIAL> "->" { return KW_HyphenMinusGreaterThanSign; }
<YYINITIAL> "." { return KW_FullStop; }
<YYINITIAL> ".." { return KW_FullStopFullStop; }
<YYINITIAL> "..." { return KW_FullStopFullStopFullStop; }
<YYINITIAL> "..<" { return KW_FullStopFullStopLessThanSign; }
<YYINITIAL> "/" { return KW_Solidus; }
<YYINITIAL> "/=" { return KW_SolidusEqualsSign; }
<YYINITIAL> ":" { return KW_Colon; }
<YYINITIAL> "::" { return KW_ColonColon; }
<YYINITIAL> ";" { return KW_Semicolon; }
<YYINITIAL> "<" { return KW_LessThanSign; }
<YYINITIAL> "<>" { return KW_LessThanSignGreaterThanSign; }
<YYINITIAL> "=" { return KW_EqualsSign; }
<YYINITIAL> "==" { return KW_EqualsSignEqualsSign; }
<YYINITIAL> "===" { return KW_EqualsSignEqualsSignEqualsSign; }
<YYINITIAL> "=>" { return KW_EqualsSignGreaterThanSign; }
<YYINITIAL> ">" { return KW_GreaterThanSign; }
<YYINITIAL> ">=" { return KW_GreaterThanSignEqualsSign; }
<YYINITIAL> "?" { return KW_QuestionMark; }
<YYINITIAL> "?." { return KW_QuestionMarkFullStop; }
<YYINITIAL> "?:" { return KW_QuestionMarkColon; }
<YYINITIAL> "@" { return KW_CommercialAt; }
<YYINITIAL> "AFTER" { return KW_AFTER; }
<YYINITIAL> "BEFORE" { return KW_BEFORE; }
<YYINITIAL> "ELSE" { return KW_ELSE; }
<YYINITIAL> "ELSEIF" { return KW_ELSEIF; }
<YYINITIAL> "ENDFOR" { return KW_ENDFOR; }
<YYINITIAL> "ENDIF" { return KW_ENDIF; }
<YYINITIAL> "FOR" { return KW_FOR; }
<YYINITIAL> "IF" { return KW_IF; }
<YYINITIAL> "SEPARATOR" { return KW_SEPARATOR; }
<YYINITIAL> "[" { return KW_LeftSquareBracket; }
<YYINITIAL> "]" { return KW_RightSquareBracket; }
<YYINITIAL> "abstract" { return KW_Abstract; }
<YYINITIAL> "annotation" { return KW_Annotation; }
<YYINITIAL> "as" { return KW_As; }
<YYINITIAL> "case" { return KW_Case; }
<YYINITIAL> "catch" { return KW_Catch; }
<YYINITIAL> "class" { return KW_Class; }
<YYINITIAL> "create" { return KW_Create; }
<YYINITIAL> "def" { return KW_Def; }
<YYINITIAL> "default" { return KW_Default; }
<YYINITIAL> "dispatch" { return KW_Dispatch; }
<YYINITIAL> "do" { return KW_Do; }
<YYINITIAL> "else" { return KW_Else; }
<YYINITIAL> "enum" { return KW_Enum; }
<YYINITIAL> "extends" { return KW_Extends; }
<YYINITIAL> "extension" { return KW_Extension; }
<YYINITIAL> "false" { return KW_False; }
<YYINITIAL> "final" { return KW_Final; }
<YYINITIAL> "finally" { return KW_Finally; }
<YYINITIAL> "for" { return KW_For; }
<YYINITIAL> "if" { return KW_If; }
<YYINITIAL> "implements" { return KW_Implements; }
<YYINITIAL> "import" { return KW_Import; }
<YYINITIAL> "instanceof" { return KW_Instanceof; }
<YYINITIAL> "interface" { return KW_Interface; }
<YYINITIAL> "native" { return KW_Native; }
<YYINITIAL> "new" { return KW_New; }
<YYINITIAL> "null" { return KW_Null; }
<YYINITIAL> "override" { return KW_Override; }
<YYINITIAL> "package" { return KW_Package; }
<YYINITIAL> "private" { return KW_Private; }
<YYINITIAL> "protected" { return KW_Protected; }
<YYINITIAL> "public" { return KW_Public; }
<YYINITIAL> "return" { return KW_Return; }
<YYINITIAL> "static" { return KW_Static; }
<YYINITIAL> "strictfp" { return KW_Strictfp; }
<YYINITIAL> "super" { return KW_Super; }
<YYINITIAL> "switch" { return KW_Switch; }
<YYINITIAL> "synchronized" { return KW_Synchronized; }
<YYINITIAL> "throw" { return KW_Throw; }
<YYINITIAL> "throws" { return KW_Throws; }
<YYINITIAL> "transient" { return KW_Transient; }
<YYINITIAL> "true" { return KW_True; }
<YYINITIAL> "try" { return KW_Try; }
<YYINITIAL> "typeof" { return KW_Typeof; }
<YYINITIAL> "val" { return KW_Val; }
<YYINITIAL> "var" { return KW_Var; }
<YYINITIAL> "volatile" { return KW_Volatile; }
<YYINITIAL> "while" { return KW_While; }
<YYINITIAL> "{" { return KW_LeftCurlyBracket; }
<YYINITIAL> "|" { return KW_VerticalLine; }
<YYINITIAL> "||" { return KW_VerticalLineVerticalLine; }
<YYINITIAL> "}" { return KW_RightCurlyBracket; }


<YYINITIAL> {DECIMAL_ERROR_PATTERN} { return 0; /* antlr <invalid> */ }
<YYINITIAL> {COMMENT_ERROR_PATTERN} { return 0; /* antlr <invalid> */ }




<YYINITIAL> {ID} { return RULE_ID; }
<YYINITIAL> {RICH_TEXT} { return RULE_RICH_TEXT; }
<YYINITIAL> {RICH_TEXT_START} { return RULE_RICH_TEXT_START; }
<YYINITIAL> {RICH_TEXT_END} { return RULE_RICH_TEXT_END; }
<YYINITIAL> {RICH_TEXT_INBETWEEN} { return RULE_RICH_TEXT_INBETWEEN; }
<YYINITIAL> {COMMENT_RICH_TEXT_INBETWEEN} { return RULE_COMMENT_RICH_TEXT_INBETWEEN; }
<YYINITIAL> {COMMENT_RICH_TEXT_END} { return RULE_COMMENT_RICH_TEXT_END; }
<YYINITIAL> {HEX} { return RULE_HEX; }
<YYINITIAL> {INT} { return RULE_INT; }
<YYINITIAL> {DECIMAL} { return RULE_DECIMAL; }
<YYINITIAL> {STRING} { return RULE_STRING; }
<YYINITIAL> {ML_COMMENT} { return RULE_ML_COMMENT; }
<YYINITIAL> {SL_COMMENT} { return RULE_SL_COMMENT; }
<YYINITIAL> {WS} { return RULE_WS; }
<YYINITIAL> {ANY_OTHER} { return RULE_ANY_OTHER; }


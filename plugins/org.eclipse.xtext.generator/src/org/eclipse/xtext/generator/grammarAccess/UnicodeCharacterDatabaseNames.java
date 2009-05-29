/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Moritz Eysholdt
 */
public class UnicodeCharacterDatabaseNames {

	/**
	 * Executing this main method prints the code needed to implement
	 * UnicodeCharacterDatabaseNames.getCharacterName(char) to stdout.
	 */
	public static void main(String[] args) {
		final Pattern hexline = Pattern.compile("([0-9A-F]{4,5})\\s+(.*)");
		final Pattern ident = Pattern.compile("[A-Z \\-_]+");
		final int max = 256;
		final String url = "http://www.unicode.org/Public/UNIDATA/NamesList.txt";
		try {
			Scanner s = new Scanner(new URL(url).openStream());
			while (s.hasNextLine()) {
				String line = s.nextLine();
				Matcher m = hexline.matcher(line);
				if (m.matches()) {
					int cchar = Integer.parseInt(m.group(1), 16);
					if (cchar >= max)
						break;
					String cname = m.group(2);
					if (ident.matcher(cname).matches()) {
						System.out.println("case " + cchar + ": return \""
								+ cname + "\"; // " + ((char) cchar));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the Unicode string name for a character.
	 * 
	 * Attention: This method is generated, do not change it manually! For
	 * regeneration, see UnicodeCharacterDatabaseNames.main(String[])
	 * 
	 * @generated
	 */
	public static String getCharacterName(char character) {
		switch (character) {
		case 32:
			return "SPACE"; //  
		case 33:
			return "EXCLAMATION MARK"; // !
		case 34:
			return "QUOTATION MARK"; // "
		case 35:
			return "NUMBER SIGN"; // #
		case 36:
			return "DOLLAR SIGN"; // $
		case 37:
			return "PERCENT SIGN"; // %
		case 38:
			return "AMPERSAND"; // &
		case 39:
			return "APOSTROPHE"; // '
		case 40:
			return "LEFT PARENTHESIS"; // (
		case 41:
			return "RIGHT PARENTHESIS"; // )
		case 42:
			return "ASTERISK"; // *
		case 43:
			return "PLUS SIGN"; // +
		case 44:
			return "COMMA"; // ,
		case 45:
			return "HYPHEN-MINUS"; // -
		case 46:
			return "FULL STOP"; // .
		case 47:
			return "SOLIDUS"; // /
		case 48:
			return "DIGIT ZERO"; // 0
		case 49:
			return "DIGIT ONE"; // 1
		case 50:
			return "DIGIT TWO"; // 2
		case 51:
			return "DIGIT THREE"; // 3
		case 52:
			return "DIGIT FOUR"; // 4
		case 53:
			return "DIGIT FIVE"; // 5
		case 54:
			return "DIGIT SIX"; // 6
		case 55:
			return "DIGIT SEVEN"; // 7
		case 56:
			return "DIGIT EIGHT"; // 8
		case 57:
			return "DIGIT NINE"; // 9
		case 58:
			return "COLON"; // :
		case 59:
			return "SEMICOLON"; // ;
		case 60:
			return "LESS-THAN SIGN"; // <
		case 61:
			return "EQUALS SIGN"; // =
		case 62:
			return "GREATER-THAN SIGN"; // >
		case 63:
			return "QUESTION MARK"; // ?
		case 64:
			return "COMMERCIAL AT"; // @
		case 65:
			return "LATIN CAPITAL LETTER A"; // A
		case 66:
			return "LATIN CAPITAL LETTER B"; // B
		case 67:
			return "LATIN CAPITAL LETTER C"; // C
		case 68:
			return "LATIN CAPITAL LETTER D"; // D
		case 69:
			return "LATIN CAPITAL LETTER E"; // E
		case 70:
			return "LATIN CAPITAL LETTER F"; // F
		case 71:
			return "LATIN CAPITAL LETTER G"; // G
		case 72:
			return "LATIN CAPITAL LETTER H"; // H
		case 73:
			return "LATIN CAPITAL LETTER I"; // I
		case 74:
			return "LATIN CAPITAL LETTER J"; // J
		case 75:
			return "LATIN CAPITAL LETTER K"; // K
		case 76:
			return "LATIN CAPITAL LETTER L"; // L
		case 77:
			return "LATIN CAPITAL LETTER M"; // M
		case 78:
			return "LATIN CAPITAL LETTER N"; // N
		case 79:
			return "LATIN CAPITAL LETTER O"; // O
		case 80:
			return "LATIN CAPITAL LETTER P"; // P
		case 81:
			return "LATIN CAPITAL LETTER Q"; // Q
		case 82:
			return "LATIN CAPITAL LETTER R"; // R
		case 83:
			return "LATIN CAPITAL LETTER S"; // S
		case 84:
			return "LATIN CAPITAL LETTER T"; // T
		case 85:
			return "LATIN CAPITAL LETTER U"; // U
		case 86:
			return "LATIN CAPITAL LETTER V"; // V
		case 87:
			return "LATIN CAPITAL LETTER W"; // W
		case 88:
			return "LATIN CAPITAL LETTER X"; // X
		case 89:
			return "LATIN CAPITAL LETTER Y"; // Y
		case 90:
			return "LATIN CAPITAL LETTER Z"; // Z
		case 91:
			return "LEFT SQUARE BRACKET"; // [
		case 92:
			return "REVERSE SOLIDUS"; // \
		case 93:
			return "RIGHT SQUARE BRACKET"; // ]
		case 94:
			return "CIRCUMFLEX ACCENT"; // ^
		case 95:
			return "LOW LINE"; // _
		case 96:
			return "GRAVE ACCENT"; // `
		case 97:
			return "LATIN SMALL LETTER A"; // a
		case 98:
			return "LATIN SMALL LETTER B"; // b
		case 99:
			return "LATIN SMALL LETTER C"; // c
		case 100:
			return "LATIN SMALL LETTER D"; // d
		case 101:
			return "LATIN SMALL LETTER E"; // e
		case 102:
			return "LATIN SMALL LETTER F"; // f
		case 103:
			return "LATIN SMALL LETTER G"; // g
		case 104:
			return "LATIN SMALL LETTER H"; // h
		case 105:
			return "LATIN SMALL LETTER I"; // i
		case 106:
			return "LATIN SMALL LETTER J"; // j
		case 107:
			return "LATIN SMALL LETTER K"; // k
		case 108:
			return "LATIN SMALL LETTER L"; // l
		case 109:
			return "LATIN SMALL LETTER M"; // m
		case 110:
			return "LATIN SMALL LETTER N"; // n
		case 111:
			return "LATIN SMALL LETTER O"; // o
		case 112:
			return "LATIN SMALL LETTER P"; // p
		case 113:
			return "LATIN SMALL LETTER Q"; // q
		case 114:
			return "LATIN SMALL LETTER R"; // r
		case 115:
			return "LATIN SMALL LETTER S"; // s
		case 116:
			return "LATIN SMALL LETTER T"; // t
		case 117:
			return "LATIN SMALL LETTER U"; // u
		case 118:
			return "LATIN SMALL LETTER V"; // v
		case 119:
			return "LATIN SMALL LETTER W"; // w
		case 120:
			return "LATIN SMALL LETTER X"; // x
		case 121:
			return "LATIN SMALL LETTER Y"; // y
		case 122:
			return "LATIN SMALL LETTER Z"; // z
		case 123:
			return "LEFT CURLY BRACKET"; // {
		case 124:
			return "VERTICAL LINE"; // |
		case 125:
			return "RIGHT CURLY BRACKET"; // }
		case 126:
			return "TILDE"; // ~
		case 160:
			return "NO-BREAK SPACE"; //  
		case 161:
			return "INVERTED EXCLAMATION MARK"; // ¡
		case 162:
			return "CENT SIGN"; // ¢
		case 163:
			return "POUND SIGN"; // £
		case 164:
			return "CURRENCY SIGN"; // ¤
		case 165:
			return "YEN SIGN"; // ¥
		case 166:
			return "BROKEN BAR"; // ¦
		case 167:
			return "SECTION SIGN"; // §
		case 168:
			return "DIAERESIS"; // ¨
		case 169:
			return "COPYRIGHT SIGN"; // ©
		case 170:
			return "FEMININE ORDINAL INDICATOR"; // ª
		case 172:
			return "NOT SIGN"; // ¬
		case 173:
			return "SOFT HYPHEN"; // ­
		case 174:
			return "REGISTERED SIGN"; // ®
		case 175:
			return "MACRON"; // ¯
		case 176:
			return "DEGREE SIGN"; // °
		case 177:
			return "PLUS-MINUS SIGN"; // ±
		case 178:
			return "SUPERSCRIPT TWO"; // ²
		case 179:
			return "SUPERSCRIPT THREE"; // ³
		case 180:
			return "ACUTE ACCENT"; // ´
		case 181:
			return "MICRO SIGN"; // µ
		case 182:
			return "PILCROW SIGN"; // ¶
		case 183:
			return "MIDDLE DOT"; // ·
		case 184:
			return "CEDILLA"; // ¸
		case 185:
			return "SUPERSCRIPT ONE"; // ¹
		case 186:
			return "MASCULINE ORDINAL INDICATOR"; // º
		case 188:
			return "VULGAR FRACTION ONE QUARTER"; // ¼
		case 189:
			return "VULGAR FRACTION ONE HALF"; // ½
		case 190:
			return "VULGAR FRACTION THREE QUARTERS"; // ¾
		case 191:
			return "INVERTED QUESTION MARK"; // ¿
		case 192:
			return "LATIN CAPITAL LETTER A WITH GRAVE"; // À
		case 193:
			return "LATIN CAPITAL LETTER A WITH ACUTE"; // Á
		case 194:
			return "LATIN CAPITAL LETTER A WITH CIRCUMFLEX"; // Â
		case 195:
			return "LATIN CAPITAL LETTER A WITH TILDE"; // Ã
		case 196:
			return "LATIN CAPITAL LETTER A WITH DIAERESIS"; // Ä
		case 197:
			return "LATIN CAPITAL LETTER A WITH RING ABOVE"; // Å
		case 199:
			return "LATIN CAPITAL LETTER C WITH CEDILLA"; // Ç
		case 200:
			return "LATIN CAPITAL LETTER E WITH GRAVE"; // È
		case 201:
			return "LATIN CAPITAL LETTER E WITH ACUTE"; // É
		case 202:
			return "LATIN CAPITAL LETTER E WITH CIRCUMFLEX"; // Ê
		case 203:
			return "LATIN CAPITAL LETTER E WITH DIAERESIS"; // Ë
		case 204:
			return "LATIN CAPITAL LETTER I WITH GRAVE"; // Ì
		case 205:
			return "LATIN CAPITAL LETTER I WITH ACUTE"; // Í
		case 206:
			return "LATIN CAPITAL LETTER I WITH CIRCUMFLEX"; // Î
		case 207:
			return "LATIN CAPITAL LETTER I WITH DIAERESIS"; // Ï
		case 209:
			return "LATIN CAPITAL LETTER N WITH TILDE"; // Ñ
		case 210:
			return "LATIN CAPITAL LETTER O WITH GRAVE"; // Ò
		case 211:
			return "LATIN CAPITAL LETTER O WITH ACUTE"; // Ó
		case 212:
			return "LATIN CAPITAL LETTER O WITH CIRCUMFLEX"; // Ô
		case 213:
			return "LATIN CAPITAL LETTER O WITH TILDE"; // Õ
		case 214:
			return "LATIN CAPITAL LETTER O WITH DIAERESIS"; // Ö
		case 215:
			return "MULTIPLICATION SIGN"; // ×
		case 216:
			return "LATIN CAPITAL LETTER O WITH STROKE"; // Ø
		case 217:
			return "LATIN CAPITAL LETTER U WITH GRAVE"; // Ù
		case 218:
			return "LATIN CAPITAL LETTER U WITH ACUTE"; // Ú
		case 219:
			return "LATIN CAPITAL LETTER U WITH CIRCUMFLEX"; // Û
		case 220:
			return "LATIN CAPITAL LETTER U WITH DIAERESIS"; // Ü
		case 221:
			return "LATIN CAPITAL LETTER Y WITH ACUTE"; // Ý
		case 224:
			return "LATIN SMALL LETTER A WITH GRAVE"; // à
		case 225:
			return "LATIN SMALL LETTER A WITH ACUTE"; // á
		case 226:
			return "LATIN SMALL LETTER A WITH CIRCUMFLEX"; // â
		case 227:
			return "LATIN SMALL LETTER A WITH TILDE"; // ã
		case 228:
			return "LATIN SMALL LETTER A WITH DIAERESIS"; // ä
		case 229:
			return "LATIN SMALL LETTER A WITH RING ABOVE"; // å
		case 231:
			return "LATIN SMALL LETTER C WITH CEDILLA"; // ç
		case 232:
			return "LATIN SMALL LETTER E WITH GRAVE"; // è
		case 233:
			return "LATIN SMALL LETTER E WITH ACUTE"; // é
		case 234:
			return "LATIN SMALL LETTER E WITH CIRCUMFLEX"; // ê
		case 235:
			return "LATIN SMALL LETTER E WITH DIAERESIS"; // ë
		case 236:
			return "LATIN SMALL LETTER I WITH GRAVE"; // ì
		case 237:
			return "LATIN SMALL LETTER I WITH ACUTE"; // í
		case 238:
			return "LATIN SMALL LETTER I WITH CIRCUMFLEX"; // î
		case 239:
			return "LATIN SMALL LETTER I WITH DIAERESIS"; // ï
		case 241:
			return "LATIN SMALL LETTER N WITH TILDE"; // ñ
		case 242:
			return "LATIN SMALL LETTER O WITH GRAVE"; // ò
		case 243:
			return "LATIN SMALL LETTER O WITH ACUTE"; // ó
		case 244:
			return "LATIN SMALL LETTER O WITH CIRCUMFLEX"; // ô
		case 245:
			return "LATIN SMALL LETTER O WITH TILDE"; // õ
		case 246:
			return "LATIN SMALL LETTER O WITH DIAERESIS"; // ö
		case 247:
			return "DIVISION SIGN"; // ÷
		case 248:
			return "LATIN SMALL LETTER O WITH STROKE"; // ø
		case 249:
			return "LATIN SMALL LETTER U WITH GRAVE"; // ù
		case 250:
			return "LATIN SMALL LETTER U WITH ACUTE"; // ú
		case 251:
			return "LATIN SMALL LETTER U WITH CIRCUMFLEX"; // û
		case 252:
			return "LATIN SMALL LETTER U WITH DIAERESIS"; // ü
		case 253:
			return "LATIN SMALL LETTER Y WITH ACUTE"; // ý
		case 255:
			return "LATIN SMALL LETTER Y WITH DIAERESIS"; // ÿ
		}
		return null;
	}

}

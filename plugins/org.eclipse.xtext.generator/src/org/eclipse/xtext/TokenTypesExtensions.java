package org.eclipse.xtext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.WrappedException;

public class TokenTypesExtensions {
	
	private static Map<Object,String> tokenTypeMap;

	public static void main(String[] args) {
		doGenerate("../org.eclipse.xtext.generator.tests/src-gen", "org/eclipse/xtext", "XtextGrammarTest");
	}

	public static void doGenerate(String srcGen, String namespace, String LanguageName) {
		try {
			File file = new File(srcGen + "/" + namespace + "/parser/internal/Internal" + LanguageName + ".tokens");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Pattern pattern = Pattern.compile("(.*)=(\\d+)");
			StringBuffer buff = new StringBuffer();
			buff.append("package ").append(namespace.replace('/', '.')).append(".parser;");
			buff.append("\npublic interface ").append(LanguageName).append("Tokens {\n");
			while (line != null) {
				Matcher m = pattern.matcher(line);
				if (!m.matches()) {
					throw new IllegalStateException("Couldn't match line : '" + line + "'");
				}
				buff.append("    public final static int ").append(toJavaIdentifier(m.group(1))).append(" = ").append(
						m.group(2)).append(";\t// ").append(m.group(1)).append("\n");
				line = br.readLine();
			}
			buff.append("}\n");
			FileWriter writer = new FileWriter(srcGen+"/"+namespace+"/parser/"+LanguageName+"Tokens.java");
			writer.append(buff);
			writer.close();
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	public static String getAntlrTokenName(Object antlrTokenId) {
		return tokenTypeMap.get(antlrTokenId);
	}
	
	public static Set<Object> getAntlrTokenTypes() {
		return tokenTypeMap.keySet();
	}
	
	public static Map<Object, String> loadTokenTypeNames(String srcGen, String languageNamespace, String languageName) {
		try {
			tokenTypeMap = new HashMap<Object, String>();
			File file = new File(srcGen + "/" + languageNamespace + "/parser/internal/Internal" + languageName + ".tokens");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			Pattern pattern = Pattern.compile("(.*)=(\\d+)");
			while (line != null) {
				Matcher m = pattern.matcher(line);
				if (!m.matches()) {
					throw new IllegalStateException("Couldn't match line : '" + line + "'");
				}
				
				String tokenTypeId = m.group(2);
				String token = m.group(1);
				tokenTypeMap.put(Integer.parseInt(tokenTypeId), token);
				line = br.readLine();
			}
			return tokenTypeMap;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}
	
	private static String toJavaIdentifier(String string) {
		if (string.startsWith("'")) {
			string = string.substring(1, string.length() - 1);
			boolean needsTranslation = false;
			for (char x : string.toCharArray()) {
				needsTranslation = needsTranslation || !Character.isJavaIdentifierPart(x);
			}
			if (needsTranslation) {
				String result = "TOKEN_";
				for (char x : string.toCharArray()) {
					if (Character.isJavaIdentifierPart(x)) {
						result += x;
					} else {
						result += char2Identifier(x);
					}
				}
				return result;
			}
			return "KW_"+string;
		}
		return string;
	}

	private static String char2Identifier(char x) {
		switch (x) {
		case '+':
			return "Plus";
		case '-':
			return "Minus";
		case '*':
			return "Asterisk";
		case '/':
			return "Slash";
		case '(':
			return "OpeningParenthesis";
		case ')':
			return "ClosingParenthesis";
		case '[':
			return "OpeningSquareBracket";
		case ']':
			return "ClosingSquareBracket";
		case '{':
			return "OpeningCurlyBracket";
		case '}':
			return "ClosingCurlyBracket";
		case '=':
			return "Equals";
		case '!':
			return "ExplanationMark";
		case '?':
			return "QuestionMark";
		case ':':
			return "Colon";
		case ';':
			return "SemiColon";
		case '.':
			return "Dot";
		case ',':
			return "Comma";
		case '|':
			return "Bar";
		case '\\':
			return "BackSlash";
		case '\'':
			return "SingleQuote";
		case '"':
			return "DoubleQuote";
		default:
			return "_" + (int) x;
		}
	}
}

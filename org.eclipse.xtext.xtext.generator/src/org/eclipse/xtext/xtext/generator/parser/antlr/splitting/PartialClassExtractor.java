/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * A Split-humongous-class-refactoring based on {@link String#indexOf(String)} 
 * searches and regular expressions.
 * 
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be subclassed by clients.
 */
public class PartialClassExtractor {
	
	public static final int METHODS_PER_CLASS = 5000;
	
	private final String content;
	private final String originalContent;
	private static final Pattern SIGNATURE = Pattern.compile("^\\s*public final (void|EObject|Enumerator|AntlrDatatypeRuleToken|Boolean) \\S*\\((EObject in_current)?\\) throws RecognitionException \\{\\s*$");
	private static final String ANTLR_END_MARKER = "    // $ANTLR end ";
	private static final String ANTLR_START_MARKER = "    // $ANTLR start ";

	private final int methodsPerClass;

	public PartialClassExtractor(String content, int methodsPerClass) {
		this.originalContent = content;
		if ("\n".equals(Strings.newLine())) {
			this.content = content;
		} else {
			this.content = originalContent.replace(Strings.newLine(), "\n");
		}
		this.methodsPerClass = methodsPerClass;
	}

	public String transform() {
		String content = this.content;
		List<String> potentiallyExtractedClasses = getExtractedClasses();
		if (potentiallyExtractedClasses.size() <= 1)
			return originalContent;
		String className = getClassName();
		String superClassName = getSuperClassName();
		StringWriter result = new StringWriter(content.length());
		PrintWriter printer = new PrintWriter(result, false);
		printer.print(content.substring(0, content.indexOf("public class ")));
		List<String> allSignatures = getAllSignatures();
		printer.println("@SuppressWarnings(\"all\")");
		printer.printf("interface %sSignatures {", className).println();
		for(String signature: allSignatures) {
			printer.println(signature);
		}
		printer.println("}");
		printer.println();
		printer.println("@SuppressWarnings(\"all\")");
		printer.printf("abstract class %s%d extends %s implements %sSignatures {", className, 1, superClassName, className).println();
		printer.println();
		printConstructor(className, printer, 1);
		printer.print(getTokenDefinitions());
		printer.println();
		String customMethods = getCustomMethods();
		String customConstructor = getCustomConstructor(customMethods, className);
		if (customConstructor != null)
			customMethods = customMethods.replace(customConstructor, "");
		printer.print(customMethods);
		printer.println();
		printer.print(getBitSetsAndDfas());
		printer.println();
		printer.println();
		for(int i = 0; i < potentiallyExtractedClasses.size(); i++) {
			printer.println("@SuppressWarnings(\"all\")");
			printer.printf("abstract class %s%d extends %s%d {", className, i + 2, className, i + 1).println();
			printer.println();
			printConstructor(className, printer, i + 2);
			printer.print(potentiallyExtractedClasses.get(i));
			printer.println();
			printer.println("}");
			printer.println();
		}
		printer.printf("public class %s extends %s%d {", className, className, potentiallyExtractedClasses.size() + 1).println();
		printer.println();
		printer.print(getConstructors());
		printer.println();
		if (customConstructor != null) {
			printer.print(customConstructor);
			printer.println();
		}
		printer.println("}");
		printer.flush();
		if (originalContent == content)
			return result.toString();
		// reinstate consistent line endings
		return result.toString().replace(Strings.newLine(), "\n").replace("\n", Strings.newLine());
	}

	private String getCustomConstructor(String customMethods, String className) {
		int start = customMethods.indexOf("        public " + className + "(");
		if (start == -1) {
			start = customMethods.indexOf("    \tpublic " + className + "(");
		}
		if (start == -1) {
			return null;
		}
		int end = customMethods.indexOf('}', start);
		return customMethods.substring(start, end + 1);
	}

	protected void printConstructor(String className, PrintWriter printer, int number) {
		printer.printf(
				"        %s%d(TokenStream input) {\n" +
				"            this(input, new RecognizerSharedState());\n" +
				"        }\n" +
				"\n" +
				"        %s%d(TokenStream input, RecognizerSharedState state) {\n" +
				"            super(input, state);\n" +
				"        }", className, number, className, number).println();
		printer.println();
	}

	protected String getClassName() {
		int classDefinition = content.indexOf("public class ");
		classDefinition += "public class ".length();
		String result = content.substring(classDefinition, content.indexOf(' ', classDefinition));
		return result;
	}
	
	protected String getSuperClassName() {
		int classDefinition = content.indexOf("public class ");
		int extendsClause = content.indexOf(" extends ", classDefinition);
		extendsClause += " extends ".length();
		String result = content.substring(extendsClause, content.indexOf(' ', extendsClause));
		return result;
	}
	
	protected String getCustomMethods() {
		int start = content.indexOf("    public String[] getTokenNames() {");
		int end = content.indexOf(ANTLR_START_MARKER, start);
		return content.substring(start, end).replaceFirst("\tprivate ", "\tprotected ");
	}
	
	protected String getTokenDefinitions() {
		int start = content.indexOf("    public static final String[] tokenNames = new String[] {");
		int end = content.indexOf(
				"    // delegates\n" + 
				"    // delegators", start);
		return content.substring(start, end);
	}
	
	protected String getConstructors() {
		String startMarker = 
				"    // delegates\n" + 
				"    // delegators\n";
		int start = content.indexOf(startMarker) + startMarker.length();
		int end = content.indexOf(
				"    public String[] getTokenNames() {", start);
		return content.substring(start, end);
	}
	
	protected String getBitSetsAndDfas() {
		int start = content.lastIndexOf("    // Delegated rules");
		return content.substring(start).replace("private static class FollowSets", "protected static class FollowSets");
	}

	protected List<String> getExtractedClasses() {
		List<String> result = Lists.newArrayList();
		int workingStart = content.indexOf(ANTLR_START_MARKER);
		int startOffset = workingStart;
		int counter = 0;
		while(workingStart != -1) {
			int endOffset = content.indexOf(ANTLR_END_MARKER, workingStart);
			endOffset = content.indexOf('\n', endOffset);
			counter++;
			if (counter == methodsPerClass) {
				counter = 0;
				result.add(content.substring(startOffset, endOffset + 1));
				workingStart = content.indexOf(ANTLR_START_MARKER, endOffset);
				startOffset = workingStart;
			} else {
				workingStart = content.indexOf(ANTLR_START_MARKER, endOffset);
				if (workingStart == -1) {
					result.add(content.substring(startOffset, endOffset + 1));
				}
			}
		}
		return result;
	}

	protected List<String> getAllSignatures() {
		List<String> result = Lists.newArrayList();
		BufferedReader reader = new BufferedReader(new StringReader(content));
		try {
			try {
				String line = reader.readLine();
				while (line != null) {
					String signature = getSignature(line);
					if (signature != null) {
						result.add(signature);
					}
					line = reader.readLine();
				}
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public String getSignature(String line) {
		if (SIGNATURE.matcher(line).matches()) {
			return line.replaceFirst("public final", "").replace(" {", ";");
		} else {
			return null;
		}
	}

}

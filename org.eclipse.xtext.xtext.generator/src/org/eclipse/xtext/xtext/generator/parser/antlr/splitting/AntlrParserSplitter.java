/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Preconditions;

public class AntlrParserSplitter {

	public static final int FIELDS_PER_CLASS = 1000;

	public static final Pattern DECLARATION_PATTERN = Pattern.compile("public static final BitSet (FOLLOW_.*?)(\\s*=.*;)", 0);
	public static final Pattern REFERENCE_PATTERN = Pattern.compile("(?<!BitSet )(FOLLOW_[\\w]+)", 0);

	private final String content;
	private Map<String, Integer> fields = new HashMap<String, Integer>();
	private List<ExtractedClass> extractedClasses = new ArrayList<ExtractedClass>();

	private final int fieldsPerClass;

	public AntlrParserSplitter(String content) {
		this(content, FIELDS_PER_CLASS);
	}
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public AntlrParserSplitter(String content, int fieldsPerClass) {
		this.content = content;
		this.fieldsPerClass = fieldsPerClass;
	}

	public String transform() {
		fields.clear();
		extractedClasses.clear();

		Matcher m = REFERENCE_PATTERN.matcher(content);
		StringBuffer result = new StringBuffer();
		int lastMatch = 0;
		while(m.find()) {
			String field = m.group();
			registerField(field);
			m.appendReplacement(result, getTransformedReference(field));
			lastMatch = m.end();
		}

		m = DECLARATION_PATTERN.matcher(content);
		if(m.find(lastMatch)) {
			result.append(content.subSequence(lastMatch, m.start()));

			ExtractedClass ec = new ExtractedClass(extractedClasses.size());
			do {
				ec.addDeclaration(m.group());
				if(ec.isFull()) {
					extractedClasses.add(ec.finalized());
					ec = new ExtractedClass(extractedClasses.size());
				}
			} while (m.find());

			if(ec.hasContent())
				extractedClasses.add(ec.finalized());
		}

		result.append("\n");
		for(ExtractedClass ec : getExtractedClasses()) {
			result.append(ec.getContent());
			result.append("\n");
		}

		result.append("\n}");
		return result.toString();
	}

	public List<ExtractedClass> getExtractedClasses() {
		return Collections.unmodifiableList(extractedClasses);
	}

	private String getTransformedReference(String field) {
		int idx = fields.get(field);
		return getExtractedClassName(idx / fieldsPerClass) + "." + field;
	}

	private String getExtractedClassName(int i) {
		return String.format("FollowSets%03d", i);
	}

	private void registerField(String field) {
		if(!fields.containsKey(field))
			fields.put(field, fields.size());
	}

	public class ExtractedClass {
		private static final String INDENT = "    ";
		private static final String INDENT2 = INDENT + INDENT;
		private final int index;
		private StringBuilder content;
		private int declarationCount;
		private boolean finalized;

		public ExtractedClass(int index) {
			this.index = index;
			content = createContent();
		}

		public boolean isFull() {
			return declarationCount >= fieldsPerClass;
		}

		public void addDeclaration(String declaration) {
			Preconditions.checkState(!finalized, "already finalized");
			content.append(INDENT2);
			content.append(declaration.trim());
			content.append("\n");
			declarationCount++;
		}

		private StringBuilder createContent() {
			StringBuilder result = new StringBuilder();
			result.append(INDENT);
			result.append("private static class ");
			result.append(getName());
			result.append(" {\n");
			return result ;
		}

		public boolean hasContent() {
			return declarationCount > 0;
		}

		public ExtractedClass finalized() {
			Preconditions.checkState(!finalized);
			content.append(INDENT);
			content.append("}\n");
			finalized = true;
			return this;
		}

		public String getName() {
			return getExtractedClassName(index);
		}

		public String getContent() {
			return content.toString();
		}

	}

}

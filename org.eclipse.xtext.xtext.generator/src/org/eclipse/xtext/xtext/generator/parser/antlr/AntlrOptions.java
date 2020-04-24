/**
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrParserSplitter;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.PartialClassExtractor;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.internal.LexerSpecialStateTransitionSplitter;

public class AntlrOptions {
	private boolean backtrack = false;

	private boolean backtrackLexer = false;

	private boolean memoize = false;

	private int k = -1;

	private boolean ignoreCase = false;

	private boolean classSplitting = false;

	private int fieldsPerClass = AntlrParserSplitter.FIELDS_PER_CLASS;

	private int methodsPerClass = PartialClassExtractor.METHODS_PER_CLASS;

	private int casesPerSpecialStateSwitch = LexerSpecialStateTransitionSplitter.CASES_PER_SPECIAL_STATE_SWITCH;

	private boolean skipUnusedRules = false;

	private boolean optimizeCodeQuality = true;

	private boolean stripAllComments = false;

	private String keptBitSetsPattern;

	private String keptBitSetName;

	public void setFieldsPerClass(String fieldsPerClass) {
		this.fieldsPerClass = Integer.parseInt(fieldsPerClass);
	}

	public void setMethodsPerClass(String methodsPerClass) {
		this.methodsPerClass = Integer.parseInt(methodsPerClass);
	}

	public void setCasesPerSpecialStateSwitch(String casesPerSpecialStateSwitch) {
		this.casesPerSpecialStateSwitch = Integer.parseInt(casesPerSpecialStateSwitch);
	}

	public void setKAsString(String k) {
		this.k = Integer.parseInt(k);
	}

	public boolean isBacktrack() {
		return backtrack;
	}

	public void setBacktrack(boolean backtrack) {
		this.backtrack = backtrack;
	}

	public boolean isBacktrackLexer() {
		return backtrackLexer;
	}

	public void setBacktrackLexer(boolean backtrackLexer) {
		this.backtrackLexer = backtrackLexer;
	}

	public boolean isMemoize() {
		return memoize;
	}

	public void setMemoize(boolean memoize) {
		this.memoize = memoize;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	public boolean isClassSplitting() {
		return classSplitting;
	}

	public void setClassSplitting(boolean classSplitting) {
		this.classSplitting = classSplitting;
	}

	public int getFieldsPerClass() {
		return fieldsPerClass;
	}

	public int getMethodsPerClass() {
		return methodsPerClass;
	}

	public int getCasesPerSpecialStateSwitch() {
		return casesPerSpecialStateSwitch;
	}

	public boolean isSkipUnusedRules() {
		return skipUnusedRules;
	}

	public void setSkipUnusedRules(boolean skipUnusedRules) {
		this.skipUnusedRules = skipUnusedRules;
	}

	public boolean isOptimizeCodeQuality() {
		return optimizeCodeQuality;
	}

	public void setOptimizeCodeQuality(boolean optimizeCodeQuality) {
		this.optimizeCodeQuality = optimizeCodeQuality;
	}

	public boolean isStripAllComments() {
		return stripAllComments;
	}

	public void setStripAllComments(boolean stripAllComments) {
		this.stripAllComments = stripAllComments;
	}

	public String getKeptBitSetsPattern() {
		return keptBitSetsPattern;
	}

	public void setKeptBitSetsPattern(String keptBitSetsPattern) {
		this.keptBitSetsPattern = keptBitSetsPattern;
	}

	public String getKeptBitSetName() {
		return keptBitSetName;
	}

	public void setKeptBitSetName(String keptBitSetName) {
		this.keptBitSetName = keptBitSetName;
	}
}

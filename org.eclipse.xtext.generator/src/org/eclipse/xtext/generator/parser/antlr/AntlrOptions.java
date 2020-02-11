/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

@Deprecated
public class AntlrOptions extends org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions {

	@Override
	public void setFieldsPerClass(String fieldsPerClass) {
		super.setFieldsPerClass(fieldsPerClass);
	}

	@Override
	public void setMethodsPerClass(String methodsPerClass) {
		super.setMethodsPerClass(methodsPerClass);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public void setCasesPerSpecialStateSwitch(String casesPerSpecialStateSwitch) {
		super.setCasesPerSpecialStateSwitch(casesPerSpecialStateSwitch);
	}

	@Override
	public void setKAsString(String k) {
		super.setKAsString(k);
	}

	@Override
	public boolean isBacktrack() {
		return super.isBacktrack();
	}

	@Override
	public void setBacktrack(boolean backtrack) {
		super.setBacktrack(backtrack);
	}

	@Override
	public boolean isBacktrackLexer() {
		return super.isBacktrackLexer();
	}

	@Override
	public void setBacktrackLexer(boolean backtrackLexer) {
		super.setBacktrackLexer(backtrackLexer);
	}

	@Override
	public boolean isMemoize() {
		return super.isMemoize();
	}

	@Override
	public void setMemoize(boolean memoize) {
		super.setMemoize(memoize);
	}

	@Override
	public int getK() {
		return super.getK();
	}

	@Override
	public void setK(int k) {
		super.setK(k);
	}

	@Override
	public boolean isIgnoreCase() {
		return super.isIgnoreCase();
	}

	@Override
	public void setIgnoreCase(boolean ignoreCase) {
		super.setIgnoreCase(ignoreCase);
	}

	@Override
	public boolean isClassSplitting() {
		return super.isClassSplitting();
	}

	@Override
	public void setClassSplitting(boolean classSplitting) {
		super.setClassSplitting(classSplitting);
	}

	@Override
	public int getFieldsPerClass() {
		return super.getFieldsPerClass();
	}

	@Override
	public int getMethodsPerClass() {
		return super.getMethodsPerClass();
	}

	/**
	 * @since 2.9
	 */
	@Override
	public int getCasesPerSpecialStateSwitch() {
		return super.getCasesPerSpecialStateSwitch();
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isSkipUnusedRules() {
		return super.isSkipUnusedRules();
	}

	/**
	 * @since 2.9
	 */
	@Override
	public void setSkipUnusedRules(boolean skipUnusedRules) {
		super.setSkipUnusedRules(skipUnusedRules);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isOptimizeCodeQuality() {
		return super.isOptimizeCodeQuality();
	}

	/**
	 * @since 2.9
	 */
	@Override
	public void setOptimizeCodeQuality(boolean optimizeCodeQuality) {
		super.setOptimizeCodeQuality(optimizeCodeQuality);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isStripAllComments() {
		return super.isStripAllComments();
	}

	/**
	 * @since 2.9
	 */
	@Override
	public void setStripAllComments(boolean stripAllComments) {
		super.setStripAllComments(stripAllComments);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public String getKeptBitSetsPattern() {
		return super.getKeptBitSetsPattern();
	}

	/**
	 * @since 2.9
	 */
	@Override
	public void setKeptBitSetsPattern(String keptBitSetsPattern) {
		super.setKeptBitSetsPattern(keptBitSetsPattern);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public String getKeptBitSetName() {
		return super.getKeptBitSetName();
	}

	/**
	 * @since 2.9
	 */
	@Override
	public void setKeptBitSetName(String keptBitSetName) {
		super.setKeptBitSetName(keptBitSetName);
	}
	
}

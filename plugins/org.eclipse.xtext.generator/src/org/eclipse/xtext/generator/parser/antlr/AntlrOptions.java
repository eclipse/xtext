/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

public class AntlrOptions {

	org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions delegate = new org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions();

	public boolean isBacktrack() {
		return delegate.isBacktrack();
	}

	public void setBacktrack(boolean backtrack) {
		delegate.setBacktrack(backtrack);
	}

	public boolean isMemoize() {
		return delegate.isMemoize();
	}

	public void setMemoize(boolean memoize) {
		delegate.setMemoize(memoize);
	}

	public int getK() {
		return delegate.getK();
	}

	public void setK(int k) {
		delegate.setK(k);
	}

	/**
	 * @since 2.1
	 */
	public void setKAsString(String k) {
		delegate.setKAsString(k);
	}

	public void setBacktrackLexer(boolean backtrackLexer) {
		delegate.setBacktrackLexer(backtrackLexer);
	}

	public boolean isBacktrackLexer() {
		return delegate.isBacktrackLexer();
	}

	public void setIgnoreCase(boolean ignoreCase) {
		delegate.setIgnoreCase(ignoreCase);
	}

	public boolean isIgnoreCase() {
		return delegate.isIgnoreCase();
	}

	public boolean isClassSplitting() {
		return delegate.isClassSplitting();
	}

	public void setClassSplitting(boolean value) {
		delegate.setClassSplitting(value);
	}

	/**
	 * @since 2.1
	 */
	public int getFieldsPerClass() {
		return delegate.getFieldsPerClass();
	}

	/**
	 * @since 2.1
	 */
	public void setFieldsPerClass(String fieldsPerClass) {
		delegate.setFieldsPerClass(fieldsPerClass);
	}

	/**
	 * @since 2.1
	 */
	public int getMethodsPerClass() {
		return delegate.getMethodsPerClass();
	}

	/**
	 * @since 2.1
	 */
	public void setMethodsPerClass(String methodsPerClass) {
		delegate.setMethodsPerClass(methodsPerClass);
	}

	/**
	 * @since 2.9
	 */
	public boolean isOptimizeCodeQuality() {
		return delegate.isOptimizeCodeQuality();
	}

	/**
	 * @since 2.9
	 * Whether to strip unnecessary comments and remove duplicate bitsets
	 */
	public void setOptimizeCodeQuality(boolean optimizeCodeQuality) {
		delegate.setOptimizeCodeQuality(optimizeCodeQuality);
	}

	/**
	 * @since 2.9
	 */
	public String getKeptBitSetsPattern() {
		return delegate.getKeptBitSetsPattern();
	}

	/**
	 * @since 2.9
	 * When removing bitsets, the ones matching this pattern will be kept
	 */
	public void setKeptBitSetsPattern(String keptBitSetsPattern) {
		delegate.setKeptBitSetsPattern(keptBitSetsPattern);
	}

	/**
	 * @since 2.9
	 */
	public String getKeptBitSetName() {
		return delegate.getKeptBitSetName();
	}

	/**
	 * @since 2.9
	 * Allows to rename bitsets kept by {@link #setKeptBitSetsPattern(String)}
	 */
	public void setKeptBitSetName(String keptBitSetName) {
		delegate.setKeptBitSetName(keptBitSetName);
	}

}

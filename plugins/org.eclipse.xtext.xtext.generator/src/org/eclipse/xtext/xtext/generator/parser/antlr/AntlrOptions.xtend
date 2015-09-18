/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrParserSplitter
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.PartialClassExtractor

@Accessors
class AntlrOptions {
	boolean backtrack = false
	boolean backtrackLexer = false
	boolean memoize = false
	int k = -1
	boolean ignoreCase = false
	boolean classSplitting = false
	int fieldsPerClass = AntlrParserSplitter.FIELDS_PER_CLASS
	int methodsPerClass = PartialClassExtractor.METHODS_PER_CLASS
	boolean skipUnusedRules = false
	boolean optimizeCodeQuality = true
	boolean stripAllComments = false
	String keptBitSetsPattern
	String keptBitSetName

	def void setFieldsPerClass(String fieldsPerClass) {
		this.fieldsPerClass = Integer.parseInt(fieldsPerClass)
	}

	def void setMethodsPerClass(String methodsPerClass) {
		this.methodsPerClass = Integer.parseInt(methodsPerClass)
	}

	def void setKAsString(String k) {
		this.k = Integer.parseInt(k)
	}

}

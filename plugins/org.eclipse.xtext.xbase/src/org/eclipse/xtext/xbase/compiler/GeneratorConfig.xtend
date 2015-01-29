/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Holger Schill - Initial contribution and API
 * @author Miro Spoenemann
 */
@Accessors
class GeneratorConfig {

	/**
	 * Whether expressions shall be generated.
	 */
	boolean generateExpressions = true

	/**
	 * Whether <code>@SuppressWarnings</code> shall be generated for non-nested types.
	 */
	boolean generateSyntheticSuppressWarnings = true
	
	/**
	 * Whether <code>@Generated</code> shall be generated for non-nested types.
	 */
	boolean generateGeneratedAnnotation = false
	
	/**
	 * Whether the current time shall be added to <code>@Generated</code> annotations.
	 */
	boolean includeDateInGeneratedAnnotation = false
	
	/**
	 * The comment that is added to <code>@Generated</code> annotations, also supports variables:
	 * <ul>
	 *   <li><code>${sourcefile}</code></li>
	 * </ul>
	 */
	String generatedAnnotationComment

	/**
	 * The target Java language version.
	 */
	JavaVersion targetVersion = JavaVersion.JAVA5
	
	/**
	 * Copy the values of the given generator configuration.
	 */
	def copy(GeneratorConfig other) {
		this.generateExpressions = other.generateExpressions
		this.generateSyntheticSuppressWarnings = other.generateSyntheticSuppressWarnings
		this.generateGeneratedAnnotation = other.generateGeneratedAnnotation
		this.includeDateInGeneratedAnnotation = other.includeDateInGeneratedAnnotation
		this.generatedAnnotationComment = other.generatedAnnotationComment
		this.targetVersion = other.targetVersion
		return this
	}

}
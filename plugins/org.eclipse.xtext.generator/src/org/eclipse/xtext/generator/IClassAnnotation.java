/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

/**
 * Class annotations can be added to the {@link Generator} workflow component in order to configure
 * specific Java annotations to be added to each generated class.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.8
 */
public interface IClassAnnotation {
	
	/**
	 * Convert the class annotation to a string suitable for use in Java code generation.
	 */
	@Override
	String toString();
	
	/**
	 * Return the qualified name of the annotation interface for use in import declarations,
	 * or {@code null} if no import is required.
	 */
	String getAnnotationImport();

}

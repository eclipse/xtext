/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.MutableElement;

/**
 * Associates generated Java elements with their source Xtend elements 
 * @since 2.7
 * @noimplement This interface is not intended to be implemented by clients.
 * @see Tracability
 */
public interface Associator {
	/**
	 * Associates the generate element with the Xtend source code. Every generated element should have
	 * a source element. This information is used by features like "Go to Declaration" and the outline view.
	 * A typical use case (generating a getter for a field) would look like this:
	 * 
	 * <pre>
	 * myClass.declaredFields.forEach[field|
	 *  myClass.addMethod("get" + field.simpleName.toFirstUpper) [
	 *   primarySourceElement = field
	 *   // return type, body etc...
	 *  ]
	 * ]
	 * </pre>
	 * 
	 * This way, the getter generated in the active annotation above would be associated with the field in the Xtend source code.
	 * Notice that we passed the field from the Java AST as a source element. This is a shortcut for
	 * 
	 * <pre>
	 * primarySourceElement = field.primarySourceElement
	 * </pre>
	 * 
	 * @param sourceElement the source element that the secondaryElement was derived from
	 * @param javaElement the generated Java element 
	 */
	void setPrimarySourceElement(MutableElement javaElement, Element sourceElement);
}

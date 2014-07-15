/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;

import com.google.common.annotations.Beta;

/**
 * 
 * Support for navigating between the primary AST structure representing the Xtend code
 * and the corresponding Java elements derived from that.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 * @see Associator
 */
@Beta
public interface Tracability {
	
	/**
	 * @deprecated use {@link #isSource(Element)}
	 */
	boolean isSource(NamedElement element);
	
	/**
	 * @deprecated use {@link #isGenerated(Element)}
	 */
	boolean isGenerated(NamedElement element);
	
	/**
	 * @deprecated use {@link #isExternal(Element)}
	 */
	boolean isExternal(NamedElement element);
	
	/**
	 * @deprecated use {@link #getPrimaryGeneratedJavaElement(Element)}
	 */
	NamedElement getPrimaryGeneratedJavaElement(NamedElement source);
	/**
	 * @deprecated use {@link #isThePrimaryGeneratedJavaElement(Element)}
	 * @since 2.7
	 */
	boolean isThePrimaryGeneratedJavaElement(NamedElement target);
	
	/**
	 * @deprecated use {@link #getPrimarySourceElement(Element)}
	 * @since 2.7
	 */
	NamedElement getPrimarySourceElement(NamedElement target);
	
	/**
	 * @param element
	 * @return whether the given element is a source (i.e Xtend) element.
	 * @since 2.7
	 */
	boolean isSource(Element element);
	
	/**
	 * @param element
	 * @return whether the given element is a Java element derived from the currently processed {@link CompilationUnit}
	 * @since 2.7
	 */
	boolean isGenerated(Element element);
	
	/**
	 * @param element
	 * @return whether the given element is a Java element <b>not</b> derived from the currently processed {@link CompilationUnit}
	 * @since 2.7
	 */
	boolean isExternal(Element element);
	
	/**
	 * @param source
	 * @return the primary generated element (Java) derived from the given source element (Xtend).
	 * @since 2.7
	 */
	Element getPrimaryGeneratedJavaElement(Element source);
	/**
	 * @since 2.7
	 * @param target
	 * @return whether this element was already present in the Xtend source AST.
	 */
	boolean isThePrimaryGeneratedJavaElement(Element target);
	
	/**
	 * @param target
	 * @return the source element (Xtend) the given target (Java) element is derived from
	 * @since 2.7
	 */
	Element getPrimarySourceElement(Element target);
}

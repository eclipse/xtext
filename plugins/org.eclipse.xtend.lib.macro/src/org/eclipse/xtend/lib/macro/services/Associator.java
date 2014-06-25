package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.NamedElement;

/**
 * Associates generated Java elements with their source Xtend elements 
 * @since 2.7
 * @noimplement This interface is not intended to be implemented by clients.
 * @see Tracability
 */
public interface Associator {
	/**
	 * @param generatedElement the generated Java element
	 * @param sourceElement the source Xtend element
	 * @throws IllegalArgumentException if generatedElement is note a Java element or sourceElement is not an Xtend element 
	 */
	void setPrimarySourceElement(NamedElement generatedElement, NamedElement sourceElement);
}

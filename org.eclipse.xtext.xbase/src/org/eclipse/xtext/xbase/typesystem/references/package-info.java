/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
/**
 * Lightweight representations for the various
 * {@link org.eclipse.xtext.common.types.JvmTypeReference}
 * which offer some rich API.
 *  
 * Lightweight type references that are not forced to be contained in a 
 * unique {@link org.eclipse.emf.ecore.EObject#eContainer() container} but can
 * be used independently from EMF containment constraints.
 * 
 * Most clients should never be forced to use an interface different of the
 * {@link org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference}.
 * It offers various methods to be introspected, converted or explored.
 * 
 * Main use cases that are already adressed on this primary API are
 * 
 * <ul>
 *   <li>Query for assignability</li>
 *   <li>Obtain super types and explore the type hierarchy</li>
 *   <li>Convert to synonyms, e.g. lists or arrays</li>
 *   <li>Compute the bounds of a reference</li>
 * </ul>
 * 
 * Even though a lightweight type reference may be used in various places,
 * there exists the notion of an {@link org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner owner}.
 * The owner offers access to a resource set and some services that allow to
 * customize the beviour and logic of type references by means of Google guice.
 * That's why all references must be associated with such an owner.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
package org.eclipse.xtext.xbase.typesystem.references;
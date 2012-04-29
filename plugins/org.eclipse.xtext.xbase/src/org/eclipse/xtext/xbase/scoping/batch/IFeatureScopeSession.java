/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@NonNullByDefault
@ImplementedBy(RootFeatureScopeSession.class)
public interface IFeatureScopeSession {

	/*
		 * initialize with 
		 * this, super, fields falls vorhanden (z.b. nicht in annotations)
		 *   - jmd überprüft die fields auf extension field semantic, d.h.
		 *   - auch imports hier übergeben
		 *   - wir übergeben die DomainSpeciifc elements und jmd packt die 
		 *     inferierten jvm elements in die scope session
		 * 
		 * fork
		 *   - add element (impliziter fork?)
		 *   - add elements?
		 *   
		 * jmd verwaltet diese elemente (parameter und leitet daraus die implizit 
		 *   erreichbaren element ab, so dass diese stets und ständig sichtbar sind)
		 *   diese werden sortiert und gebulkt, d.h.
		 *   it -> this -> alle extension fields -> statische imports -> implizite imports
		 *   
		 *   - ergänzt jemand etwas, wird die current values liste verändert
		 *   
		 * simple feature call scoping und extension scoping bei member feature calls
		 *   und assignments wird auf diese menge der bekannten identifier runtergebrochen
		 *   
		 * typdaten müssen auf der session gesetzt werden, d.h. wir erfragen an einer
		 *   zentralen instanz die an den current intermediate state delegiert
		 *   - diese sollte beim starten der session gesetzt werden
		 *   - ist die batch scope geschichte vllt typesystemspezifisch?
		 *   
		 */

	IFeatureScopeSession addTypesToStaticScope(List<JvmType> staticFeatureProviders, List<JvmType> extensionProviders);
	
	IFeatureScopeSession addToExtensionScope(JvmIdentifiableElement baseElement, List<XExpression> extensionProviders);
	
	IFeatureScopeSession addLocalElement(QualifiedName name, JvmIdentifiableElement element);
	
	IFeatureScopeSession addLocalElements(Map<QualifiedName, JvmIdentifiableElement> elements);
	
	IScope createFeatureCallScope(EObject context, EReference reference, IResolvedTypes resolvedTypes);
	
	@Nullable IEObjectDescription getLocalElement(QualifiedName name);
	Collection<IEObjectDescription> getLocalElements();

	List<TypeBucket> getStaticallyImportedTypes();
	List<TypeBucket> getStaticallyImportedExtensionTypes();

	IFeatureScopeSession recursiveInitialize(EObject context);

	IScope getScope(XExpression expression, EReference reference, IResolvedTypes types);

}

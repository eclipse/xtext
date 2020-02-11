/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/

package org.eclipse.xtext.parser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class BaseEPackageAccess {

	public static EPackage getEPackageFromRegistry(String string) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(string);
		if (ePackage == null)
			throw new IllegalStateException("couldn't load EPackage for URI '" + string + "'");
		return ePackage;
	}

	public static EPackage loadEcoreFile(ClassLoader loader, String string) {
		URI uri = URI.createURI(string);
		if (!uri.hasFragment())
			uri = uri.appendFragment("/");
		URI normalized = new ClassloaderClasspathUriResolver().resolve(loader, uri);
		return (EPackage) new ResourceSetImpl().getEObject(normalized, true);
	}

	public static Object loadGrammarFile(String string, XtextResourceSet resourceSet) {
		Resource resource = loadResource(string, resourceSet);
		return resource.getContents().get(0);
	}

	public static Resource loadResource(String string, XtextResourceSet resourceSet) {
		URI uri = URI.createURI(string);
		Resource resource;
		try {
			resource = resourceSet.getResource(uri, true);
			if (resource == null) {
				throw new IllegalArgumentException("Couldn't create resource for URI : " + uri);
			}
		} catch (Exception e) {
			throw new WrappedException(e);
		}
		EList<EObject> contents = resource.getContents();
		if (contents.size() < 1) {
			throw new IllegalStateException("loading classpath:" + string + " : Expected at least root element but found "
					+ contents.size());
		}
		return resource;
	}

}

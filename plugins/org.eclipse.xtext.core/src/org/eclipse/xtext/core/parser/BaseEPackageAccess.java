/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.core.parser;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class BaseEPackageAccess {
	public static EPackage get(String string) {
		EPackage package1 = EPackage.Registry.INSTANCE.getEPackage(string);
		if (package1 == null)
			throw new IllegalStateException("couldn't load EPackage for URI '"+string+"'");
		return package1;
	}
	
	protected static Resource loadResource(ClassLoader loader, String string) {
		InputStream in = loader.getResourceAsStream(string);
		if (in ==null) 
			throw new IllegalArgumentException("Couldn't load resource from classpath : "+string);
		URI uri = URI.createURI("classpath:/"+string);
		Resource resource = new ResourceSetImpl().createResource(uri);
		if (resource ==null) 
			throw new IllegalArgumentException("Couldn't create resource for URI : "+uri);
		try {
			resource.load(in, null);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		EList<EObject> contents = resource.getContents();
		if (contents.size()!=1) {
			throw new IllegalStateException("loading classpath:"+string+" : Expected one root element but found "+contents.size());
		}
		return resource;
	}
	
	protected static EPackage loadEcoreFile(ClassLoader loader, String string) {
		Resource resource = loadResource(loader, string);
		return (EPackage) resource.getContents().get(0);
	}
	
	protected static Object loadGrammarFile(ClassLoader loader, String string) {
		Resource resource = loadResource(loader, string);
		return resource.getContents().get(0);
	}
}

/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.FileNotFoundOnClasspathException;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class GrammarProvider {

	private final String languageName;

	private volatile Grammar grammar;

	private final Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject(optional=true)
	private ClassLoader classLoader;

	@Inject
	public GrammarProvider(@Named(Constants.LANGUAGE_NAME) String languageName, Provider<XtextResourceSet> resourceSetProvider) {
		this.languageName = languageName;
		this.resourceSetProvider = resourceSetProvider;
	}

	public Grammar getGrammar(Object requestor) {
		if (grammar==null) {
			XtextPackage.eINSTANCE.getClass();
			// comment shameless copied from Scopes.Singleton
			// DCL on a volatile is safe as of Java 5, which we obviously require.
			synchronized(this) {
				if (grammar == null) {
					XtextResourceSet resourceSet = resourceSetProvider.get();
					if (classLoader != null) {
						resourceSet.setClasspathURIContext(classLoader);
					} else {
						final ClassLoader classLoaderToUse = requestor == null ? getClass().getClassLoader() : requestor.getClass().getClassLoader();
						resourceSet.setClasspathURIContext(classLoaderToUse);
					}
					String fileWithoutExt = ClasspathUriUtil.CLASSPATH_SCHEME + ":/" + languageName.replace('.', '/');
					try {
						grammar = (Grammar) BaseEPackageAccess.loadGrammarFile(fileWithoutExt + ".xtextbin", resourceSet);
						EcoreUtil.resolveAll(grammar.eResource());
					} catch (RuntimeException e) {
						Throwable cause = e;
						while (cause.getCause() != null)
							cause = cause.getCause();
						if (cause instanceof FileNotFoundOnClasspathException) {
							grammar = (Grammar) BaseEPackageAccess.loadGrammarFile(fileWithoutExt + ".xmi", resourceSet);
						} else
							throw e;
					}
				}
			}
		}
		return grammar;
	}
	
	/**
	 * Public for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 2.9
	 */
	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
}

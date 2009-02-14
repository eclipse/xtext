/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.resource.ClasspathUriUtil;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class GrammarProvider {

	private final String languageName;

	private volatile Grammar grammar;

	@Inject
	public GrammarProvider(@Named(Constants.LANGUAGE_NAME) String languageName) {
		this.languageName = languageName;
	}

	public Grammar getGrammar(Object requestor) {
		if (grammar==null) {
			XtextPackage.eINSTANCE.getClass();
			// comment shameless copied from Scopes.Singleton
			// DCL on a volatile is safe as of Java 5, which we obviously require.
			synchronized(this) {
				if (grammar == null) {
					grammar = (Grammar) BaseEPackageAccess.loadGrammarFile(
							requestor == null ? getClass().getClassLoader() : requestor.getClass().getClassLoader(),
							ClasspathUriUtil.CLASSPATH_SCHEME + ":/" + languageName.replace('.', '/') + ".xmi");
				}
			}
		}
		return grammar;
	}
}

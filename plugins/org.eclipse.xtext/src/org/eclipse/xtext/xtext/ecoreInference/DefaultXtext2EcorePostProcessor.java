/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.xtend.XtendResourceParser;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.util.Strings;

public class DefaultXtext2EcorePostProcessor implements IXtext2EcorePostProcessor {

	private static final Logger log = Logger.getLogger(DefaultXtext2EcorePostProcessor.class);

	private ExecutionContextImpl ctx;

	public void process(GeneratedMetamodel metamodel) {
		ExecutionContext ctx = getExecutionContext();
		Resource xtendFile = loadXtendFile(metamodel);
		if (xtendFile != null) {
			ctx = ctx.cloneWithResource(xtendFile);
			try {
				final Object[] params = new Object[] { metamodel };
				Extension extension = ctx.getExtension("process", params);
				if (extension != null) {
					extension.evaluate(params, ctx);
				}
			}
			catch (EvaluationException e) {
				log.error("Error encountered processing metamodel " + metamodel.getName() + " with "
						+ xtendFile.getFullyQualifiedName(), e);
			}
		}
	}

	protected ExecutionContext getExecutionContext() {
		if (ctx == null) {
			ctx = new ExecutionContextImpl();
			ctx.registerMetaModel(new EmfRegistryMetaModel());
			ctx.registerMetaModel(new JavaBeansMetaModel());
		}
		return ctx;
	}

	protected Resource loadXtendFile(GeneratedMetamodel metamodel) {
		final String extension = getExtensionName(metamodel);
		try {
			org.eclipse.emf.ecore.resource.Resource grammarResource = metamodel.eResource();
			URI uri = grammarResource.getURI();
			URIConverter uriConverter = grammarResource.getResourceSet().getURIConverter();
			// check if uri can be used for resolve
			if (!uri.isHierarchical() || uri.isRelative())
				return null;
			uri = URI.createURI(Strings.lastToken(extension, "::")).appendFileExtension(XtendFile.FILE_EXTENSION).resolve(uri);

			if (!uriConverter.exists(uri, null))
				return null;

			InputStream in = uriConverter.createInputStream(uri);
			XtendResourceParser parser = new XtendResourceParser();
			Resource xtendFile = parser.parse(new InputStreamReader(in), extension + '.' + XtendFile.FILE_EXTENSION);
			return xtendFile;
		}
		catch (ClasspathUriResolutionException e) {
			// no xtend file found
		}
		catch (Exception e) {
			log.error("Could not parse " + extension, e);
		}
		return null;
	}

	protected String getExtensionName(GeneratedMetamodel metamodel) {
		final Grammar grammar = (Grammar) metamodel.eContainer();
		final String extension = grammar.getName().replace(".", "::") + "PostProcessor";
		return extension;
	}

}
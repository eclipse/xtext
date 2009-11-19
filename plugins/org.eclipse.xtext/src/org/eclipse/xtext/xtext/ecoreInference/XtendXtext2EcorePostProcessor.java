/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import static org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory.getCurrentThreadResourceLoader;
import static org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory.setCurrentThreadResourceLoader;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.mwe.core.resources.ResourceLoader;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
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

/**
 * Xtend strategy for interface {@link IXtext2EcorePostProcessor} which delegates the actual post-processing behavior to
 * an <code>Xtend</code> based implementation.
 * 
 * @author Knut Wannheden - Initial contribution and API
 * @author Michael Clay
 */
public class XtendXtext2EcorePostProcessor implements IXtext2EcorePostProcessor {

	// logger is available to sublasses
	protected static final Logger logger = Logger.getLogger(XtendXtext2EcorePostProcessor.class);
	private ExecutionContext executionContext;

	public void process(GeneratedMetamodel metamodel) {
		Resource xtendFile = loadXtendFile(metamodel);
		if (xtendFile != null) {
			ExecutionContext ctx = getExecutionContext(metamodel);
			ctx = ctx.cloneWithResource(xtendFile);
			ResourceLoader currentThreadResourceLoader = null;
			try {
				currentThreadResourceLoader = getCurrentThreadResourceLoader();
				final Object[] params = new Object[] { metamodel };
				Extension extension = ctx.getExtension("process", params);
				if (extension != null) {
					setCurrentThreadResourceLoader(getResourceLoader(metamodel));
					extension.evaluate(params, ctx);
				}
			}
			catch (EvaluationException e) {
				logger.error("Error encountered processing metamodel " + metamodel.getName() + " with "
						+ xtendFile.getFullyQualifiedName(), e);
			}
			finally {
				setCurrentThreadResourceLoader(currentThreadResourceLoader);
			}
		}
	}

	/**
	 * @param metamodel
	 *            the metamodel to augment
	 * @return the resource loader used to load resources during the xtend processing
	 */
	protected ResourceLoader getResourceLoader(GeneratedMetamodel metamodel) {
		return ResourceLoaderFactory.createResourceLoader();
	}

	/**
	 * @param metamodel
	 *            the metamodel to augment
	 * @return the executionContext used to perform the xtend processing
	 */
	protected ExecutionContext getExecutionContext(GeneratedMetamodel metamodel) {
		if (executionContext == null) {
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.registerMetaModel(new EmfRegistryMetaModel());
			executionContext.registerMetaModel(new JavaBeansMetaModel());
			this.executionContext = executionContext;
		}
		return executionContext;
	}

	/**
	 * Expects an Xtend file named <code>MyDsl</code>PostProcessor.ext with an extension with signature
	 * process(xtext::GeneratedMetamodel) in the same folder as the grammar file.
	 * 
	 * @param metamodel
	 *            the metamodel to augment
	 * @return the xtendFile to execute
	 */
	protected Resource loadXtendFile(GeneratedMetamodel metamodel) {
		final String extension = getExtensionName(metamodel);
		try {
			URI uri = getXtendFileLocation(metamodel);
			if (uri == null)
				return null;
			URIConverter uriConverter = metamodel.eResource().getResourceSet().getURIConverter();
			if (!uriConverter.exists(uri, null))
				return null;

			InputStream in = uriConverter.createInputStream(uri);
			try {
				XtendResourceParser parser = new XtendResourceParser();
				Resource xtendFile = parser.parse(new InputStreamReader(in), extension + '.' + XtendFile.FILE_EXTENSION);
				return xtendFile;
			} finally {
				if (in != null)
					in.close();
			}
		}
		catch (ClasspathUriResolutionException ignored) {
			// no xtend file found
		}
		catch (Exception e) {
			logger.error("Could not parse " + extension, e);
		}
		return null;
	}

	protected String getExtensionName(GeneratedMetamodel metamodel) {
		final Grammar grammar = (Grammar) metamodel.eContainer();
		final String extension = grammar.getName().replace(".", "::") + "PostProcessor";
		return extension;
	}

	protected URI getXtendFileLocation(GeneratedMetamodel metamodel) {
		URI uri = metamodel.eResource().getURI();
		// check if uri can be used for resolve
		if (!uri.isHierarchical() || uri.isRelative())
			return null;
		uri = URI.createURI(Strings.lastToken(getExtensionName(metamodel), "::")).appendFileExtension(
				XtendFile.FILE_EXTENSION).resolve(uri);
		return uri;
	}

}
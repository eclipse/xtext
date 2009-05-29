/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.scoping;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.DefaultScopeProvider;
import org.eclipse.xtext.xtend.AbstractXtendService;
import org.eclipse.xtext.xtend.NoSuchExtensionException;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * 
 * This scope provider must be configured with a qualified name to an Xtend file.
 * Therein the implementation will try to find and invoke extensions, with the following pattern
 * 
 * IScope scope_<ExpectedTypeName>(<MyContextType> ctx, EReference ref) : ...
 * 
 * Where
 * 1) ExpectedTypeName refers to ref.getEType().getName() and
 * 2) MyContextType refers to the type (or any super type) of the source element.
 * 
 * If no such declaration can be found it will sitch the ctx to ctx.eContainer and try again.
 * Example:
 * If you have Classes containing Features which have a cross reference to a Class.
 * The implementation will first look for
 * 
 * IScope scope_Class(Feature ctx,EReference ref) : ...
 * 
 * and if not found for
 * 
 * IScope scope_Class(Class ctx, EReference ref) : ...
 * 
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sven Efftinge
 * 
 */
public class XtendScopeProvider extends AbstractXtendService implements IScopeProvider {
	public final static String EXTENSION_FILE = "ScopeExtensions";

	private final String extensionFile;

	private final DefaultScopeProvider defaultScopeProvider;

	@Inject
	public XtendScopeProvider(@Named(EXTENSION_FILE) String name, DefaultScopeProvider defaultScopeProvider) {
		this.extensionFile = name;
		this.defaultScopeProvider = defaultScopeProvider;
	}

	private static Logger log = Logger.getLogger(XtendScopeProvider.class);

	private static final String SCOPE_EXTENSION_PREFIX = "scope_";

	public IScope getScope(EObject context, final EReference reference) {
		try {
			while (true) {
				Object result = null;
				try {
					String extensionName = extensionName(context, reference);
					result = invokeExtension(extensionName, Lists.newArrayList(context, reference));
				} catch (NoSuchExtensionException e) {
					// ignore
				}
				if (result != null)
					return (IScope) result;
				if (context.eContainer() != null)
					return getScope(context.eContainer(), reference);

				computeDefaultScope(context, reference);
			}
		} catch (Throwable e) {
			log.error("Error invoking scope extension", e);
		}
		return null;
	}
	
	public IScope getScope(EObject context, final EClass type) {
		try {
			while (true) {
				Object result = null;
				try {
					String extensionName = extensionName(context, type);
					result = invokeExtension(extensionName, Lists.newArrayList(context, type));
				} catch (NoSuchExtensionException e) {
					// ignore
				}
				if (result != null)
					return (IScope) result;
				if (context.eContainer() != null)
					return getScope(context.eContainer(), type);

				computeDefaultScope(context, type);
			}
		} catch (Throwable e) {
			log.error("Error invoking scope extension", e);
		}
		return null;
	}

	protected IScope computeDefaultScope(EObject ctx, EReference reference) {
		return this.defaultScopeProvider.getScope(ctx, reference);
	}
	
	protected IScope computeDefaultScope(EObject ctx, EClass type) {
		return this.defaultScopeProvider.getScope(ctx, type);
	}

	private String extensionName(EObject context, EReference reference) {
		return extensionName(context, reference.getEReferenceType());
	}

	private String extensionName(EObject context, EClass type) {
		return SCOPE_EXTENSION_PREFIX + type.getName();
	}
	
	@Override
	protected String getMasterXtendFileName() {
		return extensionFile;
	}

}

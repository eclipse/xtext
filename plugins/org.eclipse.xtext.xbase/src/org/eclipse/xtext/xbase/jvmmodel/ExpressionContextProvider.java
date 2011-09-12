/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ExpressionContextProvider implements IExpressionContextProvider, IExpressionContextAssociator {
	
	@Inject
	private OnChangeEvictingCache cache;
	
	protected Map<XExpression, JvmIdentifiableElement> getMapping(Resource resource) {
		return cache.get("expression-context", resource, new Provider<Map<XExpression, JvmIdentifiableElement>>() {
			public Map<XExpression, JvmIdentifiableElement> get() {
				return newLinkedHashMap();
			}
		});
	}
	
	public XExpression getAssociatedExpression(JvmIdentifiableElement element) {
		if (element == null)
			return null;
		Map<XExpression, JvmIdentifiableElement> mapping = getMapping(element.eResource());
		for (Map.Entry<XExpression, JvmIdentifiableElement> entry : mapping.entrySet()) {
			if (entry.getValue() == element) {
				return entry.getKey();
			}
		}
		return null;
	}

	public JvmIdentifiableElement getAssociatedJvmElement(XExpression expr) {
		if (expr == null)
			return null;
		final Map<XExpression, JvmIdentifiableElement> mapping = getMapping(expr.eResource());
		if (mapping.containsKey(expr)) {
			return mapping.get(expr);
		}
		return null;
	}
	
	public void associate(XExpression expression, JvmIdentifiableElement element) {
		if (expression == null)
			return;
		final Map<XExpression, JvmIdentifiableElement> mapping = getMapping(expression.eResource());
		if (mapping.containsKey(expression)) {
			throw new IllegalStateException("There is already a binding to the given expression "+expression);
		}
		mapping.put(expression, element);
	}
	
}

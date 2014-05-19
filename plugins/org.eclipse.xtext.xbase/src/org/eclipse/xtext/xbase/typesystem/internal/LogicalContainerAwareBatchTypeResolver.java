/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class LogicalContainerAwareBatchTypeResolver extends DefaultBatchTypeResolver {
	
	@Override
	protected List<EObject> getEntryPoints(EObject object) {
		Resource resource = object.eResource();
		List<EObject> contents = resource.getContents();
		List<EObject> result = Lists.newArrayList();
		for(EObject content: contents) {
			if (content instanceof JvmType) {
				result.add(content);
			}
		}
		return result;
	}

}

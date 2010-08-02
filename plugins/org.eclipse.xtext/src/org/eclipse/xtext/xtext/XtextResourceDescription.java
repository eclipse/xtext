/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import static com.google.common.collect.Iterables.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextResourceDescription extends DefaultResourceDescription {

	private final static Logger log = Logger.getLogger(XtextResourceDescription.class);
	
	public XtextResourceDescription(Resource resource, IQualifiedNameProvider nameProvider) {
		super(resource, nameProvider);
	}
	
	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		if (!getResource().isLoaded()) {
			try {
				getResource().load(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				return Collections.<IEObjectDescription> emptyList();
			}
		}
		Grammar grammar = (Grammar) getResource().getContents().get(0);
		List<EObject> exported = Lists.<EObject>newArrayList(grammar);
		exported.addAll(grammar.getMetamodelDeclarations());
		exported.addAll(grammar.getRules());
		Iterable<IEObjectDescription> result = transform(exported, new Function<EObject, IEObjectDescription>() {
			public IEObjectDescription apply(EObject from) {
				return createIEObjectDescription(from);
			}
		});
		Iterable<IEObjectDescription> filter = Iterables.filter(result, Predicates.notNull());
		return Lists.newArrayList(filter);
	}

}

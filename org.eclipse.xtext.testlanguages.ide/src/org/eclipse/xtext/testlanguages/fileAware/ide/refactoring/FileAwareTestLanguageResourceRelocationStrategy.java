/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.drop;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.head;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

public class FileAwareTestLanguageResourceRelocationStrategy implements IResourceRelocationStrategy {

	@Inject
	private IResourceServiceProvider resourceServiceProvider;

	public boolean canHandle(ResourceRelocationChange change) {
		return resourceServiceProvider.canHandle(change.getFromURI());
	}

	@Override
	public void applyChange(ResourceRelocationContext context) {
		filter(context.getChanges(), c -> canHandle(c)).forEach(change -> {
			context.addModification(change, resource -> {

				EObject rootElement = head(resource.getContents());
				if (rootElement instanceof PackageDeclaration) {
					List<String> segments = change.getToURI().trimSegments(1).segmentsList();
					String newPackage = Joiner.on(".").join(drop(segments, 2));
					((PackageDeclaration) rootElement).setName(newPackage);
				}
			});
		});
	}
}

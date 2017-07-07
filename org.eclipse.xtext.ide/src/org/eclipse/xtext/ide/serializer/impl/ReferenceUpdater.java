/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceSnapshot;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Delta;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.common.base.Objects;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ReferenceUpdater implements IReferenceUpdater {

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private IQualifiedNameConverter nameConverter;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IValueConverterService valueConverter;

	protected String findValidName(IUpdatableReference updatable, IScope scope) {
		Iterable<IEObjectDescription> elements = scope.getElements(updatable.getTargetEObject());
		String ruleName = linkingHelper.getRuleNameFrom(updatable.getCrossReference());
		for (IEObjectDescription desc : elements) {
			try {
				String unconverted = nameConverter.toString(desc.getName());
				String string = valueConverter.toString(unconverted, ruleName);
				return string;
			} catch (ValueConverterException e) {
				// do nothing
			}
		}
		return null;
	}

	@Override
	public boolean isAffected(Deltas deltas, RelatedResource resource) {
		for (IReferenceSnapshot ref : resource.outgoingReferences) {
			Delta delta = deltas.findContainingDelta(ref.getTarget().getObject());
			if (delta != null) {
				return true;
			}
		}
		return false;
	}

	protected boolean needsUpdating(Deltas deltas, EObject source, EObject target) {
		Delta sourceDelta = deltas.findContainingDelta(source);
		Delta targetDelta = deltas.findContainingDelta(target);
		return !Objects.equal(sourceDelta, targetDelta);
	}

	@Override
	public void update(IReferenceUpdaterContext context) {
		EObject root = context.getResource().getContents().get(0);
		Deltas deltas = context.getEObjectDescriptionDeltas();

		TreeIterator<EObject> iterator = EcoreUtil2.eAll(root);
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			for (EReference ref : next.eClass().getEAllReferences()) {
				if (ref.isContainment()) {
					continue;
				}
				Object value = next.eGet(ref);
				if (value instanceof List<?>) {
					List<?> targets = (List<?>) value;
					for (int i = 0; i < targets.size(); i++) {
						EObject t = (EObject) targets.get(i);
						if (needsUpdating(deltas, next, t)) {
							context.updateReference(next, ref, i);
						}
					}
				} else if (value instanceof EObject) {
					if (needsUpdating(deltas, next, (EObject) value)) {
						context.updateReference(next, ref);
					}
				}
			}
		}
	}

	@Override
	public void updateReference(ITextRegionDiffBuilder rewriter, IUpdatableReference upd) {
		IUpdatableReference updatable = (IUpdatableReference) upd;
		if (rewriter.isModified(updatable.getReferenceRegion())) {
			return;
		}
		IScope scope = scopeProvider.getScope(updatable.getSourceEObject(), updatable.getEReference());
		ISemanticRegion region = updatable.getReferenceRegion();
		QualifiedName oldName = nameConverter.toQualifiedName(region.getText());
		IEObjectDescription oldDesc = scope.getSingleElement(oldName);
		if (oldDesc != null && oldDesc.getEObjectOrProxy() == updatable.getTargetEObject()) {
			return;
		}
		String newName = findValidName(updatable, scope);
		rewriter.replace(region, newName);
	}
}

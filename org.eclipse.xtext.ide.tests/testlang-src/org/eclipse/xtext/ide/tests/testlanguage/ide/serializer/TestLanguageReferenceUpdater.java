/**
 * Copyright (c) 2019, 2020 TypeFox (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.serializer;

import com.google.inject.Inject;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;

/**
 * Customized reference updater to handle FQN renaming gracefully.
 * 
 * <p>
 * When renaming {@code Foo} to {@code Bar}, it follows the default logic, but
 * when renaming {@code my.type.Foo} to {@code Bar}, it will result in
 * {@code my.type.Bar} instead of {@code Bar}.
 */
public class TestLanguageReferenceUpdater extends ReferenceUpdater {
	@Inject
	private IQualifiedNameConverter nameConverter;

	@Inject
	@SerializerScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Override
	public void updateReference(ITextRegionDiffBuilder rewriter, IUpdatableReference ref) {
		if (rewriter.isModified(ref.getReferenceRegion())) {
			return;
		}
		IScope scope = scopeProvider.getScope(ref.getSourceEObject(), ref.getEReference());
		ISemanticRegion region = ref.getReferenceRegion();
		QualifiedName oldName = nameConverter.toQualifiedName(region.getText());
		IEObjectDescription oldDesc = scope.getSingleElement(oldName);
		if (oldDesc != null && oldDesc.getEObjectOrProxy() == ref.getTargetEObject()) {
			return;
		}
		String newName = findValidName(ref, scope);
		if (newName != null) {
			if (oldName.getSegmentCount() > 1) {
				newName = oldName.skipLast(1).append(newName).toString();
			}
			rewriter.replace(region, newName);
		}
	}
}

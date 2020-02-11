/*******************************************************************************
 * Copyright (c) 2019 TypeFox (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide.serializer

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding

/**
 * Customized reference updater to handle FQN renaming gracefully.
 * 
 * <p>
 * When renaming {@code Foo} to {@code Bar}, it follows the default logic,
 * but when renaming {@code my.type.Foo} to {@code Bar}, it will result
 * in {@code my.type.Bar} instead of {@code Bar}.
 */
class TestLanguageReferenceUpdater extends ReferenceUpdater {

	@Inject
	IQualifiedNameConverter nameConverter;

	@Inject
	@SerializerScopeProviderBinding
	IScopeProvider scopeProvider;

	override void updateReference(ITextRegionDiffBuilder rewriter, IUpdatableReference it) {
		if (rewriter.isModified(referenceRegion)) {
			return;
		}
		val scope = scopeProvider.getScope(sourceEObject, EReference);
		val region = referenceRegion;
		val oldName = nameConverter.toQualifiedName(region.text);
		val oldDesc = scope.getSingleElement(oldName);
		if (oldDesc !== null && oldDesc.EObjectOrProxy === targetEObject) {
			return;
		}
		var newName = findValidName(it, scope);
		if (newName !== null) {
			// Check if the original was a FQN. If so, "rename" the last segment only.
			if (oldName.segmentCount > 1) {
				newName = oldName.skipLast(1).append(newName).toString;
			}
			rewriter.replace(region, newName);
		}
	}

}

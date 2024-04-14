/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide.serializer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext;
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider;
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Import;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PartialSerializationTestLanguageReferenceUpdater extends ReferenceUpdater {
	@Inject
	private IQualifiedNameConverter converter;

	@Override
	public void update(IReferenceUpdaterContext context) {
		super.update(context);
		Node node = IterableExtensions.head(Iterables.filter(context.getResource().getContents(), Node.class));
		if (node == null) {
			return;
		}
		Set<Import> toDelete = new HashSet<>();
		Set<QualifiedName> toAdd = new HashSet<>();
		Map<Import, QualifiedName> toChange = new HashMap<>();
		Map<QualifiedName, Import> imports = IterableExtensions.toMap(node.getImports(),
				(Import it) -> converter.toQualifiedName(it.getImportedNamespace()));
		for (IUpdatableReference target : context.getUpdatableReferences()) {
			EObjectDescriptionDeltaProvider.Delta delta = this
					.findContainingDelta(context.getEObjectDescriptionDeltas(), target.getTargetEObject());
			if (delta != null) {
				QualifiedName original = IterableExtensions
						.head(delta.getSnapshot().getDescriptions()).getQualifiedName();
				QualifiedName modified = IterableExtensions.head(delta.getDescriptions())
						.getQualifiedName();
				if (!Objects.equals(original, modified)) {
					Import imp = imports.get(original);
					if (imp != null) {
						toChange.put(imp, modified);
					}
				}
			}
		}
		context.modifyModel(() -> {
			for (Import toDel : toDelete) {
				EcoreUtil.remove(toDel);
			}
			for (Map.Entry<Import, QualifiedName> toCh : toChange.entrySet()) {
				Import imp = toCh.getKey();
				QualifiedName name = toCh.getValue();
				imp.setImportedNamespace(converter.toString(name));
			}
			for (QualifiedName toA : toAdd) {
				Import newImport = PartialSerializationTestLanguageFactory.eINSTANCE.createImport();
				newImport.setImportedNamespace(converter.toString(toA));
				node.getImports().add(newImport);
			}
		});
	}
}

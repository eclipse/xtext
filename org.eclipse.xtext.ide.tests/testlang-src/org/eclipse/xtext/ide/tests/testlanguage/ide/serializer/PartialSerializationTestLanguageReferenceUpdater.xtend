/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide.serializer

import com.google.inject.Inject
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Import
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder
import org.eclipse.xtext.ide.serializer.hooks.IUpdatableReference
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class PartialSerializationTestLanguageReferenceUpdater extends ReferenceUpdater {

	@Inject IQualifiedNameConverter converter

	override update(IReferenceUpdaterContext context) {
		super.update(context)
		val node = context.resource.contents.filter(Node).head
		if (node === null || node.imports.isEmpty) {
			return
		}
		val toDelete = <Import>newHashSet
		val toAdd = <QualifiedName>newHashSet
		val toChange = <Import, QualifiedName>newHashMap()
		val imports = node.imports.toMap[converter.toQualifiedName(importedNamespace)]

		for (target : context.updatableReferences) {
			val delta = context.EObjectDescriptionDeltas.findContainingDelta(target.targetEObject)
			if (delta !== null) {
				val original = delta.snapshot.descriptions.head.qualifiedName
				val modified = delta.descriptions.head.qualifiedName
				if (original != modified) {
					val imp = imports.get(original)
					if (imp !== null) {
						toChange.put(imp, modified)
					}
				}
			}
		}
		if (!toDelete.isEmpty || !toAdd.isEmpty || !toChange.isEmpty) {
			context.modifyModel [
				for (toDel : toDelete) {
					EcoreUtil.remove(toDel)
				}
				for (toCh : toChange.entrySet) {
					val imp = toCh.key
					val name = toCh.value
					imp.importedNamespace = converter.toString(name)
				}
				for (toA : toAdd) {
					node.imports += PartialSerializationTestLanguageFactory.eINSTANCE.createImport => [
						importedNamespace = converter.toString(toA)
					]
				}
			]
		}
	}
}

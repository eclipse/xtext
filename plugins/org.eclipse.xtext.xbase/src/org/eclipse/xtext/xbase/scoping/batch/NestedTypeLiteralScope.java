/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeLiteralScope extends AbstractSessionBasedScope {

	private final JvmType outerType;
	private final LightweightTypeReference receiverType;
	private final Set<QualifiedName> importedNames;
	private final QualifiedName outerTypeName;
	private final QualifiedName outerTypeBinaryName;

	protected NestedTypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, LightweightTypeReference receiverType, JvmType outerType) {
		super(parent, session, featureCall);
		this.outerType = outerType;
		this.receiverType = receiverType;
		if (featureCall != null) {
			this.importedNames = ImportedNamesAdapter.findOrInstall(featureCall.eResource()).getImportedNames();
			this.outerTypeName = QualifiedName.create(outerType.getQualifiedName('.').split("\\."));
			this.outerTypeBinaryName = QualifiedName.create(outerType.getQualifiedName('$').split("\\."));
		} else {
			this.importedNames = null;
			this.outerTypeName = null;
			this.outerTypeBinaryName = null;
		}
	}

	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (importedNames != null) {
			importedNames.add(outerTypeName.append(name).toLowerCase());
			importedNames.add(outerTypeBinaryName.skipLast(1).append(outerTypeBinaryName.getLastSegment()+"$"+name).toLowerCase());
		}
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall.isExplicitOperationCallOrBuilderSyntax())
			return Collections.emptyList();
		if (outerType instanceof JvmDeclaredType && name.getSegmentCount() == 1) {
			String singleSegment = name.getFirstSegment();
			List<String> lookup = Collections.singletonList(singleSegment);
			if (singleSegment.indexOf('$') != -1) {
				lookup = Strings.split(singleSegment, '$');
			}
			JvmType result = findNestedType((JvmDeclaredType)outerType, lookup.iterator());
			if (result != null) {
				IEObjectDescription description = EObjectDescription.create(name, result);
				return Collections.<IEObjectDescription>singletonList(new TypeLiteralDescription(description, receiverType, isVisible(result)));
			}
		}
		return Collections.emptyList();
	}
	
	protected JvmType findNestedType(JvmDeclaredType outerType, Iterator<String> iterator) {
		String current = iterator.next();
		for(JvmMember member: outerType.getMembers()) {
			if (member instanceof JvmDeclaredType && member.getSimpleName().equals(current)) {
				if (iterator.hasNext()) {
					return findNestedType((JvmDeclaredType) member, iterator);
				}
				return (JvmDeclaredType) member;
			}
		}
		return null;
	}

	protected boolean isVisible(JvmType type) {
		if (type instanceof JvmMember)
			return getSession().isVisible((JvmMember) type);
		return true; // primitives et. al
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayListWithExpectedSize(2);
		if (outerType instanceof JvmDeclaredType) {
			for(JvmMember member: ((JvmDeclaredType) outerType).getMembers()) {
				if (member instanceof JvmDeclaredType) {
					IEObjectDescription description = EObjectDescription.create(member.getSimpleName(), member);
					result.add(new TypeLiteralDescription(description, receiverType, isVisible((JvmType) member)));
				}
			}
		}
		return result;
	}

}

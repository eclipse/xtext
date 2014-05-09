/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypesScope extends AbstractKnownTypesScope {

	private JvmDeclaredType innermost;

	public NestedTypesScope(JvmDeclaredType innermost, AbstractScope parent) {
		super(parent);
		this.innermost = innermost;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null) {
			return Collections.singletonList(result);
		}
		return super.getElements(name);
	}
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		JvmDeclaredType declarator = innermost;
		while(declarator != null) {
			if (EcoreUtil.isAncestor(declarator, type)) {
				doGetDescriptions(type, declarator, 0, result);
			}
			declarator = EcoreUtil2.getContainerOfType(declarator.eContainer(), JvmDeclaredType.class);
		}
			
		super.doGetElements(type, result);
	}

	@Override
	protected void doGetDescriptions(JvmType type, JvmType declarator, int index, List<IEObjectDescription> result) {
		String typeName = type.getQualifiedName('.');
		String declaratorName = declarator.getQualifiedName('.');
		int declaratorLength = declaratorName.length();
		String subName = typeName.substring(declaratorLength + 1);
		List<String> segments = Strings.split(subName, '.');
		result.add(EObjectDescription.create(QualifiedName.create(segments), type));
		result.add(EObjectDescription.create(subName.replace('.', '$'), type));
	}

	@Override
	protected IEObjectDescription doGetSingleElement(QualifiedName name, String firstSegment, int dollarIndex) {
		JvmDeclaredType declarator = innermost;
		while(declarator != null) {
			Iterable<JvmDeclaredType> nestedTypes = declarator.findAllTypesByName(firstSegment);
			for(JvmDeclaredType nested: nestedTypes) {
				JvmType nestedType = findNestedType(nested, 0, name);
				if (nestedType != null) {
					return toDescription(name, nestedType, dollarIndex, 0);
				}
			}
			declarator = EcoreUtil2.getContainerOfType(declarator.eContainer(), JvmDeclaredType.class);
		}
		if (dollarIndex > 0 && name.getSegmentCount() == 1) {
			QualifiedName splitted = QualifiedName.create(Strings.split(name.getFirstSegment(), '$'));
			IEObjectDescription result = doGetSingleElement(splitted);
			if (result != null) {
				return new AliasedEObjectDescription(name, result);
			}
		}
		return null;
	}

}
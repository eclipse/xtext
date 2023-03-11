/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * Renames synthetic elements to avoid name clashes. Dispatch methods are handled by validation.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SyntheticNameClashResolver {

	@Inject
	private IXtendJvmAssociations associations;

	public void resolveNameClashes(JvmGenericType type) {
		Multimap<String, JvmIdentifiableElement> classScope = HashMultimap.create();
		List<JvmMember> renameableMembers = newArrayList();
		int i = 1;
		for (JvmMember member : type.getMembers()) {
			String simpleName = member.getSimpleName();
			if (simpleName != null) {
				if (!isRenameable(member))
					classScope.put(simpleName, member);
				else
					renameableMembers.add(member);
			}
			if (member instanceof JvmFeature) {
				for(JvmGenericType localType: ((JvmFeature) member).getLocalClasses()) {
					localType.setSimpleName(localType.getSimpleName() + '_' + (i++));
				}
			}
		}
		for (JvmMember renameable : renameableMembers) {
			String simpleName = renameable.getSimpleName();
			if (collides(renameable, simpleName, classScope)) {
				int count = 0;
				String currentName;
				do {
					if (count == Integer.MAX_VALUE)
						throw new IllegalStateException("Cannot find a collision-free name for "
								+ renameable.getIdentifier());
					currentName = simpleName + "_" + ++count;
				} while (collides(renameable, currentName, classScope));
				renameable.setSimpleName(currentName);
				classScope.put(currentName, renameable);
			} else {
				classScope.put(simpleName, renameable);
			}
		}
	}

	/*
	 * @return true or false ;-)
	 */
	protected boolean collides(JvmIdentifiableElement element, String currentName,
			Multimap<String, JvmIdentifiableElement> scope) {
		if (scope.containsKey(currentName)) {
			if (element instanceof JvmOperation) {
				for (JvmIdentifiableElement other : scope.get(currentName)) {
					if (!(other instanceof JvmOperation)
							|| ((JvmOperation) element).getParameters().size() == ((JvmOperation) other)
									.getParameters().size())
						return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	protected boolean isRenameable(JvmIdentifiableElement element) {
		String simpleName = element.getSimpleName();
		if (!simpleName.startsWith("_")) {
			return false;
		}
		EObject source = associations.getPrimarySourceElement(element);
		return (isCreateExtension(source) && (simpleName
				.startsWith(XtendJvmModelInferrer.CREATE_CHACHE_VARIABLE_PREFIX) || simpleName
				.startsWith(XtendJvmModelInferrer.CREATE_INITIALIZER_PREFIX)))
				|| isAnonymousExtensionField(source);
	}

	protected boolean isAnonymousExtensionField(EObject source) {
		return source instanceof XtendField && ((XtendField) source).isExtension()
				&& isEmpty(((XtendField) source).getName());
	}

	protected boolean isCreateExtension(EObject source) {
		return source instanceof XtendFunction && ((XtendFunction) source).getCreateExtensionInfo() != null;
	}
}

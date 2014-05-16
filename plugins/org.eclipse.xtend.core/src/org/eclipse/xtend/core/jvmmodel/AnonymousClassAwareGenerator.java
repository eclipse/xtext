/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AnonymousClassAwareGenerator extends JvmModelGenerator {

	@Override
	protected Iterable<JvmMember> _getMembersToBeCompiled(JvmGenericType it) {
		if (it.isLocal() && !it.isAnonymous()) {
			Set<EObject> elements = getSourceElements(it);
			if (elements.size() == 1) {
				EObject element = elements.iterator().next();
				if (element instanceof AnonymousClass) {
					final JvmConstructor constructor = ((AnonymousClass) element).getConstructorCall().getConstructor();
					if (constructor.getParameters().size() >= 1) {
						return Iterables.filter(it.getMembers(), new Predicate<JvmMember>() {
							public boolean apply(JvmMember input) {
								if (input instanceof JvmConstructor) {
									return constructor == input; 
								}
								return true;
							}
						});
					}
				}
			}
		} 
		return super._getMembersToBeCompiled(it);
	}
	
}

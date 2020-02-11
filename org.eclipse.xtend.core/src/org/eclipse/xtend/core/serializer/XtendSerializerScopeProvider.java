/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.serializer;

import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.serializer.SerializerScopeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendSerializerScopeProvider extends SerializerScopeProvider {

	@Inject
	private AnonymousClassUtil anonymousClassUtil;
	
	@Override
	protected IScope doCreateConstructorCallSerializationScope(XConstructorCall context) {
		if (context.eContainer() instanceof AnonymousClass) {
			final AnonymousClass anonymousClass = (AnonymousClass) context.eContainer(); 
			final JvmType superType = anonymousClassUtil.getSuperType(anonymousClass);
			if(superType != null) {
				return createAnonymousClassConstructorScope(context, superType);
			}
		}
		return super.doCreateConstructorCallSerializationScope(context);
	}

}

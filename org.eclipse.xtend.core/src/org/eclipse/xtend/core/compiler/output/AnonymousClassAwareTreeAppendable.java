/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.compiler.output;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.compiler.AnonymousClassCompilerHelper;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

/**
 * A custom implementation that takes into consideration anonymous classes,
 * which, in some cases, cannot be compiled into standard Java anonymous classes:
 * they are compiled into nested local classes.
 * 
 * It uses a custom {@link LightweightTypeReferenceSerializer}.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class AnonymousClassAwareTreeAppendable extends TreeAppendable {

	private AnonymousClassCompilerHelper compilerHelper;

	public AnonymousClassAwareTreeAppendable(AnonymousClassCompilerHelper compilerHelper, ImportManager importManager, ITraceURIConverter converter,
			ILocationInFileProvider locationProvider, IJvmModelAssociations jvmModelAssociations, EObject source, String indentation,
			String lineSeparator) {
		super(importManager, converter, locationProvider, jvmModelAssociations, source, indentation, lineSeparator);
		this.compilerHelper = compilerHelper;
	}

	protected AnonymousClassAwareTreeAppendable(AnonymousClassCompilerHelper compilerHelper, SharedAppendableState state, ITraceURIConverter converter,
			ILocationInFileProvider locationProvider, IJvmModelAssociations jvmModelAssociations, Set<ILocationData> sourceLocations,
			boolean useForDebugging) {
		super(state, converter, locationProvider, jvmModelAssociations, sourceLocations, useForDebugging);
		this.compilerHelper = compilerHelper;
	}

	@Override
	protected LightweightTypeReferenceSerializer createLightweightTypeReferenceSerializer() {
		return new LightweightTypeReferenceSerializer(this) {
			@Override
			protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
				if (reference.isAnonymous() &&
						!compilerHelper.canCompileToJavaAnonymousClass(reference.getType())) {
					// serialize the type of the generated nested local class
					AnonymousClassAwareTreeAppendable.this.append(reference.getType());
				} else {
					super.doVisitParameterizedTypeReference(reference);
				}
			}
		};
	}

	@Override
	protected TreeAppendable createChild(SharedAppendableState state, ITraceURIConverter converter, ILocationInFileProvider locationProvider,
			IJvmModelAssociations jvmModelAssociations, Set<ILocationData> newData, boolean useForDebugging) {
		return new AnonymousClassAwareTreeAppendable(compilerHelper, state, converter, locationProvider, jvmModelAssociations, newData, useForDebugging);
	}

}

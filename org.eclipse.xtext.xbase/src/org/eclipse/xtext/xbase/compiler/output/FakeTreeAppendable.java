/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FakeTreeAppendable extends StringBuilderBasedAppendable implements ITreeAppendable {
	
	public FakeTreeAppendable() {
		super();
	}

	public FakeTreeAppendable(ImportManager typeSerializer, String indentation, String lineSeparator) {
		super(typeSerializer, indentation, lineSeparator);
	}

	public FakeTreeAppendable(ImportManager typeSerializer) {
		super(typeSerializer);
	}

	@Override
	public ITreeAppendable append(JvmType type) {
		super.append(type);
		return this;
	}
	
	@Override
	public ITreeAppendable append(Class<?> type) {
		super.append(type);
		return this;
	}
	
	@Override
	public ITreeAppendable append(CharSequence string) {
		super.append(string);
		return this;
	}
	
	@Override
	public ITreeAppendable append(LightweightTypeReference typeRef) {
		super.append(typeRef);
		return this;
	}
	
	@Override
	public ITreeAppendable decreaseIndentation() {
		super.decreaseIndentation();
		return this;
	}
	
	@Override
	public ITreeAppendable increaseIndentation() {
		super.increaseIndentation();
		return this;
	}
	
	@Override
	public ITreeAppendable newLine() {
		super.newLine();
		return this;
	}
	
	@Override
	public AbstractTraceRegion getTraceRegion() {
		throw new UnsupportedOperationException("FakeTreeAppendable cannot provide trace information");
	}

	@Override
	public ITreeAppendable trace(EObject object, boolean useForDebugging) {
		return this;
	}
	
	@Override
	public ITreeAppendable trace(ILocationData location) {
		return this;
	}
	
	@Override
	public ITreeAppendable trace(ILocationData location, boolean useForDebugging) {
		return this;
	}

	@Override
	public ITreeAppendable trace(Iterable<? extends EObject> objects) {
		return this;
	}
	
	@Override
	public ITreeAppendable trace(EObject object, EStructuralFeature feature, int indexInList) {
		return this;
	}

	@Override
	public ITreeAppendable trace(EObject object) {
		return this;
	}

	@Override
	public ErrorTreeAppendable errorChild() {
		throw new UnsupportedOperationException();
	}

}
/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TracingAppendable extends AbstractTraceRegion implements ITracingAppendable {

	protected static class ShiftedRegion extends AbstractTraceRegion {
		private final int relativeOffset;
		private final AbstractTraceRegion original;
		
		protected ShiftedRegion(final int relativeOffset, AbstractTraceRegion original, @Nullable AbstractTraceRegion parent) {
			super(parent);
			this.relativeOffset = relativeOffset;
			this.original = original;
			List<AbstractTraceRegion> nested = Lists.transform(original.getNestedRegions(), new Function<AbstractTraceRegion, AbstractTraceRegion>() {
				public AbstractTraceRegion apply(@Nullable AbstractTraceRegion input) {
					if (input == null)
						throw new IllegalArgumentException("input may not be null");
					return new ShiftedRegion(relativeOffset, input, ShiftedRegion.this);
				}
			});
			getWritableNestedRegions().addAll(nested);
		}

		@Override
		public int getToOffset() {
			return original.getToOffset();
		}

		@Override
		public int getToLength() {
			return original.getToLength();
		}
		@Override
		@Nullable
		public URI getToPath() {
			return original.getToPath();
		}
		@Override
		@Nullable
		public String getToProjectName() {
			return original.getToProjectName();
		}
		@Override
		public int getFromOffset() {
			return original.getFromOffset() + relativeOffset;
		}

		@Override
		public int getFromLength() {
			return original.getFromLength();
		}
	}

	private final ILocationInFileProvider locationProvider;
	private final IAppendable delegate;
	private int targetLength = -1;
	private Exception targetLengthCloser;
	private final int targetOffset;
	private TracingAppendable child;
	private URI sourceURI;
	private String sourceProject;
	private int sourceOffset;
	private int sourceLength;
	
	public TracingAppendable(IAppendable delegate, ILocationInFileProvider locationProvider) {
		super(null);
		this.delegate = delegate;
		this.locationProvider = locationProvider;
		this.targetOffset = delegate.length();
	}
	
	public TracingAppendable(IAppendable delegate, ILocationInFileProvider locationProvider, TracingAppendable parent) {
		super(parent);
		this.delegate = delegate;
		this.locationProvider = locationProvider;
		this.targetOffset = delegate.length();
	}
	
	protected TracingAppendable(IAppendable delegate, ILocationInFileProvider helper, EObject object, TracingAppendable parent) {
		this(delegate, helper);
		ITextRegion textRegion = helper.getSignificantTextRegion(object);
		URI uri = object.eResource().getURI();
		setTraceData(uri, null, textRegion.getOffset(), textRegion.getLength());
	}
	
	protected TracingAppendable(IAppendable delegate, ILocationInFileProvider helper, URI sourceURI, @Nullable String sourceProject, int offset, int length, TracingAppendable parent) {
		this(delegate, helper);
		setTraceData(sourceURI, sourceProject, offset, length);
	}
	
	protected TracingAppendable(IAppendable delegate, ILocationInFileProvider helper, URI sourceURI, int offset, int length, TracingAppendable parent) {
		this(delegate, helper);
		setTraceData(sourceURI, null, offset, length);
	}
	
	public List<AbstractTraceRegion> getTraceRegions(final int relativeOffset, @Nullable AbstractTraceRegion parent) {
		AbstractTraceRegion result = new ShiftedRegion(relativeOffset, this, parent);
		return Collections.singletonList(result);
	}
	
	public ITracingAppendable trace(EObject object) {
		closeRecentChild();
		TracingAppendable result = new TracingAppendable(delegate, locationProvider, object, this);
		child = result;
		return result;
	}
	
	public ITracingAppendable trace(URI sourceURI, int offset, int length) {
		closeRecentChild();
		TracingAppendable result = new TracingAppendable(delegate, locationProvider, sourceURI, offset, length, this);
		child = result;
		return result;
	}
	
	public ITracingAppendable trace(URI sourceURI, @Nullable String sourceProject, int offset, int length) {
		closeRecentChild();
		TracingAppendable result = new TracingAppendable(delegate, locationProvider, sourceURI, sourceProject, offset, length, this);
		child = result;
		return result;
	}
	
	protected void setTraceData(URI sourceURI, @Nullable String sourceProject, int sourceOffset, int sourceLength) {
		this.sourceURI = sourceURI;
		if (sourceProject != null) {
			this.sourceProject = sourceProject;
		} else {
			if (!sourceURI.isPlatformResource()) {
				// TODO see CharSequenceTraceWrapper, duplicate code
				sourceProject = "<unknown>";
			} else {
				sourceProject = sourceURI.segment(2);
			}
		}
		this.sourceOffset = sourceOffset;
		this.sourceLength = sourceLength;
	}

	@Override
	public int getFromLength() {
		if (targetLength != -1)
			return targetLength;
		return delegate.length() - getFromOffset();
	}
	
	@Override
	public int getFromOffset() {
		return targetOffset;
	}
	
	@Override
	public int getToLength() {
		return sourceLength;
	}
	
	@Override
	public int getToOffset() {
		return sourceOffset;
	}
	
	@Override
	public URI getToPath() {
		return sourceURI;
	}
	
	@Override
	public String getToProjectName() {
		return sourceProject;
	}
	
	protected void closeTraceRegion() {
		if (targetLength != -1)
			return;
		closeRecentChild();
		targetLength = length() - targetOffset;
		targetLengthCloser = new Exception();
		targetLengthCloser.fillInStackTrace();
	}

	protected void closeRecentChild() {
		if (targetLength != -1) {
			throw new IllegalStateException(targetLengthCloser);
		}
		if (child != null) {
			child.closeTraceRegion();
			List<AbstractTraceRegion> children = getWritableNestedRegions();
			if (child.targetLength == 0 && !children.isEmpty()) {
				if (children.get(children.size() - 1) == child)
					children.remove(children.size() - 1);
			}
		}
	}
	
	public IAppendable append(String string) {
		closeRecentChild();
		delegate.append(string);
		return this;
	}

	public IAppendable append(JvmType type) {
		closeRecentChild();
		delegate.append(type);
		return this;
	}

	public IAppendable newLine() {
		closeRecentChild();
		delegate.newLine();
		return this;
	}

	public IAppendable increaseIndentation() {
		closeRecentChild();
		delegate.increaseIndentation();
		return this;
	}

	public IAppendable decreaseIndentation() {
		closeRecentChild();
		delegate.decreaseIndentation();
		return this;
	}

	public List<String> getImports() {
		return delegate.getImports();
	}

	public void openScope() {
		delegate.openScope();
	}

	public void openPseudoScope() {
		delegate.openPseudoScope();
	}

	public String declareVariable(Object key, String proposedName) {
		return delegate.declareVariable(key, proposedName);
	}

	public String declareSyntheticVariable(Object key, String proposedName) {
		return delegate.declareSyntheticVariable(key, proposedName);
	}

	public String getName(Object key) {
		return delegate.getName(key);
	}
	
	public boolean hasName(Object key) {
		return delegate.hasName(key);
	}

	public Object getObject(String name) {
		return delegate.getObject(name);
	}
	
	public boolean hasObject(String name) {
		return delegate.hasObject(name);
	}

	public void closeScope() {
		delegate.closeScope();
	}

	@Override
	public String toString() {
		return delegate.toString();
	}
	
	public int length() {
		return delegate.length();
	}
}

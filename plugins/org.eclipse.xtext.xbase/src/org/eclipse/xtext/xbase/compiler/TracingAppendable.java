/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.LeafIterator;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class TracingAppendable extends AbstractTraceRegion implements ITracingAppendable, ITraceRegionProvider {

	protected static class ShiftedRegion extends AbstractTraceRegion {
		private final int relativeOffset;
		private final ITraceRegion original;

		protected ShiftedRegion(int relativeOffset, ITraceRegion original) {
			this.relativeOffset = relativeOffset;
			this.original = original;
		}

		public int getToOffset() {
			return original.getToOffset();
		}

		public int getToLength() {
			return original.getToLength();
		}

		public ITraceRegion getParent() {
			return original.getParent();
		}
		@Override
		public URI getToPath() {
			return original.getToPath();
		}
		@Override
		public String getToProjectName() {
			return original.getToProjectName();
		}
		@Override
		public List<ITraceRegion> getNestedRegions() {
			List<ITraceRegion> result = Lists.transform(super.getNestedRegions(), new Function<ITraceRegion, ITraceRegion>() {
				public ITraceRegion apply(ITraceRegion input) {
					return new ShiftedRegion(relativeOffset, original);
				}
			});
			return result;
		}
		public int getFromOffset() {
			return original.getFromOffset() + relativeOffset;
		}

		public int getFromLength() {
			return original.getFromLength();
		}
	}

	private final ILocationInFileProvider locationProvider;
	private final IAppendable delegate;
	private int targetLength = -1;
	private final int targetOffset;
	private TracingAppendable child;
	private TracingAppendable parent;
	private List<TracingAppendable> children;
	private URI sourceURI;
	private String sourceProject;
	private int sourceOffset;
	private int sourceLength;
	
	public TracingAppendable(IAppendable delegate, ILocationInFileProvider locationProvider) {
		this.delegate = delegate;
		this.locationProvider = locationProvider;
		this.targetOffset = delegate.length();
	}
	
	public TracingAppendable(IAppendable delegate, ILocationInFileProvider helper, EObject object) {
		this(delegate, helper);
		ITextRegion textRegion = helper.getSignificantTextRegion(object);
		URI uri = object.eResource().getURI();
		setTraceData(uri, null, textRegion.getOffset(), textRegion.getLength());
	}
	
	public TracingAppendable(IAppendable delegate, ILocationInFileProvider helper, URI sourceURI, String sourceProject, int offset, int length) {
		this(delegate, helper);
		setTraceData(sourceURI, sourceProject, offset, length);
	}
	
	public TracingAppendable(IAppendable delegate, ILocationInFileProvider helper, URI sourceURI, int offset, int length) {
		this(delegate, helper);
		setTraceData(sourceURI, null, offset, length);
	}
	
	public List<ITraceRegion> getTraceRegions(final int relativeOffset) {
		ITraceRegion result = new ShiftedRegion(relativeOffset, this);
		return Collections.singletonList(result);
	}
	
	public ITracingAppendable trace(EObject object) {
		TracingAppendable result = new TracingAppendable(delegate, locationProvider, object);
		result.setParent(this);
		return result;
	}
	
	public ITracingAppendable trace(URI sourceURI, int offset, int length) {
		TracingAppendable result = new TracingAppendable(delegate, locationProvider, sourceURI, offset, length);
		result.setParent(this);
		return result;
	}
	
	public ITracingAppendable trace(URI sourceURI, String sourceProject, int offset, int length) {
		TracingAppendable result = new TracingAppendable(delegate, locationProvider, sourceURI, sourceProject, offset, length);
		result.setParent(this);
		return result;
	}
	
	public List<ITraceRegion> getTraceRegions(int relativeOffset, ITraceRegion parent) {
		if (relativeOffset == 0)
			return null;
		return null;
	}
	
	protected void setParent(TracingAppendable parent) {
		parent.closeChildren();
		if (parent.children == null) {
			parent.children = Lists.newArrayList();
		}
		parent.children.add(this);
		parent.child = this;
		this.parent = parent;
	}

	protected void setTraceData(URI sourceURI, String sourceProject, int sourceOffset, int sourceLength) {
		this.sourceURI = sourceURI;
		if (sourceProject != null) {
			this.sourceProject = sourceProject;
		} else {
			if (!sourceURI.isPlatformResource()) {
				// TODO see CharSequenceTraceWrapper, duplicate code
				throw new IllegalArgumentException("Expected platform resource uri");
			}
			sourceProject = sourceURI.segment(2);
		}
		this.sourceOffset = sourceOffset;
		this.sourceLength = sourceLength;
	}

	public int getFromLength() {
		if (targetLength != -1)
			return targetLength;
		return delegate.length() - getFromOffset();
	}
	
	public int getFromOffset() {
		return targetOffset;
	}
	
	public int getToLength() {
		return sourceLength;
	}
	
	public int getToOffset() {
		return sourceOffset;
	}
	
	public ITraceRegion getParent() {
		return parent;
	}
	
	@Override
	public List<ITraceRegion> getNestedRegions() {
		if (children == null) {
			return Collections.emptyList();
		}
		return Collections.<ITraceRegion>unmodifiableList(children);
	}
	
	@Override
	public URI getToPath() {
		return sourceURI;
	}
	
	@Override
	public String getToProjectName() {
		return sourceProject;
	}
	
	@Override
	public Iterator<ITraceRegion> leafIterator() {
		if (children == null)
			return Collections.<ITraceRegion>singleton(this).iterator();
		return new LeafIterator(this);
	}
	
	protected void closeTraceRegion() {
		if (targetLength != -1)
			return;
		closeChildren();
		targetLength = length() - targetOffset;
	}

	protected void closeChildren() {
		if (targetLength != -1) {
			throw new IllegalStateException();
		}
		if (child != null) {
			child.closeTraceRegion();
		}
	}
	
	public IAppendable append(String string) {
		closeChildren();
		delegate.append(string);
		return this;
	}

	public IAppendable append(JvmType type) {
		closeChildren();
		delegate.append(type);
		return this;
	}

	public IAppendable newLine() {
		closeChildren();
		delegate.newLine();
		return this;
	}

	public IAppendable increaseIndentation() {
		closeChildren();
		delegate.increaseIndentation();
		return this;
	}

	public IAppendable decreaseIndentation() {
		closeChildren();
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

	public Object getObject(String name) {
		return delegate.getObject(name);
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

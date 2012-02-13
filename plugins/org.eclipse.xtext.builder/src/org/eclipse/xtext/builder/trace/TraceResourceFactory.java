/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceResourceFactory extends ResourceFactoryImpl {
	
	protected class Strategy implements TraceRegionSerializer.Strategy<DebugTraceRegion> {
		public DebugTraceRegion createResult(int fromOffset, int fromLength, int toOffset, int toLength,
				DebugTraceRegion parent, URI toPath, String toProject) {
			DebugTraceRegion result = TraceFactory.eINSTANCE.createDebugTraceRegion();
			result.setFromOffset(fromOffset);
			result.setFromLength(fromLength);
			result.setToOffset(toOffset);
			result.setToLength(toLength);
			result.setToPath(toPath);
			result.setToProject(toProject);
			if (parent != null)
				parent.getNestedRegions().add(result);
			return result;
		}

		public AbstractTraceRegion toRegion(final DebugTraceRegion t) {
			return new AbstractTraceRegion(null) {
				@Override
				public int getToOffset() {
					return t.getToOffset();
				}
				
				@Override
				public int getToLength() {
					return t.getToLength();
				}
				
				@Override
				public int getFromOffset() {
					return t.getFromOffset();
				}
				
				@Override
				public int getFromLength() {
					return t.getFromLength();
				}
				@Override
				public URI getToPath() {
					return t.getToPath();
				}
				@Override
				public String getToProjectName() {
					return t.getToProject();
				}
			};
		}

		public List<DebugTraceRegion> getChildren(DebugTraceRegion t) {
			return t.getNestedRegions();
		}
	}

	@Override
	public Resource createResource(URI uri) {
		Resource result = new ResourceImpl(uri) {
			@Override
			protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
				TraceRegionSerializer serializer = new TraceRegionSerializer();
				DebugTraceRegion result = serializer.doReadFrom(inputStream, new Strategy());
				getContents().add(result);
			}

			@Override
			protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
				TraceRegionSerializer serializer = new TraceRegionSerializer();
				serializer.doWriteTo(new Strategy(), (DebugTraceRegion) getContents().get(0), outputStream);
			}
		};
		return result;
	}
}

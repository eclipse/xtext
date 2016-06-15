/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import static com.google.common.collect.Sets.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.junit.Test;
/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class LineMappingNormalizationTest {
	
	private SourceRelativeURI source = new SourceRelativeURI(URI.createURI("source.dsl"));
	
	private class TestableLineMappingProvider extends LineMappingProvider {
		@Override
		public List<LineMapping> normalizeLineInfo(Set<LineMapping> lineData) {
			return super.normalizeLineInfo(lineData);
		}
	}
	
	private TestableLineMappingProvider support = new TestableLineMappingProvider() ;
	
	@Test
	public void testNomalization() {
		Set<LineMapping> mappings = newHashSet(
				new LineMapping(1,1,1,source),
				new LineMapping(2,5,5,source),
				new LineMapping(1,6,6,source),
				new LineMapping(3,7,8,source),
				new LineMapping(3,8,8,source));
		List<LineMapping> info = support.normalizeLineInfo(mappings);
		assertEquals(info.toString(), 4, info.size());
		
		assertEquals(1, info.get(0).sourceStartLine);
		assertEquals(1, info.get(0).targetStartLine);
		assertEquals(1, info.get(0).targetEndLine);
		
		assertEquals(2, info.get(1).sourceStartLine);
		assertEquals(5, info.get(1).targetStartLine);
		assertEquals(5, info.get(1).targetEndLine);
		
		assertEquals(1, info.get(2).sourceStartLine);
		assertEquals(6, info.get(2).targetStartLine);
		assertEquals(6, info.get(2).targetEndLine);
		
		assertEquals(3, info.get(3).sourceStartLine);
		assertEquals(7, info.get(3).targetStartLine);
		assertEquals(8, info.get(3).targetEndLine);
	}
	
}

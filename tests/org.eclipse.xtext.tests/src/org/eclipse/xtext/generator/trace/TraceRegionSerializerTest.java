/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceRegionSerializerTest {

	@Test
	public void testReadTraceVersion3() throws IOException {
		TraceRegionSerializer serializer = new TraceRegionSerializer();
		InputStream in = getClass().getResourceAsStream("version3.trace");
		AbstractTraceRegion traceRegion = serializer.readTraceRegionFrom(in);
		in.close();
		Assert.assertEquals("HelloWorld.xtend", traceRegion.getMergedAssociatedLocation().getPath().lastSegment());
		Assert.assertEquals(298, traceRegion.getMyLength());
		Assert.assertEquals(1, traceRegion.getNestedRegions().size());
		Assert.assertEquals(2, traceRegion.getNestedRegions().get(0).getNestedRegions().size());
	}

}

/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.ByteStreams;

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
		Assert.assertEquals("HelloWorld.xtend", traceRegion.getMergedAssociatedLocation().getSrcRelativePath().toString());
		Assert.assertEquals(298, traceRegion.getMyLength());
		Assert.assertEquals(1, traceRegion.getNestedRegions().size());
		Assert.assertEquals(2, traceRegion.getNestedRegions().get(0).getNestedRegions().size());
	}
	
	@Test
	public void testReadTraceVersion4() throws IOException {
		TraceRegionSerializer serializer = new TraceRegionSerializer();
		InputStream in = getClass().getResourceAsStream("version4.trace");
		AbstractTraceRegion traceRegion = serializer.readTraceRegionFrom(in);
		in.close();
		Assert.assertEquals("org/eclipse/xtext/java/JavaSourceLanguageSetup.xtend", traceRegion.getMergedAssociatedLocation().getSrcRelativePath().toString());
		Assert.assertEquals(1835, traceRegion.getMyLength());
		Assert.assertTrue(traceRegion.isUseForDebugging());
		Assert.assertEquals(1, traceRegion.getNestedRegions().size());
		Assert.assertEquals(7, traceRegion.getNestedRegions().get(0).getNestedRegions().size());
	}
	
	@Test
	public void testRewriteV3TracesWithCompressedInt() throws IOException {
		TraceRegionSerializer serializer = new TraceRegionSerializer();
		InputStream in = getClass().getResourceAsStream("version3.trace");
		byte[] v3bytes = ByteStreams.toByteArray(in);
		in.close();
		AbstractTraceRegion traceRegion = serializer.readTraceRegionFrom(new ByteArrayInputStream(v3bytes));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		serializer.writeTraceRegionTo(traceRegion, outputStream);
		byte[] currentBytes = outputStream.toByteArray();
		Assert.assertTrue(v3bytes.length > currentBytes.length);
		Assert.assertEquals(1213 /* magic number */, v3bytes.length); 
		Assert.assertEquals(385 /* magic number */, currentBytes.length);
		Assert.assertEquals(traceRegion, serializer.readTraceRegionFrom(new ByteArrayInputStream(currentBytes)));
	}
	
	@Test
	public void testRewriteV4TracesWithCompressedInt() throws IOException {
		TraceRegionSerializer serializer = new TraceRegionSerializer();
		InputStream in = getClass().getResourceAsStream("version4.trace");
		byte[] v4bytes = ByteStreams.toByteArray(in);
		in.close();
		AbstractTraceRegion traceRegion = serializer.readTraceRegionFrom(new ByteArrayInputStream(v4bytes));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		serializer.writeTraceRegionTo(traceRegion, outputStream);
		byte[] currentBytes = outputStream.toByteArray();
		Assert.assertTrue(v4bytes.length > currentBytes.length);
		Assert.assertEquals(4610 /* magic number */, v4bytes.length); 
		Assert.assertEquals(1655 /* magic number */, currentBytes.length);
		Assert.assertEquals(traceRegion, serializer.readTraceRegionFrom(new ByteArrayInputStream(currentBytes)));
	}

}

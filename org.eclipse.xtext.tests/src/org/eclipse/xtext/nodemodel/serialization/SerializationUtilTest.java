/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.junit.Assert;
import org.junit.Test;

/** @author Mark Christiaens */

public class SerializationUtilTest extends Assert {
	
	@Test
	public void testSyntaxErrorMessage() throws IOException {
		final String message = "hi";
		String [] issueCodes = { null, "issue" };
		String [][] issueDatas = { null, {null}, {"issue data"}};
		
		for (String[] issueData : issueDatas) {
			for (String issueCode : issueCodes) {
				SyntaxErrorMessage sem = new SyntaxErrorMessage(message, issueCode, issueData);
				ByteArrayOutputStream out = new ByteArrayOutputStream ();
				DataOutputStream dout = new DataOutputStream(out);
				SerializationUtil.writeSyntaxErrorMessage(dout, null, sem);
				dout.close();
				byte[] array = out.toByteArray();
				ByteArrayInputStream in = new ByteArrayInputStream(array); 
				DataInputStream din = new DataInputStream(in);
				SyntaxErrorMessage sem2 = SerializationUtil.readSyntaxErrorMessage(din, null);
				assertEquals(sem, sem2); 
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream ();
		DataOutputStream dout = new DataOutputStream(out);
		SerializationUtil.writeSyntaxErrorMessage(dout, null, null);
		dout.close();
		byte[] array = out.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(array); 
		DataInputStream din = new DataInputStream(in);
		SyntaxErrorMessage readMessage = SerializationUtil.readSyntaxErrorMessage(din, null);
		assertNull(readMessage);
	}
}

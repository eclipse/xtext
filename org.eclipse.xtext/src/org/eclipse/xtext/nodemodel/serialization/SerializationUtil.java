/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.serialization;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author mark.christiaens - Initial contribution and API
 * 
 * @since 2.3
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class SerializationUtil {
	public static final int KIB = 1024;
	
	public static void fillIdToEObjectMap(Resource resource, List<EObject> map) {
		TreeIterator<EObject> allContents = EcoreUtil.getAllContents(resource, false);  
				
		if (allContents.hasNext()) {
			EObject root = allContents.next();
			fillIdToEObjectMap(root, map);
		}
	}

	public static void fillIdToEObjectMap(EObject eObject, List<EObject> map) {
		if (eObject.eContainingFeature() == null || !eObject.eContainingFeature().isTransient()) {
			map.add(eObject);
			EList<EObject> eContents = eObject.eContents();

			for (EObject child : eContents) {
				fillIdToEObjectMap(child, map);
			}
		}
	}

	public static long milliDiff(long startLoad, long doneLoad) {
		return (doneLoad - startLoad) / 1000000;
	}

	public static String getCompleteContent(XtextResource xr) throws IOException, UnsupportedEncodingException {
		XtextResourceSet resourceSet = (XtextResourceSet) xr.getResourceSet();
		URIConverter uriConverter = resourceSet.getURIConverter();
		URI uri = xr.getURI();
		String encoding = xr.getEncoding();

		InputStream inputStream = null;

		try {
			inputStream = uriConverter.createInputStream(uri);

			return getCompleteContent(encoding, inputStream);
		} finally {
			tryClose(inputStream, null);
		}
	}

	public static String getCompleteContent(String encoding, InputStream inputStream)
			throws UnsupportedEncodingException, IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, encoding);

		StringBuilder sb = new StringBuilder (); 
		char[] buffer = new char[128 * KIB];

		int n = inputStreamReader.read(buffer);

		while (n != -1) {
			sb.append (buffer, 0, n);
			n = inputStreamReader.read(buffer);
		}

		return sb.toString();
	}
	
	public static byte [] getCompleteContent(InputStream inputStream)
			throws IOException {
		byte[] buffer = new byte[128 * KIB];
		int nextFreePos = 0; 
		int n = inputStream.read(buffer, nextFreePos, buffer.length - nextFreePos);
		while (n != -1) {
			nextFreePos += n; 
			if (nextFreePos >= buffer.length) {
				buffer = copyOf(buffer, buffer.length*2); 
			}
			n = inputStream.read(buffer, nextFreePos, buffer.length - nextFreePos);
		}
		
		return copyOf(buffer, nextFreePos);  
	}
	
	static byte[] copyOf(byte[] original, int newLength) {
        byte[] copy = new byte[newLength];
        System.arraycopy(original, 0, copy, 0,
                         Math.min(original.length, newLength));
        return copy;
    }

	public static void writeSyntaxErrorMessage(DataOutputStream out, SerializationConversionContext scc,
			SyntaxErrorMessage syntaxErrorMessage) throws IOException {
		if (syntaxErrorMessage == null) {
			out.writeBoolean(true);
		} else {
			out.writeBoolean(false);
			SerializationUtil.writeString(out, syntaxErrorMessage.getMessage());
			SerializationUtil.writeString(out, syntaxErrorMessage.getIssueCode());
			SerializationUtil.writeStringArray(out, syntaxErrorMessage.getIssueData());
		}
	}
	
	public static SyntaxErrorMessage readSyntaxErrorMessage(DataInputStream in, DeserializationConversionContext context)
			throws IOException {
		boolean isNull = in.readBoolean();
		if (isNull)
			return null;
		String message = SerializationUtil.readString(in);
		String issueCode = SerializationUtil.readString(in);
		String[] issueData = SerializationUtil.readStringArray(in);
		SyntaxErrorMessage result = new SyntaxErrorMessage(message, issueCode, issueData);
		return result;
	}

	static public int writeInt(DataOutputStream out, int value, boolean optimizePositive) throws IOException {
		if (!optimizePositive)
			value = (value << 1) ^ (value >> 31);
		if ((value & ~0x7F) == 0) {
			out.writeByte((byte) value);
			return 1;
		}
		out.writeByte((byte) ((value & 0x7F) | 0x80));
		value >>>= 7;
		if ((value & ~0x7F) == 0) {
			out.writeByte((byte) value);
			return 2;
		}
		out.writeByte((byte) ((value & 0x7F) | 0x80));
		value >>>= 7;
		if ((value & ~0x7F) == 0) {
			out.writeByte((byte) value);
			return 3;
		}
		out.writeByte((byte) ((value & 0x7F) | 0x80));
		value >>>= 7;
		if ((value & ~0x7F) == 0) {
			out.writeByte((byte) value);
			return 4;
		}
		out.writeByte((byte) ((value & 0x7F) | 0x80));
		value >>>= 7;
		out.writeByte((byte) value);
		return 5;
	}

	static public int readInt(DataInputStream in, boolean optimizePositive) throws IOException {
		for (int offset = 0, result = 0; offset < 32; offset += 7) {
			int b = in.readByte();
			result |= (b & 0x7F) << offset;
			if ((b & 0x80) == 0) {
				if (!optimizePositive)
					result = (result >>> 1) ^ -(result & 1);
				return result;
			}
		}
		throw new IOException("Malformed integer");
	}

	public static final void writeString(DataOutputStream out, String s) throws IOException {
		boolean isNull = s == null; 
		
		out.writeBoolean(isNull); 
		
		if (!isNull) {
			out.writeUTF(s);
		}
	}

	public static final String readString(DataInputStream in) throws IOException {
		boolean isNull = in.readBoolean();
	
		if (isNull) {
			return null;
		}
	
		String string = in.readUTF();
	
		return string;
	}

	public static void writeStringArray(DataOutputStream out, String[] ss) throws IOException {
		out.writeBoolean(ss == null);
		if (ss != null) {
			writeInt(out, ss.length, true); 
			for (String data : ss) {
				writeString(out, data);
			}
		}
	}

	public static String[] readStringArray(DataInputStream in) throws IOException {
		boolean isIssueDataNull = in.readBoolean();
		String[] result = null;
	
		if (!isIssueDataNull) {
			int issueDataLength = readInt(in, true); 
			result = new String[issueDataLength];
	
			for (int i = 0; i < issueDataLength; ++i) {
				result[i] = readString(in);
			}
		}
	
		return result;
	}
	
	public static void tryClose(Closeable stream, Logger logger) throws IOException {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception e) {
				if (logger != null) {
					logger.error("Could not close an stream for a cache entry: " + e, e);
				}
			}
		}
	}
}

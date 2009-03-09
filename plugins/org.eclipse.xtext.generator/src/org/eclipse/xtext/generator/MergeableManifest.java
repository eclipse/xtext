/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MergeableManifest extends Manifest {

	public static final Attributes.Name BUNDLE_NAME = new Attributes.Name("Bundle-Name");
	public static final Attributes.Name BUNDLE_SYMBOLIC_NAME = new Attributes.Name("Bundle-SymbolicName");
	public static final Attributes.Name BUNDLE_VERSION = new Attributes.Name("Bundle-Version");
	public static final Attributes.Name BUNDLE_CLASSPATH = new Attributes.Name("Bundle-ClassPath");
	public static final Attributes.Name BUNDLE_VENDOR = new Attributes.Name("Bundle-Vendor");
	public static final Attributes.Name BUNDLE_REQUIRED_EXECUTION_ENV = new Attributes.Name(
			"Bundle-RequiredExecutionEnvironment");
	public static final Attributes.Name EXPORT_PACKAGE = new Attributes.Name("Export-Package");
	public static final Attributes.Name REQUIRE_BUNDLE = new Attributes.Name("Require-Bundle");
	public static final Attributes.Name BUNDLE_ACTIVATION_POLICY = new Attributes.Name("Bundle-ActivationPolicy");
	public static final Attributes.Name BUNDLE_LOCALIZATION = new Attributes.Name("Bundle-Localization");

	public class OrderAwareAttributes extends Attributes {
		public OrderAwareAttributes() {
			try {
				Field field = Attributes.class.getDeclaredField("map");
				field.setAccessible(true);
				field.set(this, new LinkedHashMap<Object, Object>());
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}

		/*
		 * Copied from base class, but omitted call to make72Safe(buffer)
		 */
		@SuppressWarnings("deprecation")
		public void myWriteMain(DataOutputStream out) throws IOException {
			// write out the *-Version header first, if it exists
			String vername = Name.MANIFEST_VERSION.toString();
			String version = getValue(vername);
			if (version == null) {
				vername = Name.SIGNATURE_VERSION.toString();
				version = getValue(vername);
			}

			if (version != null) {
				out.writeBytes(vername + ": " + version + "\r\n");
			}

			// write out all attributes except for the version
			// we wrote out earlier
			Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Object, Object> e = it.next();
				String name = ((Name) e.getKey()).toString();
				if ((version != null) && !(name.equalsIgnoreCase(vername))) {

					StringBuffer buffer = new StringBuffer(name);
					buffer.append(": ");

					String value = (String) e.getValue();
					if (value != null) {
						byte[] vb = value.getBytes("UTF8");
						value = new String(vb, 0, 0, vb.length);
					}
					buffer.append(value);

					buffer.append("\r\n");
					// Manifest.make72Safe(buffer);
					out.writeBytes(buffer.toString());
				}
			}
			out.writeBytes("\r\n");
		}

		/*
		 * Copied from base class, but omitted call to make72Safe(buffer)
		 */
		@SuppressWarnings("deprecation")
		public void myWrite(DataOutputStream out) throws IOException {
			Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Object, Object> e = it.next();
				StringBuffer buffer = new StringBuffer(((Name) e.getKey()).toString());
				buffer.append(": ");

				String value = (String) e.getValue();
				if (value != null) {
					byte[] vb = value.getBytes("UTF8");
					value = new String(vb, 0, 0, vb.length);
				}
				buffer.append(value);

				buffer.append("\r\n");
				// Manifest.make72Safe(buffer);
				out.writeBytes(buffer.toString());
			}
			out.writeBytes("\r\n");
		}
	}

	/**
	 * @param resourceAsStream
	 * @throws IOException
	 */
	public MergeableManifest(InputStream in) throws IOException {
		try {
			Field field = Manifest.class.getDeclaredField("attr");
			field.setAccessible(true);
			field.set(this, new OrderAwareAttributes());
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		read(in);
	}

	/**
	 * adds the qualified names to the require-bundle attribute, if not already
	 * present.
	 *
	 * @param bundles - passing parameterized bundled (e.g. versions, etc.) is not supported
	 */
	public void addRequiredBundles(Set<String> bundles) {
		String s = (String) getMainAttributes().get(REQUIRE_BUNDLE);
		String result = mergeIntoCommaSeparatedList(s, bundles);
		if (!"".equals(result.trim()))
			getMainAttributes().put(REQUIRE_BUNDLE, result);
	}

	/*
	 * Copied from base class to omit the call to make72Safe(..).
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void write(OutputStream out) throws IOException {
		DataOutputStream dos = new DataOutputStream(out);
		// Write out the main attributes for the manifest
		((OrderAwareAttributes)getMainAttributes()).myWriteMain(dos);
		// Now write out the pre-entry attributes
		Iterator<Map.Entry<String,Attributes>> it = getEntries().entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry<String,Attributes> e = it.next();
	            StringBuffer buffer = new StringBuffer("Name: ");
	            String value = e.getKey();
	            if (value != null) {
	                byte[] vb = value.getBytes("UTF8");
	                value = new String(vb, 0, 0, vb.length);
	            }
		    buffer.append(value);
		    buffer.append("\r\n");
	            // make72Safe(buffer); // SZ: uncomment as it messes the formatting
	            dos.writeBytes(buffer.toString());
		    ((OrderAwareAttributes)e.getValue()).myWrite(dos);
		}
		dos.flush();
	}

	/**
	 * adds the qualified names to the export-package attribute, if not already
	 * present.
	 *
	 * @param packages - passing parameterized packages is not supported
	 */
	public void addExportedPackages(Set<String> bundles) {
		String s = (String) getMainAttributes().get(EXPORT_PACKAGE);
		String result = mergeIntoCommaSeparatedList(s, bundles);
		if (!"".equals(result.trim()))
			getMainAttributes().put(EXPORT_PACKAGE, result);
	}

	protected static String mergeIntoCommaSeparatedList(String currentString, Set<String> toMergeIn) {
		String string = currentString == null ? "" : currentString;
		String[] split = string.split("\\s*,\\s*");
		Set<ParameterizedElement> all = new LinkedHashSet<ParameterizedElement>();
		for (int i = 0; i < split.length; i++) {
			String value = split[i];
			if (!value.trim().equals(""))
				all.add(new ParameterizedElement(value.trim()));
		}

		for (String value : toMergeIn) {
			if (!value.trim().equals("")) {
				if (value.indexOf(';') != -1)
					throw new IllegalArgumentException("Element " + value
							+ " contains a semicolon. Merging parameterized elements is not yet supported");
				all.add(new ParameterizedElement(value.trim()));
			}
		}

		StringBuffer buff = new StringBuffer(string.length());
		Iterator<ParameterizedElement> iterator = all.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next().toString();
			buff.append(s);
			if (iterator.hasNext())
				buff.append(",\r\n ");
		}
		String result = buff.toString();
		return result;
	}

	public static class ParameterizedElement {
		private final String name;
		private final String value;

		public ParameterizedElement(String value) {
			this.value = value;
			this.name = value.indexOf(';') == -1 ? value : value.substring(0, value.indexOf(';'));
		}

		@Override
		public String toString() {
			return value;
		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			ParameterizedElement other = (ParameterizedElement) obj;
			return name.equals(other.name);
		}

	}

}

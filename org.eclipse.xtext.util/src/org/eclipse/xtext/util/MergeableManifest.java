/*******************************************************************************
 * Copyright (c) 2008, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import static com.google.common.collect.Sets.*;

import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.Manifest;

import org.apache.log4j.Logger;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Code is largely copied from {@link Manifest}. Needed to adapt some details
 * (line length, detection or changes when only ordering is changed). Original
 * code has extended {@link Manifest} and used reflection to modify behavior.
 * This gives warnings with Java 9/10 and will probably fail with future
 * versions. Hence it is better to have some copied code instead of the
 * reflection warning.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - merging of parameterized entries
 * @author Arne Deutsch - avoid inheriting from java.util.jar.Manifest to avoid
 * reflective calls
 * @since 2.2 moved to org.eclipse.xtext.util
 */
public class MergeableManifest implements Cloneable {

	public static final Attributes.Name BUNDLE_NAME = new Attributes.Name("Bundle-Name");
	public static final Attributes.Name BUNDLE_SYMBOLIC_NAME = new Attributes.Name("Bundle-SymbolicName");
	public static final Attributes.Name BUNDLE_VERSION = new Attributes.Name("Bundle-Version");
	public static final Attributes.Name BUNDLE_CLASSPATH = new Attributes.Name("Bundle-ClassPath");
	public static final Attributes.Name BUNDLE_VENDOR = new Attributes.Name("Bundle-Vendor");
	public static final Attributes.Name BUNDLE_REQUIRED_EXECUTION_ENV = new Attributes.Name(
			"Bundle-RequiredExecutionEnvironment");
	public static final Attributes.Name EXPORT_PACKAGE = new Attributes.Name("Export-Package");
	public static final Attributes.Name IMPORT_PACKAGE = new Attributes.Name("Import-Package");
	public static final Attributes.Name REQUIRE_BUNDLE = new Attributes.Name("Require-Bundle");
	public static final Attributes.Name BUNDLE_ACTIVATION_POLICY = new Attributes.Name("Bundle-ActivationPolicy");
	public static final Attributes.Name BUNDLE_LOCALIZATION = new Attributes.Name("Bundle-Localization");
	public static final Attributes.Name BUNDLE_ACTIVATOR = new Attributes.Name("Bundle-Activator");

	/**
	 * @deprecated Is only used in deprecated static methods.
	 */
	@Deprecated
	private static final String LINEBREAK = Strings.newLine();

	/*
	 * java.util.Manifest throws an exception if line exceeds 512 chars
	 */
	/**
	 * @deprecated Use {@link #make512Safe(StringBuffer, String)} instead
	 * @since 2.9
	 */
	@Deprecated
	public static String make512Safe(StringBuffer lines) {
		return make512Safe(lines, LINEBREAK);
	}

	/**
	 * @since 2.11
	 */
	public static String make512Safe(StringBuffer lines, String lineDelimiter) {
		if (lines.length() > 512) {
			StringBuilder result = new StringBuilder(lines.length());
			String[] splitted = lines.toString().split("\\r?\\n");
			for (String string : splitted) {
				if (string.length() > 512) {
					int idx = 510;
					StringBuilder temp = new StringBuilder(string);
					int length = temp.length();
					while (idx < length - 2) {
						temp.insert(idx, lineDelimiter + " ");
						idx += 512;
						length += 3;
					}
					result.append(temp.toString());
				} else {
					result.append(string);
				}
				result.append(lineDelimiter);
			}
			return result.toString();
		}
		return lines.toString();
	}

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

		@Override
		public Object put(Object name, Object value) {
			final Object result = super.put(name, value);
			if (result != null && !result.equals(value))
				modified = true;
			return result;
		}

		/**
		 * Copied from {@link Manifest}, but replaced call to make72Safe(buffer) with
		 * make512Safe(buffer) and does not write empty values
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
				out.writeBytes(vername + ": " + version + lineDelimiter);
			}

			// write out all attributes except for the version
			// we wrote out earlier
			Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Object, Object> e = it.next();
				String value = (String) e.getValue();
				if (!Strings.isEmpty(value)) {
					String name = ((Name) e.getKey()).toString();
					if ((version != null) && !(name.equalsIgnoreCase(vername))) {
						StringBuffer buffer = new StringBuffer(name);
						buffer.append(": ");

						byte[] vb = value.trim().getBytes("UTF8");
						value = new String(vb, 0, 0, vb.length);
						buffer.append(value);
						if (it.hasNext())
							buffer.append(lineDelimiter);
						out.writeBytes(make512Safe(buffer, lineDelimiter));
					}
				}
			}
			out.writeBytes(lineDelimiter);
		}

		/**
		 * Copied from {@link Manifest}, but omitted call to make72Safe(buffer) and
		 * does not write empty values
		 */
		@SuppressWarnings("deprecation")
		public void myWrite(DataOutputStream out) throws IOException {
			Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Object, Object> e = it.next();
				String value = (String) e.getValue();
				if (Strings.isEmpty(value)) {
					StringBuffer buffer = new StringBuffer(((Name) e.getKey()).toString());
					buffer.append(": ");

					byte[] vb = value.trim().getBytes("UTF8");
					value = new String(vb, 0, 0, vb.length);
					buffer.append(value);
					if (it.hasNext())
						buffer.append(lineDelimiter);
					out.writeBytes(make512Safe(buffer, lineDelimiter));
				}
			}
			out.writeBytes(lineDelimiter);
		}
	}

	private boolean modified = false;

	private String projectName;
	private String lineDelimiter = Strings.newLine();

	// manifest main attributes
	private Attributes attr = new OrderAwareAttributes();

	// manifest entries
	private Map<String, Attributes> entries = new HashMap<>();

	/**
	 * Constructs a new Manifest from the specified input stream.
	 *
	 * @param is the input stream containing manifest data
	 * @throws IOException if an I/O error has occurred
	 */
	public MergeableManifest(InputStream in) throws IOException {
		read(in);
		// hack: reconstruct linebreaks
		addRequiredBundles(Collections.<String>emptySet());
		addExportedPackages(Collections.<String>emptySet());
		addImportedPackages(Collections.<String>emptySet());
		modified = false;
	}

	/**
	 * Constructs a new Manifest that is a copy of the specified Manifest.
	 *
	 * @param man the Manifest to copy
	 */
	public MergeableManifest(MergeableManifest man) {
		attr.putAll(man.getMainAttributes());
		entries.putAll(man.getEntries());
	}

	public MergeableManifest(InputStream in, String projectName) throws IOException {
		this(in);
		this.projectName = projectName;
	}

	/**
	 * adds the qualified names to the require-bundle attribute, if not already
	 * present.
	 *
	 * @param bundles - passing parameterized bundled (e.g. versions, etc.) is
	 * not supported
	 */
	public void addRequiredBundles(Set<String> bundles) {
		// TODO manage transitive dependencies
		// don't require self
		Set<String> bundlesToMerge;
		String bundleName = (String) getMainAttributes().get(BUNDLE_SYMBOLIC_NAME);
		if (bundleName != null) {
			int idx = bundleName.indexOf(';');
			if (idx >= 0) {
				bundleName = bundleName.substring(0, idx);
			}
		}
		if (bundleName != null && bundles.contains(bundleName)
				|| projectName != null && bundles.contains(projectName)) {
			bundlesToMerge = new LinkedHashSet<String>(bundles);
			bundlesToMerge.remove(bundleName);
			bundlesToMerge.remove(projectName);
		} else {
			bundlesToMerge = bundles;
		}
		String s = (String) getMainAttributes().get(REQUIRE_BUNDLE);
		Wrapper<Boolean> modified = Wrapper.wrap(this.modified);
		String result = mergeIntoCommaSeparatedList(s, bundlesToMerge, modified, lineDelimiter);
		this.modified = modified.get();
		getMainAttributes().put(REQUIRE_BUNDLE, result);
	}

	/**
	 * @since 2.9
	 */
	public String getBREE() {
		return (String) getMainAttributes().get(BUNDLE_REQUIRED_EXECUTION_ENV);
	}

	/**
	 * @since 2.9
	 */
	public void setBREE(String bree) {
		String oldValue = getBREE();
		if (Objects.equal(oldValue, bree)) {
			return;
		}
		getMainAttributes().put(BUNDLE_REQUIRED_EXECUTION_ENV, bree);
		this.modified = true;
	}

	/**
	 * @since 2.9
	 */
	public String getBundleActivator() {
		return (String) getMainAttributes().get(BUNDLE_ACTIVATOR);
	}

	/**
	 * @since 2.9
	 */
	public void setBundleActivator(String activator) {
		String oldValue = getBundleActivator();
		if (Objects.equal(oldValue, activator)) {
			return;
		}
		getMainAttributes().put(BUNDLE_ACTIVATOR, activator);
		this.modified = true;
	}

	/**
	 * @since 2.11
	 */
	public void setLineDelimiter(String delimiter) {
		this.lineDelimiter = delimiter;

	}

	public boolean isModified() {
		return modified;
	}

	/**
	 * adds the qualified names to the export-package attribute, if not already
	 * present.
	 *
	 * @param packages - passing parameterized packages is not supported
	 */
	public void addExportedPackages(Set<String> packages) {
		String s = (String) getMainAttributes().get(EXPORT_PACKAGE);
		Wrapper<Boolean> modified = Wrapper.wrap(this.modified);
		String result = mergeIntoCommaSeparatedList(s, packages, modified, lineDelimiter);
		this.modified = modified.get();
		getMainAttributes().put(EXPORT_PACKAGE, result);
	}

	/**
	 * adds the qualified names to the export-package attribute, if not already
	 * present.
	 *
	 * @param packages - packages to add
	 *
	 * @since 2.9
	 */
	public void addExportedPackages(String... packages) {
		addExportedPackages(newHashSet(packages));
	}

	public void addImportedPackages(Set<String> packages) {
		String s = (String) getMainAttributes().get(IMPORT_PACKAGE);
		Wrapper<Boolean> modified = Wrapper.wrap(this.modified);
		String result = mergeIntoCommaSeparatedList(s, packages, modified, lineDelimiter);
		this.modified = modified.get();
		getMainAttributes().put(IMPORT_PACKAGE, result);
	}

	/**
	 * @since 2.0
	 */
	protected static String[] splitQuoteAware(String string) {
		List<StringBuilder> result = Lists.newArrayList(new StringBuilder());
		boolean inQuote = false;
		for (int i = 0; i < string.length(); i++)
			switch (string.charAt(i)) {
			case ',':
				if (inQuote)
					result.get(result.size() - 1).append(string.charAt(i));
				else
					result.add(new StringBuilder());
				break;
			case '"':
				inQuote = !inQuote;
			default:
				result.get(result.size() - 1).append(string.charAt(i));
			}
		String[] resultArray = new String[result.size()];
		for (int i = 0; i < result.size(); i++)
			resultArray[i] = result.get(i).toString();
		return resultArray;
	}

	/**
	 * @deprecated Use {@link #mergeIntoCommaSeparatedList(String, Set, Wrapper, String)} instead.
	 */
	@Deprecated
	public static String mergeIntoCommaSeparatedList(String currentString, Set<String> toMergeIn,
			Wrapper<Boolean> modified) {
		return mergeIntoCommaSeparatedList(currentString, toMergeIn, modified, LINEBREAK);
	}

	/**
	 * @since 2.11
	 */
	public static String mergeIntoCommaSeparatedList(String currentString, Set<String> toMergeIn,
			Wrapper<Boolean> modified, String lineDelimiter) {
		String string = currentString == null ? "" : currentString;
		String[] split = splitQuoteAware(string);
		Map<String, String> name2parameters = new LinkedHashMap<String, String>();
		for (int i = 0; i < split.length; i++) {
			String value = split[i].trim();
			if (!value.equals("")) {
				Pair<String, String> nameParameter = getSplitEntry(value);
				name2parameters.put(nameParameter.getFirst(), nameParameter.getSecond());
			}
		}

		for (String value : toMergeIn) {
			if (!value.trim().equals("")) {
				Pair<String, String> nameParameter = getSplitEntry(value.trim());
				String existingParameter = name2parameters.get(nameParameter.getFirst());
				if (existingParameter != null) {
					continue;
				}
				boolean newModified = modified.get();
				newModified |= name2parameters.put(nameParameter.getFirst(), nameParameter.getSecond()) != null;
				modified.set(newModified);
			}
		}

		StringBuffer buff = new StringBuffer(string.length());
		Iterator<Map.Entry<String, String>> iterator = name2parameters.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			buff.append(entry.getKey());
			if (entry.getValue() != null) {
				buff.append(";").append(entry.getValue());
			}
			if (iterator.hasNext())
				buff.append("," + lineDelimiter + " ");
		}
		String result = buff.toString();
		return result;
	}

	/**
	 * @since 2.3
	 */
	protected static Pair<String, String> getSplitEntry(String entry) {
		int semicolon = entry.indexOf(';');
		String name;
		String parameter;
		if (semicolon == -1) {
			name = entry;
			parameter = null;
		} else {
			name = entry.substring(0, semicolon);
			parameter = entry.substring(semicolon + 1);
		}
		return Tuples.create(name, parameter);
	}

	/**
	 * Returns the main Attributes for the Manifest.
	 * 
	 * @return the main Attributes for the Manifest
	 */
	public Attributes getMainAttributes() {
		return attr;
	}

	/**
	 * Returns a Map of the entries contained in this Manifest. Each entry is
	 * represented by a String name (key) and associated Attributes (value). The
	 * Map permits the {@code null} key, but no entry with a null key is created
	 * by {@link #read}, nor is such an entry written by using {@link #write}.
	 *
	 * @return a Map of the entries contained in this Manifest
	 */
	public Map<String, Attributes> getEntries() {
		return entries;
	}

	/**
	 * Returns the Attributes for the specified entry name. This method is
	 * defined as:
	 * 
	 * <pre>
	 *      return (Attributes)getEntries().get(name)
	 * </pre>
	 * 
	 * Though {@code null} is a valid {@code name}, when
	 * {@code getAttributes(null)} is invoked on a {@code Manifest} obtained
	 * from a jar file, {@code null} will be returned. While jar files
	 * themselves do not allow {@code null}-named attributes, it is possible to
	 * invoke {@link #getEntries} on a {@code Manifest}, and on that result,
	 * invoke {@code put} with a null key and an arbitrary value. Subsequent
	 * invocations of {@code getAttributes(null)} will return the
	 * just-{@code put} value.
	 * <p>
	 * Note that this method does not return the manifest's main attributes; see
	 * {@link #getMainAttributes}.
	 *
	 * @param name entry name
	 * @return the Attributes for the specified entry name
	 */
	public Attributes getAttributes(String name) {
		return getEntries().get(name);
	}

	/**
	 * Clears the main Attributes as well as the entries in this Manifest.
	 */
	public void clear() {
		attr.clear();
		entries.clear();
	}

	/**
	 * Writes the Manifest to the specified OutputStream.
	 * Attributes.Name.MANIFEST_VERSION must be set in MainAttributes prior to
	 * invoking this method.
	 *
	 * @param out the output stream
	 * @exception IOException if an I/O error has occurred
	 * @see #getMainAttributes
	 */
	@SuppressWarnings("deprecation")
	public void write(OutputStream out) throws IOException {
		DataOutputStream dos = new DataOutputStream(out);
		// Write out the main attributes for the manifest
		((OrderAwareAttributes) getMainAttributes()).myWriteMain(dos);
		// Now write out the pre-entry attributes
		Iterator<Map.Entry<String, Attributes>> it = getEntries().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Attributes> e = it.next();
			StringBuffer buffer = new StringBuffer("Name: ");
			String value = e.getKey();
			if (value != null) {
				byte[] vb = value.getBytes("UTF8");
				value = new String(vb, 0, 0, vb.length);
			}
			buffer.append(value);
			buffer.append(lineDelimiter);
			dos.writeBytes(make512Safe(buffer, lineDelimiter));
			((OrderAwareAttributes) e.getValue()).myWrite(dos);
		}
		dos.flush();
	}

	/**
	 * Reads the Manifest from the specified InputStream. The entry names and
	 * attributes read will be merged in with the current manifest entries.
	 *
	 * @param is the input stream
	 * @exception IOException if an I/O error has occurred
	 */
	public void read(InputStream is) throws IOException {
		// Buffered input stream for reading manifest data
		FastInputStream fis = new FastInputStream(is);
		// Line buffer
		byte[] lbuf = new byte[512];
		// Read the main attributes for the manifest
		attr.read(fis, lbuf);
		// Total number of entries, attributes read
		int ecount = 0, acount = 0;
		// Average size of entry attributes
		int asize = 2;
		// Now parse the manifest entries
		int len;
		String name = null;
		boolean skipEmptyLines = true;
		byte[] lastline = null;

		while ((len = fis.readLine(lbuf)) != -1) {
			if (lbuf[--len] != '\n') {
				throw new IOException("manifest line too long");
			}
			if (len > 0 && lbuf[len - 1] == '\r') {
				--len;
			}
			if (len == 0 && skipEmptyLines) {
				continue;
			}
			skipEmptyLines = false;

			if (name == null) {
				name = parseName(lbuf, len);
				if (name == null) {
					throw new IOException("invalid manifest format");
				}
				if (fis.peek() == ' ') {
					// name is wrapped
					lastline = new byte[len - 6];
					System.arraycopy(lbuf, 6, lastline, 0, len - 6);
					continue;
				}
			} else {
				// continuation line
				byte[] buf = new byte[lastline.length + len - 1];
				System.arraycopy(lastline, 0, buf, 0, lastline.length);
				System.arraycopy(lbuf, 1, buf, lastline.length, len - 1);
				if (fis.peek() == ' ') {
					// name is wrapped
					lastline = buf;
					continue;
				}
				name = new String(buf, 0, buf.length, "UTF8");
				lastline = null;
			}
			Attributes attr = getAttributes(name);
			if (attr == null) {
				attr = new Attributes(asize);
				entries.put(name, attr);
			}
			attr.read(fis, lbuf);
			ecount++;
			acount += attr.size();
			// XXX: Fix for when the average is 0. When it is 0,
			// you get an Attributes object with an initial
			// capacity of 0, which tickles a bug in HashMap.
			asize = Math.max(2, acount / ecount);

			name = null;
			skipEmptyLines = true;
		}
	}

	private String parseName(byte[] lbuf, int len) {
		if (toLower(lbuf[0]) == 'n' && toLower(lbuf[1]) == 'a' && toLower(lbuf[2]) == 'm' && toLower(lbuf[3]) == 'e'
				&& lbuf[4] == ':' && lbuf[5] == ' ') {
			try {
				return new String(lbuf, 6, len - 6, "UTF8");
			} catch (Exception e) {
			}
		}
		return null;
	}

	private int toLower(int c) {
		return (c >= 'A' && c <= 'Z') ? 'a' + (c - 'A') : c;
	}

	/**
	 * Returns true if the specified Object is also a Manifest and has the same
	 * main Attributes and entries.
	 *
	 * @param o the object to be compared
	 * @return true if the specified Object is also a Manifest and has the same
	 * main Attributes and entries
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof MergeableManifest) {
			MergeableManifest m = (MergeableManifest) o;
			return attr.equals(m.getMainAttributes()) && entries.equals(m.getEntries());
		} else {
			return false;
		}
	}

	/**
	 * Returns the hash code for this Manifest.
	 */
	@Override
	public int hashCode() {
		return attr.hashCode() + entries.hashCode();
	}

	/**
	 * Returns a shallow copy of this MergeableManifest. The shallow copy is implemented
	 * as follows:
	 * 
	 * <pre>
	 * public Object clone() {
	 * 	return new MergeableManifest(this);
	 * }
	 * </pre>
	 * 
	 * @return a shallow copy of this MergeableManifest
	 */
	@Override
	public Object clone() {
		return new MergeableManifest(this);
	}

	/*
	 * A fast buffered input stream for parsing manifest files.
	 */
	static class FastInputStream extends FilterInputStream {
		private byte buf[];
		private int count = 0;
		private int pos = 0;

		FastInputStream(InputStream in) {
			this(in, 8192);
		}

		FastInputStream(InputStream in, int size) {
			super(in);
			buf = new byte[size];
		}

		@Override
		public int read() throws IOException {
			if (pos >= count) {
				fill();
				if (pos >= count) {
					return -1;
				}
			}
			return Byte.toUnsignedInt(buf[pos++]);
		}

		@Override
		public int read(byte[] b, int off, int len) throws IOException {
			int avail = count - pos;
			if (avail <= 0) {
				if (len >= buf.length) {
					return in.read(b, off, len);
				}
				fill();
				avail = count - pos;
				if (avail <= 0) {
					return -1;
				}
			}
			if (len > avail) {
				len = avail;
			}
			System.arraycopy(buf, pos, b, off, len);
			pos += len;
			return len;
		}

		/*
		 * Reads 'len' bytes from the input stream, or until an end-of-line is
		 * reached. Returns the number of bytes read.
		 */
		public int readLine(byte[] b, int off, int len) throws IOException {
			byte[] tbuf = this.buf;
			int total = 0;
			while (total < len) {
				int avail = count - pos;
				if (avail <= 0) {
					fill();
					avail = count - pos;
					if (avail <= 0) {
						return -1;
					}
				}
				int n = len - total;
				if (n > avail) {
					n = avail;
				}
				int tpos = pos;
				int maxpos = tpos + n;
				while (tpos < maxpos && tbuf[tpos++] != '\n')
					;
				n = tpos - pos;
				System.arraycopy(tbuf, pos, b, off, n);
				off += n;
				total += n;
				pos = tpos;
				if (tbuf[tpos - 1] == '\n') {
					break;
				}
			}
			return total;
		}

		public byte peek() throws IOException {
			if (pos == count)
				fill();
			if (pos == count)
				return -1; // nothing left in buffer
			return buf[pos];
		}

		public int readLine(byte[] b) throws IOException {
			return readLine(b, 0, b.length);
		}

		@Override
		public long skip(long n) throws IOException {
			if (n <= 0) {
				return 0;
			}
			long avail = count - pos;
			if (avail <= 0) {
				return in.skip(n);
			}
			if (n > avail) {
				n = avail;
			}
			pos += n;
			return n;
		}

		@Override
		public int available() throws IOException {
			return (count - pos) + in.available();
		}

		@Override
		public void close() throws IOException {
			if (in != null) {
				in.close();
				in = null;
				buf = null;
			}
		}

		private void fill() throws IOException {
			count = pos = 0;
			int n = in.read(buf, 0, buf.length);
			if (n > 0) {
				count = n;
			}
		}
	}

	/**
	 * The Attributes class maps Manifest attribute names to associated string
	 * values. Valid attribute names are case-insensitive, are restricted to the
	 * ASCII characters in the set [0-9a-zA-Z_-], and cannot exceed 70
	 * characters in length. Attribute values can contain any characters and
	 * will be UTF8-encoded when written to the output stream. See the
	 * <a href="{@docRoot}/../specs/jar/jar.html">JAR File Specification</a> for
	 * more information about valid attribute names and values.
	 *
	 * <p>
	 * This map and its views have a predictable iteration order, namely the
	 * order that keys were inserted into the map, as with
	 * {@link LinkedHashMap}.
	 *
	 * @see MergeableManifest
	 */
	public static class Attributes implements Map<Object, Object>, Cloneable {
		private static Logger log = Logger.getLogger(Attributes.class);
		/**
		 * The attribute name-value mappings.
		 */
		protected Map<Object, Object> map;

		/**
		 * Constructs a new, empty Attributes object with default size.
		 */
		public Attributes() {
			this(11);
		}

		/**
		 * Constructs a new, empty Attributes object with the specified initial
		 * size.
		 *
		 * @param size the initial number of attributes
		 */
		public Attributes(int size) {
			map = new LinkedHashMap<>(size);
		}

		/**
		 * Constructs a new Attributes object with the same attribute name-value
		 * mappings as in the specified Attributes.
		 *
		 * @param attr the specified Attributes
		 */
		public Attributes(Attributes attr) {
			map = new LinkedHashMap<>(attr);
		}

		/**
		 * Returns the value of the specified attribute name, or null if the
		 * attribute name was not found.
		 *
		 * @param name the attribute name
		 * @return the value of the specified attribute name, or null if not
		 * found.
		 */
		public Object get(Object name) {
			return map.get(name);
		}

		/**
		 * Returns the value of the specified attribute name, specified as a
		 * string, or null if the attribute was not found. The attribute name is
		 * case-insensitive.
		 * <p>
		 * This method is defined as:
		 * 
		 * <pre>
		 * return (String) get(new Attributes.Name((String) name));
		 * </pre>
		 *
		 * @param name the attribute name as a string
		 * @return the String value of the specified attribute name, or null if
		 * not found.
		 * @throws IllegalArgumentException if the attribute name is invalid
		 */
		public String getValue(String name) {
			return (String) get(new Attributes.Name(name));
		}

		/**
		 * Returns the value of the specified Attributes.Name, or null if the
		 * attribute was not found.
		 * <p>
		 * This method is defined as:
		 * 
		 * <pre>
		 * return (String) get(name);
		 * </pre>
		 *
		 * @param name the Attributes.Name object
		 * @return the String value of the specified Attribute.Name, or null if
		 * not found.
		 */
		public String getValue(Name name) {
			return (String) get(name);
		}

		/**
		 * Associates the specified value with the specified attribute name
		 * (key) in this Map. If the Map previously contained a mapping for the
		 * attribute name, the old value is replaced.
		 *
		 * @param name the attribute name
		 * @param value the attribute value
		 * @return the previous value of the attribute, or null if none
		 * @exception ClassCastException if the name is not a Attributes.Name or
		 * the value is not a String
		 */
		public Object put(Object name, Object value) {
			return map.put(name, value);
		}

		/**
		 * Associates the specified value with the specified attribute name,
		 * specified as a String. The attributes name is case-insensitive. If
		 * the Map previously contained a mapping for the attribute name, the
		 * old value is replaced.
		 * <p>
		 * This method is defined as:
		 * 
		 * <pre>
		 * return (String) put(new Attributes.Name(name), value);
		 * </pre>
		 *
		 * @param name the attribute name as a string
		 * @param value the attribute value
		 * @return the previous value of the attribute, or null if none
		 * @exception IllegalArgumentException if the attribute name is invalid
		 */
		public String putValue(String name, String value) {
			return (String) put(new Name(name), value);
		}

		/**
		 * Removes the attribute with the specified name (key) from this Map.
		 * Returns the previous attribute value, or null if none.
		 *
		 * @param name attribute name
		 * @return the previous value of the attribute, or null if none
		 */
		public Object remove(Object name) {
			return map.remove(name);
		}

		/**
		 * Returns true if this Map maps one or more attribute names (keys) to
		 * the specified value.
		 *
		 * @param value the attribute value
		 * @return true if this Map maps one or more attribute names to the
		 * specified value
		 */
		public boolean containsValue(Object value) {
			return map.containsValue(value);
		}

		/**
		 * Returns true if this Map contains the specified attribute name (key).
		 *
		 * @param name the attribute name
		 * @return true if this Map contains the specified attribute name
		 */
		public boolean containsKey(Object name) {
			return map.containsKey(name);
		}

		/**
		 * Copies all of the attribute name-value mappings from the specified
		 * Attributes to this Map. Duplicate mappings will be replaced.
		 *
		 * @param attr the Attributes to be stored in this map
		 * @exception ClassCastException if attr is not an Attributes
		 */
		public void putAll(Map<?, ?> attr) {
			// ## javac bug?
			if (!Attributes.class.isInstance(attr))
				throw new ClassCastException();
			for (Map.Entry<?, ?> me : (attr).entrySet())
				put(me.getKey(), me.getValue());
		}

		/**
		 * Removes all attributes from this Map.
		 */
		public void clear() {
			map.clear();
		}

		/**
		 * Returns the number of attributes in this Map.
		 */
		public int size() {
			return map.size();
		}

		/**
		 * Returns true if this Map contains no attributes.
		 */
		public boolean isEmpty() {
			return map.isEmpty();
		}

		/**
		 * Returns a Set view of the attribute names (keys) contained in this
		 * Map.
		 */
		public Set<Object> keySet() {
			return map.keySet();
		}

		/**
		 * Returns a Collection view of the attribute values contained in this
		 * Map.
		 */
		public Collection<Object> values() {
			return map.values();
		}

		/**
		 * Returns a Collection view of the attribute name-value mappings
		 * contained in this Map.
		 */
		public Set<Map.Entry<Object, Object>> entrySet() {
			return map.entrySet();
		}

		/**
		 * Compares the specified Attributes object with this Map for equality.
		 * Returns true if the given object is also an instance of Attributes
		 * and the two Attributes objects represent the same mappings.
		 *
		 * @param o the Object to be compared
		 * @return true if the specified Object is equal to this Map
		 */
		@Override
		public boolean equals(Object o) {
			return map.equals(o);
		}

		/**
		 * Returns the hash code value for this Map.
		 */
		@Override
		public int hashCode() {
			return map.hashCode();
		}

		/**
		 * Returns a copy of the Attributes, implemented as follows:
		 * 
		 * <pre>
		 * public Object clone() {
		 * 	return new Attributes(this);
		 * }
		 * </pre>
		 * 
		 * Since the attribute names and values are themselves immutable, the
		 * Attributes returned can be safely modified without affecting the
		 * original.
		 */
		@Override
		public Object clone() {
			return new Attributes(this);
		}

		/*
		 * Reads attributes from the specified input stream. XXX Need to handle
		 * UTF8 values.
		 */
		@SuppressWarnings("deprecation")
		void read(MergeableManifest.FastInputStream is, byte[] lbuf) throws IOException {
			String name = null, value = null;
			byte[] lastline = null;

			int len;
			while ((len = is.readLine(lbuf)) != -1) {
				boolean lineContinued = false;
				if (lbuf[--len] != '\n') {
					throw new IOException("line too long");
				}
				if (len > 0 && lbuf[len - 1] == '\r') {
					--len;
				}
				if (len == 0) {
					break;
				}
				int i = 0;
				if (lbuf[0] == ' ') {
					// continuation of previous line
					if (name == null) {
						throw new IOException("misplaced continuation line");
					}
					lineContinued = true;
					byte[] buf = new byte[lastline.length + len - 1];
					System.arraycopy(lastline, 0, buf, 0, lastline.length);
					System.arraycopy(lbuf, 1, buf, lastline.length, len - 1);
					if (is.peek() == ' ') {
						lastline = buf;
						continue;
					}
					value = new String(buf, 0, buf.length, "UTF8");
					lastline = null;
				} else {
					while (lbuf[i++] != ':') {
						if (i >= len) {
							throw new IOException("invalid header field");
						}
					}
					if (lbuf[i++] != ' ') {
						throw new IOException("invalid header field");
					}
					name = new String(lbuf, 0, 0, i - 2);
					if (is.peek() == ' ') {
						lastline = new byte[len - i];
						System.arraycopy(lbuf, i, lastline, 0, len - i);
						continue;
					}
					value = new String(lbuf, i, len - i, "UTF8");
				}
				try {
					if ((putValue(name, value) != null) && (!lineContinued)) {
						log.warn("Duplicate name in Manifest: " + name + ".\n" + "Ensure that the manifest does not "
								+ "have duplicate entries, and\n" + "that blank lines separate "
								+ "individual sections in both your\n" + "manifest and in the META-INF/MANIFEST.MF "
								+ "entry in the jar file.");
					}
				} catch (IllegalArgumentException e) {
					throw new IOException("invalid header field name: " + name);
				}
			}
		}

		/**
		 * The Attributes.Name class represents an attribute name stored in this
		 * Map. Valid attribute names are case-insensitive, are restricted to
		 * the ASCII characters in the set [0-9a-zA-Z_-], and cannot exceed 70
		 * characters in length. Attribute values can contain any characters and
		 * will be UTF8-encoded when written to the output stream. See the
		 * <a href="{@docRoot}/../specs/jar/jar.html">JAR File Specification</a>
		 * for more information about valid attribute names and values.
		 */
		public static class Name {
			private String name;
			private int hashCode = -1;

			/**
			 * Constructs a new attribute name using the given string name.
			 *
			 * @param name the attribute string name
			 * @exception IllegalArgumentException if the attribute name was
			 * invalid
			 * @exception NullPointerException if the attribute name was null
			 */
			public Name(String name) {
				if (name == null) {
					throw new NullPointerException("name");
				}
				if (!isValid(name)) {
					throw new IllegalArgumentException(name);
				}
				this.name = name.intern();
			}

			private static boolean isValid(String name) {
				int len = name.length();
				if (len > 70 || len == 0) {
					return false;
				}
				for (int i = 0; i < len; i++) {
					if (!isValid(name.charAt(i))) {
						return false;
					}
				}
				return true;
			}

			private static boolean isValid(char c) {
				return isAlpha(c) || isDigit(c) || c == '_' || c == '-';
			}

			private static boolean isAlpha(char c) {
				return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
			}

			private static boolean isDigit(char c) {
				return c >= '0' && c <= '9';
			}

			/**
			 * Compares this attribute name to another for equality.
			 * 
			 * @param o the object to compare
			 * @return true if this attribute name is equal to the specified
			 * attribute object
			 */
			@Override
			public boolean equals(Object o) {
				if (o instanceof Name) {
					Comparator<String> c = String.CASE_INSENSITIVE_ORDER;
					return c.compare(name, ((Name) o).name) == 0;
				} else {
					return false;
				}
			}

			/**
			 * Computes the hash value for this attribute name.
			 */
			@Override
			public int hashCode() {
				if (hashCode == -1) {
					hashCode = name.toLowerCase(Locale.ROOT).hashCode();
				}
				return hashCode;
			}

			/**
			 * Returns the attribute name as a String.
			 */
			@Override
			public String toString() {
				return name;
			}

			/**
			 * {@code Name} object for {@code Manifest-Version} manifest
			 * attribute. This attribute indicates the version number of the
			 * manifest standard to which a JAR file's manifest conforms.
			 * 
			 * @see <a href="{@docRoot}/../specs/jar/jar.html#JAR_Manifest">
			 * Manifest and Signature Specification</a>
			 */
			public static final Name MANIFEST_VERSION = new Name("Manifest-Version");

			/**
			 * {@code Name} object for {@code Signature-Version} manifest
			 * attribute used when signing JAR files.
			 * 
			 * @see <a href="{@docRoot}/../specs/jar/jar.html#JAR_Manifest">
			 * Manifest and Signature Specification</a>
			 */
			public static final Name SIGNATURE_VERSION = new Name("Signature-Version");

			/**
			 * {@code Name} object for {@code Content-Type} manifest attribute.
			 */
			public static final Name CONTENT_TYPE = new Name("Content-Type");

			/**
			 * {@code Name} object for {@code Class-Path} manifest attribute.
			 * 
			 * @see <a href="{@docRoot}/../specs/jar/jar.html#classpath"> JAR
			 * file specification</a>
			 */
			public static final Name CLASS_PATH = new Name("Class-Path");

			/**
			 * {@code Name} object for {@code Main-Class} manifest attribute
			 * used for launching applications packaged in JAR files. The
			 * {@code Main-Class} attribute is used in conjunction with the
			 * {@code -jar} command-line option of the {@code java} application
			 * launcher.
			 */
			public static final Name MAIN_CLASS = new Name("Main-Class");

			/**
			 * {@code Name} object for {@code Sealed} manifest attribute used
			 * for sealing.
			 * 
			 * @see <a href="{@docRoot}/../specs/jar/jar.html#package-sealing">
			 * Package Sealing</a>
			 */
			public static final Name SEALED = new Name("Sealed");

			/**
			 * {@code Name} object for {@code Extension-List} manifest attribute
			 * used for the extension mechanism that is no longer supported.
			 */
			public static final Name EXTENSION_LIST = new Name("Extension-List");

			/**
			 * {@code Name} object for {@code Extension-Name} manifest
			 * attribute. used for the extension mechanism that is no longer
			 * supported.
			 */
			public static final Name EXTENSION_NAME = new Name("Extension-Name");

			/**
			 * {@code Name} object for {@code Extension-Installation} manifest
			 * attribute.
			 *
			 * @deprecated Extension mechanism is no longer supported.
			 */
			@Deprecated
			public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation");

			/**
			 * {@code Name} object for {@code Implementation-Title} manifest
			 * attribute used for package versioning.
			 */
			public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");

			/**
			 * {@code Name} object for {@code Implementation-Version} manifest
			 * attribute used for package versioning.
			 */
			public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");

			/**
			 * {@code Name} object for {@code Implementation-Vendor} manifest
			 * attribute used for package versioning.
			 */
			public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");

			/**
			 * {@code Name} object for {@code Implementation-Vendor-Id} manifest
			 * attribute.
			 *
			 * @deprecated Extension mechanism is no longer supported.
			 */
			@Deprecated
			public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");

			/**
			 * {@code Name} object for {@code Implementation-URL} manifest
			 * attribute.
			 *
			 * @deprecated Extension mechanism is no longer supported.
			 */
			@Deprecated
			public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL");

			/**
			 * {@code Name} object for {@code Specification-Title} manifest
			 * attribute used for package versioning.
			 */
			public static final Name SPECIFICATION_TITLE = new Name("Specification-Title");

			/**
			 * {@code Name} object for {@code Specification-Version} manifest
			 * attribute used for package versioning.
			 */
			public static final Name SPECIFICATION_VERSION = new Name("Specification-Version");

			/**
			 * {@code Name} object for {@code Specification-Vendor} manifest
			 * attribute used for package versioning.
			 */
			public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");

			/**
			 * {@code Name} object for {@code Multi-Release} manifest attribute
			 * that indicates this is a multi-release JAR file.
			 */
			public static final Name MULTI_RELEASE = new Name("Multi-Release");
		}
	}

}

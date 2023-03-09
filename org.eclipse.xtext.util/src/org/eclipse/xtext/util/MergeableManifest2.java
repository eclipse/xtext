/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Functionality to read and write Manifest files. Guarantees that modifying
 * does not destroy the order of the elements to ensure minimal diffs for
 * load/save cycles.
 * 
 * Re-implementation from {@link MergeableManifest} but without reflection.
 * Reflection causes warnings that it might get be removed in future versions.
 * Hence we implement the functionality with all the inherited one by ourself.
 * 
 * @author Arne Deutsch - Initial contribution and API
 */
public class MergeableManifest2 implements Cloneable {

	public static final String MANIFEST_VERSION = "Manifest-Version";
	public static final String SIGNATURE_VERSION = "Signature-Version";
	public static final String REQUIRE_BUNDLE = "Require-Bundle";
	public static final String BUNDLE_SYMBOLIC_NAME = "Bundle-SymbolicName";
	public static final String EXPORT_PACKAGE = "Export-Package";
	public static final String IMPORT_PACKAGE = "Import-Package";
	public static final String BUNDLE_REQUIREDEXECUTIONENVIRONMENT = "Bundle-RequiredExecutionEnvironment";
	public static final String BUNDLE_ACTIVATOR = "Bundle-Activator";

	private String name;
	private String version;
	private String bree;
	private String bundleActivator;
	private String newline = System.lineSeparator();
	private Attributes mainAttributes = new Attributes();
	private Map<String, Attributes> entries = new LinkedHashMap<>();
	private boolean modified;

	private Pattern emptyEntryPattern = newEmptyLinePattern();

	/**
	 * Create a new manifest from the given stream and with the given name. As
	 * the stream is created by the caller the caller is also responsible for
	 * closing it.
	 * 
	 * @param stream The stream to read the manifest content from.
	 * @param name The name of the manifest, written to "Bundle-SymbolicName".
	 */
	public MergeableManifest2(InputStream stream, String name) throws IOException {
		this.name = name;
		read(stream);
		this.modified = false;
	}

	private Pattern newEmptyLinePattern() {
		return Pattern.compile("," + newline + " [ \t]*," + newline + " ");
	}

	/**
	 * Create a new manifest from the given stream. As the stream is created by
	 * the caller the caller is also responsible for closing it.
	 * 
	 * @param stream The stream to read the manifest content from.
	 */
	public MergeableManifest2(InputStream stream) throws IOException {
		read(stream);
		this.modified = false;
	}

	/**
	 * Create a copy from the given one.
	 * 
	 * @param toCopy The original manifest to copy.
	 */
	public MergeableManifest2(MergeableManifest2 toCopy) {
		this.name = toCopy.name;
		this.version = toCopy.version;
		this.newline = toCopy.newline;
		this.emptyEntryPattern = newEmptyLinePattern();
		this.mainAttributes.putAll(toCopy.mainAttributes);
		this.entries.putAll(toCopy.entries);
		this.modified = false;
	}

	private void read(InputStream stream) throws IOException {
		read(new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.toList()));
	}

	private void read(List<String> lines) throws IOException {
		int lineIndex = readHeader(lines, 0);
		readEntries(lines, lineIndex);
	}

	private int readHeader(List<String> lines, int startIndex) throws IOException {
		int lineIndex = startIndex;
		while (lineIndex < lines.size()) {
			String line = lines.get(lineIndex);
			if (line.length() > 512) {
				throw new IOException("Line is to long '" + line + "'");
			}
			lineIndex++;
			while (lineIndex < lines.size() && lines.get(lineIndex).startsWith(" ")) {
				line += newline + lines.get(lineIndex);
				lineIndex++;
			}
			if (line.isEmpty()) {
				return lineIndex; // end of header
			} else if (line.contains(": ")) {
				String[] split = line.split(": ", 2);
				String name = split[0];
				if (!isValidName(name)) {
					throw new IOException("Missing name of value");
				}
				String value = split[1];
				if (name.equals(MANIFEST_VERSION)) {
					version = value;
				} else if (version == null && name.equals(SIGNATURE_VERSION)) {
					version = value;
				} else if (name.equals(BUNDLE_SYMBOLIC_NAME)) {
					this.name = Bundle.fromInput(value).getName();
				} else if (name.equals(BUNDLE_REQUIREDEXECUTIONENVIRONMENT)) {
					bree = value;
				} else if (name.equals(BUNDLE_ACTIVATOR)) {
					bundleActivator = value;
				} else if (name.equals(REQUIRE_BUNDLE) || name.equals(EXPORT_PACKAGE) || name.equals(IMPORT_PACKAGE)) {
					// filter all entries from "Require-Bundle",
					// "Export-Package" and "Import-Package" entries
					// that are empty to fix manifest files that are invalid in
					// this regard
					value = filterEmptyBundles(value);
				}
				mainAttributes.put(name, value);
			} else {
				throw new IOException("Missing ': '");
			}
		}
		return lineIndex;
	}

	private String filterEmptyBundles(String bundleString) {
		String result = bundleString.trim();
		if (result.startsWith("," + newline + " "))
			result = result.substring(("," + newline + " ").length(), result.length());
		Matcher matcher = emptyEntryPattern.matcher(result);
		result = matcher.replaceAll("," + newline + " ");
		if (result.endsWith(","))
			result = result.substring(0, result.length() - 1);
		return result;
	}

	private void readEntries(List<String> lines, int startIndex) throws IOException {
		int lineIndex = startIndex;
		Attributes attributes = null;
		while (lineIndex < lines.size()) {
			String line = lines.get(lineIndex);
			lineIndex++;
			while (lineIndex < lines.size() && lines.get(lineIndex).startsWith(" ")) {
				line += lines.get(lineIndex).substring(1);
				lineIndex++;
			}
			if (line.toLowerCase().startsWith("name: ")) {
				String name = line.substring("name: ".length());
				attributes = entries.get(name);
				if (attributes == null) {
					attributes = new Attributes();
					entries.put(name, attributes);
				}
			} else if (line.contains(": ")) {
				String[] split = line.split(": ", 2);
				String name = split[0];
				if (!isValidName(name)) {
					throw new IOException("Missing name of value");
				}
				String value = split[1];
				if (attributes == null)
					throw new IOException("Missing name of entry");
				attributes.put(name, value);
			} else if (line.isEmpty()) {
				// nothing to do
			} else {
				throw new IOException("Missing ': '");
			}
		}
	}

	private boolean isValidName(String name) {
		if (name.isEmpty() || name.length() > 70)
			return false;
		for (int n = 0; n < name.length(); n++) {
			char c = name.charAt(n);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '-' || c == '_')
				continue;
			return false;
		}
		return true;
	}

	/**
	 * @return the attributes read from the header. Does not include the entries
	 * that are started with "Name: [...]" line.
	 */
	public Attributes getMainAttributes() {
		return mainAttributes;
	}

	/**
	 * @return the attribute section that has been started with the name from
	 * the "Name: [...]" line.
	 */
	public Attributes getAttributes(String name) {
		return entries.get(name);
	}

	/**
	 * @return all entries started with "Name: [...]" line but not the main
	 * attributes.
	 */
	public Map<String, Attributes> getEntries() {
		return entries;
	}

	/**
	 * @return true in case any modification has been applied to the manifest
	 * since it was read.
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * Remove all main entries and all section entries.
	 */
	public void clear() {
		mainAttributes.clear();
		entries.clear();
	}

	/**
	 * Add the set with given bundles to the "Require-Bundle" main attribute.
	 * 
	 * @param requiredBundles The set with all bundles to add.
	 */
	public void addRequiredBundles(Set<String> requiredBundles) {
		addRequiredBundles(requiredBundles.toArray(new String[requiredBundles.size()]));
	}

	/**
	 * Add the list with given bundles to the "Require-Bundle" main attribute.
	 * 
	 * @param requiredBundles The list of all bundles to add.
	 */
	public void addRequiredBundles(String... requiredBundles) {
		String oldBundles = mainAttributes.get(REQUIRE_BUNDLE);
		if (oldBundles == null)
			oldBundles = "";
		BundleList oldResultList = BundleList.fromInput(oldBundles, newline);
		BundleList resultList = BundleList.fromInput(oldBundles, newline);
		for (String bundle : requiredBundles) {
			Bundle newBundle = Bundle.fromInput(bundle);
			if (name != null && name.equals(newBundle.getName()))
				continue;
			resultList.mergeInto(newBundle);
		}
		String result = resultList.toString();
		boolean changed = !oldResultList.toString().equals(result);
		modified |= changed;
		if (changed)
			mainAttributes.put(REQUIRE_BUNDLE, result);
	}

	/**
	 * Add the set with given bundles to the "Import-Package" main attribute.
	 * 
	 * @param importedPackages The set of all packages to add.
	 */
	public void addImportedPackages(Set<String> importedPackages) {
		addImportedPackages(importedPackages.toArray(new String[importedPackages.size()]));
	}

	/**
	 * Add the list with given bundles to the "Import-Package" main attribute.
	 * 
	 * @param importedPackages The list of all packages to add.
	 */
	public void addImportedPackages(String... importedPackages) {
		String oldBundles = mainAttributes.get(IMPORT_PACKAGE);
		if (oldBundles == null)
			oldBundles = "";
		BundleList oldResultList = BundleList.fromInput(oldBundles, newline);
		BundleList resultList = BundleList.fromInput(oldBundles, newline);
		for (String bundle : importedPackages)
			resultList.mergeInto(Bundle.fromInput(bundle));
		String result = resultList.toString();
		boolean changed = !oldResultList.toString().equals(result);
		modified |= changed;
		if (changed)
			mainAttributes.put(IMPORT_PACKAGE, result);
	}

	/**
	 * Add the set with given bundles to the "Export-Package" main attribute.
	 * 
	 * @param exportedPackages The set of all packages to add.
	 */
	public void addExportedPackages(Set<String> exportedPackages) {
		addExportedPackages(exportedPackages.toArray(new String[exportedPackages.size()]));
	}

	/**
	 * Add the list with given bundles to the "Export-Package" main attribute.
	 * 
	 * @param exportedPackages The list of all packages to add.
	 */
	public void addExportedPackages(String... exportedPackages) {
		String oldBundles = mainAttributes.get(EXPORT_PACKAGE);
		if (oldBundles == null)
			oldBundles = "";
		BundleList oldResultList = BundleList.fromInput(oldBundles, newline);
		BundleList resultList = BundleList.fromInput(oldBundles, newline);
		for (String bundle : exportedPackages)
			resultList.mergeInto(Bundle.fromInput(bundle));
		String result = resultList.toString();
		boolean changed = !oldResultList.toString().equals(result);
		modified |= changed;
		if (changed)
			mainAttributes.put(EXPORT_PACKAGE, result);
	}

	/**
	 * Set the main attribute "Bundle-RequiredExecutionEnvironment" to the given
	 * value.
	 * 
	 * @param bree The new value
	 */
	public void setBREE(String bree) {
		String old = mainAttributes.get(BUNDLE_REQUIREDEXECUTIONENVIRONMENT);
		if (!bree.equals(old)) {
			this.mainAttributes.put(BUNDLE_REQUIREDEXECUTIONENVIRONMENT, bree);
			this.modified = true;
			this.bree = bree;
		}
	}

	/**
	 * @return the value of the main attribute
	 * "Bundle-RequiredExecutionEnvironment".
	 */
	public String getBREE() {
		return bree;
	}

	/**
	 * Set the main attribute "Bundle-Activator" to the given value.
	 * 
	 * @param bundleActivator The new value
	 */
	public void setBundleActivator(String bundleActivator) {
		String old = mainAttributes.get(BUNDLE_ACTIVATOR);
		if (!bundleActivator.equals(old)) {
			this.mainAttributes.put(BUNDLE_ACTIVATOR, bundleActivator);
			this.modified = true;
			this.bundleActivator = bundleActivator;
		}
	}

	/**
	 * @return the value of the main attribute "Bundle-Activator".
	 */
	public String getBundleActivator() {
		return bundleActivator;
	}

	/**
	 * Set the line delimiter to a specific value. Is only used for writing, NOT
	 * for reading!
	 * 
	 * @param lineDelimeter typically either "\n" or "\r\n".
	 */
	public void setLineDelimiter(String lineDelimeter) {
		newline = lineDelimeter;
		this.emptyEntryPattern = newEmptyLinePattern();
	}

	/**
	 * Write the contents to the manifest to the given stream. As the stream is
	 * created by the caller the caller is also responsible for closing it.
	 * 
	 * @param stream the stream to write the output to.
	 */
	public void write(OutputStream stream) throws IOException {
		write(new BufferedWriter(new OutputStreamWriter(stream)));
	}

	private void write(BufferedWriter writer) throws IOException {
		writeHeader(writer);
		writeEntries(writer);
		writer.flush();
	}

	private void writeHeader(BufferedWriter writer) throws IOException {
		String manifestVersion = mainAttributes.get(MANIFEST_VERSION);
		if (manifestVersion != null)
			writer.append(MANIFEST_VERSION).append(": ").append(manifestVersion).append(newline);
		String signatureVersion = mainAttributes.get(SIGNATURE_VERSION);
		if (signatureVersion != null)
			writer.append(SIGNATURE_VERSION).append(": ").append(signatureVersion).append(newline);
		for (Entry<String, String> entry : mainAttributes.entrySet()) {
			String key = entry.getKey();
			if (key.equals(MANIFEST_VERSION) || key.equals(SIGNATURE_VERSION))
				continue;
			String value = mainAttributes.get(entry.getKey());
			writer.append(make512Safe(new StringBuffer(key + ": " + value), newline));
		}
	}

	private void writeEntries(BufferedWriter writer) throws IOException {
		for (Entry<String, Attributes> entry : entries.entrySet()) {
			writer.write(newline);
			writer.append("Name: ").append(entry.getKey()).append(newline);
			for (Entry<String, String> child : entry.getValue().entrySet()) {
				String key = child.getKey();
				String value = child.getValue();
				if (value.isEmpty())
					continue;
				writer.append(make512Safe(new StringBuffer(key + ": " + value), newline));
			}
		}
	}

	private static List<String> splitAtCharHonorQuoting(String value, char c) {
		if (value.indexOf(c) == -1)
			return Collections.singletonList(value);
		List<String> result = new ArrayList<>();
		String rest = value;
		while (!rest.isEmpty()) {
			int commaIndex = rest.indexOf(c);
			if (commaIndex == -1) {
				result.add(rest);
				break;
			} else {
				int quote0Index = rest.indexOf('"');
				if (quote0Index == -1 || commaIndex < quote0Index) {
					result.add(rest.substring(0, commaIndex));
					rest = rest.substring(commaIndex + 1);
				} else {
					int quote1Index = rest.indexOf('"', quote0Index + 1);
					if (quote1Index == -1) {
						result.add(rest.substring(0, commaIndex));
						rest = rest.substring(commaIndex + 1);
					} else {
						commaIndex = rest.indexOf(c, quote1Index);
						if (commaIndex == -1) {
							result.add(rest);
							rest = "";
						} else {
							result.add(rest.substring(0, commaIndex));
							rest = rest.substring(commaIndex + 1);
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public MergeableManifest2 clone() throws CloneNotSupportedException {
		return new MergeableManifest2(this);
	}

	/**
	 * Return a string that ensures that no line is longer then 512 characters
	 * and lines are broken according to manifest specification.
	 * 
	 * @param input The buffer containing the content that should be made safe
	 * @param newline The string to use to create newlines (usually "\n" or
	 * "\r\n")
	 * @return The string with no longer lines then 512, ready to be read again
	 * by {@link MergeableManifest2}.
	 */
	public static String make512Safe(StringBuffer input, String newline) {
		StringBuilder result = new StringBuilder();
		String content = input.toString();
		String rest = content;
		while (!rest.isEmpty()) {
			if (rest.contains("\n")) {
				String line = rest.substring(0, rest.indexOf("\n"));
				rest = rest.substring(rest.indexOf("\n") + 1);
				if (line.length() > 1 && line.charAt(line.length() - 1) == '\r')
					line = line.substring(0, line.length() - 1);
				append512Safe(line, result, newline);
			} else {
				append512Safe(rest, result, newline);
				break;
			}
		}
		return result.toString();
	}

	private static void append512Safe(String toAppend, StringBuilder result, String newline) {
		boolean hasAppended = false;
		while (toAppend.length() > 512) {
			if (hasAppended)
				result.append(" ");
			hasAppended = true;
			result.append(toAppend.substring(0, 510)).append(newline);
			toAppend = toAppend.substring(510);
		}
		if (hasAppended)
			result.append(" ");
		result.append(toAppend).append(newline);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
		result = prime * result + ((mainAttributes == null) ? 0 : mainAttributes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MergeableManifest2 other = (MergeableManifest2) obj;
		if (entries == null) {
			if (other.entries != null)
				return false;
		} else if (!entries.equals(other.entries))
			return false;
		if (mainAttributes == null) {
			if (other.mainAttributes != null)
				return false;
		} else if (!mainAttributes.equals(other.mainAttributes))
			return false;
		return true;
	}

	/**
	 * A map that updates the "modified" state of the owning
	 * {@link MergeableManifest2}.
	 */
	public class Attributes implements Map<String, String> {

		private LinkedHashMap<String, String> content = new LinkedHashMap<>();

		@Override
		public int size() {
			return content.size();
		}

		@Override
		public boolean isEmpty() {
			return content.isEmpty();
		}

		@Override
		public boolean containsKey(Object key) {
			return content.containsKey(key);
		}

		@Override
		public boolean containsValue(Object value) {
			return content.containsValue(value);
		}

		@Override
		public String get(Object key) {
			return content.get(key);
		}

		@Override
		public String put(String key, String value) {
			if (value.equals(content.get(key)))
				return value;
			modified = true;
			return content.put(key, value);
		}

		@Override
		public String remove(Object key) {
			modified = true;
			return content.remove(key);
		}

		@Override
		public void putAll(Map<? extends String, ? extends String> m) {
			modified = true;
			content.putAll(m);
		}

		@Override
		public void clear() {
			modified = true;
			content.clear();
		}

		@Override
		public Set<String> keySet() {
			return content.keySet();
		}

		@Override
		public Collection<String> values() {
			return content.values();
		}

		@Override
		public Set<Entry<String, String>> entrySet() {
			return content.entrySet();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((content == null) ? 0 : content.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Attributes other = (Attributes) obj;
			if (content == null) {
				if (other.content != null)
					return false;
			} else if (!content.equals(other.content))
				return false;
			return true;
		}

	}

	private static class BundleList {

		private final List<Bundle> list;
		private final String newline;

		public BundleList(List<Bundle> list, String newline) {
			this.list = list;
			this.newline = newline;
		}

		private static BundleList fromInput(String input, String newline) {
			if (input.isEmpty())
				return new BundleList(new ArrayList<>(), newline);
			return new BundleList(splitAtCharHonorQuoting(input, ',').stream().map(s -> Bundle.fromInput(s))
					.filter(b -> !"".equals(b.getName())).collect(Collectors.toList()), newline);
		}

		public void mergeInto(Bundle newBundle) {
			if (list.isEmpty()) {
				list.add(newBundle);
				return;
			}
			boolean merged = false;
			for (int i = 0; i < list.size(); i++) {
				Bundle oldBundle = list.get(i);
				if (oldBundle.hasSameName(newBundle)) {
					String oldBundleNameIncludingWhitespacePrefix = oldBundle.getNameIncludingWhitespacePrefix();
					String oldBundleVersion = oldBundle.getVersion();
					String oldBundleSuffix = oldBundle.getSuffix();
					String bundleVersion = oldBundleVersion == null ? newBundle.getVersion() : oldBundleVersion;
					merged = true;
					if (bundleVersion != null) {
						if (oldBundleSuffix == null) {
							list.set(i, Bundle.fromNameVersion(oldBundleNameIncludingWhitespacePrefix, bundleVersion));
						} else if (oldBundleVersion == null) {
							list.set(i, Bundle.fromNameVersionSuffix(oldBundleNameIncludingWhitespacePrefix,
									bundleVersion, oldBundleSuffix));
						}
					}
				}
			}
			// in case we add a new bundle and there are already other bundles
			// we write it on a new line for better readability
			if (!merged) {
				if (!"".equals(newBundle.getName())) {
					list.add(Bundle.fromBundleWithNewName(newBundle, newline + " " + newBundle.getName()));
				}
			}
		}

		// Output is used by algorithm ... do not change for debugging purposes!
		@Override
		public String toString() {
			String separator = "";
			StringBuilder result = new StringBuilder("");
			for (Bundle bundle : list) {
				result.append(separator).append(bundle);
				separator = ",";
			}
			return result.toString();
		}

	}

	private static class Bundle {
		private final String input;
		private final List<String> split;

		public static Bundle fromInput(String input) {
			return new Bundle(input);
		}

		public static Bundle fromBundleWithNewName(Bundle bundle, String newName) {
			if (bundle.getSuffix() == null)
				return new Bundle(newName);
			return new Bundle(newName + ";" + bundle.getSuffix());
		}

		public static Bundle fromNameVersion(String name, String version) {
			return new Bundle(name + ";bundle-version=\"" + version + "\"");
		}

		public static Bundle fromNameVersionSuffix(String name, String version, String suffix) {
			return new Bundle(name + ";bundle-version=\"" + version + "\";" + suffix);
		}

		private Bundle(String input) {
			this.input = input;
			if (this.input.contains(";"))
				this.split = Collections.unmodifiableList(splitAtCharHonorQuoting(this.input, ';'));
			else
				this.split = Collections.singletonList(this.input);
		}

		public boolean hasSameName(Bundle other) {
			return Objects.equals(getName(), other.getName());
		}

		public String getName() {
			// trim because prefix (such as newline) is encoded in the name,
			// also remove all newlines to ensure linebreaks in name does not
			// cause issues
			return split.get(0).trim().replaceAll("\r?\n ", "");
		}

		public String getNameIncludingWhitespacePrefix() {
			return split.get(0);
		}

		public String getSuffix() {
			return split.size() > 1 ? split.subList(1, split.size()).stream().reduce((a, b) -> a + ";" + b).get()
					: null;
		}

		public String getVersion() {
			for (int n = 1; n < split.size(); n++) {
				String part = split.get(n).trim().replaceAll("\r?\n ", "");
				if (part.contains("bundle-version=")) {
					int startIndex = part.indexOf("bundle-version=") + "bundle-version=".length();
					if (part.charAt(startIndex) == '"') {
						return part.substring(startIndex + 1, part.indexOf("\"", startIndex + 1)).trim()
								.replaceAll("\r?\n ", "");
					} else {
						return part.substring(startIndex).trim().replaceAll("\r?\n ", "");
					}
				}
			}
			return null;
		}

		// Output is used by algorithm ... do not change for debugging purposes!
		@Override
		public String toString() {
			String bundleName = split.get(0); // Do not trim to not lose prefix
			String bundleVersion = getVersion();
			String bundleSuffix = getSuffix();
			if (bundleVersion == null && bundleSuffix == null)
				return bundleName;
			return bundleName + ";" + bundleSuffix;
		}

	}

}

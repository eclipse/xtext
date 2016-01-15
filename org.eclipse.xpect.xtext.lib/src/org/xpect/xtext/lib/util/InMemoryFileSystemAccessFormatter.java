package org.xpect.xtext.lib.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.generator.InMemoryFileSystemAccess;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class InMemoryFileSystemAccessFormatter implements Function<InMemoryFileSystemAccess, String> {

	protected static class FileEntryComparator implements Comparator<Map.Entry<String, Object>> {
		public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {
			if (o1.getKey() == null)
				return 1;
			if (o2.getKey() == null)
				return -1;
			return o1.getKey().compareTo(o2.getKey());
		}
	}

	protected boolean alwaysShowFileName = false;
	protected String includeOnlyFileNamesEndingWith = null;

	public InMemoryFileSystemAccessFormatter alwaysShowFileName() {
		this.alwaysShowFileName = true;
		return this;
	}

	public String apply(InMemoryFileSystemAccess fsa) {
		return apply(fsa.getAllFiles());
	}

	public String apply(Map<String, Object> files) {
		Map<String, Object> filtered = filter(files);
		if (filtered.isEmpty())
			return "(no files have been generated)";
		else if (filtered.size() == 1 && !alwaysShowFileName)
			return formatContent(filtered.values().iterator().next());
		else {
			List<Entry<String, Object>> sorted = sort(Lists.newArrayList(filtered.entrySet()));
			List<String> result = Lists.newArrayList();
			for (Map.Entry<String, Object> e : sorted) {
				StringBuilder buf = new StringBuilder();
				buf.append("-- ");
				buf.append(e.getKey());
				buf.append(" --\n  ");
				buf.append(formatContent(e.getValue()).replace("\n", "\n  "));
				buf.append("\n-- / --");
				result.add(buf.toString());
			}
			return Joiner.on("\n").join(result);
		}
	}

	protected Map<String, Object> filter(Map<String, Object> files) {
		Map<String, Object> filtered = Maps.newHashMap();
		for (Map.Entry<String, Object> e : files.entrySet())
			if (isFileNameIncluded(e.getKey()))
				filtered.put(e.getKey(), e.getValue());
		return filtered;
	}

	protected String formatContent(byte[] content) {
		return "(binary content)";
	}

	protected String formatContent(CharSequence content) {
		return content.toString();
	}

	protected String formatContent(Object content) {
		if (content instanceof CharSequence)
			return formatContent((CharSequence) content);
		if (content instanceof byte[])
			return formatContent((byte[]) content);
		if (content != null)
			return "(unknown content type: " + content.getClass().getName();
		return "(null)";
	}

	public String getIncludeOnlyFileNamesEndingWith() {
		return includeOnlyFileNamesEndingWith;
	}

	public InMemoryFileSystemAccessFormatter includeOnlyFileNamesEndingWith(String includeOnlyFileNamesEndingWith) {
		this.includeOnlyFileNamesEndingWith = includeOnlyFileNamesEndingWith;
		return this;
	}

	public boolean isAlwaysShowFileName() {
		return alwaysShowFileName;
	}

	protected boolean isFileNameIncluded(String fileName) {
		if (includeOnlyFileNamesEndingWith != null && fileName != null)
			return fileName.endsWith(includeOnlyFileNamesEndingWith);
		return true;
	}

	protected List<Map.Entry<String, Object>> sort(List<Map.Entry<String, Object>> files) {
		Collections.sort(files, new FileEntryComparator());
		return files;
	}

}

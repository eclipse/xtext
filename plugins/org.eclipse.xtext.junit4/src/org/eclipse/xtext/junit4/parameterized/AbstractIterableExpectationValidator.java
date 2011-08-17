package org.eclipse.xtext.junit4.parameterized;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.xtext.junit4.parameterized.TestExpectationValidator.ITestExpectationValidator;
import org.eclipse.xtext.util.Exceptions;

import com.google.common.base.Function;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public abstract class AbstractIterableExpectationValidator implements ITestExpectationValidator<Iterable<Object>> {
	protected class Item {
		protected String escaped;
		protected String normalized;

		public Item(String normalized, String escaped) {
			super();
			this.normalized = normalized;
			this.escaped = escaped;
		}

		@Override
		public boolean equals(Object obj) {
			return normalized.equals(obj);
		}

		@Override
		public int hashCode() {
			return normalized.hashCode();
		}

		@Override
		public String toString() {
			return normalized;
		}

	}

	public static class ToString implements Function<Object, String> {
		public String apply(Object from) {
			return from == null ? "null" : from.toString();
		}
	}

	protected static final Pattern WS = Pattern.compile("\\s*", Pattern.MULTILINE);
	protected boolean caseSensitive;
	protected boolean ordered;

	protected boolean whitespaceSensitive;

	public AbstractIterableExpectationValidator(boolean caseSensitive, boolean whitespaceSensitive) {
		super();
		this.caseSensitive = caseSensitive;
		this.whitespaceSensitive = whitespaceSensitive;
	}

	protected Item createItem(String normalized, String escaped) {
		return new Item(normalized, escaped);
	}

	protected List<Item> escape(List<String> items) {
		List<Item> result = Lists.newArrayList();
		for (String item : items)
			result.add(createItem(normalize(item), escape(item)));
		return result;
	}

	protected String escape(String str) {
		if (whitespaceSensitive)
			return escapeQuoted(str);
		return escapeUnquoted(str);
	}

	protected String escapeQuoted(String str) {
		return '"' + str.replaceAll("\\\"", "\\\\\"").replaceAll("\\\\", "\\\\").replaceAll("\\n", "\\\\n")
				.replaceAll("\\r", "\\\\r") + '"';
	}

	protected String escapeUnquoted(String str) {
		return str.replaceAll("\\s+", " ");
	}

	protected Collection<String> normalize(List<String> items) {
		Collection<String> result = ordered ? Lists.<String> newArrayList() : HashMultiset.<String> create();
		for (String item : items)
			result.add(normalize(item));
		return result;
	}

	protected String normalize(String item) {
		if (!caseSensitive)
			item = item.trim();
		if (!whitespaceSensitive)
			item = WS.matcher(item).replaceAll("").toLowerCase();
		return item;
	}

	protected List<Item> sort(List<Item> ordered, List<Item> items) {
		List<Item> result = Lists.newArrayList();
		Multiset<Item> unsorted = LinkedHashMultiset.create(items);
		for (Item i : ordered) {
			if (unsorted.contains(i)) {
				result.add(createItem(i.normalized, i.escaped));
				unsorted.remove(i);
			}
		}
		for (Item i : unsorted)
			result.add(createItem(i.normalized, i.escaped));
		return result;
	}

	protected List<String> toStringList(Iterable<Object> actual, Class<? extends Function<Object, String>> functionClass) {
		List<String> result = Lists.newArrayList();
		try {
			Function<Object, String> func = functionClass.newInstance();
			for (Object obj : actual)
				result.add(func.apply(obj));
			return result;
		} catch (InstantiationException e) {
			Exceptions.throwUncheckedException(e);
		} catch (IllegalAccessException e) {
			Exceptions.throwUncheckedException(e);
		}
		return Collections.emptyList();
	}

	protected List<String> toStringList(String items, char separator) {
		List<String> result = Lists.newArrayList();
		boolean esc = false, quoted = false;
		StringBuilder item = new StringBuilder();
		StringBuilder ws = new StringBuilder();
		for (int i = 0; i < items.length(); i++) {
			char c = items.charAt(i);
			if (!esc) {
				if (!quoted) {
					if (c == separator) {
						result.add(item.toString());
						item = new StringBuilder();
						ws = new StringBuilder();
						continue;
					} else if (Character.isWhitespace(c)) {
						ws.append(c);
						continue;
					}
				}
				if (whitespaceSensitive && c == '"') {
					if (quoted)
						item.append(ws);
					ws = new StringBuilder();
					quoted = !quoted;
					continue;
				} else if (c == '\\') {
					esc = true;
					continue;
				}
			} else {
				esc = false;
				switch (c) {
					case 'n':
						c = '\n';
						break;
					case 'r':
						c = '\r';
						break;
				}
			}
			if (ws.length() > 0) {
				if (item.length() > 0)
					item.append(ws);
				else
					ws = new StringBuilder();
			}
			item.append(c);
		}
		if (item.length() > 0)
			result.add(item.toString());
		return result;
	}

}
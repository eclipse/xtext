package org.eclipse.xpect.parameters;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringCollection<T extends StringCollection<T>.Item> implements Iterable<T> {
	public class Item implements Comparable<Item> {
		protected String escaped = null;
		protected String normalized = null;
		protected String pure;

		public Item(String pure) {
			super();
			this.pure = pure;
		}

		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			if (obj == null || !Item.class.isInstance(obj))
				return false;
			return getNormalized().equals(((Item) obj).getNormalized());
		}

		public String getEscaped() {
			if (escaped == null)
				escaped = escape(pure);
			return escaped;
		}

		public String getNormalized() {
			if (normalized == null)
				normalized = normalize(pure);
			return normalized;
		}

		public String getPure() {
			return pure;
		}

		@Override
		public int hashCode() {
			return getNormalized().hashCode();
		}

		@Override
		public String toString() {
			return pure;
		}

		public int compareTo(Item o) {
			if (normalized == null)
				return -1;
			if (o == null || o.normalized == null)
				return 1;
			return normalized.compareTo(o.normalized);
		}

	}

	protected static final Pattern WS = Pattern.compile("\\s+", Pattern.MULTILINE);
	protected boolean caseSensitive = true;
	protected Collection<T> items;
	protected boolean ordered = true;
	protected char quote = '\"';
	protected boolean quoted = true;
	protected char separator = ',';
	protected boolean whitespaceSensitive = true;

	protected Collection<T> createCollection() {
		return ordered ? Lists.<T> newArrayList() : HashMultiset.<T> create();
	}

	protected String escape(String str) {
		str = str.replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
		if (quoted)
			return quote + str.replace(String.valueOf(quote), "\\" + quote) + quote;
		if (str.startsWith("!") || str.equals("..."))
			str = "\\" + str;
		str = str.replace(String.valueOf(separator), "\\" + separator);
		if (whitespaceSensitive)
			return str;
		return str.trim();
	}

	protected String escapeUnquoted(String str) {
		return str.replaceAll("\\s+", " ");
	}

	public char getQuote() {
		return quote;
	}

	public char getSeparator() {
		return separator;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public boolean isQuoted() {
		return quoted;
	}

	public boolean isWhitespaceSensitive() {
		return whitespaceSensitive;
	}

	public Iterator<T> iterator() {
		return items.iterator();
	}

	protected String normalize(String item) {
		if (!quoted)
			item = item.trim();
		if (!whitespaceSensitive)
			item = WS.matcher(item).replaceAll("");
		if (!caseSensitive)
			item = item.toLowerCase();
		return item;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public void setQuote(char quote) {
		this.quote = quote;
	}

	public void setQuoted(boolean quoted) {
		this.quoted = quoted;
	}

	public void setSeparator(char separator) {
		this.separator = separator;
	}

	public void setWhitespaceSensitive(boolean whitespaceSensitive) {
		this.whitespaceSensitive = whitespaceSensitive;
	}

}
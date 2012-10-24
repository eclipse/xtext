package org.eclipse.xpect.parameters;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xpect.parameters.ActualCollection.ActualItem;
import org.eclipse.xpect.parameters.ExpectationCollection.ExpectationItem;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Predicate;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ExpectationCollection extends StringCollection<ExpectationItem> {
	public class ExpectationItem extends StringCollection<ExpectationItem>.Item {
		protected boolean negated;
		protected boolean wildcard;

		public ExpectationItem(String pure, boolean negated, boolean wildcard) {
			super(pure);
			this.negated = negated;
			this.wildcard = wildcard;
		}

		public boolean isNegated() {
			return negated;
		}

		public boolean isPure() {
			return !negated && !wildcard;
		}

		public boolean isWildcard() {
			return wildcard;
		}

	}

	final protected static String WILDCARD = "...";

	public List<String> applyPredicate(Predicate<String> predicate) {
		List<String> items = Lists.newArrayList();
		for (ExpectationItem i : this)
			if (!i.isWildcard() && predicate.apply(i.pure))
				items.add(i.pure);
		return items;
	}

	protected ExpectationItem createItem(String item, boolean negated, boolean quoted, boolean escaped) {
		if (!escaped && !negated && !quoted && WILDCARD.equals(item))
			return new ExpectationItem(item.toString(), false, true);
		return new ExpectationItem(item.toString(), negated, false);
	}

	public void init(String expectation) {
		items = createCollection();
		boolean esc = false, escaped = true, quote = false, quoted = false, neg = false;
		StringBuilder item = new StringBuilder();
		StringBuilder ws = new StringBuilder();
		for (int i = 0; i < expectation.length(); i++) {
			char c = expectation.charAt(i);
			if (!esc) {
				if (!quote) {
					if (c == separator) {
						if (item.length() > 0)
							items.add(createItem(item.toString(), neg, quoted, escaped));
						neg = quoted = escaped = false;
						item = new StringBuilder();
						ws = new StringBuilder();
						continue;
					} else if (Character.isWhitespace(c)) {
						ws.append(c);
						continue;
					} else if (c == '!' && item.length() == 0) {
						neg = true;
						continue;
					}
				}
				if (this.quoted && c == this.quote) {
					if (quote)
						item.append(ws);
					ws = new StringBuilder();
					quote = !quote;
					quoted = true;
					continue;
				} else if (c == '\\') {
					escaped = esc = true;
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
				ws = new StringBuilder();
			}
			item.append(c);
		}
		if (item.length() > 0)
			items.add(createItem(item.toString(), neg, quoted, escaped));
	}

	public boolean isPure() {
		for (ExpectationItem i : this)
			if (i.isNegated() || i.isWildcard())
				return false;
		return true;
	}

	public boolean isWildcard() {
		for (ExpectationItem i : this)
			if (i.isWildcard())
				return true;
		return false;
	}

	public List<Pair<Collection<ExpectationItem>, ActualItem>> map(ActualCollection actual) {
		if (!isOrdered() || !actual.isOrdered())
			return mapUnordered(actual);
		else
			return mapOrdered(actual);
	}

	protected List<Pair<Collection<ExpectationItem>, ActualItem>> mapOrdered(ActualCollection actual) {
		List<Pair<Collection<ExpectationItem>, ActualItem>> r = Lists.newArrayList();
		List<ExpectationItem> exIt = Lists.newArrayList(this.iterator());
		List<ActualItem> actIt = Lists.newArrayList(actual.iterator());
		int exp = 0, act = 0;
		while (exp < exIt.size() && act < actIt.size()) {
			if (exIt.get(exp).isNegated() || exIt.get(exp).isWildcard()) {
				Set<ExpectationItem> expectedNegated = Sets.newLinkedHashSet();
				Set<ExpectationItem> expectedWildcard = Sets.newLinkedHashSet();
				while (exp < exIt.size() && !exIt.get(exp).isPure()) {
					if (exIt.get(exp).isNegated())
						expectedNegated.add(exIt.get(exp));
					else if (exIt.get(exp).isWildcard())
						expectedWildcard.add(exIt.get(exp));
					exp++;
				}
				while (act < actIt.size()) {
					if (exp < exIt.size() && exIt.get(exp).isPure() && exIt.get(exp).equals(actIt.get(act))) {
						r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(Collections.singleton(exIt.get(exp)), actIt.get(act)));
						exp++;
						act++;
						break;
					}
					if (!expectedNegated.contains(actIt.get(act))) {
						if (expectedWildcard.isEmpty())
							r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(expectedNegated, actIt.get(act)));
						else
							r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(expectedWildcard, actIt.get(act)));
					} else
						r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(null, actIt.get(act)));
					act++;
				}
			} else if (exIt.get(exp).equals(actIt.get(act))) {
				r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(Collections.singleton(exIt.get(exp)), actIt.get(act)));
				exp++;
				act++;
			} else {
				int lact = act + 1;
				while (lact < actIt.size() && !exIt.get(exp).equals(actIt.get(lact)))
					lact++;
				if (lact < actIt.size()) {
					while (act < lact) {
						r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(null, actIt.get(act)));
						act++;
					}
					r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(Collections.singleton(exIt.get(exp)), actIt.get(lact)));
					exp++;
					act++;
				} else {
					r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(Collections.singleton(exIt.get(exp)), null));
					exp++;
				}
			}
		}
		while (act < actIt.size()) {
			r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(null, actIt.get(act)));
			act++;
		}
		while (exp < exIt.size()) {
			if (exIt.get(exp).isPure())
				r.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(Collections.singleton(exIt.get(exp)), null));
			exp++;
		}
		return r;
	}

	protected List<Pair<Collection<ExpectationItem>, ActualItem>> mapUnordered(ActualCollection actual) {
		Map<ExpectationItem, List<ExpectationItem>> remainingExpectations = Maps.newHashMap();
		Set<ExpectationItem> negatedExpectations = Sets.newLinkedHashSet();
		List<ExpectationItem> wildcardExpectations = Lists.newArrayList();
		for (ExpectationItem exp : this)
			if (exp.isWildcard())
				wildcardExpectations.add(exp);
			else if (exp.isNegated())
				negatedExpectations.add(exp);
			else {
				List<ExpectationItem> items = remainingExpectations.get(exp);
				if (items == null)
					remainingExpectations.put(exp, items = Lists.newArrayList());
				items.add(exp);
			}
		List<ActualItem> sortedActual = Lists.newArrayList(actual);
		Collections.sort(sortedActual);
		List<Pair<Collection<ExpectationItem>, ActualItem>> result = Lists.newArrayList();
		for (ActualItem act : sortedActual) {
			List<ExpectationItem> exp = remainingExpectations.get(act);
			if (exp != null && !exp.isEmpty()) {
				ExpectationItem ei = exp.get(exp.size() - 1);
				exp.remove(exp.size() - 1);
				result.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(Collections.singleton(ei), act));
			} else if (!negatedExpectations.contains(act)) {
				if (wildcardExpectations.isEmpty())
					result.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(negatedExpectations, act));
				else
					result.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(wildcardExpectations, act));
			} else
				result.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(null, act));
		}
		List<ExpectationItem> remainingExpectationsSorted = Lists.newArrayList();
		for (List<ExpectationItem> x : remainingExpectations.values())
			remainingExpectationsSorted.addAll(x);
		Collections.sort(remainingExpectationsSorted);
		for (ExpectationItem ei : remainingExpectationsSorted)
			if (ei.isPure())
				result.add(Tuples.<Collection<ExpectationItem>, ActualItem> create(Collections.singleton(ei), null));
		return result;
	}

	public boolean matches(ActualCollection actual) {
		if (!isOrdered() || !actual.isOrdered())
			return matchesUnordered(actual);
		else
			return matchesOrdered(actual);
	}

	protected boolean matchesOrdered(ActualCollection actual) {
		if (isPure())
			return items.equals(actual.items);
		Iterator<ExpectationItem> exIt = this.iterator();
		Iterator<ActualItem> actIt = actual.iterator();
		while (exIt.hasNext() && actIt.hasNext()) {
			ExpectationItem exp = exIt.next();
			ActualItem act = actIt.next();
			if (exp.isNegated() || exp.isWildcard()) {
				List<ExpectationItem> expectedNegated = Lists.newArrayList();
				if (exp.isNegated())
					expectedNegated.add(exp);
				while (exIt.hasNext()) {
					exp = exIt.next();
					if (exp.isNegated())
						expectedNegated.add(exp);
					else if (exp.isPure())
						break;
				}
				Set<ActualItem> actualSkipped = Sets.newHashSet();
				if (exp.isPure()) {
					if (!exp.equals(act)) {
						actualSkipped.add(act);
						while (actIt.hasNext()) {
							act = actIt.next();
							if (exp.equals(act))
								break;
							else
								actualSkipped.add(act);
						}
					}
					if (!exp.equals(act))
						return false;
				} else {
					actualSkipped.add(act);
					while (actIt.hasNext())
						actualSkipped.add(actIt.next());
				}
				for (ExpectationItem e : expectedNegated)
					if (actualSkipped.contains(e))
						return false;
			} else if (!exp.equals(act))
				return false;
		}
		if (actIt.hasNext())
			return false;
		while (exIt.hasNext())
			if (exIt.next().isPure())
				return false;
		return true;
	}

	protected boolean matchesUnordered(ActualCollection actual) {
		if (isPure())
			return items.equals(actual.items);
		Multiset<ActualItem> act = HashMultiset.create(actual);
		for (ExpectationItem item : this) {
			if (item.isWildcard())
				continue;
			if (item.isNegated()) {
				if (act.contains(item))
					return false;
			} else if (!act.contains(item))
				return false;
		}
		return true;
	}
}

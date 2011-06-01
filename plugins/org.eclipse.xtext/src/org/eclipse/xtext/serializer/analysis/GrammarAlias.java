/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.formallang.GrammarFormatter;
import org.eclipse.xtext.util.formallang.IGrammarAdapter;
import org.eclipse.xtext.util.formallang.IGrammarFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarAlias {

	public static class AbstractElementAlias {
		final protected boolean many;
		final protected boolean optional;
		protected AbstractElementAlias parent;

		public AbstractElementAlias(boolean many, boolean optional) {
			super();
			this.many = many;
			this.optional = optional;
		}

		public AbstractElementAlias getParent() {
			return parent;
		}

		public boolean isMany() {
			return many;
		}

		public boolean isOptional() {
			return optional;
		}

		@Override
		public String toString() {
			GrammarFormatter<AbstractElementAlias, AbstractElement> formatter = GrammarFormatter.newFormatter(
					new GrammarAliasAdapter(), new GrammarElementTitleSwitch().showAssignments().hideCardinality());
			return formatter.format(this);
		}
	}

	public static class AlternativeAlias extends CompoundAlias {
		final protected Set<AbstractElementAlias> children;

		public AlternativeAlias(boolean many, boolean optional, AbstractElementAlias... children) {
			super(many, optional);
			this.children = Sets.newHashSet();
			addChildren(children);
		}

		public AlternativeAlias(boolean many, boolean optional, Iterable<AbstractElementAlias> children) {
			super(many, optional);
			this.children = Sets.newHashSet();
			addChildren(children);
		}

		@Override
		public Set<AbstractElementAlias> getChildren() {
			return children;
		}
	}

	public abstract static class CompoundAlias extends AbstractElementAlias {

		public CompoundAlias(boolean many, boolean optional) {
			super(many, optional);
		}

		public void addChildren(AbstractElementAlias... children) {
			for (AbstractElementAlias child : children) {
				child.parent = this;
				getChildren().add(child);
			}
		}

		public void addChildren(Iterable<AbstractElementAlias> children) {
			for (AbstractElementAlias child : children) {
				child.parent = this;
				getChildren().add(child);
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			CompoundAlias other = (CompoundAlias) obj;
			return many == other.many && optional == other.optional && getChildren().equals(other.getChildren());
		}

		public abstract Collection<AbstractElementAlias> getChildren();

		@Override
		public int hashCode() {
			int result = getChildren().hashCode();
			if (many)
				result *= 7;
			if (optional)
				result *= 23;
			return result;
		}

	}

	public static class GrammarAliasAdapter implements IGrammarAdapter<AbstractElementAlias, AbstractElement> {

		public Iterable<AbstractElementAlias> getAlternativeChildren(AbstractElementAlias ele) {
			return ele instanceof AlternativeAlias ? ((AlternativeAlias) ele).getChildren() : null;
		}

		public AbstractElementAlias getParent(AbstractElementAlias ele) {
			return ele.getParent();
		}

		public Iterable<AbstractElementAlias> getSequentialChildren(AbstractElementAlias ele) {
			return ele instanceof GroupAlias ? ((GroupAlias) ele).getChildren() : null;
		}

		public AbstractElement getToken(AbstractElementAlias owner) {
			return owner instanceof TokenAlias ? ((TokenAlias) owner).getToken() : null;
		}

		public Iterable<AbstractElementAlias> getUnorderedChildren(AbstractElementAlias ele) {
			return ele instanceof UnorderedGroupAlias ? ((UnorderedGroupAlias) ele).getChildren() : null;
		}

		public boolean isMany(AbstractElementAlias ele) {
			return ele.isMany();
		}

		public boolean isOptional(AbstractElementAlias ele) {
			return ele.isOptional();
		}
	}

	public static class GrammarAliasFactory implements IGrammarFactory<AbstractElementAlias, AbstractElement> {

		public AbstractElementAlias createForAlternativeChildren(boolean many, boolean optional,
				Iterable<AbstractElementAlias> children) {
			return new AlternativeAlias(many, optional, children);
		}

		public AbstractElementAlias createForSequentialChildren(boolean many, boolean optional,
				Iterable<AbstractElementAlias> children) {
			return new GroupAlias(many, optional, children);
		}

		public AbstractElementAlias createForToken(boolean many, boolean optional, AbstractElement token) {
			return new TokenAlias(many, optional, token);
		}

		public AbstractElementAlias createForUnordertedChildren(boolean many, boolean optional,
				Iterable<AbstractElementAlias> children) {
			return new UnorderedGroupAlias(many, optional, children);
		}
	}

	public static class GroupAlias extends CompoundAlias {
		final protected List<AbstractElementAlias> children;

		public GroupAlias(boolean many, boolean optional, AbstractElementAlias... children) {
			super(many, optional);
			this.children = Lists.newArrayList();
			addChildren(children);
		}

		public GroupAlias(boolean many, boolean optional, Iterable<AbstractElementAlias> children) {
			super(many, optional);
			this.children = Lists.newArrayList();
			addChildren(children);
		}

		@Override
		public List<AbstractElementAlias> getChildren() {
			return children;
		}
	}

	public static class TokenAlias extends AbstractElementAlias {

		final protected AbstractElement token;

		public TokenAlias(boolean many, boolean optional, AbstractElement token) {
			super(many, optional);
			this.token = token;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			TokenAlias other = (TokenAlias) obj;
			return many == other.many && optional == other.optional && token.equals(other.token);
		}

		public AbstractElement getToken() {
			return token;
		}

		@Override
		public int hashCode() {
			int result = token.hashCode();
			if (many)
				result *= 7;
			if (optional)
				result *= 23;
			return result;
		}

	}

	public static class UnorderedGroupAlias extends CompoundAlias {
		final protected Set<AbstractElementAlias> children;

		public UnorderedGroupAlias(boolean many, boolean optional, AbstractElementAlias... children) {
			super(many, optional);
			this.children = Sets.newHashSet();
			addChildren(children);
		}

		public UnorderedGroupAlias(boolean many, boolean optional, Iterable<AbstractElementAlias> children) {
			super(many, optional);
			this.children = Sets.newHashSet();
			addChildren(children);
		}

		@Override
		public Set<AbstractElementAlias> getChildren() {
			return children;
		}
	}

}

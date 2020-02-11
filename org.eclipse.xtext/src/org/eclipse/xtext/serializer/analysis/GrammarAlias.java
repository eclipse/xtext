/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.formallang.Production;
import org.eclipse.xtext.util.formallang.ProductionFactory;
import org.eclipse.xtext.util.formallang.ProductionFormatter;

import com.google.common.base.Function;
import com.google.common.base.Objects;
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
			GrammarElementTitleSwitch t2s = new GrammarElementTitleSwitch().showAssignments().hideCardinality();
			Function<Production<AbstractElementAlias, AbstractElement>, String> formatter2 = new ProductionFormatter<AbstractElementAlias, AbstractElement>()
					.setTokenToString(t2s);
			return formatter2.apply(new GrammarAliasAdapter(this));
		}
	}

	public static class AlternativeAlias extends CompoundAlias {
		final protected Set<AbstractElementAlias> children;

		public AlternativeAlias(boolean many, boolean optional, AbstractElementAlias... children) {
			super(many, optional);
			this.children = Sets.newLinkedHashSet();
			addChildren(children);
		}

		public AlternativeAlias(boolean many, boolean optional, Iterable<AbstractElementAlias> children) {
			super(many, optional);
			this.children = Sets.newLinkedHashSet();
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

	public static class GrammarAliasAdapter implements Production<AbstractElementAlias, AbstractElement> {

		protected AbstractElementAlias root;

		public GrammarAliasAdapter(AbstractElementAlias root) {
			super();
			this.root = root;
		}

		@Override
		public Iterable<AbstractElementAlias> getAlternativeChildren(AbstractElementAlias ele) {
			return ele instanceof AlternativeAlias ? ((AlternativeAlias) ele).getChildren() : null;
		}

		@Override
		public AbstractElementAlias getParent(AbstractElementAlias ele) {
			return ele.getParent();
		}

		@Override
		public Iterable<AbstractElementAlias> getSequentialChildren(AbstractElementAlias ele) {
			return ele instanceof GroupAlias ? ((GroupAlias) ele).getChildren() : null;
		}

		@Override
		public AbstractElement getToken(AbstractElementAlias owner) {
			return owner instanceof TokenAlias ? ((TokenAlias) owner).getToken() : null;
		}

		@Override
		public Iterable<AbstractElementAlias> getUnorderedChildren(AbstractElementAlias ele) {
			return ele instanceof UnorderedGroupAlias ? ((UnorderedGroupAlias) ele).getChildren() : null;
		}

		@Override
		public boolean isMany(AbstractElementAlias ele) {
			return ele.isMany();
		}

		@Override
		public boolean isOptional(AbstractElementAlias ele) {
			return ele.isOptional();
		}

		@Override
		public AbstractElementAlias getRoot() {
			return root;
		}
	}

	public static class GrammarAliasFactory implements ProductionFactory<AbstractElementAlias, AbstractElement> {

		@Override
		public AbstractElementAlias createForAlternativeChildren(boolean many, boolean optional,
				Iterable<AbstractElementAlias> children) {
			return new AlternativeAlias(many, optional, children);
		}

		@Override
		public AbstractElementAlias createForSequentialChildren(boolean many, boolean optional,
				Iterable<AbstractElementAlias> children) {
			return new GroupAlias(many, optional, children);
		}

		@Override
		public AbstractElementAlias createForToken(boolean many, boolean optional, AbstractElement token) {
			return new TokenAlias(many, optional, token);
		}

		@Override
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
			return many == other.many && optional == other.optional && Objects.equal(token, other.token);
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
			this.children = Sets.newLinkedHashSet();
			addChildren(children);
		}

		public UnorderedGroupAlias(boolean many, boolean optional, Iterable<AbstractElementAlias> children) {
			super(many, optional);
			this.children = Sets.newLinkedHashSet();
			addChildren(children);
		}

		@Override
		public Set<AbstractElementAlias> getChildren() {
			return children;
		}
	}

}

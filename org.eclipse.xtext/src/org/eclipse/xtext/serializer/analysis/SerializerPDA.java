/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ISerState.SerStateType;
import org.eclipse.xtext.util.formallang.NfaGraphFormatter;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

public class SerializerPDA implements Pda<ISerState, RuleCall> {

	public static class SerializerPDACloneFactory implements PdaFactory<SerializerPDA, ISerState, RuleCall, ISerState> {

		@Override
		public SerializerPDA create(ISerState start, ISerState stop) {
			SerializerPDA.SerializerPDAState s1 = new SerializerPDAState(start.getGrammarElement(), SerStateType.START);
			SerializerPDA.SerializerPDAState s2 = new SerializerPDAState(stop.getGrammarElement(), SerStateType.STOP);
			return new SerializerPDA(s1, s2);
		}

		@Override
		public ISerState createPop(SerializerPDA pda, ISerState token) {
			return new SerializerPDAState(token.getGrammarElement(), SerStateType.POP);
		}

		@Override
		public ISerState createPush(SerializerPDA pda, ISerState token) {
			return new SerializerPDAState(token.getGrammarElement(), SerStateType.PUSH);
		}

		@Override
		public ISerState createState(SerializerPDA nfa, ISerState token) {
			return new SerializerPDAState(token.getGrammarElement(), SerStateType.ELEMENT);
		}

		@Override
		public void setFollowers(SerializerPDA nfa, ISerState owner, Iterable<ISerState> followers) {
			((SerializerPDA.SerializerPDAState) owner).followers = Lists.newArrayList(followers);
			for (ISerState follower : followers) {
				Preconditions.checkNotNull(follower);
				((SerializerPDA.SerializerPDAState) follower).precedents.add(owner);
			}
		}
	}

	public static class SerializerPDAElementFactory
			implements PdaFactory<SerializerPDA, ISerState, RuleCall, AbstractElement> {

		@Override
		public SerializerPDA create(AbstractElement start, AbstractElement stop) {
			SerializerPDA.SerializerPDAState s1 = new SerializerPDAState(start, SerStateType.START);
			SerializerPDA.SerializerPDAState s2 = new SerializerPDAState(stop, SerStateType.STOP);
			return new SerializerPDA(s1, s2);
		}

		@Override
		public ISerState createPop(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.POP);
		}

		@Override
		public ISerState createPush(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.PUSH);
		}

		@Override
		public ISerState createState(SerializerPDA nfa, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.ELEMENT);
		}

		@Override
		public void setFollowers(SerializerPDA nfa, ISerState owner, Iterable<ISerState> followers) {
			((SerializerPDA.SerializerPDAState) owner).followers = Lists.newArrayList(followers);
			for (ISerState follower : followers) {
				Preconditions.checkNotNull(follower);
				((SerializerPDA.SerializerPDAState) follower).precedents.add(owner);
			}
		}
	}

	public static class SerializerPDAGetToken implements Function<ISerState, AbstractElement> {

		@Override
		public AbstractElement apply(ISerState input) {
			return input.getGrammarElement();
		}

	}

	public static class SerializerPDAIsAssignedAction implements Predicate<ISerState> {

		@Override
		public boolean apply(ISerState input) {
			return input != null && GrammarUtil.isAssignedAction(input.getGrammarElement());
		}

	}

	protected static class SerializerPDAState implements ISerState {
		protected List<ISerState> followers = Lists.newArrayList();
		protected final List<ISerState> precedents = Lists.newArrayList();
		protected final AbstractElement grammarElement;
		protected final SerStateType type;
		//		protected final SerializerPDAState opposite;

		public SerializerPDAState(AbstractElement grammarElement, SerStateType type) {
			super();
			this.type = type;
			this.grammarElement = grammarElement;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			SerializerPDA.SerializerPDAState s = (SerializerPDA.SerializerPDAState) obj;
			return grammarElement == s.grammarElement && type == s.type;
		}

		@Override
		public List<ISerState> getFollowers() {
			return followers;
		}

		@Override
		public AbstractElement getGrammarElement() {
			return grammarElement;
		}

		@Override
		public SerStateType getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return (grammarElement != null ? grammarElement.hashCode() : 1) * type.hashCode();
		}

		@Override
		public String toString() {
			GrammarElementTitleSwitch fmt = new GrammarElementTitleSwitch().hideCardinality().showQualified()
					.showAssignments();
			switch (type) {
				case ELEMENT:
					return fmt.apply(grammarElement);
				case POP:
					return "<<" + fmt.apply(grammarElement);
				case PUSH:
					return ">>" + fmt.apply(grammarElement);
				case START:
					return "start";
				case STOP:
					return "stop";
			}
			return "";
		}

		@Override
		public List<ISerState> getPrecedents() {
			return precedents;
		}

		//		@Override
		//		public ISerState getOpposite() {
		//			return null;
		//		}
	}

	protected SerializerPDA.SerializerPDAState start;
	protected SerializerPDA.SerializerPDAState stop;

	public SerializerPDA(SerializerPDA.SerializerPDAState start, SerializerPDA.SerializerPDAState stop) {
		super();
		this.start = start;
		this.stop = stop;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		return new NfaUtil().equalsIgnoreOrder(this, (SerializerPDA) obj);
	}

	@Override
	public Iterable<ISerState> getFollowers(ISerState state) {
		return ((SerializerPDA.SerializerPDAState) state).followers;
	}

	@Override
	public RuleCall getPop(ISerState state) {
		SerializerPDA.SerializerPDAState s = (SerializerPDA.SerializerPDAState) state;
		return s.type == SerStateType.POP ? (RuleCall) s.grammarElement : null;
	}

	@Override
	public RuleCall getPush(ISerState state) {
		SerializerPDA.SerializerPDAState s = (SerializerPDA.SerializerPDAState) state;
		return s.type == SerStateType.PUSH ? (RuleCall) s.grammarElement : null;
	}

	@Override
	public SerializerPDAState getStart() {
		return start;
	}

	@Override
	public SerializerPDAState getStop() {
		return stop;
	}

	@Override
	public int hashCode() {
		int r = 0;
		if (start != null && start.followers != null)
			for (ISerState s : start.followers)
				if (s != null)
					r += s.hashCode();
		return r;
	}

	@Override
	public String toString() {
		return new NfaGraphFormatter().format(this);
	}

}

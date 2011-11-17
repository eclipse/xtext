/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ISerState.SerStateType;
import org.eclipse.xtext.util.formallang.NfaGraphFormatter;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaFactory;

import com.google.common.collect.Lists;

public class SerializerPDA implements Pda<ISerState, RuleCall> {

	public static class SerializerPDACloneFactory implements PdaFactory<SerializerPDA, ISerState, RuleCall, ISerState> {

		public SerializerPDA create(ISerState start, ISerState stop) {
			SerializerPDA.SerializerPDAState s1 = new SerializerPDAState(start.getGrammarElement(), SerStateType.START);
			SerializerPDA.SerializerPDAState s2 = new SerializerPDAState(stop.getGrammarElement(), SerStateType.STOP);
			return new SerializerPDA(s1, s2);
		}

		public ISerState createPop(SerializerPDA pda, ISerState token) {
			return new SerializerPDAState(token.getGrammarElement(), SerStateType.POP);
		}

		public ISerState createPush(SerializerPDA pda, ISerState token) {
			return new SerializerPDAState(token.getGrammarElement(), SerStateType.PUSH);
		}

		public ISerState createState(SerializerPDA nfa, ISerState token) {
			return new SerializerPDAState(token.getGrammarElement(), SerStateType.ELEMENT);
		}

		public void setFollowers(SerializerPDA nfa, ISerState owner, Iterable<ISerState> followers) {
			((SerializerPDA.SerializerPDAState) owner).followers = Lists.newArrayList(followers);
		}
	}

	public static class SerializerPDAElementFactory implements
			PdaFactory<SerializerPDA, ISerState, RuleCall, AbstractElement> {

		public SerializerPDA create(AbstractElement start, AbstractElement stop) {
			SerializerPDA.SerializerPDAState s1 = new SerializerPDAState(start, SerStateType.START);
			SerializerPDA.SerializerPDAState s2 = new SerializerPDAState(stop, SerStateType.STOP);
			return new SerializerPDA(s1, s2);
		}

		public ISerState createPop(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.POP);
		}

		public ISerState createPush(SerializerPDA pda, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.PUSH);
		}

		public ISerState createState(SerializerPDA nfa, AbstractElement token) {
			return new SerializerPDAState(token, SerStateType.ELEMENT);
		}

		public void setFollowers(SerializerPDA nfa, ISerState owner, Iterable<ISerState> followers) {
			((SerializerPDA.SerializerPDAState) owner).followers = Lists.newArrayList(followers);
		}
	}

	protected static class SerializerPDAState implements ISerState {
		protected List<ISerState> followers = Collections.emptyList();
		protected AbstractElement grammarElement;
		protected SerStateType type;

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

		public List<ISerState> getFollowers() {
			return followers;
		}

		public AbstractElement getGrammarElement() {
			return grammarElement;
		}

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

	public Iterable<ISerState> getFollowers(ISerState state) {
		return ((SerializerPDA.SerializerPDAState) state).followers;
	}

	public RuleCall getPop(ISerState state) {
		SerializerPDA.SerializerPDAState s = (SerializerPDA.SerializerPDAState) state;
		return s.type == SerStateType.POP ? (RuleCall) s.grammarElement : null;
	}

	public RuleCall getPush(ISerState state) {
		SerializerPDA.SerializerPDAState s = (SerializerPDA.SerializerPDAState) state;
		return s.type == SerStateType.PUSH ? (RuleCall) s.grammarElement : null;
	}

	public ISerState getStart() {
		return start;
	}

	public ISerState getStop() {
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
/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.ImportManager;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TreeAppendable implements ITreeAppendable, IAcceptor<String>, CharSequence {

	/**
	 * A {@link org.eclipse.xtext.xbase.compiler.output.TreeAppendable.Visitor visitor} can be used
	 * to manipulate an existing {@link TreeAppendable} or to create a completely new one recursively.
	 * Implementors may override {@link #visit(String)} and {@link #visit(TreeAppendable)}
	 */
	public abstract static class Visitor {
		/**
		 * Manipulate the given appendable or return a new one.
		 * @param original the visited {@link TreeAppendable}
		 * @return the original appendable or a new one.
		 */
		protected TreeAppendable visit(TreeAppendable original) {
			visitChildren(original);
			return original;
		}

		/**
		 * Traverses the children of the given appendable and manipulates it in-place.
		 * @param parent the appendable whose children should be visited.
		 */
		protected void visitChildren(TreeAppendable parent) {
			for (int i = 0; i < parent.children.size(); i++) {
				Object o = parent.children.get(i);
				if (o instanceof String) {
					parent.children.set(i, visit((String) o));
				} else {
					parent.children.set(i, visit((TreeAppendable) o));
				}
			}
		}

		/**
		 * Manipulate the given string and return the result.
		 * @param string the visited {@link String}
		 * @return the original string or a new one.
		 */
		protected String visit(String string) {
			return string;
		}
	}

	private List<Object> children;
	private final SharedAppendableState state;
	private final ILocationInFileProvider locationProvider;
	final LocationData locationData;
	private boolean closed = false;

	public TreeAppendable(ImportManager importManager, ILocationInFileProvider locationProvider, EObject source,
			String indentation, String lineSeparator) {
		this(new SharedAppendableState(indentation, lineSeparator, importManager), locationProvider, source);
	}

	protected TreeAppendable(SharedAppendableState state, ILocationInFileProvider locationProvider, EObject source) {
		this(state, locationProvider, new LocationData(locationProvider, source));
	}

	protected TreeAppendable(SharedAppendableState state, ILocationInFileProvider locationProvider,
			@Nullable LocationData sourceLocation) {
		this.state = state;
		this.locationProvider = locationProvider;
		this.children = Lists.newArrayList();
		this.locationData = sourceLocation;
	}

	public TreeAppendable trace(EObject object) {
		if (locationData == null)
			return this;
		// TODO use locationProvider from service registry
		LocationData newData = new LocationData(locationProvider, object);
		if (newData.equals(locationData)) {
			return this;
		}
		TreeAppendable result = new TreeAppendable(state, locationProvider, newData);
		children.add(result);
		return result;
	}

	public TreeAppendable acceptVisitor(TreeAppendable.Visitor visitor) {
		return visitor.visit(this);
	}

	public LocationData getLocationData() {
		return locationData;
	}
	
	public List<? extends Object> getChildren() {
		return children;
	}

	public void accept(@Nullable String text) {
		children.add(text);
	}

	protected void markClosed() {
		if (closed)
			return;
		closeLastChild();
	}

	protected void closeLastChild() {
		if (closed) {
			throw new IllegalStateException("TreeAppendable was already closed");
		}
		if (!children.isEmpty()) {
			Object lastChild = children.get(children.size() - 1);
			if (lastChild instanceof TreeAppendable) {
				((TreeAppendable) lastChild).markClosed();
			}
		}
	}

	public TreeAppendable append(JvmType type) {
		closeLastChild();
		state.appendType(type, this);
		return this;
	}
	
	public ITreeAppendable append(ITreeAppendable other) {
		closeLastChild();
		if (other instanceof TreeAppendable) {
			((TreeAppendable) other).markClosed();
		} else {
			// TODO improve
			throw new IllegalArgumentException("Unexpected implementation");
		}
		children.add(other);
		return this;
	}

	public TreeAppendable append(String string) {
		closeLastChild();
		appendIndented(string);
		return this;
	}

	public TreeAppendable appendUnsafe(String string) {
		accept(string);
		return this;
	}

	public TreeAppendable newLine() {
		closeLastChild();
		state.appendNewLineAndIndentation(this);
		return this;
	}

	public TreeAppendable increaseIndentation() {
		closeLastChild();
		state.increaseIndentation();
		return this;
	}

	public TreeAppendable decreaseIndentation() {
		closeLastChild();
		state.decreaseIndentation();
		return this;
	}

	public List<String> getImports() {
		return state.getImports();
	}

	public void openScope() {
		state.openScope();
	}

	public void openPseudoScope() {
		state.openPseudoScope();
	}

	public String declareVariable(Object key, String proposedName) {
		return state.declareVariable(key, proposedName);
	}

	public String declareSyntheticVariable(Object key, String proposedName) {
		return state.declareSyntheticVariable(key, proposedName);
	}

	public String getName(Object key) {
		return state.getName(key);
	}

	public boolean hasName(Object key) {
		return state.hasName(key);
	}

	public Object getObject(String name) {
		return state.getObject(name);
	}

	public boolean hasObject(String name) {
		return state.hasObject(name);
	}

	public void closeScope() {
		state.closeScope();
	}

	public String getContent() {
		StringBuilder result = new StringBuilder(8 * 1024);
		doGetContent(result);
		return result.toString();
	}
	
	public char charAt(int index) {
		return toString().charAt(index);
	}
	
	public CharSequence subSequence(int start, int end) {
		return toString().subSequence(start, end);
	}
	
	@Override
	public String toString() {
		return getContent();
	}

	protected void doGetContent(StringBuilder result) {
		for (Object child : children) {
			if (child instanceof String) {
				result.append(child);
			} else {
				((TreeAppendable) child).doGetContent(result);
			}
		}
	}

	public int length() {
		return toString().length();
	}

	public AbstractTraceRegion getTraceRegion() {
		if (locationData == null) {
			throw new IllegalStateException("tree appendabel was used without tracing");
		}
		return new LocationBasedTraceRegion(null, this, 0);
	}

	protected void appendIndented(String text) {
		int length = text.length();
		int nextLineOffset = 0;
		int idx = 0;
		while (idx < length) {
			char currentChar = text.charAt(idx);
			// check for \r or \r\n
			if (currentChar == '\r') {
				int delimiterLength = 1;
				if (idx + 1 < length && text.charAt(idx + 1) == '\n') {
					delimiterLength++;
					idx++;
				}
				int lineLength = idx - delimiterLength - nextLineOffset + 1;
				children.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
				state.appendNewLineAndIndentation(this);
				nextLineOffset = idx + 1;
			} else if (currentChar == '\n') {
				int lineLength = idx - nextLineOffset;
				children.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
				state.appendNewLineAndIndentation(this);
				nextLineOffset = idx + 1;
			}
			idx++;
		}
		if (nextLineOffset != length) {
			int lineLength = length - nextLineOffset;
			children.add(text.substring(nextLineOffset, nextLineOffset + lineLength));
		}
	}

}

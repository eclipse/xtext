/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IAppendable {

	IAppendable append(Object obj);

	IAppendable increaseIndentation();

	IAppendable decreaseIndentation();
	
	List<String> getImports();

	void openScope();

	String declareVariable(Object key, String proposedName);

	String getName(Object key);

	void closeScope();

	public static class StringBuilderBasedAppendable implements IAppendable {

		private StringBuilder builder = new StringBuilder(8 * 1024);
		private int indentationlevel = 0;
		private String indentation = "  ";

		public IAppendable append(Object obj) {
			if (obj instanceof Later) {
				throw new IllegalArgumentException("Later cannot be appended. Call exec on it.");
			}
			if (obj instanceof JvmTypeReference) {
				appendTypeRef((JvmTypeReference)obj);
			} else if (obj instanceof JvmType) {
				appendType((JvmType)obj);
			} else {
				String string = String.valueOf(obj);
				String replaced = string.replace("\n", getIndentationString());
				builder.append(replaced);
			}
			return this;
		}

		private CharSequence getIndentationString() {
			StringBuilder sb = new StringBuilder(10);
			sb.append("\n");
			for (int i = 0; i < indentationlevel; i++) {
				sb.append(indentation);
			}
			return sb.toString();
		}

		@Override
		public String toString() {
			return builder.toString();
		}

		public IAppendable increaseIndentation() {
			indentationlevel++;
			return this;
		}

		public IAppendable decreaseIndentation() {
			if (indentationlevel == 0)
				throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
			indentationlevel--;
			return this;
		}

		private Stack<Map<Object, String>> localVars = new Stack<Map<Object, String>>();
		private boolean organizeImports;
		
		public StringBuilderBasedAppendable(boolean organizeImports){
			this.organizeImports = organizeImports;
			openScope();
		}
		
		public StringBuilderBasedAppendable(){
			this(false);
		}

		public void openScope() {
			localVars.push(new HashMap<Object, String>());
		}

		public String declareVariable(Object key, String proposedName) {
			if (localVars.isEmpty())
				throw new IllegalStateException("No local scope has been opened.");
			Map<Object, String> currentScope = localVars.peek();
			String newName = findNewName(new HashSet<String>(currentScope.values()), proposedName);
			currentScope.put(key, newName);
			return newName;
		}

		protected String findNewName(HashSet<String> names, String proposedName) {
			if (names.contains(proposedName)) {
				for (int i = 1; i < Integer.MAX_VALUE; i++) {
					String newProposal = proposedName + "_" + i;
					if (!names.contains(newProposal))
						return newProposal;
				}
			}
			return proposedName;
		}

		public String getName(Object key) {
			if (localVars.isEmpty())
				throw new IllegalStateException("No local scope has been opened.");
			int size = localVars.size();
			int i = size-1;
			while (i>=0) {
				Map<Object, String> currentScope = localVars.get(i--);
				final String string = currentScope.get(key);
				if (string !=null)
					return string;
			}
			return null;
		}

		public void closeScope() {
			if (localVars.isEmpty())
				throw new IllegalStateException("No local scope has been opened.");
			localVars.pop();
		}
		
		private Map<String,String> imports = newHashMap();

		protected void appendTypeRef(JvmTypeReference typeRef) {
			if (typeRef instanceof JvmParameterizedTypeReference) {
				final JvmType type = typeRef.getType();
				appendType(type);
				EList<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) typeRef).getArguments();
				if (!arguments.isEmpty()) {
					append("<");
					Iterator<JvmTypeReference> iterator = arguments.iterator();
					while (iterator.hasNext()) {
						JvmTypeReference jvmTypeReference = iterator.next();
						appendTypeRef(jvmTypeReference);
						if (iterator.hasNext())
							append(",");
					}
					append(">");
				}
			} else if (typeRef instanceof JvmWildcardTypeReference) {
				append("?");
				Iterator<JvmTypeConstraint> iterator = ((JvmWildcardTypeReference) typeRef).getConstraints().iterator();
				while (iterator.hasNext()) {
					JvmTypeConstraint constraint = iterator.next();
					if (constraint instanceof JvmUpperBound) {
						append(" extends ");
					} else {
						append(" super ");
					}
					appendTypeRef(constraint.getTypeReference());
					if (iterator.hasNext())
						append(" & ");
				}
			} else if (typeRef instanceof JvmGenericArrayTypeReference) {
				append(typeRef.getType());
			}
		}

		protected void appendType(final JvmType type) {
			if (type instanceof JvmPrimitiveType || type instanceof JvmVoid || type instanceof JvmTypeParameter) {
				append(type.getQualifiedName('.'));
			} else if (type instanceof JvmArrayType) {
				appendTypeRef(((JvmArrayType) type).getComponentType());
				append("[]");
			} else {
				final String qn = type.getQualifiedName('.');
				final String simpleName = type.getSimpleName();
				if (qn.startsWith("java.lang.")) {
					append(simpleName);
				} else if (!organizeImports) {
					append(qn);
				} else {
					if (imports.containsKey(simpleName)) {
						if (qn.equals(imports.get(simpleName))) {
							append(simpleName);
						} else {
							append(qn);
						}
					} else {
						imports.put(simpleName, qn);
						append(simpleName);
					}
				}
			}
		}

		public List<String> getImports() {
			ArrayList<String> result = newArrayList(imports.values());
			Collections.sort(result);
			return result;
		}

	}

}

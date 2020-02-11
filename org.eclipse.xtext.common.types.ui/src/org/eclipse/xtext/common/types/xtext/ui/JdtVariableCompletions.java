/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.NamingConventions;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.inject.Inject;

/**
 * 
 * Utilities and Facade to the {@link NamingConventions}.
 * It is not based on a parser (i.e. from XTypes) to allow languages with other syntaxes to use this.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class JdtVariableCompletions {
	
	public interface CompletionDataAcceptor {
		void accept(String replaceText, StyledString label, Image img);
	}
	
	public enum VariableType {
		INSTANCE_FIELD,
		PARAMETER,
		LOCAL_VAR,
		STATIC_FIELD
	}

	@Inject
	private IJavaProjectProvider javaProjectProvider;

	public void getVariableProposals(EObject ctx, EReference refToTypeRef, VariableType varType, Set<String> notAllowedNames, CompletionDataAcceptor acceptor) {
		String typeName = getTextUnderReference(ctx, refToTypeRef);
		internalGetVariableProposals(typeName, ctx, varType, notAllowedNames, acceptor);
	}
	/**
	 * @since 2.3
	 */
	public void getVariableProposals(String typeName, EObject ctx, VariableType varType,
			Set<String> notAllowedNames, CompletionDataAcceptor acceptor){
		internalGetVariableProposals(typeName, ctx, varType, notAllowedNames, acceptor);
	}

	protected void internalGetVariableProposals(String typeName, EObject ctx, VariableType varType,
			Set<String> notAllowedNames, CompletionDataAcceptor acceptor) {
		boolean isMany = false;
		String baseType = null;
		if (isCollectionType(typeName)) {
			baseType = getFirstTypeArgumentSimpleName(typeName);
			isMany = true;
		} else if (isArray(typeName)) {
			baseType = getArrayComponentTypeSimpleName(typeName);
			isMany = true;
		} else {
			baseType = getRawTypeSimpleName(typeName);
		}
		
		for (String string : getVariableProposals(baseType, isMany, ctx, varType, notAllowedNames)) {
			acceptor.accept(string,
					new StyledString(string + " : " + typeName),
					getImage(ctx));
		}
	}
	
	protected boolean isCollectionType(String typeName) {
		return getCollectionTypes().contains(getRawTypeSimpleName(typeName)) && getFirstTypeArgumentSimpleName(typeName) != null;
	}
	
	protected boolean isArray(String typeName) {
		return getArrayComponentTypeSimpleName(typeName) != null;
	}
	
	protected String getArrayComponentTypeSimpleName(String typeName) {
		int idx = typeName.indexOf('[');
		if (idx != -1) {
			return getSimpleName(typeName.substring(0, idx));
		}
		return null;
	}

	protected Image getImage(EObject context) {
		return JavaPlugin.getImageDescriptorRegistry().get(JavaPluginImages.DESC_OBJS_LOCAL_VARIABLE);
	}

	/**
	 * @return the simple name of the main type (raw type) of the given type name.
	 */
	protected String getRawTypeSimpleName(String typeName) {
		final int idxOfFirstBracket = typeName.indexOf('<');
		if (idxOfFirstBracket != -1) {
			String mainType = typeName.substring(0, idxOfFirstBracket);
			return getSimpleName(mainType);
		}
		return getSimpleName(typeName);
	}

	/**
	 * @return the simple name of the first argument of a Java Type Reference or null if the given string
	 *         doesn't have a first type argument.
	 */
	protected String getFirstTypeArgumentSimpleName(String typeName) {
		final int idxOfFirstBracket = typeName.indexOf(leftTypeArgParen());
		if (idxOfFirstBracket != -1) {
			final int afterFirstBracket = idxOfFirstBracket+1;
			int index = typeName.indexOf(rightTypeArgParen(), afterFirstBracket);
			if (index == -1)
				return null;
			int idx1 = typeName.indexOf(typeArgSeparator(), afterFirstBracket);
			if (idx1 != -1 && idx1 < index) {
				index = idx1;
			}
			int idx2 = typeName.indexOf(leftTypeArgParen(), afterFirstBracket);
			if (idx2 != -1 && idx2 < index) {
				index = idx2;
			}
			final String substring = typeName.substring(afterFirstBracket, index);
			String firstInnerType = getSimpleName(substring);
			return firstInnerType;
		}
		return null;
	}

	protected String typeArgSeparator() {
		return ",";
	}

	protected String rightTypeArgParen() {
		return ">";
	}

	protected String leftTypeArgParen() {
		return "<";
	}

	protected Set<String> getCollectionTypes() {
		return newHashSet("Collection", "List", "Iterable", "Set", "Iterator", "HashSet", "LinkedHashSet", "ArrayList",
				"LinkedList");
	}

	protected String getSimpleName(String mainType) {
		if (mainType.indexOf('.') != -1) {
			return mainType.substring(mainType.lastIndexOf('.') + 1);
		}
		return mainType;
	}

	protected String getTextUnderReference(EObject ctx, EReference refToTypeRef) {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(ctx, refToTypeRef);
		StringBuilder sb = new StringBuilder();
		for (INode n : nodes) {
			sb.append(NodeModelUtils.getTokenText(n));
		}
		return sb.toString();
	}

	public String[] getVariableProposals(String simpleTypeName, boolean isPlural, EObject ctx, VariableType varType, Set<String> excludedNames) {
		if (!org.eclipse.xtext.util.Strings.isEmpty(simpleTypeName)) {
			IJavaProject javaProject = null;
			if (ctx != null && ctx.eResource() != null && ctx.eResource().getResourceSet() != null)
				javaProject = javaProjectProvider.getJavaProject(ctx.eResource().getResourceSet());
			return NamingConventions.suggestVariableNames(getVariableKind(varType),
					NamingConventions.BK_TYPE_NAME, simpleTypeName, javaProject, isPlural?1:0, excludedNames.toArray(new String[excludedNames.size()]), false);
		}
		return new String[0];
	}

	protected int getVariableKind(VariableType varType) {
		switch (varType) {
			case INSTANCE_FIELD :
				return NamingConventions.VK_INSTANCE_FIELD;
			case LOCAL_VAR :
				return NamingConventions.VK_LOCAL;
			case PARAMETER :
				return NamingConventions.VK_PARAMETER;
			case STATIC_FIELD:
				return NamingConventions.VK_STATIC_FINAL_FIELD;
			default:
				throw new IllegalStateException("unhandled enum const"+varType);
		}
	}
}

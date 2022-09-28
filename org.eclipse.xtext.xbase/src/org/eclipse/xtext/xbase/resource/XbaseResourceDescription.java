/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xtype.XImportDeclaration;

import com.google.common.collect.Iterables;

/**
 * @since 2.29
 */
public class XbaseResourceDescription extends DefaultResourceDescription {
	protected static class PrimitiveNamesFilteringSet extends HashSet<QualifiedName> {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean add(QualifiedName e) {
			if (e != null) {
				switch (e.getLastSegment()) {
					case "boolean":
					case "int":
					case "char":
					case "byte":
					case "short":
					case "long":
					case "double":
					case "float":
					case "void":
						return false;
					default:
						return super.add(e);
				}
			}
			return false;
		}
	}

	private IBatchTypeResolver typeResolver;

	private IQualifiedNameConverter nameConverter;

	private Set<QualifiedName> importedNames;

	public XbaseResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy,
			IResourceScopeCache cache, IBatchTypeResolver typeResolver, IQualifiedNameConverter nameConverter) {
		super(resource, strategy, cache);
		this.typeResolver = typeResolver;
		this.nameConverter = nameConverter;
	}
	
	@Override
	protected EObjectDescriptionLookUp getLookUp() {
		if (lookup == null)
			lookup = new EObjectDescriptionLookUp(computeExportedObjects());
		return lookup;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		if (importedNames != null) {
			return importedNames;
		}
		Set<QualifiedName> result = createEmptyImportedNamesSet();
		Resource resource = getResource();
		List<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			IResolvedTypes types = typeResolver.resolveTypes(resource);
			TreeIterator<Object> iter = EcoreUtil.getAllContents(resource, true);
			while(iter.hasNext()) {
				Object content = iter.next();
				if (content instanceof XExpression) {
					LightweightTypeReference typeReference = types.getActualType((XExpression) content);
					if (typeReference != null) {
						registerAllTypes(typeReference.getType(), result);
					}
					if (content instanceof XMemberFeatureCall) {
						// an unresolved member feature call, where the receiver is a type literal could potentially become
						// a reference to a nested type
						XMemberFeatureCall casted = (XMemberFeatureCall) content;
						if (casted.getFeature() != null && casted.getFeature().eIsProxy() && !casted.isExplicitOperationCallOrBuilderSyntax()) {
							XExpression receiver = casted.getActualReceiver();
							if (receiver instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) receiver).isTypeLiteral()) {
								JvmIdentifiableElement type = ((XAbstractFeatureCall) receiver).getFeature();
								QualifiedName maybeType = nameConverter.toQualifiedName(type.getIdentifier() + "$" + casted.getConcreteSyntaxFeatureName()).toLowerCase();
								result.add(maybeType);
							}
							continue;
						}
					}
					if (content instanceof XAbstractFeatureCall) {
						XAbstractFeatureCall casted = (XAbstractFeatureCall) content;
						if (casted.isTypeLiteral()) {
							JvmIdentifiableElement feature = casted.getFeature();
							if (feature instanceof JvmDeclaredType) {
								registerAllTypes((JvmType) feature, result);
							}
						}
					}
				}
				if (content instanceof XImportDeclaration) {
					registerAllTypes(((XImportDeclaration) content).getImportedType(), result);
				}
				if (content instanceof JvmIdentifiableElement && (!(content instanceof JvmType) || content instanceof JvmDeclaredType)) {
					JvmIdentifiableElement casted = (JvmIdentifiableElement) content;
					LightweightTypeReference typeRef = types.getActualType(casted);
					if (typeRef != null) {
						registerAllTypes(typeRef.getType(), result);
					}
				}
			}
		}
		Iterables.addAll(result, super.getImportedNames());
		return importedNames = Collections.unmodifiableSet(result);
	}
	
	protected Set<QualifiedName> createEmptyImportedNamesSet() {
		return new PrimitiveNamesFilteringSet();
	}

	protected void registerAllTypes(JvmType type, Set<QualifiedName> result) {
		if (type == null || type.eIsProxy()) {
			return;
		}
		if (!isLocal(type) && type instanceof JvmDeclaredType
				&& result.add(nameConverter.toQualifiedName(type.getIdentifier()).toLowerCase())) {
			if (type instanceof JvmGenericType) {
				JvmGenericType genericType = (JvmGenericType) type;
				registerAllTypes(genericType.getDeclaringType(), result);
				JvmTypeReference extendedClass = genericType.getExtendedClass();
				if (extendedClass != null) {
					registerAllTypes(extendedClass.getType(), result);
				}
				for (JvmTypeReference intf : genericType.getExtendedInterfaces()) {
					registerAllTypes(intf.getType(), result);
				}
			}
		}
	}

	protected boolean isLocal(JvmType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isLocal();
	}
}

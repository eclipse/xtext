/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.xtext.xbase.compiler.ISourceAppender;

import com.google.common.collect.Iterables;

public class LightweightTypeReferenceSerializer extends TypeReferenceVisitor {
	private ISourceAppender appender;

	public LightweightTypeReferenceSerializer(ISourceAppender appender) {
		this.appender = appender;
	}

	@Override
	protected void doVisitAnyTypeReference(AnyTypeReference reference) {
		reference.toJavaType().accept(this);
	}

	@Override
	protected void doVisitArrayTypeReference(ArrayTypeReference reference) {
		reference.getComponentType().accept(this);
		appender.append("[]");
	}

	@Override
	protected void doVisitCompoundTypeReference(CompoundTypeReference reference) {
		reference.toJavaType().accept(this);
	}

	@Override
	protected void doVisitFunctionTypeReference(FunctionTypeReference reference) {
		if (appender.isJava()) {
			doVisitParameterizedTypeReference(reference);
		} else {
			appender.append("(");
			appendCommaSeparated(reference.getParameterTypes());
			appender.append(")=>");
			if (reference.getReturnType() == null) {
				appender.append("void");
			} else {
				reference.getReturnType().accept(this);
			}
		}
	}

	@Override
	protected void doVisitInnerFunctionTypeReference(InnerFunctionTypeReference reference) {
		if (appender.isJava()) {
			reference.getOuter().accept(this);
			appender.append(".");
			appender.append(reference.getType().getSimpleName());
			if (!reference.getTypeArguments().isEmpty()) {
				appender.append("<");
				appendCommaSeparated(reference.getTypeArguments());
				appender.append(">");
			}
		} else {
			appender.append("(");
			appendCommaSeparated(reference.getParameterTypes());
			appender.append(")=>");
			if (reference.getReturnType() == null) {
				appender.append("void");
			} else {
				reference.getReturnType().accept(this);
			}
		}
	}

	@Override
	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		if (reference.isAnonymous()) {
			reference.getNamedType().accept(this);
		} else {
			appender.append(reference.getType());
			if (!reference.getTypeArguments().isEmpty()) {
				appender.append("<");
				appendCommaSeparated(reference.getTypeArguments());
				appender.append(">");
			}
		}
	}

	@Override
	protected void doVisitInnerTypeReference(InnerTypeReference reference) {
		reference.getOuter().accept(this);
		appender.append(".");
		appender.append(reference.getType().getSimpleName());
		if (!reference.getTypeArguments().isEmpty()) {
			appender.append("<");
			appendCommaSeparated(reference.getTypeArguments());
			appender.append(">");
		}
	}

	@Override
	protected void doVisitUnboundTypeReference(UnboundTypeReference reference) {
		reference.toJavaType().accept(this);
	}

	@Override
	protected void doVisitUnknownTypeReference(UnknownTypeReference reference) {
		appender.append(reference.getSimpleName());
	}

	@Override
	protected void doVisitWildcardTypeReference(WildcardTypeReference reference) {
		appender.append("?");
		if (reference.getLowerBound() != null) {
			appender.append(" super ");
			reference.getLowerBound().accept(this);
		} else {
			Iterable<LightweightTypeReference> relevantUpperBounds = Iterables.filter(reference.getUpperBounds(),
					(it) -> !"java.lang.Object".equals(it.getIdentifier()));
			if (!Iterables.isEmpty(relevantUpperBounds)) {
				appender.append(" extends ");
				boolean isFirst = true;
				for (LightweightTypeReference upperBound : relevantUpperBounds) {
					if (!isFirst) {
						appender.append(" & ");
					}
					isFirst = false;
					upperBound.accept(this);
				}
			}
		}
	}

	protected void appendCommaSeparated(List<LightweightTypeReference> references) {
		boolean isFirst = true;
		for (LightweightTypeReference reference : references) {
			if (!isFirst) {
				appender.append(", ");
			}
			isFirst = false;
			reference.accept(this);
		}
	}
}

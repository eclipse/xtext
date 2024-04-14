/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.signatureHelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.ParameterInformation;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureHelpParams;
import org.eclipse.lsp4j.SignatureInformation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.signatureHelp.ISignatureHelpService;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.OperationCall;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Signature help service implementation for the test language.
 * 
 * @author akos.kitta - Initial contribution and API
 */
public class SignatureHelpServiceImpl implements ISignatureHelpService {
	private static final String OPENING_CHAR = "(";

	private static final String CLOSING_CHAR = ")";

	private static final String SEPARATOR_CHAR = ",";

	/**
	 * Shared comparator singleton to compare {@link SignatureInformation
	 * signature information} instances based on the number of parameters first,
	 * then the parameter labels lexicographically.
	 */
	private static final Comparator<SignatureInformation> SIGNATURE_INFO_ORDERING = (Comparator<SignatureInformation>) (
			SignatureInformation left, SignatureInformation right) -> {
		int result = left.getParameters().size()- right.getParameters().size();
		if (result == 0) {
			int i = 0;
			int size = left.getParameters().size();
			while (i < size) {
				result = left.getParameters().get(i).getLabel().getLeft()
						.compareTo(right.getParameters().get(i).getLabel().getLeft());
				if (result != 0) {
					return result;
				}
				i++;
			}
		}
		return result;
	};

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	@Inject
	private IScopeProvider scopeProvider;

	@Override
	public SignatureHelp getSignatureHelp(Document document, XtextResource resource, SignatureHelpParams params,
			CancelIndicator cancelIndicator) {
		int offset = document.getOffSet(params.getPosition());
		Preconditions.checkNotNull(resource, "resource");
		Preconditions.checkArgument(offset >= 0, "offset >= 0. Was: " + offset);
		EObject object = offsetHelper.resolveContainedElementAt(resource, offset);
		if (object instanceof OperationCall) {
			String operationName = getOperationName((OperationCall) object);
			if (!Strings.isNullOrEmpty(operationName)) {
				return getSignatureHelp((OperationCall) object, operationName, offset);
			}
		}
		return ISignatureHelpService.EMPTY;
	}

	private SignatureHelp getSignatureHelp(OperationCall call, String operationName, int offset) {
		// If the offset exceeds either the opening or the closing characters'
		// offset we should not
		// provide signature help at all.

		List<Integer> separatorIndices = new ArrayList<>();
		for (INode node : NodeModelUtils.getNode(call).getChildren()) {
			String text = node.getText();
			if (SignatureHelpServiceImpl.OPENING_CHAR.equals(text) && node.getOffset() >= offset) {
				return ISignatureHelpService.EMPTY;
			} else {
				if (SignatureHelpServiceImpl.CLOSING_CHAR.equals(text) && node.getOffset() < offset) {
					return ISignatureHelpService.EMPTY;
				} else {
					if (SignatureHelpServiceImpl.SEPARATOR_CHAR.equals(text)) {
						separatorIndices.add(node.getOffset());
					}
				}
			}
		}
		// Here we will distinguish between three different AST states:
		// 1. Valid state: when the number of parameter separators equals with
		// the number of (parameters - 1)
		// and each separator is surrounded by two parameters.
		// 2. Broken recoverable state: the number of parameters equals with the
		// number of separators and the
		// last separator offset is greater than the last parameter (offset +
		// length) and each separator is
		// surrounded by two parameters. Expect the last separator.
		// 3. Broken inconsistent state: non of the above cases.
		int paramCount = call.getParams().size();
		int separatorCount = separatorIndices.size();
		if (separatorCount+ 1 == paramCount || separatorCount == paramCount) {
			List<INode> paramNodes = NodeModelUtils.findNodesForFeature(call,
					TestLanguagePackage.Literals.OPERATION__PARAMS);
			// Parameter count could be greater than separator count.
			for (int i = 0; i < separatorCount; i++) {
				INode paramNode = paramNodes.get(i);
				// If separator is not after a parameter, signature help
				// should not be provided.
				if (paramNode.getOffset()+ paramNode.getLength() > separatorIndices.get(i).intValue()) {
					return ISignatureHelpService.EMPTY;
				}
			}
		} else {
			return ISignatureHelpService.EMPTY;
		}
		final int currentParameter;
		if (paramCount != 0) {
			if (separatorIndices.contains(offset)) {
				currentParameter = separatorIndices.indexOf(offset)+ 2;
			} else {
				// Here we can execute a binary search for sure, because the
				// nodes where visited in order.
				currentParameter = -Collections.binarySearch(separatorIndices, offset);
			}
		} else {
			currentParameter = 0;
		}
		Iterable<Operation> visibleOperations = Iterables.filter(getVisibleOperationsWithName(call, operationName),
				it -> currentParameter <= it.getParams().size());
		int paramOffset = separatorIndices.contains(offset) ? 2 : 1;
		final Integer activeParamIndex;
		if (paramCount == 0) {
			Iterable<Integer> paramSize = Iterables.transform(visibleOperations, it -> it.getParams().size());
			// If on declaration-side no no-args exists, propose the first
			// parameter on use-side.
			if (!Iterables.any(paramSize, it -> it.intValue() == 0)
					&& Iterables.any(visibleOperations, it -> !it.getParams().isEmpty())) {
				activeParamIndex = 0;
			} else {
				activeParamIndex = null;
			}
		} else {
			activeParamIndex = currentParameter - paramOffset;
		}
		SignatureHelp signatureHelp = new SignatureHelp();
		signatureHelp.setActiveParameter(activeParamIndex);
		signatureHelp.setActiveSignature(0);
		signatureHelp.setSignatures(IterableExtensions
				.sortWith(IterableExtensions.toList(Iterables.transform(visibleOperations, (Operation operation) -> {
					SignatureInformation signatureInformation = new SignatureInformation(getLabel(operation));
					signatureInformation.setParameters(
							Lists.transform(operation.getParams(), (Parameter param) -> new ParameterInformation(
									param.getName() + ": " + getLabel(param.getType()))));
					return signatureInformation;
				})), SignatureHelpServiceImpl.SIGNATURE_INFO_ORDERING));
		return signatureHelp;
	}

	private Iterable<Operation> getVisibleOperationsWithName(EObject object, String name) {
		return Iterables.filter(Iterables.transform(
				Iterables.filter(Iterables.filter(
						scopeProvider.getScope(object, TestLanguagePackage.Literals.OPERATION_CALL__OPERATION)
								.getAllElements(),
						(IEObjectDescription it) -> it.getEClass() == TestLanguagePackage.Literals.OPERATION),
						(IEObjectDescription it) -> Objects.equals(it.getQualifiedName().getLastSegment(), name)),
				IEObjectDescription::getEObjectOrProxy), Operation.class);
	}

	private String getOperationName(OperationCall call) {
		INode firstNode = Iterables.getFirst(
				NodeModelUtils.findNodesForFeature(call, TestLanguagePackage.Literals.OPERATION_CALL__OPERATION), null);
		if (firstNode != null) {
			return firstNode.getText();
		}
		return null;
	}

	private String getLabel(EObject it) {
		if (it instanceof Operation) {
			Operation it1 = (Operation) it;
			return EcoreUtil2.getContainerOfType(it1, TypeDeclaration.class).getName() + "." + it1.getName() + "("
					+ Joiner.on(", ")
							.join(Iterables.transform(it1.getParams(),
									(Parameter p) -> p.getName() + ": " + getLabel(p.getType())))
					+ "): " + (it1.getReturnType() == null ? "void" : getLabel(it1.getReturnType()));
		} else if (it instanceof PrimitiveType) {
			return ((PrimitiveType) it).getName();
		} else if (it instanceof TypeReference) {
			return ((TypeReference) it).getTypeRef().getName();
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(it).toString());
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend.core.formatting.MemberFromSuperImplementor;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.SemanticModificationWrapper;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.quickfix.ILinkingIssueQuickfixProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CreateMemberQuickfixes implements ILinkingIssueQuickfixProvider {

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private XtendTypeReferenceSerializer typeRefSerializer;

	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	@Inject
	private MemberFromSuperImplementor superMemberImplementor;

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private Primitives primitives;

	@Inject
	private JdtVariableCompletions jdtVariableCompletions;

	@Inject
	private IssueModificationContext.Factory modificationContextFactory;

	@Inject
	private ExpectedTypeResolver expectedTypeResolver;

	@Inject
	private UndefinedMethodFix undefinedMethodFix;

	public void addQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			IXtextDocument xtextDocument, XtextResource resource, EObject referenceOwner, EReference unresolvedReference)
			throws Exception {
		if (issue.getData() == null || issue.getData().length==0)
			return;
		String elementName = issue.getData()[0];
		if (elementName != null) {
			if (referenceOwner instanceof XMemberFeatureCall) {
				XExpression target = ((XMemberFeatureCall) referenceOwner).getMemberCallTarget();
				if (target != null && isExpressionWithName(target, XbaseScopeProvider.SUPER))
					return;
			}
			if (referenceOwner instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall call = (XAbstractFeatureCall) referenceOwner;
				StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(new ImportManager(true));
				computeTypeArguments(call, call.getTypeArguments(), appendable);
				JvmTypeReference expectedFieldType = null;
				boolean isExtension = false;
				List<XExpression> arguments = computeArguments(call, isExtension);
				if (call instanceof XMemberFeatureCall) {
					XExpression memberCallTarget = ((XMemberFeatureCall) call).getMemberCallTarget();
					isExtension = memberCallTarget != null
							&& !isExpressionWithName(memberCallTarget, XbaseScopeProvider.THIS);
				} else if (call instanceof XAssignment) {
					if (isExpressionWithName(call.getExplicitArguments().get(0), XbaseScopeProvider.IT))
						isExtension = true;
				}

				if (call instanceof XAssignment) {
					XExpression xExpression = arguments.get(0);
					expectedFieldType = typeProvider.getType(xExpression);
				}
				JvmTypeReference expectedType = typeProvider.getExpectedType(call);

				JvmTypeReference resolvedExpectedType = (expectedType != null) ? expectedTypeResolver
						.resolveExpectedType(call, expectedType) : null;
				if (resolvedExpectedType != null && resolvedExpectedType.getType() != null) {
					typeRefSerializer.serialize(resolvedExpectedType, call, appendable);
					appendable.append(" ");
				}
				if (expectedFieldType == null)
					expectedFieldType = resolvedExpectedType;
				boolean isSetter = false;
				if (call instanceof XAssignment) {
					isSetter = true;
					appendable.append("set" + StringExtensions.toFirstUpper(elementName));
				} else
					appendable.append(elementName);
				computeArgumentString(call, false, appendable, isExtension);
				IModificationContext modificationContext = modificationContextFactory.createModificationContext(issue);
				createNewXtendFunction(isSetter ? "set" + StringExtensions.toFirstUpper(elementName) : elementName,
						appendable.toString(), isExtension, resolvedExpectedType, issue, issueResolutionAcceptor,
						modificationContext);
				if (!isExtension && (arguments.size() == 0 || call instanceof XAssignment)) {
					createNewXtendField(elementName, expectedFieldType, call, issue, issueResolutionAcceptor,
							modificationContext);
					if (!(call instanceof XAssignment))
						createNewLocalVariable(elementName, resolvedExpectedType, issue, issueResolutionAcceptor,
								modificationContext);
				}
			}
		}
	}

	/**
	 * @since 2.3
	 */
	protected void createNewLocalVariable(final String elementName, JvmTypeReference expectedType, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor, IModificationContext modificationContext) {
		final StringBuilderBasedAppendable localVarDescriptionBuilder = new StringBuilderBasedAppendable();
		localVarDescriptionBuilder.append("...").newLine();
		final String defaultValueLiteral = getDefaultValueLiteral(expectedType);
		localVarDescriptionBuilder.append("val ").append(elementName).append(" = ").append(defaultValueLiteral);
		localVarDescriptionBuilder.newLine().append("...");
		issueResolutionAcceptor.accept(issue, "Create local variable '" + elementName + "'",
				localVarDescriptionBuilder.toString(), "fix_private_field.png",
				new SemanticModificationWrapper(issue.getUriToProblem(), new ISemanticModification() {
					public void apply(final EObject element, final IModificationContext context) throws Exception {
						if (element != null) {
							XtendMember xtendMember = EcoreUtil2.getContainerOfType(element, XtendMember.class);
							if (xtendMember != null) {
								int offset = getFirstOffsetOfKeyword(xtendMember, "{");
								IXtextDocument xtextDocument = context.getXtextDocument();
								if (offset != -1 && xtextDocument != null) {
									final ReplacingAppendable appendable = appendableFactory.get(xtextDocument,
											element, offset, 0, 1, false);
									appendable.increaseIndentation().newLine().append("val ").append(elementName).append(" = ")
											.append(defaultValueLiteral);
									appendable.commitChanges();
								}
							}
						}
					}
				}));
	}

	/**
	 * @since 2.3
	 */
	protected void createNewXtendFunction(@NonNull final String elementName, final @NonNull String callText,
			final boolean isExtension, final JvmTypeReference expectedType, final Issue issue,
			final IssueResolutionAcceptor issueResolutionAcceptor, IModificationContext modificationContext) {
		StringBuilderBasedAppendable methodDescriptionBuilder = new StringBuilderBasedAppendable();
		StringBuilderBasedAppendable methodLabelBuilder = new StringBuilderBasedAppendable();
		methodDescriptionBuilder.append("...").newLine().append("def ");
		methodLabelBuilder.append("Create ");
		if (isExtension)
			methodLabelBuilder.append("extension ");
		methodLabelBuilder.append("method '").append(elementName).append("'");
		methodDescriptionBuilder.append(callText).append(" {}").newLine().append("...");
		IssueResolution issueResolutionMethodInType = new IssueResolution(methodLabelBuilder.toString(),
				methodDescriptionBuilder.toString(), "fix_public_function.png", modificationContext,
				new SemanticModificationWrapper(issue.getUriToProblem(), new ISemanticModification() {
					public void apply(final EObject element, final IModificationContext context) throws Exception {
						if (element != null) {
							XAbstractFeatureCall call = (XAbstractFeatureCall) element;
							XtendClass xtendClazz = EcoreUtil2.getContainerOfType(element, XtendClass.class);
							IXtextDocument xtextDocument = context.getXtextDocument();
							doCreateNewFunctionInClazz(call, xtendClazz, expectedType, xtextDocument, callText);
						}
					}
				}));
		issueResolutionAcceptor.getIssueResolutions().add(issueResolutionMethodInType);
	}

	/**
	 * @since 2.3
	 */
	protected void doCreateNewFunctionInClazz(@NonNull XAbstractFeatureCall call, XtendClass xtendClazz,
			@Nullable JvmTypeReference expectedType, IXtextDocument xtextDocument, @NonNull String callText)
			throws BadLocationException {
		XtendFunction function = EcoreUtil2.getContainerOfType(call, XtendFunction.class);
		int offset = superMemberImplementor.getFunctionInsertOffset(xtendClazz);
		if (function != null) {
			ICompositeNode node = NodeModelUtils.getNode(function);
			if (node != null)
				offset = node.getTotalEndOffset();
		}
		final ReplacingAppendable appendable = appendableFactory.get(xtextDocument, call, offset, 0, 1, false);
		appendable.newLine().increaseIndentation().append("def ");
		appendable.append(callText);
		appendable.append(" { }").decreaseIndentation().decreaseIndentation().newLine();
		appendable.commitChanges();
	}

	/**
	 * @since 2.3
	 */
	protected void createNewXtendField(final String elementName, final JvmTypeReference expectedType,
			XAbstractFeatureCall call, final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor,
			IModificationContext modificationContext) {
		StringBuilderBasedAppendable fieldDescriptionBuilder = new StringBuilderBasedAppendable(new ImportManager(true));
		final JvmTypeReference type = (expectedType == null || expectedType.getType() == null) ? typeRefs
				.createTypeRef(typeRefs.findDeclaredType(Object.class, call)) : expectedType;
		fieldDescriptionBuilder.append("...").newLine();
		typeRefSerializer.serialize(type, call, fieldDescriptionBuilder);
		fieldDescriptionBuilder.append(" ").append(elementName).newLine().append("...");
		IssueResolution issueResolutionField = new IssueResolution("Create field '" + elementName + "'",
				fieldDescriptionBuilder.toString(), "fix_private_field.png", modificationContext,
				new SemanticModificationWrapper(issue.getUriToProblem(), new ISemanticModification() {

					public void apply(EObject element, IModificationContext context) throws Exception {
						XAbstractFeatureCall call = (XAbstractFeatureCall) element;
						XtendClass xtendClazz = EcoreUtil2.getContainerOfType(element, XtendClass.class);
						IXtextDocument xtextDocument = context.getXtextDocument();
						int openingBraceOffset = getFirstOffsetOfKeyword(xtendClazz, "{");
						if (openingBraceOffset != -1 && xtextDocument != null && call != null)
							doCreateNewFieldInClazz(elementName, call, type, xtextDocument, openingBraceOffset);
					}

				}));
		issueResolutionAcceptor.getIssueResolutions().add(issueResolutionField);
	}

	/**
	 * @since 2.3
	 */
	protected void doCreateNewFieldInClazz(@NonNull final String elementName, @NonNull XAbstractFeatureCall call,
			@NonNull JvmTypeReference expectedType, @NonNull IXtextDocument xtextDocument, int openingBraceOffset)
			throws BadLocationException {
		final ReplacingAppendable appendable = appendableFactory.get(xtextDocument, call, openingBraceOffset, 0, 1,
				false);
		appendable.newLine();
		typeRefSerializer.serialize(expectedType, call, appendable);
		appendable.append(" ").append(elementName);
		appendable.commitChanges();
	}

	/**
	 * @since 2.3
	 */
	protected int getFirstOffsetOfKeyword(EObject object, String keyword) {
		int offset = -1;
		if (object != null) {
			ICompositeNode node = NodeModelUtils.getNode(object);
			if (node != null) {
				for (ILeafNode leafNode : node.getLeafNodes()) {
					if (leafNode.getGrammarElement() instanceof Keyword
							&& equal(keyword, ((Keyword) leafNode.getGrammarElement()).getValue())) {
						return leafNode.getOffset() + 1;
					}
				}
			}
		}
		return offset;
	}

	/**
	 * @since 2.3
	 */
	protected String getDefaultValueLiteral(JvmTypeReference type) {
		if (primitives.isPrimitive(type)) {
			Primitive primitiveKind = primitives.primitiveKind((JvmPrimitiveType) type.getType());
			if (primitiveKind == Primitive.Boolean)
				return "false";
			else
				return "0 as " + type.getSimpleName();
		}
		return "null";
	}

	/**
	 * @since 2.3
	 */
	protected void computeArgumentString(XAbstractFeatureCall call, boolean paramNames, final IAppendable appendable,
			boolean isExtension) {
		Iterator<XExpression> iterator = computeArguments(call, isExtension).iterator();
		final Set<String> notallowed = Sets.newHashSet();
		appendable.append("(");
		while (iterator.hasNext()) {
			XExpression expression = iterator.next();
			JvmTypeReference typeRef = typeProvider.getType(expression);
			if (typeRef != null) {
				typeRefSerializer.serialize(typeRef, call, appendable);
				appendable.append(" ");
				VariableNameAcceptor acceptor = new VariableNameAcceptor(notallowed);
				jdtVariableCompletions.getVariableProposals(typeRef.getIdentifier(), call,
						JdtVariableCompletions.VariableType.PARAMETER, notallowed, acceptor);
				appendable.append(acceptor.getVariableName());
			}
			if (iterator.hasNext())
				appendable.append(", ");
		}
		appendable.append(")");
	}

	protected List<XExpression> computeArguments(XAbstractFeatureCall call, boolean isExtension) {
		List<XExpression> arguments = Lists.newArrayList(call.getExplicitArguments());
		if (call instanceof XMemberFeatureCall && !isExtension)
			arguments.remove(((XMemberFeatureCall) call).getMemberCallTarget());
		else if (call instanceof XAssignment) {
			XExpression firstArgument = arguments.get(0);
			if (isExpressionWithName(firstArgument, XbaseScopeProvider.THIS))
				arguments.remove(firstArgument);

		}
		return arguments;
	}

	protected boolean isExpressionWithName(XExpression expression, QualifiedName fqn) {
		ICompositeNode node = NodeModelUtils.getNode(expression);
		if (node != null) {
			String string = node.getText().trim();
			if (string.equals(fqn.toString()))
				return true;
		}
		return false;
	}

	@Fix(org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_NUMBER_OF_ARGUMENTS)
	public void fixInvalidNumberOfArguments(final Issue issue, IssueResolutionAcceptor acceptor) {
		fixUndefinedMethod(issue, acceptor);
	}

	protected void fixUndefinedMethod(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		final IModificationContext modificationContext = modificationContextFactory.createModificationContext(issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if (xtextDocument != null) {
			xtextDocument.modify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					EObject eObject = state.getEObject(issue.getUriToProblem().fragment());
					XMemberFeatureCall memberFeatureCall = EcoreUtil2.getContainerOfType(eObject,
							XMemberFeatureCall.class);
					if (memberFeatureCall == null) {
						return;
					}
					undefinedMethodFix.apply(issue, issueResolutionAcceptor, memberFeatureCall);
				}
			});
		}
	}

	protected final class VariableNameAcceptor implements JdtVariableCompletions.CompletionDataAcceptor {
		private final Set<String> notallowed;
		Set<String> variableNames = Sets.newHashSet();

		private VariableNameAcceptor(Set<String> notallowed) {
			this.notallowed = notallowed;
		}

		public void accept(String replaceText, StyledString label, Image img) {
			variableNames.add(replaceText);
			notallowed.add(replaceText);
		}

		public String getVariableName() {
			ArrayList<String> candidates = Lists.newArrayList(variableNames);
			Collections.sort(candidates, new Comparator<String>() {
				public int compare(String left, String right) {
					if (left.length() < right.length()) {
						return -1;
					} else if (left.length() > right.length()) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			if (candidates.size() > 0)
				return candidates.get(0);
			return "";
		}
	}

	/**
	 * @since 2.3
	 */
	protected void computeTypeArguments(XExpression expression, List<JvmTypeReference> typeArguments,
			final IAppendable appendable) {
		if (typeArguments.size() > 0) {
			appendable.append("<");
			Iterator<JvmTypeReference> iterator = typeArguments.iterator();
			while (iterator.hasNext()) {
				JvmTypeReference next = iterator.next();
				typeRefSerializer.serialize(next, expression, appendable);
				if (iterator.hasNext())
					appendable.append(", ");
			}
			appendable.append(">").append(" ");
		}
	}
}

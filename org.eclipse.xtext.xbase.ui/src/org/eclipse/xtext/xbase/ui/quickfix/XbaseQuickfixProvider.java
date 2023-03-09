/*******************************************************************************
 * Copyright (c) 2010, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.quickfix;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ICompositeModification;
import org.eclipse.xtext.ui.editor.model.edit.ICompositeModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler;
import org.eclipse.xtext.xbase.ui.util.InsertionOffsets;
import org.eclipse.xtext.xbase.util.TypesOrderUtil;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.inject.Inject;

public class XbaseQuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	private OrganizeImportsHandler organizeImportsHandler;

	@Inject
	protected JavaTypeQuickfixes javaTypeQuickfixes;

	@Inject
	private CreateJavaTypeQuickfixes createJavaTypeQuickfixes;

	@Inject
	private CommonTypeComputationServices services;

	@Inject
	private TypesOrderUtil typesOrderUtil;

	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	@Inject
	private InsertionOffsets insertionOffsets;
	
	@Inject
	private OperatorMapping operatorMapping;

	@Fix(IssueCodes.IMPORT_DUPLICATE)
	public void fixDuplicateImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.EQUALS_WITH_NULL)
	public void fixEqualsWithNull(final Issue issue, IssueResolutionAcceptor acceptor) {
		String message = "Replace '==' with '===' and '!=' with '!=='";
		acceptor.acceptMulti(issue, message, message, null, new ICompositeModification<XBinaryOperation>() {
			@Override
			public void apply(XBinaryOperation element, ICompositeModificationContext<XBinaryOperation> context) {
				context.setUpdateCrossReferences(false);
				context.setUpdateRelatedFiles(false);
				context.addModification(element, (object) -> {
					replaceOperator(object, OperatorMapping.EQUALS, OperatorMapping.TRIPLE_EQUALS);
					replaceOperator(object, OperatorMapping.NOT_EQUALS, OperatorMapping.TRIPLE_NOT_EQUALS);
				});
			}
		});
	}
	
	private void replaceOperator(XBinaryOperation operation, QualifiedName from, QualifiedName to) {
		JvmIdentifiableElement feature = operation.getFeature();
		String fromMethodName = operatorMapping.getMethodName(from).toString();
		if (fromMethodName.equals(feature.getSimpleName())) {
			JvmDeclaredType declaringType = ((JvmOperation) feature).getDeclaringType();
			String toMethodName = operatorMapping.getMethodName(to).toString();
			for (JvmFeature f : declaringType.findAllFeaturesByName(toMethodName)) {
				if (f instanceof JvmOperation) {
					operation.setFeature(f);
					break;
				}
			}
		}
	}

	@Fix(IssueCodes.OPERATION_WITHOUT_PARENTHESES)
	public void fixMissingParentheses(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add parentheses", "Add parentheses", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
						(XtextResource) element.eResource(), issue.getOffset() + issue.getLength(), 0);
				appendable.append("()");
				appendable.commitChanges();
			}
		});
	}

	@Fix(IssueCodes.IMPORT_UNUSED)
	public void fixUnusedImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.IMPORT_WILDCARD_DEPRECATED)
	public void fixDuplicateWildcardUse(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.AMBIGUOUS_FEATURE_CALL)
	public void fixAmbiguousMethodCall(final Issue issue, IssueResolutionAcceptor acceptor) {
		String[] data = issue.getData();
		if (data == null || data.length == 0) {
			return;
		}
		for (String replacement : data) {
			String replaceLabel = "Change to '" + replacement + "'";
			acceptor.accept(issue, replaceLabel, replaceLabel, null, new ReplaceModification(issue, replacement));
		}
	}

	@Fix(IssueCodes.INVALID_TYPE_ARGUMENTS_ON_TYPE_LITERAL)
	public void fixTypeArguments(final Issue issue, IssueResolutionAcceptor acceptor) {
		String message = issue.getMessage();
		String fixup = "Remove invalid type arguments";
		if (message.contains("argument.")) {
			fixup = "Remove invalid type argument";
		}
		acceptor.accept(issue, fixup, fixup, null, new IModification() {
			@Override
			public void apply(IModificationContext context) throws Exception {
				IXtextDocument document = context.getXtextDocument();
				document.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
	}

	@Fix(IssueCodes.OBSOLETE_CAST)
	public void fixObsoletCast(final Issue issue, IssueResolutionAcceptor acceptor) {
		String fixup = "Remove unnecessary cast";
		acceptor.accept(issue, fixup, fixup, null, new IModification() {
			@Override
			public void apply(IModificationContext context) throws Exception {
				final IXtextDocument document = context.getXtextDocument();
				ReplaceRegion replacement = document.tryReadOnly(new IUnitOfWork<ReplaceRegion, XtextResource>() {

					@Override
					public ReplaceRegion exec(XtextResource state) throws Exception {
						EObject type = state.getEObject(issue.getUriToProblem().fragment());
						XCastedExpression cast = EcoreUtil2.getContainerOfType(type, XCastedExpression.class);
						INode castNode = NodeModelUtils.findActualNodeFor(cast);
						INode targetNode = NodeModelUtils.findActualNodeFor(cast.getTarget());
						return new ReplaceRegion(castNode.getTotalTextRegion(), targetNode.getText());
					}
				});
				if (replacement != null) {
					document.replace(replacement.getOffset(), replacement.getLength(), replacement.getText());
				}
			}
		});
	}
	
	@Fix(IssueCodes.FEATURE_NOT_VISIBLE)
	public void fixInvisibleFeature(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length >= 1 && "subclass-context".equals(issue.getData()[0])) {
			String fixup;
			if (issue.getData().length == 1)
				fixup = "Add type cast.";
			else
				fixup = "Add cast to " + issue.getData()[1] + ".";
			acceptor.accept(issue, fixup, fixup, null,
					new ISemanticModification() {

						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							if (!(element instanceof XAbstractFeatureCall))
								return;
							XAbstractFeatureCall featureCall = (XAbstractFeatureCall) element;
							if (!(featureCall.getFeature() instanceof JvmMember))
								return;
							JvmType declaringType = ((JvmMember) featureCall.getFeature()).getDeclaringType();
							if (featureCall instanceof XMemberFeatureCall) {
								addTypeCastToExplicitReceiver(featureCall, context, declaringType,
										XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET);
							} else if (featureCall instanceof XAssignment) {
								addTypeCastToExplicitReceiver(featureCall, context, declaringType,
										XbasePackage.Literals.XASSIGNMENT__ASSIGNABLE);
							} else if (featureCall instanceof XFeatureCall) {
								addTypeCastToImplicitReceiver((XFeatureCall) featureCall, context, declaringType);
							}
						}

					});
		}
	}
	
	@Fix(IssueCodes.UNUSED_LOCAL_VARIABLE)
	public void removeUnusedLocalVariable(final Issue issue, IssueResolutionAcceptor acceptor) {
		// use the same label, description and image
		// to be able to use the quickfixes (issue resolution) in batch mode
		String label = "Remove local variable.";
		String description = "Remove the unused local variable.";
		String image = "delete_edit.png";
		acceptor.acceptMulti(issue, label, description, image, (ICompositeModification<XVariableDeclaration>) (element, ctx) -> {
			ctx.setUpdateCrossReferences(false);
			ctx.setUpdateRelatedFiles(false);
			ctx.addModification(element, ele -> EcoreUtil.remove(ele));
		});
	}

	private void addTypeCastToExplicitReceiver(XAbstractFeatureCall featureCall, IModificationContext context,
			JvmType declaringType, EReference structuralFeature) throws BadLocationException {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(featureCall, structuralFeature);
		if (nodes.isEmpty())
			return;
		INode firstNode = IterableExtensions.head(nodes);
		INode lastNode = IterableExtensions.last(nodes);
		int offset = firstNode.getOffset();
		int length = lastNode.getEndOffset() - offset;
		ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
				(XtextResource) featureCall.eResource(), offset, length);
		appendable.append("(");
		ListIterator<INode> nodeIter = nodes.listIterator();
		while (nodeIter.hasNext()) {
			String text = nodeIter.next().getText();
			if (nodeIter.previousIndex() == 0)
				appendable.append(Strings.removeLeadingWhitespace(text));
			else if (nodeIter.nextIndex() == nodes.size())
				appendable.append(Strings.trimTrailingLineBreak(text));
			else
				appendable.append(text);
		}
		appendable.append(" as ");
		appendable.append(declaringType);
		appendable.append(")");
		appendable.commitChanges();
	}
	
	private void addTypeCastToImplicitReceiver(XFeatureCall featureCall, IModificationContext context,
			JvmType declaringType) throws BadLocationException {
		String receiver;
		if (featureCall.getImplicitReceiver() instanceof XAbstractFeatureCall)
			receiver = ((XAbstractFeatureCall) featureCall.getImplicitReceiver()).getFeature().getSimpleName();
		else return;
		List<INode> nodes = NodeModelUtils.findNodesForFeature(featureCall,
				XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		if (nodes.isEmpty())
			return;
		INode firstNode = IterableExtensions.head(nodes);
		int offset = firstNode.getOffset();
		ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
				(XtextResource) featureCall.eResource(), offset, 0);
		appendable.append("(");
		appendable.append(receiver);
		appendable.append(" as ");
		appendable.append(declaringType);
		appendable.append(").");
		appendable.commitChanges();
	}

	@Fix(IssueCodes.REDUNDANT_CASE)
	public void fixRedundantCase(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove redundant case.", "Remove redundant case.", null, new ReplaceModification(issue,
				""));
		acceptor.accept(issue, "Assign empty expression.", "Assign empty expression.", null,
				new ISemanticModification() {

					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						XSwitchExpression switchExpression = EcoreUtil2.getContainerOfType(element,
								XSwitchExpression.class);
						if (switchExpression == null) {
							return;
						}
						XCasePart casePart = IterableExtensions.last(switchExpression.getCases());
						if (casePart == null || !(casePart.isFallThrough() && casePart.getThen() == null)) {
							return;
						}
						List<INode> nodes = NodeModelUtils.findNodesForFeature(casePart,
								XbasePackage.Literals.XCASE_PART__FALL_THROUGH);
						if (nodes.isEmpty()) {
							return;
						}
						INode firstNode = IterableExtensions.head(nodes);
						INode lastNode = IterableExtensions.last(nodes);
						int offset = firstNode.getOffset();
						int length = lastNode.getEndOffset() - offset;
						ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
								(XtextResource) element.eResource(), offset, length);
						appendable.append(": {");
						appendable.increaseIndentation().newLine();
						appendable.decreaseIndentation().newLine().append("}");
						appendable.commitChanges();
					}

				});
	}

	@Fix(IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	public void fixIncompleteCasesOnEnum(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add 'default' case", "Add 'default' case", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				XSwitchExpression switchExpression = EcoreUtil2.getContainerOfType(element, XSwitchExpression.class);
				if (switchExpression == null) {
					return;
				}
				int insertOffset = getInsertOffset(switchExpression);
				IXtextDocument document = context.getXtextDocument();
				ReplacingAppendable appendable = appendableFactory.create(document,
						(XtextResource) element.eResource(), insertOffset, 0);
				if (switchExpression.getCases().isEmpty()) {
					appendable.increaseIndentation();
				}
				appendable.newLine();
				appendable.append("default: {");
				appendable.newLine().append("}");
				appendable.commitChanges();
			}

		});
		acceptor.accept(issue, "Add missing cases", "Add missing cases", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				XSwitchExpression switchExpression = EcoreUtil2.getContainerOfType(element, XSwitchExpression.class);
				if (switchExpression == null) {
					return;
				}
				int insertOffset = getInsertOffset(switchExpression);
				IXtextDocument document = context.getXtextDocument();
				ReplacingAppendable appendable = appendableFactory.create(document,
						(XtextResource) element.eResource(), insertOffset, 0);
				if (switchExpression.getCases().isEmpty()) {
					appendable.increaseIndentation();
				}
				for (String expectedEnumerationLiteral : issue.getData()) {
					appendable.newLine().append("case ").append(expectedEnumerationLiteral).append(": {");
					appendable.newLine().append("}");
				}
				appendable.commitChanges();
			}

		});
	}

	private int getInsertOffset(XSwitchExpression switchExpression) {
		EList<XCasePart> cases = switchExpression.getCases();
		if (cases.isEmpty()) {
			return insertionOffsets.inEmpty(switchExpression);
		}
		XCasePart casePart = IterableExtensions.last(cases);
		return insertionOffsets.after(casePart);
	}

	@Fix(IssueCodes.UNREACHABLE_CASE)
	public void fixUnreachableCase(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove case", "Remove case", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				remove(element, XCasePart.class, context);
			}

		});
		acceptor.accept(issue, "Move case up", "Move case up", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				XCasePart casePart = EcoreUtil2.getContainerOfType(element, XCasePart.class);
				if (casePart == null) {
					return;
				}
				ICompositeNode caseNode = NodeModelUtils.findActualNodeFor(casePart);
				if (caseNode == null) {
					return;
				}
				XSwitchExpression switchExpression = EcoreUtil2.getContainerOfType(casePart, XSwitchExpression.class);
				if (switchExpression == null) {
					return;
				}
				ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, switchExpression);
				LightweightTypeReference actualTypeReference = owner.toLightweightTypeReference(casePart.getTypeGuard());
				for (XCasePart previousCasePart : switchExpression.getCases()) {
					if (previousCasePart == casePart) {
						return;
					}
					JvmTypeReference typeGuard = previousCasePart.getTypeGuard();
					if (typeGuard == null || previousCasePart.getCase() != null) {
						continue;
					}
					LightweightTypeReference previousTypeReference = owner.toLightweightTypeReference(typeGuard);
					if (typesOrderUtil.isHandled(actualTypeReference, previousTypeReference)) {
						ICompositeNode previousCaseNode = NodeModelUtils.findActualNodeFor(previousCasePart);
						if (previousCaseNode == null) {
							return;
						}
						moveUp(caseNode, previousCaseNode, context);
						return;
					}
				}
			}

		});
	}

	@Fix(IssueCodes.UNREACHABLE_CATCH_BLOCK)
	public void fixUnreachableCatchBlock(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove catch block", "Remove catch block", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				remove(element, XCatchClause.class, context);
			}

		});
		acceptor.accept(issue, "Move catch block up", "Move catch block up", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				XCatchClause catchClause = EcoreUtil2.getContainerOfType(element, XCatchClause.class);
				if (catchClause == null) {
					return;
				}
				ICompositeNode node = NodeModelUtils.findActualNodeFor(catchClause);
				if (node == null) {
					return;
				}
				XTryCatchFinallyExpression tryCatchFinallyExpression = EcoreUtil2.getContainerOfType(catchClause,
						XTryCatchFinallyExpression.class);
				if (tryCatchFinallyExpression == null) {
					return;
				}
				ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, tryCatchFinallyExpression);
				LightweightTypeReference actualTypeReference = owner.toLightweightTypeReference(catchClause
						.getDeclaredParam().getParameterType());
				for (XCatchClause previousCatchClause : tryCatchFinallyExpression.getCatchClauses()) {
					if (previousCatchClause == catchClause) {
						return;
					}
					LightweightTypeReference previousTypeReference = owner
							.toLightweightTypeReference(previousCatchClause.getDeclaredParam().getParameterType());
					if (typesOrderUtil.isHandled(actualTypeReference, previousTypeReference)) {
						ICompositeNode previousNode = NodeModelUtils.findActualNodeFor(previousCatchClause);
						if (previousNode == null) {
							return;
						}
						moveUp(node, previousNode, context);
						return;
					}
				}
			}

		});
	}

	@Fix(IssueCodes.UNREACHABLE_IF_BLOCK)
	public void fixUnreachableIfBlock(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove if block", "Remove if block", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				XIfExpression ifExpression = EcoreUtil2.getContainerOfType(element, XIfExpression.class);
				if (ifExpression == null) {
					return;
				}
				ICompositeNode node = NodeModelUtils.findActualNodeFor(ifExpression);
				if (node == null) {
					return;
				}
				int[] offsetAndLength = getOffsetAndLength(ifExpression, node);
				context.getXtextDocument().replace(offsetAndLength[0], offsetAndLength[1], "");
			}

		});
		acceptor.accept(issue, "Move if block up", "Move if block up", null, new ISemanticModification() {

			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				XIfExpression ifExpression = EcoreUtil2.getContainerOfType(element, XIfExpression.class);
				if (ifExpression == null) {
					return;
				}
				ICompositeNode node = NodeModelUtils.findActualNodeFor(ifExpression);
				if (node == null) {
					return;
				}
				XIfExpression firstIfExpression = getFirstIfExpression(ifExpression);
				if (firstIfExpression == null) {
					return;
				}
				XInstanceOfExpression actualIfPart = (XInstanceOfExpression) ifExpression.getIf();
				XAbstractFeatureCall actualFeatureCall = (XAbstractFeatureCall) actualIfPart.getExpression();
				JvmIdentifiableElement actualFeature = actualFeatureCall.getFeature();
				ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, firstIfExpression);
				LightweightTypeReference actualTypeReference = owner.toLightweightTypeReference(actualIfPart.getType());
				List<XExpression> ifParts = collectIfParts(firstIfExpression, new ArrayList<XExpression>());
				for (XExpression previousIfPart : ifParts) {
					if (actualIfPart == previousIfPart) {
						return;
					}
					if (!(previousIfPart instanceof XInstanceOfExpression)) {
						continue;
					}
					XInstanceOfExpression instanceOfExpression = (XInstanceOfExpression) previousIfPart;
					if (!(instanceOfExpression.getExpression() instanceof XAbstractFeatureCall)) {
						continue;
					}
					XAbstractFeatureCall previousFeatureCall = (XAbstractFeatureCall) instanceOfExpression
							.getExpression();
					if (previousFeatureCall.getFeature() != actualFeature) {
						continue;
					}
					LightweightTypeReference previousTypeReference = owner
							.toLightweightTypeReference(instanceOfExpression.getType());
					if (typesOrderUtil.isHandled(actualTypeReference, previousTypeReference)) {
						ICompositeNode previousNode = NodeModelUtils.findActualNodeFor(instanceOfExpression
								.eContainer());
						if (previousNode == null) {
							return;
						}
						int[] offsetAndLength = getOffsetAndLength(ifExpression, node);
						int offset = offsetAndLength[0];
						int length = offsetAndLength[1];
						int endOffset = offset + length;
						String text = node.getRootNode().getText().substring(offset, endOffset).trim();
						if (text.startsWith("else")) {
							text = text.substring("else".length()).trim();
						}
						if (!text.endsWith("else")) {
							text = text + " else ";
						} else {
							text = text + " ";
						}

						IXtextDocument document = context.getXtextDocument();
						document.replace(offset, length, "");
						document.replace(previousNode.getOffset(), 0, text);
						return;
					}
				}
			}

			private XIfExpression getFirstIfExpression(XIfExpression ifExpression) {
				EObject container = ifExpression.eContainer();
				if (container instanceof XIfExpression) {
					XIfExpression parentIfExpression = (XIfExpression) container;
					if (parentIfExpression.getElse() == ifExpression) {
						return getFirstIfExpression(parentIfExpression);
					}
				}
				return ifExpression;
			}

			private List<XExpression> collectIfParts(XIfExpression expression, List<XExpression> result) {
				result.add(expression.getIf());
				if (expression.getElse() instanceof XIfExpression) {
					collectIfParts((XIfExpression) expression.getElse(), result);
				}
				return result;
			}

		});
	}

	protected int[] getOffsetAndLength(XIfExpression ifExpression, ICompositeNode node) {
		int offset = node.getOffset();
		int length = node.getLength();
		if (ifExpression.getElse() != null) {
			ICompositeNode elseNode = NodeModelUtils.findActualNodeFor(ifExpression.getElse());
			if (elseNode != null) {
				length = elseNode.getOffset() - offset;
			}
		} else {
			XIfExpression parentIfExpression = EcoreUtil2.getContainerOfType(ifExpression.eContainer(),
					XIfExpression.class);
			if (parentIfExpression != null && parentIfExpression.getElse() == ifExpression) {
				ICompositeNode thenNode = NodeModelUtils.findActualNodeFor(parentIfExpression.getThen());
				if (thenNode != null) {
					int endOffset = thenNode.getEndOffset();
					length = length + (offset - endOffset);
					offset = endOffset;
				}
			}
		}
		return new int[] { offset, length };
	}

	protected void moveUp(ICompositeNode node, ICompositeNode previousNode, IModificationContext context)
			throws BadLocationException {
		IXtextDocument document = context.getXtextDocument();
		String text = node.getText() + previousNode.getText();
		text = text.trim();
		remove(document, node);
		document.replace(previousNode.getOffset(), previousNode.getLength(), text);
	}

	protected <T extends EObject> void remove(EObject element, Class<T> type, IModificationContext context)
			throws BadLocationException {
		T container = EcoreUtil2.getContainerOfType(element, type);
		if (container == null) {
			return;
		}
		ICompositeNode node = NodeModelUtils.findActualNodeFor(container);
		if (node == null) {
			return;
		}
		remove(context.getXtextDocument(), node);
	}

	protected void remove(IXtextDocument document, ICompositeNode node) throws BadLocationException {
		int offset = node.getOffset();
		int length = node.getLength();
		if (node.hasPreviousSibling()) {
			INode previousSibling = node.getPreviousSibling();
			int endOffset = previousSibling.getEndOffset();
			length = length + (offset - endOffset);
			offset = endOffset;
		}
		document.replace(offset, length, "");
	}

	protected void organizeImports(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Organize imports",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				getOrganizeImportsImage(), new IModification() {
					@Override
					public void apply(IModificationContext context) throws Exception {
						organizeImportsHandler.doOrganizeImports(context.getXtextDocument());
					}
				});
	}

	protected String getOrganizeImportsImage() {
		return "impc_obj.gif";
	}

	/**
	 * Filter quickfixes for types and constructors.
	 */
	@Override
	public void createLinkingIssueResolutions(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		final IModificationContext modificationContext = getModificationContextFactory().createModificationContext(
				issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if (xtextDocument != null) {
			xtextDocument.tryReadOnly(new CancelableUnitOfWork<Void, XtextResource>() {
				@Override
				public java.lang.Void exec(XtextResource state, CancelIndicator cancelIndicator) throws Exception {
					try {
						EObject target = state.getEObject(issue.getUriToProblem().fragment());
						EReference reference = getUnresolvedEReference(issue, target);
						if (reference != null && reference.getEReferenceType() != null) {
							createLinkingIssueQuickfixes(issue,
									getCancelableAcceptor(issueResolutionAcceptor, cancelIndicator), xtextDocument,
									state, target, reference);
						}
					} catch (WrappedException e) {
						// issue information seems to be out of sync, e.g. there is no
						// EObject with the given fragment
					}
					return null;
				}
			});
		}
	}

	protected void createLinkingIssueQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			IXtextDocument xtextDocument, XtextResource state, EObject target, EReference reference) throws Exception {
		javaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, state, target, reference);
		createJavaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, state, target, reference);
	}

	@Override
	protected EReference getUnresolvedEReference(Issue issue, EObject target) {
		EReference unresolvedEReference = super.getUnresolvedEReference(issue, target);
		if (unresolvedEReference == null && target instanceof XConstructorCall)
			return XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
		else
			return unresolvedEReference;
	}
}


package org.eclipse.xtext.xbase.ui.quickfix;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
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
	
	@Fix(IssueCodes.IMPORT_DUPLICATE)
	public void fixDuplicateImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}
	
	@Fix(IssueCodes.OPERATION_WITHOUT_PARENTHESES)
	public void fixMissingParentheses(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add parentheses", "Add parentheses", null, new ISemanticModification() {
			public void apply(EObject element, IModificationContext context) throws Exception {
				ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(), (XtextResource) element.eResource(), issue.getOffset() + issue.getLength(), 0);
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
			public void apply(IModificationContext context) throws Exception {
				IXtextDocument document = context.getXtextDocument();
				document.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
	}
	
	@Fix(IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	public void fixIncompleteCasesOnEnum(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add 'default' case", "Add 'default' case", null, new ISemanticModification() {
			
			public void apply(EObject element, IModificationContext context) throws Exception {
				XSwitchExpression switchExpression = EcoreUtil2.getContainerOfType(element, XSwitchExpression.class);
				if (switchExpression == null) {
					return;
				}
				int insertOffset = getInsertOffset(switchExpression);
				IXtextDocument document = context.getXtextDocument();
				ReplacingAppendable appendable = appendableFactory.create(document, (XtextResource) element.eResource(), insertOffset, 0);
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
			public void apply(EObject element, IModificationContext context) throws Exception {
				XSwitchExpression switchExpression = EcoreUtil2.getContainerOfType(element, XSwitchExpression.class);
				if (switchExpression == null) {
					return;
				}
				int insertOffset = getInsertOffset(switchExpression);
				IXtextDocument document = context.getXtextDocument();
				ReplacingAppendable appendable = appendableFactory.create(document, (XtextResource) element.eResource(), insertOffset, 0);
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
			
			public void apply(EObject element, IModificationContext context) throws Exception {
				remove(element, XCasePart.class, context);
			}

		});
		acceptor.accept(issue, "Move case up", "Move case up", null, new ISemanticModification() {
			
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
				OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(services, switchExpression));
				LightweightTypeReference actualTypeReference = converter.toLightweightReference(casePart.getTypeGuard());
				for (XCasePart previousCasePart : switchExpression.getCases()) {
					if (previousCasePart == casePart) {
						return;
					}
					JvmTypeReference typeGuard = previousCasePart.getTypeGuard();
					if (typeGuard == null || previousCasePart.getCase() != null) {
						continue;
					}
					LightweightTypeReference previousTypeReference = converter.toLightweightReference(typeGuard);
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
			
			public void apply(EObject element, IModificationContext context) throws Exception {
				remove(element, XCatchClause.class, context);
			}

		});
		acceptor.accept(issue, "Move catch block up", "Move catch block up", null, new ISemanticModification() {
			
			public void apply(EObject element, IModificationContext context) throws Exception {
				XCatchClause catchClause = EcoreUtil2.getContainerOfType(element, XCatchClause.class);
				if (catchClause == null) {
					return;
				}
				ICompositeNode node = NodeModelUtils.findActualNodeFor(catchClause);
				if (node == null) {
					return;
				}
				XTryCatchFinallyExpression tryCatchFinallyExpression = EcoreUtil2.getContainerOfType(catchClause, XTryCatchFinallyExpression.class);
				if (tryCatchFinallyExpression == null) {
					return;
				}
				OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(services, tryCatchFinallyExpression));
				LightweightTypeReference actualTypeReference = converter.toLightweightReference(catchClause.getDeclaredParam().getParameterType());
				for (XCatchClause previousCatchClause : tryCatchFinallyExpression.getCatchClauses()) {
					if (previousCatchClause == catchClause) {
						return;
					}
					LightweightTypeReference previousTypeReference = converter.toLightweightReference(previousCatchClause.getDeclaredParam().getParameterType());
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
				OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(services, firstIfExpression));
				LightweightTypeReference actualTypeReference = converter.toLightweightReference(actualIfPart.getType());
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
					XAbstractFeatureCall previousFeatureCall = (XAbstractFeatureCall) instanceOfExpression.getExpression();
					if (previousFeatureCall.getFeature() != actualFeature) {
						continue;
					}
					LightweightTypeReference previousTypeReference = converter.toLightweightReference(instanceOfExpression.getType());
					if (typesOrderUtil.isHandled(actualTypeReference, previousTypeReference)) {
						ICompositeNode previousNode = NodeModelUtils.findActualNodeFor(instanceOfExpression.eContainer());
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
			XIfExpression parentIfExpression = EcoreUtil2.getContainerOfType(ifExpression.eContainer(), XIfExpression.class);
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
	
	protected <T extends EObject> void remove(EObject element, Class<T> type, IModificationContext context) throws BadLocationException {
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
			xtextDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					try {
						EObject target = state.getEObject(issue.getUriToProblem().fragment());
						EReference reference = getUnresolvedEReference(issue, target);
						if(reference != null && reference.getEReferenceType() != null) 
							createLinkingIssueQuickfixes(
									issue,
									issueResolutionAcceptor,
									xtextDocument,
									state,
									target,
									reference);
					} catch(WrappedException e) {
						// issue information seems to be out of sync, e.g. there is no
						// EObject with the given fragment
						return;
					}
				}
			});
		}
	}

	protected void createLinkingIssueQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, 
			IXtextDocument xtextDocument,
			XtextResource state, EObject target, EReference reference) throws Exception {
		javaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, state, target, reference);
		createJavaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, state, target, reference);
	}
	
	@Override
	protected EReference getUnresolvedEReference(Issue issue, EObject target) {
		EReference unresolvedEReference = super.getUnresolvedEReference(issue, target);
		if(unresolvedEReference == null && target instanceof XConstructorCall)
			return XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
		else 
			return unresolvedEReference;
	}
}

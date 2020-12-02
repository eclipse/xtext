/**
 * Copyright (c) 2019, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.rename;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PrepareRenameParams;
import org.eclipse.lsp4j.PrepareRenameResult;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameOptions;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.util.Ranges;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.18
 */
public class RenameService2 implements IRenameService2 {

	private static final Logger LOG = Logger.getLogger(RenameService2.class);
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private Provider<ServerRefactoringIssueAcceptor> issueProvider;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Inject
	private TokenUtil tokenUtil;

	@Inject
	private IValueConverterService valueConverterService;

	@Inject
	private LinkingHelper linkingHelper;

	private Function<EObject, String> attributeResolver = SimpleAttributeResolver.newResolver(String.class, "name");

	@Override
	public WorkspaceEdit rename(IRenameService2.Options options) {
		try {
			TextDocumentIdentifier textDocument = options.getRenameParams().getTextDocument();
			String uri = textDocument.getUri();
			ServerRefactoringIssueAcceptor issueAcceptor = issueProvider.get();
			boolean shouldPrepareRename = shouldPrepareRename(options.getLanguageServerAccess());
			return options.getLanguageServerAccess().doRead(uri, (ILanguageServerAccess.Context context) -> {
				if (shouldPrepareRename) {
					TextDocumentIdentifier identifier = new TextDocumentIdentifier(textDocument.getUri());
					Position position = options.getRenameParams().getPosition();
					PrepareRenameParams positionParams = new PrepareRenameParams(identifier, position);
					Resource resource = context.getResource();
					Document document = context.getDocument();
					CancelIndicator cancelIndicator = options.getCancelIndicator();
					Either<Range, PrepareRenameResult> prepareRenameResult = doPrepareRename(resource, document,
							positionParams, cancelIndicator);
					if (!mayPerformRename(prepareRenameResult, options.getRenameParams())) {
						return null;
					}
				}
				WorkspaceEdit workspaceEdit = new WorkspaceEdit();
				ResourceSet resourceSet = options.getLanguageServerAccess()
						.newLiveScopeResourceSet(context.getResource().getURI());
				Resource xtextResource = resourceSet.getResource(context.getResource().getURI(), true);
				if (xtextResource instanceof XtextResource) {
					Position position = options.getRenameParams().getPosition();
					EObject element = null;
					try {
						element = getElementAtOffset((XtextResource) xtextResource, context.getDocument(), position);
					} catch (IndexOutOfBoundsException e) {
						issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL,
								"Invalid document " + toPositionFragment(position, uri));
					}
					if (element == null || element.eIsProxy()) {
						issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL,
								"No element found at " + toPositionFragment(position, uri));
					} else {
						IResourceServiceProvider services = serviceProviderRegistry
								.getResourceServiceProvider(element.eResource().getURI());
						IChangeSerializer changeSerializer = services.get(IChangeSerializer.class);
						RenameChange change = new RenameChange(options.getRenameParams().getNewName(),
								EcoreUtil.getURI(element));
						RenameContext renameContext = new RenameContext(Lists.newArrayList(change), resourceSet,
								changeSerializer, issueAcceptor);
						IRenameStrategy2 renameStrategy = services.<IRenameStrategy2>get(IRenameStrategy2.class);
						renameStrategy.applyRename(renameContext);
						ChangeConverter2.Factory converterFactory = services.<ChangeConverter2.Factory>get(
								ChangeConverter2.Factory.class);
						ChangeConverter2 changeConverter = converterFactory.create(workspaceEdit,
								options.getLanguageServerAccess());
						changeSerializer.applyModifications(changeConverter);
					}
				} else {
					issueAcceptor.add(RefactoringIssueAcceptor.Severity.FATAL,
							"Loaded resource is not an XtextResource", context.getResource().getURI());
				}
				issueAcceptor.checkSeverity();
				return workspaceEdit;
			}).exceptionally((Throwable exception) -> {
				try {
					Throwable rootCause = Throwables.getRootCause(exception);
					if (rootCause instanceof FileNotFoundException) {
						if (shouldPrepareRename) {
							return null;
						}
					}
					throw exception;
				} catch (Throwable e) {
					throw Exceptions.sneakyThrow(e);
				}
			}).get();
		} catch (InterruptedException | ExecutionException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected EObject getElementAtOffset(XtextResource xtextResource, Document document, Position caretPosition) {
		int caretOffset = document.getOffSet(caretPosition);
		EObject element = getElementWithIdentifierAt(xtextResource, caretOffset);
		if (element != null) {
			return element;
		} else {
			return getElementWithIdentifierAt(xtextResource, caretOffset - 1);
		}
	}

	protected EObject getElementWithIdentifierAt(XtextResource xtextResource, int offset) {
		if (offset >= 0) {
			if (xtextResource != null) {
				IParseResult parseResult = xtextResource.getParseResult();
				if (parseResult != null) {
					ICompositeNode rootNode = parseResult.getRootNode();
					if (rootNode != null) {
						ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
						if (leaf != null && isIdentifier(leaf)) {
							return eObjectAtOffsetHelper.resolveElementAt(xtextResource, offset);
						}
					}
				}
			}
		}
		return null;
	}

	protected boolean isIdentifier(ILeafNode leafNode) {
		return (leafNode.getGrammarElement() instanceof RuleCall
				|| leafNode.getGrammarElement() instanceof CrossReference)
				&& !tokenUtil.isWhitespaceOrCommentNode(leafNode);
	}

	@Override
	public Either<Range, PrepareRenameResult> prepareRename(IRenameService2.PrepareRenameOptions options) {
		try {
			String uri = options.getParams().getTextDocument().getUri();
			boolean shouldPrepareRename = shouldPrepareRename(options.getLanguageServerAccess());
			return options.getLanguageServerAccess().doRead(uri, (ILanguageServerAccess.Context context) -> {
				if (!shouldPrepareRename) {
					return null;
				}
				Resource resource = context.getResource();
				Document document = context.getDocument();
				PrepareRenameParams params = options.getParams();
				CancelIndicator cancelIndicator = options.getCancelIndicator();
				return doPrepareRename(resource, document, params, cancelIndicator);
			}).exceptionally((Throwable exception) -> {
				try {
					Throwable rootCause = Throwables.getRootCause(exception);
					if (rootCause instanceof FileNotFoundException) {
						if (shouldPrepareRename) {
							return null;
						}
					}
					throw exception;
				} catch (Throwable e) {
					throw Exceptions.sneakyThrow(e);
				}
			}).get();
		} catch (InterruptedException | ExecutionException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected Either<Range, PrepareRenameResult> doPrepareRename(Resource resource, Document document,
			PrepareRenameParams params, CancelIndicator cancelIndicator) {
		String uri = params.getTextDocument().getUri();
		if (resource instanceof XtextResource) {
			ICompositeNode rootNode = null;
			XtextResource xtextResource = (XtextResource) resource;
			if (xtextResource != null) {
				IParseResult parseResult = xtextResource.getParseResult();
				if (parseResult != null) {
					rootNode = parseResult.getRootNode();
				}
			}
			if (rootNode == null) {
				RenameService2.LOG.trace("Could not retrieve root node for resource. URI: " + uri);
				return null;
			}
			Position caretPosition = params.getPosition();
			try {
				int caretOffset = document.getOffSet(caretPosition);
				EObject element = null;
				int candidateOffset = caretOffset;
				do {
					element = getElementWithIdentifierAt(xtextResource, candidateOffset);
					if (element != null && !element.eIsProxy()) {
						ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, candidateOffset);
						if (leaf != null && isIdentifier(leaf)) {
							String convertedNameValue = getConvertedValue(leaf.getGrammarElement(), leaf);
							String elementName = getElementName(element);
							if (!Strings.isEmpty(convertedNameValue) && !Strings.isEmpty(elementName)
									&& Objects.equal(convertedNameValue, elementName)) {
								Position start = document.getPosition(leaf.getOffset());
								Position end = document.getPosition(leaf.getEndOffset());
								return Either.forLeft(new Range(start, end));
							}
						}
					}
					candidateOffset = (candidateOffset - 1);
				} while (((candidateOffset >= 0) && ((candidateOffset + 1) >= caretOffset)));
			} catch (IndexOutOfBoundsException e) {
				RenameService2.LOG.trace("Invalid document " + toPositionFragment(caretPosition, uri));
				return null;
			}
			RenameService2.LOG.trace("No element found at " + toPositionFragment(caretPosition, uri));
		} else {
			RenameService2.LOG.trace("Loaded resource is not an XtextResource. URI: " + resource.getURI());
		}
		return null;
	}

	protected String getConvertedValue(EObject grammarElement, ILeafNode leaf) {
		try {
			if (grammarElement instanceof RuleCall) {
				return valueConverterService
						.toValue(leaf.getText(), ((RuleCall) grammarElement).getRule().getName(), leaf).toString();
			} else if (grammarElement instanceof CrossReference) {
				return linkingHelper.getCrossRefNodeAsString(leaf, true);
			}
		} catch (Exception e) {
			// The current name text cannot be converted to a value.
			// Rename could be used to fix this.
		}
		return leaf.getText();
	}

	/**
	 * If this method returns {@code false}, it is sure, that the rename operation will fail. There is no guarantee that
	 * it will succeed even if it returns {@code true}.
	 */
	protected boolean mayPerformRename(Either<Range, PrepareRenameResult> prepareRenameResult,
			RenameParams renameParams) {
		return prepareRenameResult != null && prepareRenameResult.getLeft() != null
				&& Ranges.containsPosition(prepareRenameResult.getLeft(), renameParams.getPosition());
	}

	/**
	 * Tries to read the {@code name} {@link EAttribute} from the given {@code element}.
	 * 
	 * It never returns an empty string, but a {@code null} instead.
	 */
	protected String getElementName(EObject element) {
		if (element == null) {
			return null;
		}
		String name = attributeResolver.apply(element);
		if (Strings.isEmpty(name)) {
			return null;
		} else {
			return name;
		}
	}

	private String toPositionFragment(Position it, String uri) {
		return "position line: " + it.getLine() + " column: " + it.getCharacter() + " in resource: " + uri;
	}

	private boolean shouldPrepareRename(ILanguageServerAccess access) {
		Either<Boolean, RenameOptions> provider = null;
		if (access != null) {
			InitializeResult initializeResult = access.getInitializeResult();
			if (initializeResult != null) {
				ServerCapabilities capabilities = initializeResult.getCapabilities();
				if (capabilities != null) {
					provider = capabilities.getRenameProvider();
				}
			}
		}
		if (provider != null && provider.isRight()) {
			return Boolean.TRUE.equals(provider.getRight().getPrepareProvider());
		} else {
			return false;
		}
	}

	protected EObjectAtOffsetHelper getEObjectAtOffsetHelper() {
		return eObjectAtOffsetHelper;
	}

	protected Provider<ServerRefactoringIssueAcceptor> getIssueProvider() {
		return issueProvider;
	}

	protected IResourceServiceProvider.Registry getServiceProviderRegistry() {
		return serviceProviderRegistry;
	}

	protected TokenUtil getTokenUtil() {
		return tokenUtil;
	}

	protected IValueConverterService getValueConverterService() {
		return valueConverterService;
	}

	protected LinkingHelper getLinkingHelper() {
		return linkingHelper;
	}

	protected Function<EObject, String> getAttributeResolver() {
		return attributeResolver;
	}
}

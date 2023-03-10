/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.formatting.FormattingService;
import org.eclipse.xtext.web.server.generator.GeneratorService;
import org.eclipse.xtext.web.server.hover.HoverService;
import org.eclipse.xtext.web.server.model.IWebDocumentProvider;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.PrecomputedServiceRegistry;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.occurrences.OccurrencesService;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingService;
import org.eclipse.xtext.web.server.validation.ValidationService;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The entry class for Xtext service invocations. Use
 * {@link #getService(IServiceContext)} to obtain a {@link ServiceDescriptor}
 * for a client request. The service descriptor has some metadata that may
 * influence the message format expected for the request, and may lead to a
 * rejection of the request.
 * 
 * <p>
 * A typical usage can look like this:
 * </p>
 * 
 * <pre>
 * val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
 * val serviceDescriptor = serviceDispatcher.getService(serviceContext)
 * // Check whether the service metadata fits to the request format
 * ...
 * val result = serviceDescriptor.service.apply()
 * // Serialize and send the result back to the client
 * ...
 * </pre>
 */
@Singleton
public class XtextServiceDispatcher {

	private static final Logger LOG = Logger.getLogger(XtextServiceDispatcher.class);

	/**
	 * Service metadata, including a function for actually invoking the service.
	 */
	public static class ServiceDescriptor {
		/**
		 * Context information such as request parameters and session data.
		 */
		private IServiceContext context;

		/**
		 * The function for invoking the service.
		 */
		private Function0<? extends IServiceResult> service;

		/**
		 * Whether the service has any side effects apart from initializing data in the
		 * session.
		 */
		private boolean hasSideEffects;

		/**
		 * Whether one of the preconditions of the service does not match, e.g. because
		 * it is in conflict with another request.
		 */
		private boolean hasConflict;

		public IServiceContext getContext() {
			return context;
		}

		public void setContext(IServiceContext context) {
			this.context = context;
		}

		public Function0<? extends IServiceResult> getService() {
			return service;
		}

		public void setService(Function0<? extends IServiceResult> service) {
			this.service = service;
		}

		public boolean isHasSideEffects() {
			return hasSideEffects;
		}

		public void setHasSideEffects(boolean hasSideEffects) {
			this.hasSideEffects = hasSideEffects;
		}

		public boolean isHasConflict() {
			return hasConflict;
		}

		public void setHasConflict(boolean hasConflict) {
			this.hasConflict = hasConflict;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("context", context);
			b.add("service", service);
			b.add("hasSideEffects", hasSideEffects);
			b.add("hasConflict", hasConflict);
			return b.toString();
		}
	}

	@Inject(optional = true)
	@FormatterPreferences
	private IPreferenceValuesProvider formatterPreferencesProvider;

	@Inject
	private ResourcePersistenceService resourcePersistenceService;

	@Inject
	private UpdateDocumentService updateDocumentService;

	@Inject
	private ContentAssistService contentAssistService;

	@Inject
	private ValidationService validationService;

	@Inject
	private HighlightingService highlightingService;

	@Inject
	private HoverService hoverService;

	@Inject
	private OccurrencesService occurrencesService;

	@Inject
	private FormattingService formattingService;

	@Inject
	private GeneratorService generatorService;

	@Inject
	private IServerResourceHandler resourceHandler;

	@Inject
	private IWebResourceSetProvider resourceSetProvider;

	@Inject
	private IWebDocumentProvider documentProvider;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private IResourceFactory resourceFactory;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	@Inject
	private XtextWebDocumentAccess.Factory documentAccessFactory;

	private final Random randomGenerator = new Random();

	@Inject
	protected void registerPreComputedServices(PrecomputedServiceRegistry registry) {
		registry.addPrecomputedService(highlightingService);
		registry.addPrecomputedService(validationService);
	}

	/**
	 * Create a service descriptor according to the parameters given in the service
	 * context.
	 */
	public ServiceDescriptor getService(IServiceContext context) throws InvalidRequestException {
		String serviceType = context.getParameter(IServiceContext.SERVICE_TYPE);
		if (serviceType == null) {
			throw new InvalidRequestException.InvalidParametersException("The parameter 'serviceType' is required.");
		}
		if (LOG.isTraceEnabled()) {
			List<String> sorted = IterableExtensions.sort(context.getParameterKeys());
			String stringParams = IterableExtensions.join(sorted, ": ", ", ", "", (String key) -> {
				String value = context.getParameter(key);
				if (value.length() > 18) {
					return key + "='" + value.substring(0, 16) + "...'";
				} else {
					if (value.matches(".*\\s+.*")) {
						return key + "='" + value + "'";
					} else {
						return key + "=" + value;
					}
				}
			}).replaceAll("(\\n|\\f|\\r)+", " ");
			LOG.trace("xtext-service/" + serviceType + stringParams);
		}
		try {
			ServiceDescriptor serviceDescriptor = createServiceDescriptor(serviceType, context);
			serviceDescriptor.context = context;
			return serviceDescriptor;
		} catch (InvalidRequestException.InvalidDocumentStateException e) {
			LOG.trace("Invalid document state (" + serviceType + ")");
			ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
			serviceDescriptor.context = context;
			serviceDescriptor.service = () -> {
				return new ServiceConflictResult("invalidStateId");
			};
			serviceDescriptor.hasConflict = true;
			return serviceDescriptor;
		}
	}

	/**
	 * Do the actual dispatching by delegating to a service descriptor creation
	 * method depending on the service type. Override this method if you want to add
	 * more services to the dispatcher.
	 */
	protected ServiceDescriptor createServiceDescriptor(String serviceType, IServiceContext context) {
		if (serviceType != null) {
			switch (serviceType) {
			case "load":
				return getLoadResourceService(false, context);
			case "revert":
				return getLoadResourceService(true, context);
			case "save":
				return getSaveResourceService(context);
			case "update":
				return getUpdateDocumentService(context);
			case "assist":
				return getContentAssistService(context);
			case "validate":
				return getValidationService(context);
			case "hover":
				return getHoverService(context);
			case "highlight":
				return getHighlightingService(context);
			case "occurrences":
				return getOccurrencesService(context);
			case "format":
				return getFormattingService(context);
			case "generate":
				return getGeneratorService(context);
			default:
				throw new InvalidRequestException.InvalidParametersException(
						"The service type '" + serviceType + "' is not supported.");
			}
		} else {
			throw new InvalidRequestException.InvalidParametersException(
					"The service type '" + serviceType + "' is not supported.");
		}
	}

	protected ServiceDescriptor getLoadResourceService(boolean revert, IServiceContext context)
			throws InvalidRequestException {
		String resourceId = getResourceID(context);
		if (resourceId == null) {
			throw new InvalidRequestException.InvalidParametersException("The parameter 'resource' is required.");
		}
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.service = () -> {
			try {
				if (revert) {
					return resourcePersistenceService.revert(resourceId, resourceHandler, context);
				} else {
					return resourcePersistenceService.load(resourceId, resourceHandler, context);
				}
			} catch (Throwable throwable) {
				return handleError(serviceDescriptor, throwable);
			}
		};
		serviceDescriptor.hasSideEffects = revert;
		return serviceDescriptor;
	}

	protected ServiceDescriptor getSaveResourceService(IServiceContext context) throws InvalidRequestException {
		XtextWebDocumentAccess document = getDocumentAccess(context);
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.service = () -> {
			try {
				return resourcePersistenceService.save(document, resourceHandler, context);
			} catch (Throwable throwable) {
				return handleError(serviceDescriptor, throwable);
			}
		};
		serviceDescriptor.hasSideEffects = true;
		return serviceDescriptor;
	}

	protected ServiceDescriptor getUpdateDocumentService(IServiceContext context) throws InvalidRequestException {
		String resourceId = getResourceID(context);
		if (resourceId == null) {
			throw new InvalidRequestException.InvalidParametersException("The parameter 'resource' is required.");
		}
		String fullText = context.getParameter("fullText");
		XtextWebDocument document = getResourceDocument(resourceId, context);
		boolean initializedFromFullText = (document == null);
		if (initializedFromFullText) {
			if (fullText == null) {
				throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.");
			}
			document = getFullTextDocument(fullText, resourceId, context);
		}
		XtextWebDocumentAccess documentAccess = documentAccessFactory.create(document,
				context.getParameter("requiredStateId"), false);
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.hasSideEffects = true;
		if (fullText == null) {
			String deltaText = context.getParameter("deltaText");
			if (deltaText == null) {
				throw new InvalidRequestException.InvalidParametersException(
						"One of the parameters 'deltaText' and 'fullText' must be specified.");
			}
			int deltaOffset = getInt(context, "deltaOffset", Optional.absent());
			if (deltaOffset < 0) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter 'deltaOffset' must not be negative.");
			}
			int deltaReplaceLength = getInt(context, "deltaReplaceLength", Optional.absent());
			if (deltaReplaceLength < 0) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter 'deltaReplaceLength' must not be negative.");
			}
			serviceDescriptor.service = () -> {
				try {
					return updateDocumentService.updateDeltaText(documentAccess, deltaText, deltaOffset,
							deltaReplaceLength);
				} catch (Throwable throwable) {
					return handleError(serviceDescriptor, throwable);
				}
			};
		} else {
			if (context.getParameterKeys().contains("deltaText")) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameters 'deltaText' and 'fullText' cannot be set in the same request.");
			}
			serviceDescriptor.service = () -> {
				try {
					if (initializedFromFullText) {
						return updateDocumentService.getStateId(documentAccess);
					} else {
						return updateDocumentService.updateFullText(documentAccess, fullText);
					}
				} catch (Throwable throwable) {
					return handleError(serviceDescriptor, throwable);
				}
			};
		}
		return serviceDescriptor;
	}

	protected ServiceDescriptor getContentAssistService(IServiceContext context) throws InvalidRequestException {
		int offset = getInt(context, "caretOffset", Optional.of(0));
		if (offset < 0) {
			throw new InvalidRequestException.InvalidParametersException(
					"The parameter 'offset' must not be negative.");
		}
		XtextWebDocumentAccess document = getDocumentAccess(context);
		int proposalsLimit = getInt(context, "proposalsLimit",
				Optional.of(ContentAssistService.DEFAULT_PROPOSALS_LIMIT));
		if (proposalsLimit <= 0) {
			throw new InvalidRequestException.InvalidParametersException(
					"The parameter 'proposalsLimit' must contain a positive integer.");
		}
		int selectionStart = getInt(context, "selectionStart", Optional.of(offset));
		int selectionEnd = getInt(context, "selectionEnd", Optional.of(selectionStart));
		TextRegion selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0));
		String deltaText = context.getParameter("deltaText");
		if (deltaText == null) {
			ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
			serviceDescriptor.service = () -> {
				try {
					return contentAssistService.createProposals(document, selection, offset, proposalsLimit);
				} catch (Throwable throwable) {
					return handleError(serviceDescriptor, throwable);
				}
			};
			return serviceDescriptor;
		} else {
			if (context.getParameterKeys().contains("fullText")) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameters 'deltaText' and 'fullText' cannot be set in the same request.");
			}
			int deltaOffset = getInt(context, "deltaOffset", Optional.absent());
			if (deltaOffset < 0) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter 'deltaOffset' must not be negative.");
			}
			int deltaReplaceLength = getInt(context, "deltaReplaceLength", Optional.absent());
			if (deltaReplaceLength < 0) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter 'deltaReplaceLength' must not be negative.");
			}
			ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
			serviceDescriptor.service = () -> {
				try {
					return contentAssistService.createProposalsWithUpdate(document, deltaText, deltaOffset,
							deltaReplaceLength, selection, offset, proposalsLimit);
				} catch (Throwable throwable) {
					return handleError(serviceDescriptor, throwable);
				}
			};
			serviceDescriptor.hasSideEffects = true;
			return serviceDescriptor;
		}
	}

	protected ServiceDescriptor getValidationService(IServiceContext context) throws InvalidRequestException {
		XtextWebDocumentAccess document = getDocumentAccess(context);
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.service = () -> {
			try {
				return validationService.getResult(document);
			} catch (Throwable throwable) {
				return handleError(serviceDescriptor, throwable);
			}
		};
		return serviceDescriptor;
	}

	protected ServiceDescriptor getHoverService(IServiceContext context) throws InvalidRequestException {
		XtextWebDocumentAccess document = getDocumentAccess(context);
		int offset = getInt(context, "caretOffset", Optional.of(0));
		if (offset < 0) {
			throw new InvalidRequestException.InvalidParametersException(
					"The parameter 'offset' must not be negative.");
		}
		int selectionStart = getInt(context, "selectionStart", Optional.of(offset));
		int selectionEnd = getInt(context, "selectionEnd", Optional.of(selectionStart));
		TextRegion selection = new TextRegion(selectionStart, Math.max(selectionEnd - selectionStart, 0));
		String proposal = context.getParameter("proposal");
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.service = () -> {
			try {
				if (StringExtensions.isNullOrEmpty(proposal)) {
					return hoverService.getHover(document, offset);
				} else {
					return hoverService.getHover(document, proposal, selection, offset);
				}
			} catch (Throwable throwable) {
				return handleError(serviceDescriptor, throwable);
			}
		};
		return serviceDescriptor;
	}

	protected ServiceDescriptor getHighlightingService(IServiceContext context) throws InvalidRequestException {
		XtextWebDocumentAccess document = getDocumentAccess(context);
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.service = () -> {
			try {
				return highlightingService.getResult(document);
			} catch (Throwable throwable) {
				return handleError(serviceDescriptor, throwable);
			}
		};
		return serviceDescriptor;
	}

	protected ServiceDescriptor getOccurrencesService(IServiceContext context) throws InvalidRequestException {
		XtextWebDocumentAccess document = getDocumentAccess(context);
		int offset = getInt(context, "caretOffset", Optional.of(0));
		if (offset < 0) {
			throw new InvalidRequestException.InvalidParametersException(
					"The parameter 'offset' must not be negative.");
		}
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.service = () -> {
			try {
				return occurrencesService.findOccurrences(document, offset);
			} catch (Throwable throwable) {
				return handleError(serviceDescriptor, throwable);
			}
		};
		return serviceDescriptor;
	}

	/**
	 * @see FormatterPreferenceKeys
	 */
	protected ServiceDescriptor getFormattingService(IServiceContext context) throws InvalidRequestException {
		XtextWebDocumentAccess document = getDocumentAccess(context);
		int selectionStart = getInt(context, "selectionStart", Optional.of(0));
		int selectionEnd = getInt(context, "selectionEnd", Optional.of(selectionStart));
		String lineSeparator = context.getParameter("lineSeparator");
		String indentation = context.getParameter("indentation");
		int indentationLength = getInt(context, "indentationLength", Optional.of(4));
		int maxLineWidth = getInt(context, "maxLineWidth", Optional.of(120));
		IPreferenceValues formatterPreferences = document
				.readOnly(new CancelableUnitOfWork<IPreferenceValues, IXtextWebDocument>() {
					@Override
					public IPreferenceValues exec(IXtextWebDocument $0, CancelIndicator $1) throws Exception {
						if (formatterPreferencesProvider != null) {
							return formatterPreferencesProvider.getPreferenceValues($0.getResource());
						}
						return null;
					}
				});
		MapBasedPreferenceValues preferences = new MapBasedPreferenceValues(formatterPreferences,
				new LinkedHashMap<>());
		preferences.put(FormatterPreferenceKeys.lineSeparator, lineSeparator);
		preferences.put(FormatterPreferenceKeys.indentation, indentation);
		preferences.put(FormatterPreferenceKeys.tabWidth, indentationLength);
		preferences.put(FormatterPreferenceKeys.maxLineWidth, maxLineWidth);
		final TextRegion selection;
		if (selectionEnd > selectionStart) {
			selection = new TextRegion(selectionStart, (selectionEnd - selectionStart));
		} else {
			selection = null;
		}
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		serviceDescriptor.service = () -> {
			try {
				return formattingService.format(document, selection, preferences);
			} catch (Throwable throwable) {
				return handleError(serviceDescriptor, throwable);
			}
		};
		serviceDescriptor.hasSideEffects = true;
		return serviceDescriptor;
	}

	protected ServiceDescriptor getGeneratorService(IServiceContext context) throws InvalidRequestException {
		XtextWebDocumentAccess document = getDocumentAccess(context);
		boolean allArtifacts = getBoolean(context, "allArtifacts", Optional.of(false));
		boolean includeContent = getBoolean(context, "includeContent", Optional.of(true));
		ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
		if (allArtifacts) {
			serviceDescriptor.service = () -> {
				try {
					return generatorService.getResult(document, includeContent);
				} catch (Throwable throwable) {
					return handleError(serviceDescriptor, throwable);
				}
			};
		} else {
			String artifactId = context.getParameter("artifact");
			serviceDescriptor.service = () -> {
				try {
					return generatorService.getArtifact(document, artifactId, includeContent);
				} catch (Throwable throwable) {
					return handleError(serviceDescriptor, throwable);
				}
			};
		}
		return serviceDescriptor;
	}

	/**
	 * Retrieve the document access for the given service context. If the 'fullText'
	 * parameter is given, a new document containing that text is created. Otherwise
	 * the 'resource' parameter is used to load a resource and put it into the
	 * session store.
	 */
	protected XtextWebDocumentAccess getDocumentAccess(IServiceContext context) throws InvalidRequestException {
		XtextWebDocument document = null;
		boolean initializedFromFullText = false;
		if (context.getParameterKeys().contains("fullText")) {
			document = getFullTextDocument(context.getParameter("fullText"), getResourceID(context), context);
			initializedFromFullText = true;
		} else {
			if (context.getParameterKeys().contains("resource")) {
				document = getResourceDocument(getResourceID(context), context);
				if (document == null) {
					throw new InvalidRequestException.ResourceNotFoundException(
							"The requested resource was not found.");
				}
			} else {
				throw new InvalidRequestException.InvalidParametersException(
						"At least one of the parameters 'resource' and 'fullText' must be specified.");
			}
		}
		return documentAccessFactory.create(document, context.getParameter("requiredStateId"), initializedFromFullText);
	}

	/**
	 * Returns the resource ID from the service context. Potentially null.
	 */
	protected String getResourceID(IServiceContext context) {
		return context.getParameter("resource");
	}

	/**
	 * Create a new document containing the given text.
	 */
	protected XtextWebDocument getFullTextDocument(String fullText, String resourceId, IServiceContext context) {
		try {
			ResourceSet resourceSet = resourceSetProvider.get(resourceId, context);
			String uriString = null;
			if (resourceId != null) {
				uriString = resourceId;
			} else {
				uriString = Integer.toHexString(randomGenerator.nextInt()) + "."
						+ fileExtensionProvider.getPrimaryFileExtension();
			}
			URI uri = URI.createURI(uriString);
			XtextResource resource = (XtextResource) resourceFactory.createResource(uri);
			Resource existingResource = resourceSet.getResource(uri, false);
			if (existingResource != null) {
				resourceSet.getResources().remove(existingResource);
			}
			resourceSet.getResources().add(resource);
			resource.load(new StringInputStream(fullText), Collections.emptyMap());
			XtextWebDocument document = documentProvider.get(resourceId, context);
			document.setInput(resource);
			if (resourceId != null) {
				context.getSession().put(Pair.of(XtextWebDocument.class, resourceId), document);
			}
			return document;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	/**
	 * Obtain a document from the session store, and if it is not present there, ask
	 * the {@link IServerResourceHandler} to provide it. In case that resource
	 * handler fails to provide the document, {@code null} is returned instead.
	 */
	protected XtextWebDocument getResourceDocument(String resourceId, IServiceContext context) {
		try {
			return context.getSession().get(Pair.of(XtextWebDocument.class, resourceId), () -> {
				try {
					return resourceHandler.get(resourceId, context);
				} catch (Throwable t) {
					throw Exceptions.sneakyThrow(t);
				}
			});
		} catch (Throwable t) {
			if (t instanceof IOException) {
				return null;
			} else {
				throw Exceptions.sneakyThrow(t);
			}
		}
	}

	/**
	 * Read an string-valued parameter. If the parameter is not available, the
	 * {@code defaultValue} is returned.
	 * 
	 * @throws InvalidRequestException.InvalidParametersException if the parameter
	 *                                                            is not available
	 *                                                            and
	 *                                                            {@code defaultValue}
	 *                                                            is absent
	 */
	protected String getString(IServiceContext context, String key, Optional<String> defaultValue)
			throws InvalidRequestException.InvalidParametersException {
		String stringValue = context.getParameter(key);
		if (stringValue == null) {
			if (!defaultValue.isPresent()) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter '" + key + "' must be specified.");
			}
			return defaultValue.get();
		}
		return stringValue;
	}

	/**
	 * Read an integer-valued parameter. If the parameter is not available, the
	 * {@code defaultValue} is returned.
	 * 
	 * @throws InvalidRequestException.InvalidParametersException if the parameter
	 *                                                            is not available
	 *                                                            and
	 *                                                            {@code defaultValue}
	 *                                                            is absent
	 */
	protected int getInt(IServiceContext context, String key, Optional<Integer> defaultValue)
			throws InvalidRequestException.InvalidParametersException {
		String stringValue = context.getParameter(key);
		if (stringValue == null) {
			if (!defaultValue.isPresent()) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter '" + key + "' must be specified.");
			}
			return defaultValue.get().intValue();
		}
		try {
			return Integer.parseInt(stringValue);
		} catch (NumberFormatException e) {
			throw new InvalidRequestException.InvalidParametersException(
					"The parameter '" + key + "' must contain an integer value.");
		}
	}

	/**
	 * Read a Boolean-valued parameter. If the parameter is not available, the
	 * {@code defaultValue} is returned.
	 * 
	 * @throws InvalidRequestException.InvalidParametersException if the parameter
	 *                                                            is not available
	 *                                                            and
	 *                                                            {@code defaultValue}
	 *                                                            is absent
	 */
	protected boolean getBoolean(IServiceContext context, String key, Optional<Boolean> defaultValue)
			throws InvalidRequestException.InvalidParametersException {
		String stringValue = context.getParameter(key);
		if (stringValue == null) {
			if (!defaultValue.isPresent()) {
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter '" + key + "' must be specified.");
			}
			return defaultValue.get().booleanValue();
		}
		String lowerCase = stringValue.toLowerCase();
		if (lowerCase != null) {
			switch (lowerCase) {
			case "true":
				return true;
			case "false":
				return false;
			default:
				throw new InvalidRequestException.InvalidParametersException(
						"The parameter '" + key + "' must contain a Boolean value.");
			}
		} else {
			throw new InvalidRequestException.InvalidParametersException(
					"The parameter '" + key + "' must contain a Boolean value.");
		}
	}

	protected ServiceConflictResult _handleError(ServiceDescriptor service, Throwable throwable) {
		if (operationCanceledManager.isOperationCanceledException(throwable)) {
			LOG.trace("Service canceled (" + service.context.getParameter(IServiceContext.SERVICE_TYPE) + ")");
			return new ServiceConflictResult("canceled");
		}
		throw Exceptions.sneakyThrow(throwable);
	}

	protected ServiceConflictResult _handleError(ServiceDescriptor service,
			InvalidRequestException.InvalidDocumentStateException exception) {
		LOG.trace("Invalid document state (" + service.context.getParameter(IServiceContext.SERVICE_TYPE) + ")");
		return new ServiceConflictResult("invalidStateId");
	}

	protected ServiceConflictResult handleError(ServiceDescriptor service, Throwable exception) {
		if (exception instanceof InvalidRequestException.InvalidDocumentStateException) {
			return _handleError(service, (InvalidRequestException.InvalidDocumentStateException) exception);
		} else if (exception != null) {
			return _handleError(service, exception);
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.asList(service, exception).toString());
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.IDiagnosticAcceptor;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * An EMF resource that reads and writes models of an Xtext DSL.
 * 
 * @author Jan Köhnlein
 * @author Heiko Behrens
 * @author Dennis Hübner
 * @author Moritz Eysholdt
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 */
public class XtextResource extends ResourceImpl {

	public static final String OPTION_RESOLVE_ALL = XtextResource.class.getName() + ".RESOLVE_ALL";

	/**
	 * @deprecated use {@link SaveOptions#addTo(Map)} instead.
	 */
	@Deprecated
	public static final String OPTION_FORMAT = XtextResource.class.getName() + ".FORMAT";

	/**
	 * @deprecated use {@link SaveOptions#addTo(Map)} instead.
	 */
	@Deprecated
	public static final String OPTION_SERIALIZATION_OPTIONS = XtextResource.class.getName() + ".SERIALIZATION_OPTIONS";

	public static final String OPTION_ENCODING = XtextResource.class.getName() + ".DEFAULT_ENCODING";

	private boolean validationDisabled;
	
	/**
	 * @since 2.1
	 */
	protected volatile boolean isUpdating = false;

	private IParser parser;
	
	private ParserRule entryPoint;

	@Inject
	private ILinker linker;

	@Inject
	private IFragmentProvider fragmentProvider;
	
	@Inject
	@Named(Constants.LANGUAGE_NAME) 
	private String languageName;
	
	/**
	 * @since 2.8
	 */
	@Inject
	protected OperationCanceledManager operationCanceledManager;
	
	private long modificationStamp = Integer.MIN_VALUE;
	
	private IFragmentProvider.Fallback fragmentProviderFallback = new IFragmentProvider.Fallback() {
		
		@Override
		public String getFragment(EObject obj) {
			return XtextResource.super.getURIFragment(obj);
		}
		
		@Override
		public EObject getEObject(String fragment) {
			return XtextResource.super.getEObject(fragment);
		}
	};

	@Inject
	private ISerializer serializer;

	@Inject
	private IReferableElementsUnloader unloader;

	@Inject
	private IResourceServiceProvider resourceServiceProvider;

	@Inject
	private IConcreteSyntaxValidator validator;

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	@Inject
	private IEncodingProvider encodingProvider;

	private String encoding;

	public IResourceServiceProvider getResourceServiceProvider() {
		return resourceServiceProvider;
	}

	public void setResourceServiceProvider(IResourceServiceProvider resourceServiceProvider) {
		this.resourceServiceProvider = resourceServiceProvider;
	}

	private IParseResult parseResult;

	@Inject
	protected void setInjectedParser(IParser parser) {
		this.parser = parser;
	}

	public XtextResource(URI uri) {
		super(uri);
	}

	public XtextResource() {
		super();
	}

	/* @Nullable */
	public IParseResult getParseResult() {
		return parseResult;
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		setEncodingFromOptions(options);
		IParseResult result;
		if (entryPoint == null) {
			result = getParser().parse(createReader(inputStream));
		} else {
			result = getParser().parse(entryPoint, createReader(inputStream));
		}
		updateInternalState(this.parseResult, result);
	}
	
	/**
	 * @since 2.5
	 */
	protected Reader createReader(InputStream inputStream) throws IOException {
		if (inputStream instanceof LazyStringInputStream) {
			return new StringReader(((LazyStringInputStream) inputStream).getString());
		}
		return new InputStreamReader(new BufferedInputStream(inputStream), getEncoding());
	}

	protected void setEncodingFromOptions(Map<?, ?> options) {
		if (options != null) {
			Object encodingOption = options.get(OPTION_ENCODING);
			if (encodingOption instanceof String) {
				encoding = (String) encodingOption;
			}
		}
	}

	public String getEncoding() {
		if (encoding == null) {
			encoding = encodingProvider.getEncoding(getURI());
		}
		return encoding;
	}

	public void reparse(String newContent) throws IOException {
		try {
			isUpdating = true;
			clearInternalState();
			doLoad(new LazyStringInputStream(newContent, getEncoding()), null);
			setModified(false);
		} finally {
			isUpdating = false;
		}
	}

	protected void reattachModificationTracker(EObject element) {
		if (isTrackingModification() && element != null) {
			if (!element.eAdapters().contains(modificationTrackingAdapter))
				element.eAdapters().add(modificationTrackingAdapter);
			// copied from ResourceImpl.setTrackingModification
			for (TreeIterator<EObject> i = getAllProperContents(element); i.hasNext();) {
				EObject eObject = i.next();
				if (!eObject.eAdapters().contains(modificationTrackingAdapter))
					eObject.eAdapters().add(modificationTrackingAdapter);
			}
		}
	}

	@Override
	protected void doUnload() {
		super.doUnload();
		parseResult = null;
	}
	
	/**
	 * @since 2.9
	 */
	public void relink() {
		if (!isLoaded()) {
			throw new IllegalStateException("You can't update an unloaded resource.");
		}
		try {
			isUpdating = true;
			updateInternalState(parseResult, parseResult);
		} finally {
			isUpdating = false;
		}
	}

	public void update(int offset, int replacedTextLength, String newText) {
		if (!isLoaded()) {
			throw new IllegalStateException("You can't update an unloaded resource.");
		}
		try {
			isUpdating = true;
			IParseResult oldParseResult = parseResult;
			ReplaceRegion replaceRegion = new ReplaceRegion(new TextRegion(offset, replacedTextLength), newText);
			IParseResult newParseResult;
			ParserRule oldEntryPoint = NodeModelUtils.getEntryParserRule(oldParseResult.getRootNode());
			if (entryPoint == null || entryPoint == oldEntryPoint) {
				newParseResult = getParser().reparse(oldParseResult, replaceRegion);
			} else {
				StringBuilder builder = new StringBuilder(oldParseResult.getRootNode().getText());
				replaceRegion.applyTo(builder);
				newParseResult = getParser().parse(entryPoint, new StringReader(builder.toString()));
			}
			updateInternalState(oldParseResult, newParseResult);
		} finally {
			isUpdating = false;
		}
	}

	/**
	 * @param oldParseResult the previous parse result that should be detached if necessary.
	 * @param newParseResult the current parse result that should be attached to the content of this resource
	 * @since 2.1
	 */
	protected void updateInternalState(IParseResult oldParseResult, IParseResult newParseResult) {
		if (oldParseResult != null && oldParseResult.getRootASTElement() != null && oldParseResult.getRootASTElement() != newParseResult.getRootASTElement()) {
			EObject oldRootAstElement = oldParseResult.getRootASTElement();
			if (oldRootAstElement != newParseResult.getRootASTElement()) {
				unload(oldRootAstElement);
				getContents().remove(oldRootAstElement);
			}
		}
		updateInternalState(newParseResult);
	}
	
	protected void updateInternalState(IParseResult newParseResult) {
		this.parseResult = newParseResult;
		EObject newRootASTElement = parseResult.getRootASTElement();
		if (newRootASTElement != null && !containsRootElement(newRootASTElement))
			getContents().add(0, newRootASTElement);
		reattachModificationTracker(newRootASTElement);
		clearCache();
		clearErrorsAndWarnings();
		addSyntaxErrors();
		doLinking();
	}

	/*
	 * Extracted to allow this to be overriden from the DerivedStateAwareResource
	 */
	boolean containsRootElement(EObject newRootASTElement) {
		return getContents().contains(newRootASTElement);
	}

	/**
	 * @since 2.26
	 */
	protected void clearCache() {
		IResourceScopeCache cache = getCache();
		if (cache instanceof OnChangeEvictingCache) {
			cache.clear(this);
		}
	}

	protected void clearErrorsAndWarnings() {
		getWarnings().clear();
		getErrors().clear();
	}

	protected void addSyntaxErrors() {
		getErrors().addAll(createDiagnostics(parseResult));
	}

	protected void unload(EObject oldRootObject) {
		if (unloader != null) {
			unloader.unloadRoot(oldRootObject);
		}
	}

	protected void clearInternalState() {
		for (EObject content : getContents()) {
			unload(content);
		}
		getContents().clear();
		clearErrorsAndWarnings();
		this.parseResult = null;
	}

	protected void doLinking() {
		if (parseResult == null || parseResult.getRootASTElement() == null)
			return;

		final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(parseResult.getRootASTElement(), consumer);
		if (!validationDisabled) {
			getErrors().addAll(consumer.getResult(Severity.ERROR));
			getWarnings().addAll(consumer.getResult(Severity.WARNING));
		}
	}

	@Override
	public EObject getEObject(String uriFragment) {
		return basicGetEObject(uriFragment);
	}

	/**
	 * Resolves a fragment to an {@link EObject}. The returned object is not necessarily
	 * contained in this resource. It may resolve to a different one, instead.
	 * The result may be <code>null</code>.
	 * 
	 * @see ResourceImpl#getEObject(String)
	 * @see IFragmentProvider
	 * @since 2.4
	 */
	protected EObject basicGetEObject(/* @NonNull */ String uriFragment) {
		if (fragmentProvider != null) {
			EObject result = fragmentProvider.getEObject(this, uriFragment, fragmentProviderFallback);
			return result;
		}
		EObject result = super.getEObject(uriFragment);
		return result;
	}

	@Override
	public String getURIFragment(final EObject object) {
		if (fragmentProvider != null) {
			String result = fragmentProvider.getFragment(object, fragmentProviderFallback);
			return result;
		}
		String result = XtextResource.super.getURIFragment(object);
		return result;
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (getContents().isEmpty())
			throw new IllegalStateException("The Xtext resource must contain at least one element.");
		SaveOptions saveOptions = SaveOptions.getOptions(options);
		setEncodingFromOptions(options);
		serializer.serialize(getContents().get(0), new OutputStreamWriter(outputStream, getEncoding()), saveOptions);
	}

	/**
	 * Creates {@link org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostics} from {@link SyntaxErrorMessage syntax errors} in {@link IParseResult}.
	 * No diagnostics will be created if {@link #isValidationDisabled() validation is disabled} for this
	 * resource.
	 * 
	 * @param parseResult the parse result that provides the syntax errors.
	 * @return list of {@link org.eclipse.emf.ecore.resource.Resource.Diagnostic}. Never <code>null</code>.
	 */
	private List<Diagnostic> createDiagnostics(IParseResult parseResult) {
		if (validationDisabled)
			return Collections.emptyList();

		List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
		for (INode error : parseResult.getSyntaxErrors()) {
			addSyntaxDiagnostic(diagnostics, error);
		}
		return diagnostics;
	}

	/**
	 * @since 2.7
	 */
	protected void addSyntaxDiagnostic(List<Diagnostic> diagnostics, INode error) {
		SyntaxErrorMessage syntaxErrorMessage = error.getSyntaxErrorMessage();
		if (org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC_WITH_RANGE.equals(syntaxErrorMessage.getIssueCode())) {
			String[] issueData = syntaxErrorMessage.getIssueData();
			if (issueData.length == 1) {
				String data = issueData[0];
				int colon = data.indexOf(':');
				diagnostics.add(new XtextSyntaxDiagnosticWithRange(error, Integer.valueOf(data.substring(0, colon)), Integer.valueOf(data.substring(colon + 1)), null));
				return;
			}
		}
		diagnostics.add(new XtextSyntaxDiagnostic(error));
	}
	
	public IParser getParser() {
		return parser;
	}

	public void setParser(IParser parser) {
		this.parser = parser;
	}
	
	public ParserRule getEntryPoint() {
		if (entryPoint == null && parseResult != null) {
			entryPoint = NodeModelUtils.getEntryParserRule(parseResult.getRootNode());
		}
		return entryPoint;
	}
	
	public void setEntryPoint(ParserRule parserRule) {
		this.entryPoint = parserRule;
	}

	public IConcreteSyntaxValidator getConcreteSyntaxValidator() {
		return validator;
	}

	public List<org.eclipse.emf.common.util.Diagnostic> validateConcreteSyntax() {
		List<org.eclipse.emf.common.util.Diagnostic> diagnostics = new ArrayList<org.eclipse.emf.common.util.Diagnostic>();
		IDiagnosticAcceptor acceptor = new IConcreteSyntaxValidator.DiagnosticListAcceptor(diagnostics);
		for (EObject obj : getContents())
			validator.validateRecursive(obj, acceptor, new HashMap<Object, Object>());
		return diagnostics;
	}

	public ILinker getLinker() {
		return linker;
	}

	public void setLinker(ILinker linker) {
		this.linker = linker;
	}

	public IFragmentProvider getFragmentProvider() {
		return fragmentProvider;
	}

	public void setFragmentProvider(IFragmentProvider fragmentProvider) {
		this.fragmentProvider = fragmentProvider;
	}

	public ISerializer getSerializer() {
		return serializer;
	}

	public void setSerializer(ISerializer serializer) {
		this.serializer = serializer;
	}

	public void setParseResult(IParseResult parseResult) {
		this.parseResult = parseResult;
	}

	public boolean isValidationDisabled() {
		return validationDisabled;
	}

	public void setValidationDisabled(boolean validationDisabled) {
		this.validationDisabled = validationDisabled;
		if (validationDisabled) {
			clearErrorsAndWarnings();
		}
	}

	public void setUnloader(IReferableElementsUnloader unloader) {
		this.unloader = unloader;
	}

	public IReferableElementsUnloader getUnloader() {
		return unloader;
	}
	
	public IResourceScopeCache getCache() {
		return cache;
	}
	
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}
	
	public String getLanguageName() {
		return languageName;
	}
	
	/**
	 * @since 2.3
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	/**
	 * @since 2.4
	 */
	public void setModificationStamp(long documentModificationStamp) {
		this.modificationStamp = documentModificationStamp;
	}
	
	/**
	 * The modification stamp of the document reflected in the current state of this resource.
	 * Has to be set externally.
	 *  
	 * @since 2.4
	 */
	public long getModificationStamp() {
		return modificationStamp;
	}
	
}

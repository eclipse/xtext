/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import static com.google.common.collect.Lists.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IBatchLinkableResource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

/**
 * A resource description representing a dirty resource. Contains only preIndexing elements with a signature that is a
 * hash over the entire model text. This is necessary in order to shadow compiled types that have been deleted in the
 * dirty state.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @see org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy#postParse
 * @since 2.7
 */
public class DirtyStateResourceDescription extends AbstractResourceDescription {

	public static class Manager implements IResourceDescription.Manager {

		private static Logger LOG = Logger.getLogger(Manager.class);

		public static final String TEXT_HASH = Manager.class.getCanonicalName() + "_textHash";

		private IResourceDescription.Manager delegate;

		@Inject
		public Manager(IResourceDescription.Manager delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public IResourceDescription getResourceDescription(Resource resource) {
			return createResourceDescription(resource);
		}

		protected IResourceDescription createResourceDescription(Resource resource) {
			if(resource instanceof IBatchLinkableResource)
				return new DirtyStateResourceDescription(resource, computeTypes(resource));
			else 
				return delegate.getResourceDescription(resource);
		}

		protected List<IEObjectDescription> computeTypes(Resource resource) {
			IResourceDescription delegateDescription = delegate.getResourceDescription(resource);
			List<IEObjectDescription> result = newArrayList();
			String hash = getTextHash(resource);
			ImmutableMap<String, String> userData = ImmutableMap.of(TEXT_HASH, hash);
			for (IEObjectDescription eObjectDescription : delegateDescription.getExportedObjects()) {
				result.add(new EObjectDescription(eObjectDescription.getQualifiedName(), eObjectDescription.getEObjectOrProxy(), userData));
			}
			return result;
		}

		@Override
		public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
			return delegate.createDelta(oldDescription, newDescription);
		}

		@Override
		public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
			return delegate.isAffected(delta, candidate);
		}

		@Override
		public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate,
				IResourceDescriptions context) throws IllegalArgumentException {
			return delegate.isAffected(deltas, candidate, context);
		}

		protected String getTextHash(Resource resource) {
			try {
				MessageDigest digest = createDigest();
				if (digest != null) {
					byte[] bytes = digest.digest(getText(resource).getBytes("UTF-8"));
					return new BigInteger(bytes).toString(16);
				}
				return null;
			} catch (Exception exc) {
				LOG.error("Error creating resource text digest.", exc);
				return "";
			}
		}

		protected String getText(Resource resource) {
			String text = "";
			IParseResult parseResult = ((XtextResource) resource).getParseResult();
			if (parseResult != null)
				text = parseResult.getRootNode().getText();
			return text;
		}

		protected MessageDigest createDigest() throws NoSuchAlgorithmException {
			return MessageDigest.getInstance("MD5");
		}
	}

	private URI uri;

	private List<IEObjectDescription> types;

	public DirtyStateResourceDescription(Resource resource, List<IEObjectDescription> types) {
		this.uri = resource.getURI();
		this.types = types;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		return Collections.emptyList();
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Collections.emptyList();
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		return types;
	}
}

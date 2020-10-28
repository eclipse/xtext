/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import static org.eclipse.xtext.resource.persistence.SerializationExtensions.*;
import static com.google.common.collect.Iterables.*;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
public class SerializableResourceDescription extends AbstractResourceDescription implements Externalizable {

	private List<SerializableEObjectDescription> descriptions = Collections.emptyList();

	private List<SerializableReferenceDescription> references = Collections.emptyList();

	private List<QualifiedName> importedNames = Collections.emptyList();

	private URI uri;

	public void updateResourceURI(URI uri) {
		for (SerializableReferenceDescription ref : references)
			ref.updateResourceURI(uri, this.uri);
		for (SerializableEObjectDescription desc : descriptions)
			desc.updateResourceURI(uri);
		this.uri = uri;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected List<IEObjectDescription> computeExportedObjects() {
		return ((List<IEObjectDescription>) ((List<?>) this.descriptions));
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		return importedNames;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return ((Iterable<IReferenceDescription>) ((Iterable<?>) references));
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setURI(readURI(in));
		int descriptionsSize = in.readInt();
		descriptions = new ArrayList<>(descriptionsSize);
		for (int i = 0; i < descriptionsSize; i++)
			descriptions.add(readCastedObject(in));
		int referencesSize = in.readInt();
		references = new ArrayList<>(referencesSize);
		for (int i = 0; i < referencesSize; i++)
			references.add(readCastedObject(in));
		int importedNamesSize = in.readInt();
		importedNames = new ArrayList<>(importedNamesSize);
		for (int i = 0; i < importedNamesSize; i++)
			importedNames.add(readQualifiedName(in));
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		writeURI(out, uri);
		out.writeInt(descriptions.size());
		for (SerializableEObjectDescription desc : descriptions)
			out.writeObject(desc);
		out.writeInt(references.size());
		for (SerializableReferenceDescription ref : references)
			out.writeObject(ref);
		out.writeInt(importedNames.size());
		for (QualifiedName name : this.importedNames)
			SerializationExtensions.writeQualifiedName(out, name);
	}

	public List<SerializableEObjectDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<SerializableEObjectDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public List<SerializableReferenceDescription> getReferences() {
		return references;
	}

	public void setReferences(List<SerializableReferenceDescription> references) {
		this.references = references;
	}

	public void setImportedNames(List<QualifiedName> importedNames) {
		this.importedNames = importedNames;
	}

	public URI getURI() {
		return uri;
	}

	public void setURI(URI uri) {
		this.uri = uri;
	}

	public static SerializableResourceDescription createCopy(IResourceDescription desc) {
		SerializableResourceDescription description = new SerializableResourceDescription();
		description.setURI(desc.getURI());
		description.descriptions = Lists.newArrayList(
				transform(desc.getExportedObjects(), SerializableResourceDescription::createCopy));
		description.references = Lists.newArrayList(
				transform(desc.getReferenceDescriptions(), SerializableResourceDescription::createCopy));
		description.importedNames = Lists.newArrayList(desc.getImportedNames());
		return description;
	}

	private static SerializableEObjectDescription createCopy(IEObjectDescription desc) {
		if (desc instanceof SerializableEObjectDescriptionProvider)
			return ((SerializableEObjectDescriptionProvider) desc).toSerializableEObjectDescription();
		SerializableEObjectDescription result = new SerializableEObjectDescription();
		result.setEClass(desc.getEClass());
		result.setEObjectURI(desc.getEObjectURI());
		result.qualifiedName = desc.getQualifiedName();
		result.userData = new HashMap<String, String>(desc.getUserDataKeys().length);
		for (String key : desc.getUserDataKeys())
			result.userData.put(key, desc.getUserData(key));
		return result;
	}

	private static SerializableReferenceDescription createCopy(IReferenceDescription desc) {
		SerializableReferenceDescription result = new SerializableReferenceDescription();
		result.setSourceEObjectUri(desc.getSourceEObjectUri());
		result.setTargetEObjectUri(desc.getTargetEObjectUri());
		result.setEReference(desc.getEReference());
		result.setIndexInList(desc.getIndexInList());
		result.setContainerEObjectURI(desc.getContainerEObjectURI());
		return result;
	}

}

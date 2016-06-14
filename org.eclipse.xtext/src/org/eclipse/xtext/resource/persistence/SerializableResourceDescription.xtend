/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import java.io.Externalizable
import java.io.IOException
import java.io.ObjectInput
import java.io.ObjectOutput
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.AbstractResourceDescription

import static extension org.eclipse.xtext.resource.persistence.SerializationExtensions.*

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@Accessors class SerializableResourceDescription extends AbstractResourceDescription implements Externalizable {

	def static SerializableResourceDescription createCopy(IResourceDescription desc) {
		new SerializableResourceDescription => [
			URI = desc.URI
			descriptions = desc.exportedObjects.map[createCopy(it)].toList
			references = desc.referenceDescriptions.map[createCopy(it)].toList
			importedNames = newArrayList(desc.importedNames)
		]
	}
	
	private def static SerializableEObjectDescription createCopy(IEObjectDescription desc) {
		new SerializableEObjectDescription => [
			EClass = desc.EClass
			EObjectURI = desc.EObjectURI
			qualifiedName = desc.qualifiedName
			userData = new HashMap(desc.userDataKeys.size)
			for (key : desc.userDataKeys) {
				userData.put(key, desc.getUserData(key))
			}
		]
	}
		
	private def static SerializableReferenceDescription createCopy(IReferenceDescription desc) {
		new SerializableReferenceDescription => [
			sourceEObjectUri = desc.sourceEObjectUri
			targetEObjectUri = desc.targetEObjectUri
			EReference = desc.EReference
			indexInList = desc.indexInList
			containerEObjectURI = desc.containerEObjectURI
		]
	}	
	
	List<SerializableEObjectDescription> descriptions = emptyList
	List<SerializableReferenceDescription> references = emptyList
	List<QualifiedName> importedNames = emptyList
	URI uRI
	
	def void updateResourceURI(URI uri) {
		for (ref : references) {
			ref.updateResourceURI(uri, this.uRI)
		}
		for (desc : descriptions) {
			desc.updateResourceURI(uri)
		}
		this.uRI = uri
	}
	
	override protected computeExportedObjects() {
		descriptions as List<?> as List<IEObjectDescription>
	}
	
	override getImportedNames() {
		importedNames
	}
	
	override getReferenceDescriptions() {
		references as Iterable<?> as Iterable<IReferenceDescription>
	}
	
	override readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		URI = in.readURI
		val descriptionsSize = in.readInt
		descriptions = new ArrayList(descriptionsSize);
		for (i : 0 ..< descriptionsSize) {
			descriptions.add(in.readCastedObject)
		}
		val referencesSize = in.readInt
		references = new ArrayList(referencesSize);
		for (i : 0 ..< referencesSize) {
			references.add(in.readCastedObject)
		}
		val importedNamesSize = in.readInt
		importedNames = new ArrayList(importedNamesSize)
		for (i : 0 ..< importedNamesSize) {
			importedNames.add(in.readQualifiedName)
		}
	}
	
	override writeExternal(ObjectOutput out) throws IOException {
		out.writeURI(uRI)
		out.writeInt(descriptions.size)
		for (desc : descriptions) {
			out.writeObject(desc)
		}
		out.writeInt(references.size)
		for (ref : references) {
			out.writeObject(ref)
		}
		out.writeInt(importedNames.size)
		for (name : importedNames) {
			out.writeQualifiedName(name)
		}
	}
	
}

/**
 * @since 2.8
 */
@Accessors class SerializableEObjectDescription implements IEObjectDescription, Externalizable {
	
	URI eObjectURI
	EClass eClass
	QualifiedName qualifiedName
	HashMap<String,String> userData
	@Accessors(NONE) transient EObject eObjectOrProxy
	
	def void updateResourceURI(URI uri) {
		eObjectURI = uri.appendFragment(eObjectURI.fragment)
	}
	
	override getEObjectOrProxy() {
		if (eObjectOrProxy == null) {
			val proxy = EcoreUtil.create(eClass)
			(proxy as InternalEObject).eSetProxyURI(eObjectURI)
			eObjectOrProxy = proxy
		}
		return eObjectOrProxy
	}
	
	override getName() {
		qualifiedName
	}
	
	override getUserData(String key) {
		userData.get(key)
	}
	
	override getUserDataKeys() {
		userData.keySet
	}
	
	override readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		eObjectURI = in.readURI
		eClass = in.readEcoreElement
		qualifiedName = in.readQualifiedName
		userData = in.readCastedObject
	}
	
	override writeExternal(ObjectOutput out) throws IOException {
		out.writeURI(eObjectURI)
		out.writeURI(EcoreUtil.getURI(eClass))
		out.writeQualifiedName(qualifiedName)
		out.writeObject(userData)
	}
	
} 

/**
 * @since 2.8
 */
@Accessors class SerializableReferenceDescription implements IReferenceDescription, Externalizable {
	URI sourceEObjectUri
	URI targetEObjectUri
	URI containerEObjectURI
	EReference eReference
	int indexInList
	
	override readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		sourceEObjectUri = in.readURI
		targetEObjectUri = in.readURI
		containerEObjectURI = in.readURI
		eReference = in.readEcoreElement
		indexInList = in.readInt
	}
	
	override writeExternal(ObjectOutput out) throws IOException {
		out.writeURI(sourceEObjectUri)
		out.writeURI(targetEObjectUri)
		out.writeURI(containerEObjectURI)
		out.writeEcoreElement(eReference)
		out.writeInt(indexInList)
	}
	
	def void updateResourceURI(URI newURI, URI oldURI) {
		sourceEObjectUri = newURI.appendFragment(sourceEObjectUri.fragment)
		if (targetEObjectUri.trimFragment == oldURI) {
			targetEObjectUri = newURI.appendFragment(targetEObjectUri.fragment)
		}
	}
	
} 


/**
 * @since 2.8
 */
package class SerializationExtensions {
	
	def static <T extends ENamedElement> T readEcoreElement(ObjectInput in) throws IOException {
		val uri = in.readURI
		val ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.trimFragment.toString)
		return ePackage?.eResource?.getEObject(uri.fragment) as T
	}
	
	def static void writeEcoreElement(ObjectOutput out, ENamedElement namedElement) throws IOException {
		val uri = EcoreUtil.getURI(namedElement)
		out.writeURI(uri)
	}
	
	def static <T> T readCastedObject(ObjectInput  in) throws IOException {
		in.readObject as T
	}
	
	def static URI readURI(ObjectInput in) throws IOException {
		val stringRep = in.readUTF
		if (stringRep == "NULL") {
			return null
		}
		return URI::createURI(stringRep)
	}
	
	def static void writeURI(ObjectOutput out, URI uri) throws IOException {
		if (uri == null) {
			out.writeUTF("NULL")
		} else {
			out.writeUTF(uri.toString)
		}
	}
	
	def static QualifiedName readQualifiedName(ObjectInput in) throws IOException {
		return QualifiedName.create(in.readObject as ArrayList<String>)
	}
	
	def static void writeQualifiedName(ObjectOutput out, QualifiedName name) throws IOException {
		out.writeObject(new ArrayList(name.segments))
	}
}

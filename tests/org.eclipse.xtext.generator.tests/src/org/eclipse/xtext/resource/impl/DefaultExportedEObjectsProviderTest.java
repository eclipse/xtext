package org.eclipse.xtext.resource.impl;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IQualifiedNameProvider;

import com.google.common.collect.Lists;

public class DefaultExportedEObjectsProviderTest extends TestCase {
	private DefaultExportedEObjectsProvider provider;
	private EPackage pack;
	private EClass eClass;
	private EDataType dtype;
	private Resource impl;

	public void testGetExportedObject_1() throws Exception {
		provider.setNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			public String getQualifiedName(EObject obj) {
				if (obj instanceof EPackage)
					return ((EPackage)obj).getName();
				return null;
			}});
		
		Iterable<IEObjectDescription> iterable = provider.getExportedObjects(impl);
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(1, list.size());
		assertEquals(pack.getName(),list.get(0).getName());
		assertEquals(pack,list.get(0).getEObjectOrProxy());
	}
	
	public void testGetExportedObject_2() throws Exception {
		provider.setNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			public String getQualifiedName(EObject obj) {
				if (obj instanceof EClassifier)
					return ((EClassifier)obj).getName();
				return null;
			}});
		
		Iterable<IEObjectDescription> iterable = provider.getExportedObjects(impl);
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(2, list.size());
		assertEquals(eClass.getName(),list.get(0).getName());
		assertEquals(eClass,list.get(0).getEObjectOrProxy());
		assertEquals(dtype.getName(),list.get(1).getName());
		assertEquals(dtype,list.get(1).getEObjectOrProxy());
	}
	
	public void testGetExportedObject_3() throws Exception {
		provider.setNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			public String getQualifiedName(EObject obj) {
				if (obj instanceof ENamedElement)
					return ((ENamedElement)obj).getName();
				return null;
			}});
		
		Iterable<IEObjectDescription> iterable = provider.getExportedObjects(impl);
		ArrayList<IEObjectDescription> list = Lists.newArrayList(iterable);
		assertEquals(3, list.size());
		assertEquals(pack.getName(),list.get(0).getName());
		assertEquals(pack,list.get(0).getEObjectOrProxy());
		assertEquals(eClass.getName(),list.get(1).getName());
		assertEquals(eClass,list.get(1).getEObjectOrProxy());
		assertEquals(dtype.getName(),list.get(2).getName());
		assertEquals(dtype,list.get(2).getEObjectOrProxy());
	}

	@Override
	protected void setUp() throws Exception {
		provider = new DefaultExportedEObjectsProvider();
		impl = new XMLResourceImpl();
		EcoreFactory f = EcoreFactory.eINSTANCE;
		pack = f.createEPackage();
		pack.setName("MyPackage");
		eClass = f.createEClass();
		eClass.setName("MyEClass");
		dtype = f.createEDataType();
		dtype.setName("MyDatatype");
		pack.getEClassifiers().add(eClass);
		pack.getEClassifiers().add(dtype);
		impl.getContents().add(pack);
	}
}

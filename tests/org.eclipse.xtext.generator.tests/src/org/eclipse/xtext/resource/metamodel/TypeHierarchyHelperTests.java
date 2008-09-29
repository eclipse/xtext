package org.eclipse.xtext.resource.metamodel;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.resource.metamodel.EClassifierInfo.EClassInfo;

public class TypeHierarchyHelperTests extends TestCase {

	private TypeHierarchyHelper helper;
	private EClassifierInfos infos = new EClassifierInfos();
	private EDataType INT = EcoreFactory.eINSTANCE.createEDataType();
//	private EDataType STRING = EcoreFactory.eINSTANCE.createEDataType();

	private void liftUpFeatures() throws Exception {
		helper = new TypeHierarchyHelper(infos);
		helper.liftUpFeatures();
	}

	private EClassInfo addClass(String name, boolean isGenerated) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		EClassInfo info = (EClassInfo) EClassifierInfo.createEClassInfo(eClass, isGenerated);
		infos.addInfo("", name, info);
		return info;
	}

	private EClassInfo addClass(String name) {
		return addClass(name, true);
	}
	
	private void addAttribute(EClassInfo eClass, EDataType eType, String name) {
		EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
		feature.setName(name);
		feature.setEType(eType);
		eClass.getEClass().getEStructuralFeatures().add(feature);
	}

	public void testSimpeCase01() throws Exception {
		EClassInfo a = addClass("a");
		EClassInfo b = addClass("b");
		EClassInfo c = addClass("c");
		b.addSupertype(a);
		c.addSupertype(a);
		addAttribute(b, INT, "f1");
		addAttribute(c, INT, "f1");

		assertEquals(0, a.getEClass().getEStructuralFeatures().size());
		assertEquals(1, b.getEClass().getEStructuralFeatures().size());
		assertEquals(1, c.getEClass().getEStructuralFeatures().size());
		
		liftUpFeatures();
		
		assertEquals(1, a.getEClass().getEStructuralFeatures().size());
		assertEquals(0, b.getEClass().getEStructuralFeatures().size());
		assertEquals(0, c.getEClass().getEStructuralFeatures().size());
	}

	public void testSimpeCase02() throws Exception {
		// no uplift for less than two children
		EClassInfo a = addClass("a");
		EClassInfo b = addClass("b");
		b.addSupertype(a);
		addAttribute(b, INT, "f1");

		assertEquals(0, a.getEClass().getEStructuralFeatures().size());
		assertEquals(1, b.getEClass().getEStructuralFeatures().size());
		
		liftUpFeatures();
		
		assertEquals(0, a.getEClass().getEStructuralFeatures().size());
		assertEquals(1, b.getEClass().getEStructuralFeatures().size());
	}
	
	public void testRecursiveUplift01() throws Exception {
		// no uplift for less than two children
		EClassInfo a = addClass("a");
		EClassInfo b = addClass("b");
		EClassInfo c = addClass("c");
		EClassInfo d = addClass("d");
		EClassInfo e = addClass("e");
		b.addSupertype(a);
		c.addSupertype(a);
		d.addSupertype(c);
		e.addSupertype(c);
		
		addAttribute(b, INT, "f1");
		addAttribute(d, INT, "f1");
		addAttribute(e, INT, "f1");
	
		assertEquals(0, a.getEClass().getEStructuralFeatures().size());
		assertEquals(1, b.getEClass().getEStructuralFeatures().size());
		assertEquals(0, c.getEClass().getEStructuralFeatures().size());
		assertEquals(1, d.getEClass().getEStructuralFeatures().size());
		assertEquals(1, e.getEClass().getEStructuralFeatures().size());
		
		liftUpFeatures();
		
		assertEquals(1, a.getEClass().getEStructuralFeatures().size());
		assertEquals(0, b.getEClass().getEStructuralFeatures().size());
		assertEquals(0, c.getEClass().getEStructuralFeatures().size());
		assertEquals(0, d.getEClass().getEStructuralFeatures().size());
		assertEquals(0, e.getEClass().getEStructuralFeatures().size());
	}
	
	public void testNikolaus() throws Exception {
		// no uplift for less than two children
		EClassInfo a = addClass("a");
		EClassInfo b = addClass("b");
		EClassInfo c = addClass("c");
		EClassInfo d = addClass("d");
		EClassInfo e = addClass("e");
		b.addSupertype(a);
		c.addSupertype(a);
		d.addSupertype(b);
		d.addSupertype(c);
		e.addSupertype(b);
		e.addSupertype(c);
		
		addAttribute(d, INT, "f1");
		addAttribute(e, INT, "f1");
	
		assertEquals(0, a.getEClass().getEStructuralFeatures().size());
		assertEquals(0, b.getEClass().getEStructuralFeatures().size());
		assertEquals(0, c.getEClass().getEStructuralFeatures().size());
		assertEquals(1, d.getEClass().getEStructuralFeatures().size());
		assertEquals(1, e.getEClass().getEStructuralFeatures().size());
		
		liftUpFeatures();
		
		assertEquals(0, a.getEClass().getEStructuralFeatures().size());
		assertEquals(0, b.getEClass().getEStructuralFeatures().size());
		assertEquals(0, c.getEClass().getEStructuralFeatures().size());
		assertEquals(1, d.getEClass().getEStructuralFeatures().size());
		assertEquals(1, e.getEClass().getEStructuralFeatures().size());
	}
	

}

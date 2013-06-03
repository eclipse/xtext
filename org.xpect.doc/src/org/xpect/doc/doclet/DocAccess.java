package org.xpect.doc.doclet;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.setup.XpectSetup;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;

public class DocAccess {
	private final RootDoc root;
	private final Multimap<String, ClassDoc> byAnnotation;
	private final Multimap<String, ClassDoc> bySuperclass;
	private final List<ClassDoc> tests;

	public DocAccess(RootDoc root) {
		super();
		this.root = root;
		this.byAnnotation = groupByAnnotation(root);
		this.bySuperclass = groupBySuperClass(root);
		this.tests = collectTests(root);
	}

	public RootDoc getRoot() {
		return root;
	}

	private Multimap<String, ClassDoc> groupBySuperClass(RootDoc root) {
		Multimap<String, ClassDoc> result = LinkedHashMultimap.create();
		for (ClassDoc cls : root.classes())
			groupBySuperClass(result, cls, cls);
		return result;
	}

	private void groupBySuperClass(Multimap<String, ClassDoc> result, ClassDoc cls, ClassDoc subclass) {
		ClassDoc superclass = subclass.superclass();
		if (superclass != null) {
			result.put(superclass.qualifiedName(), cls);
			groupBySuperClass(result, cls, superclass);
		}
		for (ClassDoc i : subclass.interfaces()) {
			result.put(i.qualifiedName(), cls);
			groupBySuperClass(result, cls, i);
		}
	}

	private Multimap<String, ClassDoc> groupByAnnotation(RootDoc root) {
		Multimap<String, ClassDoc> result = LinkedHashMultimap.create();
		for (ClassDoc cls : root.classes())
			for (AnnotationDesc a : cls.annotations())
				result.put(a.annotationType().qualifiedName(), cls);
		return result;
	}

	private List<ClassDoc> collectTests(RootDoc root) {
		List<ClassDoc> result = Lists.newArrayList();
		CLS: for (ClassDoc cls : root.classes()) {
			for (AnnotationDesc a : cls.annotations()) {
				String name = a.annotationType().qualifiedName();
				if (XpectSuiteClasses.class.getName().equals(name) || XpectSetup.class.getName().equals(name)) {
					result.add(cls);
					continue CLS;
				}
			}
			for (MethodDoc m : cls.methods())
				for (AnnotationDesc a : m.annotations()) {
					String name = a.annotationType().qualifiedName();
					if (Test.class.getName().equals(name) || Xpect.class.getName().equals(name)) {
						result.add(cls);
						continue CLS;
					}
				}
		}
		return result;
	}

	public List<AnnotationTypeDoc> findAnnotationsAnnotatedWith(Class<? extends Annotation> type) {
		List<AnnotationTypeDoc> result = Lists.newArrayList();
		for (ClassDoc cls : byAnnotation.get(qualifiedName(type)))
			if (cls instanceof AnnotationTypeDoc)
				result.add((AnnotationTypeDoc) cls);
		return result;
	}

	public AnnotationTypeDoc findAnnotation(Class<? extends Annotation> type) {
		return (AnnotationTypeDoc) root.classNamed(qualifiedName(type));
	}

	public Collection<ClassDoc> findSubclassesOf(Class<?> cls) {
		return bySuperclass.get(qualifiedName(cls));
	}

	public List<ClassDoc> findXpectTests() {
		return tests;
	}

	private String qualifiedName(Class<?> cls) {
		return cls.getName().replace('$', '.');
	}

}

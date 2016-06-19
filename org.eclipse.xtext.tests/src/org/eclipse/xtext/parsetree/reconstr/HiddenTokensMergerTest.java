package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.AppendToFileEnd;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestFactory;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Ignore;
import org.junit.Test;

public class HiddenTokensMergerTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(HiddenTokensMergerTestLanguageStandaloneSetup.class);
	}

	private void assertRoundtrip(String model) throws Exception {
		EObject o = getModel(model);
		//System.out.println(EmfFormatter.objToStr(((XtextResource) o.eResource()).getParseResult().getRootNode()));
		//		System.out.println(EmfFormatter.objToStr(((XtextResource) o.eResource()).getParseResult().getRootNode()));
		String r = getSerializer().serialize(o, SaveOptions.defaultOptions());
		assertEquals(model, r);
	}

	@Test public void testDatatypeBug286557a() throws Exception {
		assertRoundtrip("#1 a;");
	}

	@Test public void testDatatypeBug286557b() throws Exception {
		assertRoundtrip("#1 a ref a;");
	}

	@Test public void testDatatypeBug286557c() throws Exception {
		assertRoundtrip("#1 a.b.c;");
	}

	@Test public void testDatatypeBug286557d() throws Exception {
		assertRoundtrip("#1 a.b.c ref a.b.c;");
	}

	@Test public void testEnumBug() throws Exception {
		assertRoundtrip("#2  kw1   array     test");
	}

	@Test public void testCommentable1() throws Exception {
		Commentable model = (Commentable) getModel("#3\n /*a*/ item a\n /*b*/ item b\n /*c*/item c");
		model.getItem().move(1, 2);
		assertEquals("#3\n /*a*/ item a /*c*/item c /*b*/ item b", serialize(model));
	}

	@Test public void testCommentable2() throws Exception {
		Commentable model = (Commentable) getModel("#3 /*a*/ item a /*b*/ item b /*c*/item c");
		model.getItem().move(1, 2);
		assertEquals("#3 /*a*/ item a /*c*/item c /*b*/ item b", serialize(model));
	}

	@Test public void testCommentable3() throws Exception {
		Commentable model = (Commentable) getModel("#3 item a//a\n item b//b\n item c//c\n");
		model.getItem().move(1, 2);
		assertEquals("#3 item a//a\n item c//c\n item b//b\n", serialize(model));
	}

	@Test public void testCommentable4() throws Exception {
		Commentable model = (Commentable) getModel("#3 /*a*/ item a /*b*/ item b /*c*/item c");
		model.getItem().remove(1);
		CommentableItem i = HiddentokenmergertestFactory.eINSTANCE.createCommentableItem();
		i.setId("foo");
		model.getItem().add(i);
		assertEquals("#3 /*a*/ item a /*c*/item c item foo", serialize(model));
	}

	@Test public void testValueList1() throws Exception {
		ValueList model = (ValueList) getModel("#4 a. /* ab */ b c./*cd*/d e.  /*ef*/f.g /*hi*/ .i");
		model.getIds().move(1, 2);
		assertEquals("#4 a. /* ab */ b e.  /*ef*/f.g /*hi*/ .i c./*cd*/d", serialize(model));
	}

	@Test public void testRefList2() throws Exception {
		RefList model = (RefList) getModel("#5 a. b c.d e.f.g.i refs a./* ab */ b c./*cd*/  d e.  /*ef*/f.g/*hi*/.i");
		model.getRefs().move(1, 2);
		assertEquals("#5 a. b c.d e.f.g.i refs a./* ab */ b e.  /*ef*/f.g/*hi*/.i c./*cd*/  d", serialize(model));
	}

	@Test
	@Ignore
	public void testRefList3() throws Exception {
		RefList model = (RefList) getResourceFromStringAndExpect("#5 a.b refs x.y", 1).getContents().get(0);
		assertEquals("#5 a. b c.d e.f.g.i refs a./* ab */ b e.  /*ef*/f.g/*hi*/.i c./*cd*/  d", serialize(model));
	}

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=297938
	@Test public void testAppendToEnd() throws Exception {
		AppendToFileEnd model = (AppendToFileEnd) getModel("#7 class foo endclass");
		model.getItems().add(HiddentokenmergertestFactory.eINSTANCE.createAppendToFileEndItem());
		model.getItems().get(1).setName("bar");
		assertEquals("#7 class foo endclass class bar endclass", serialize(model));
	}
	
	@Test public void testAction1() throws Exception {
		Action1 model = (Action1) getModel("#8  foo  sub1  sub2");
		assertEquals("#8  foo  sub1  sub2", serialize(model));
	}

	@Override
	public String serialize(EObject obj) {
		return getSerializer().serialize(obj, SaveOptions.defaultOptions());
	}

}

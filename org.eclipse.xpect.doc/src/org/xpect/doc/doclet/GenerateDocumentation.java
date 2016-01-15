package org.xpect.doc.doclet;


public class GenerateDocumentation {

//	private static String GIT_SRC = "../";
//	private static String GIT_WEBSITE = "../../Xpect_pages/";
//	private static String DOC_SRC = GIT_SRC + "org.xpect.doc/src-doc/";
//	private static String DOC_GEN_ECLIPSE = GIT_SRC + "org.xpect.doc/doc-gen/";
//	private static String DOC_GEN_WEBSITE = GIT_WEBSITE + "documentation/";
//	private static String[] SRC_FOLDERS = { //
//	GIT_SRC + "org.xpect/src", //
//			GIT_SRC + "org.xpect/src-gen", //
//			GIT_SRC + "org.xpect.ui/src", //
//			GIT_SRC + "org.xpect.ui/src-gen", //
//			GIT_SRC + "org.xpect.xtext.lib/src", //
//			GIT_SRC + "org.eclipse.xtext.example.domainmodel.xpect.tests/src" //
//	};
//
//	private DocAccess root;
//
//	public GenerateDocumentation(DocAccess root) {
//		super();
//		this.root = root;
//	}
//
//	public static void main(String[] args) {
//		String sourcepath = Joiner.on(":").join(SRC_FOLDERS);
//		String doclet = GenerateDocumentation.class.getName();
//		String subpackages = "org.xpect";
//		com.sun.tools.javadoc.Main.main(new String[] { "-doclet", doclet, "-sourcepath", sourcepath, "-subpackages", subpackages });
//	}
//
//	private List<String> generateAnnotationMethodDoc(AnnotationTypeDoc annotation) {
//		List<String> out = Lists.newArrayList();
//		out.add("<ul>");
//		for (AnnotationTypeElementDoc s : annotation.elements()) {
//			out.add("<li>");
//			out.add(s.returnType().simpleTypeName() + " ");
//			out.add("<b>" + s.name() + "</b>");
//			out.add(" default: " + s.defaultValue());
//			out.add("</li>");
//		}
//		out.add("</ul>");
//		return out;
//	}
//
//	private Chapter generateAnnotationDoc(AnnotationTypeDoc annotation) {
//		Chapter result = new Chapter(annotation.qualifiedTypeName());
//		result.add("<p>");
//		result.add(annotation.commentText());
//		result.add("</p>");
//		result.add(generateAnnotationMethodDoc(annotation));
//		return result;
//	}
//
//	private void generate() throws IOException {
//		Chapter chapter = new Chapter("Xpect Reference");
//		chapter.add(generateAnnotationsForTests());
//		chapter.add(generateAnnotationsForMethods());
//		chapter.add(generateAnnotationsForParameters());
//		chapter.add(generateSetups());
//		chapter.add(generateTestLibrary());
//		Files.write(chapter.toString().getBytes(Charsets.ISO_8859_1), new File(DOC_GEN_ECLIPSE + "index.html"));
//	}
//
//	private Chapter generateAnnotationsForParameters() {
//		Chapter chapter = new Chapter("Annotations For Test Method Parameters");
//		for (AnnotationTypeDoc cls : root.findAnnotationsAnnotatedWith(SingleParameterParser.class))
//			chapter.add(generateAnnotationDoc((AnnotationTypeDoc) cls));
//		return chapter;
//	}
//
//	private Chapter generateAnnotationsForMethods() {
//		Chapter chapter = new Chapter("Annotations For Test Methods");
//		chapter.add(generateAnnotationDoc(root.findAnnotation(Test.class)));
//		chapter.add(generateAnnotationDoc(root.findAnnotation(Xpect.class)));
//		for (AnnotationTypeDoc cls : root.findAnnotationsAnnotatedWith(MultiParameterParser.class))
//			chapter.add(generateAnnotationDoc(cls));
//		return chapter;
//	}
//
//	private Chapter generateAnnotationsForTests() {
//		Chapter chapter = new Chapter("Annotations For Test Classes");
//		chapter.add(generateAnnotationDoc(root.findAnnotation(RunWith.class)));
//		chapter.add(generateAnnotationDoc(root.findAnnotation(XpectSetup.class)));
//		chapter.add(generateAnnotationDoc(root.findAnnotation(XpectSuiteClasses.class)));
//		for (AnnotationTypeDoc cls : root.findAnnotationsAnnotatedWith(XpectURIProvider.class))
//			chapter.add(generateAnnotationDoc(cls));
//		return chapter;
//	}
//
//	private Chapter generateSetups() {
//		Chapter chapter = new Chapter("Setups");
//		for (ClassDoc cls : root.findSubclassesOf(IXpectRunnerSetup.class))
//			if (!cls.isAbstract()) {
//				Chapter c = new Chapter(cls.qualifiedName());
//				c.add(cls.commentText());
//				c.add(cls.position().file().toString());
//				chapter.add(c);
//			}
//		return chapter;
//	}
//
//	private Chapter generateTestLibrary() {
//		Chapter chapter = new Chapter("Test Library");
//		for (ClassDoc cls : root.findXpectTests()) {
//			Chapter c = new Chapter(cls.qualifiedName());
//			c.add(cls.commentText());
//			chapter.add(c);
//		}
//		return chapter;
//	}
//
//	public static boolean start(RootDoc root) {
//		try {
//			new GenerateDocumentation(new DocAccess(root)).generate();
//			System.out.println("done");
//			return true;
//		} catch (Throwable t) {
//			t.printStackTrace();
//			return false;
//		}
//	}
}

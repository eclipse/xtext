package generator

class SevenLanguagesDocumentation extends Documentation {
	
	override getXdocDocumentRootFolder() {
		'../docs/org.xtext.sevenlanguages.doc.xdoc/xdoc'
	}

	override path() {
		"7languagesDoc.html"
	}

	override additionalLinks() {
		// no additional links
	}
	
}


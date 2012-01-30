package bootstrap

import com.google.inject.Inject
import org.eclipse.xtext.xdoc.xdoc.AbstractSection
import org.eclipse.xtext.xdoc.xdoc.Chapter
import org.eclipse.xtext.xdoc.xdoc.Document

class Body {
	
	@Inject extension XdocExtensions

	@Inject extension HtmlExtensions
	
	def body(Document document) {
		'''
		<div id="maincontainer" class="container">
			«FOR chapter: document.chapters»
				«(chapter.resolve as Chapter).h1»
			«ENDFOR»
		</div>
		'''
	}
	
	def h1(Chapter chapter) '''
		<!-- chapter -->
		<section id="«chapter.href»">
			<div class="page-header">
				<h1>
					«chapter.title.toHtml»
				</h1>
			</div>
			<div class="row">
				<div class="span12 offset2">
					«chapter.contents.toHtmlParagraph»
					«FOR section: chapter.sections»
						«section.h2»
					«ENDFOR»
				</div>
			</div>
		</section>
	'''
	
	def h2(AbstractSection section) '''
		<!--  section -->
		<section id="«section.href»">
		<h2>«section.title.toHtml»</h2>
		«section.contents.toHtmlParagraph»
		«FOR subsection: section.sections»
			«subsection.h3plus(3)»
		«ENDFOR»
		</section>
	'''
	
	def h3plus(AbstractSection section, int hLevel) '''
		<!-- subsection -->
		<section id="«section.href»">
		<h«hLevel»>«section.title.toHtml»</h«hLevel»>
		«section.contents.toHtmlParagraph»
		«FOR subSection: section.sections»
			«subSection.h3plus(hLevel + 1)»
		«ENDFOR»
		</section>
	'''
}
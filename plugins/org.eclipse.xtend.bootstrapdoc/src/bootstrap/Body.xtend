package bootstrap

import com.google.inject.Inject
import org.eclipse.xtext.xdoc.xdoc.AbstractSection

class Body {
	
	@Inject extension XdocExtensions

	@Inject extension HtmlExtensions
	
	@Inject extension TargetPaths
	
	def body(AbstractSection rootSection) '''
		<div id="maincontainer" class="container">
			«FOR chapter: rootSection.sections.filter[!targetRootElement]»
				«chapter.h1»
			«ENDFOR»
		</div>
	'''
	
	def h1(AbstractSection section) '''
		<!-- chapter -->
		<section id="«section.hrefId»" style="padding-top: 68px; margin-top: -68px;">
			<div class="row">
				<div class="span8 offset3">
					<h1>
						«section.title.toHtmlText»
					</h1>
					«FOR content : section.contents»
						«content.toHtmlParagraph»
					«ENDFOR»
					«FOR subSection: section.sections»
						«subSection.h2»
					«ENDFOR»
				</div>
			</div>
		</section>
	'''
	
	def h2(AbstractSection section) '''
		<!--  section -->
		<section id="«section.hrefId»" style="padding-top: 68px; margin-top: -68px;">
		<h2>«section.title.toHtmlText»</h2>
		«FOR content : section.contents»
			«content.toHtmlParagraph»
		«ENDFOR»
		«FOR subsection: section.sections»
			«subsection.h3plus(3)»
		«ENDFOR»
		</section>
	'''
	
	def CharSequence h3plus(AbstractSection section, int hLevel) '''
		<!-- subsection -->
		<section id="«section.hrefId»" style="padding-top: 68px; margin-top: -68px;">
		<h«hLevel»>«section.title.toHtmlText»</h«hLevel»>
		«FOR content : section.contents»
			«content.toHtmlParagraph»
		«ENDFOR»
		«FOR subSection: section.sections»
			«subSection.h3plus(hLevel + 1)»
		«ENDFOR»
		</section>
	'''
}
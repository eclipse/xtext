package bootstrap

import com.google.inject.Inject
import org.eclipse.xtext.xdoc.xdoc.Document

class Menu {
	
	@Inject extension XdocExtensions

	@Inject extension HtmlExtensions
	
	def menu(Document document) '''
		<div class="topbar" data-dropdown="dropdown">
			<div class="fill">
				<div class="container">
					<a class="brand" href="http://xtend-lang.org">Xtend</a>
					<ul class="nav">
						«FOR s : document.sections»
							«IF s.sections.size <= 1»
								<li><a href="#«s.href»">«s.title.toHtml»</a></li>
							«ELSE»
								<li class="dropdown">
									<a href="#«s.href»" class="dropdown-toggle">«s.title.toHtml»</a>
									<ul class="dropdown-menu">
										«FOR subSection : s.sections»
										<li><a href="#«subSection.href»">«subSection.title.toHtml»</a></li>
										«ENDFOR»
									</ul>
								</li>
							«ENDIF»
						«ENDFOR»
						<li><a href="http://www.eclipse.org">Eclipse.org</a></li>
					</ul>
				</div>
			</div>
		</div>
	'''
}
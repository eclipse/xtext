package bootstrap

import com.google.inject.Inject
import org.eclipse.xtext.xdoc.xdoc.XdocFile

class Menu {
	
	@Inject extension XdocExtensions

	@Inject extension HtmlExtensions
	
	def menu(XdocFile file) '''
		<div class="topbar" data-dropdown="dropdown">
			<div class="fill">
				<div class="container">
					<a class="brand" href="http://xtend-lang.org">Xtend</a>
					<ul class="nav">
						«FOR s : file.mainSection.sections»
							«IF s.sections.empty»
								<li><a href="#«s.href»">«s.title.toHtml»</a></li>
							«ELSE»
								<li class="dropdown">
									<a href="#«s.href»">«s.title.toHtml»</a>
									<ul class="dropdown-menu">
										«FOR subSection : s.sections»
										<li><a href="#«subSection.href»">«subSection.title.toHtml»</a></li>
										«ENDFOR»
									</ul>
								</li>
							«ENDIF»
						«ENDFOR»
					</ul>
				</div>
			</div>
		</div>
	'''
}
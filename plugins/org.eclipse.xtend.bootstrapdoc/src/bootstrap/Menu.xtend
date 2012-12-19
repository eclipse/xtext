package bootstrap

import com.google.inject.Inject
import org.eclipse.xtext.xdoc.xdoc.Document

class Menu {
	
	@Inject extension XdocExtensions

	@Inject extension HtmlExtensions
	
	def menu(Document document) '''
			<div class="navbar navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</a>
						<a class="brand" href="http://www.xtend-lang.org">Xtend</a>
						<ul class="nav">
							«FOR s : document.sections»
								«IF s.sections.size <= 1»
									<li><a href="«s.href»">«s.title.toHtmlText»</a></li>
								«ELSE»
									<li class="dropdown">
										<a class="dropdown-toggle" data-toggle="dropdown">«s.title.toHtmlText» <b class="caret"></b></a>
										<ul class="dropdown-menu">
											«FOR subSection : s.sections»
											<li><a href="«subSection.href»">«subSection.title.toHtmlText»</a></li>
											«ENDFOR»
										</ul>
									</li>
								«ENDIF»
							«ENDFOR»
						</ul>
						<ul class="nav pull-right">
							<li><a href="http://www.eclipse.org">Eclipse.org</a></li>
						</ul>	
					</div>
				</div>
			</div>
		'''
}
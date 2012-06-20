package generator

class Community extends AbstractWebsite {

	override path() {
		'community.html'
	}
	
	override contents() '''
			<div id="header_wrapper" class="container" >
		<div class="inner">
			<div class="container">
				<div class="page-heading"><h1>Community</h1></div>
			</div>
			</div>
		</div>
		<div id="page">
			<div id="team" class="container clearfix"> 
				<h2>Resources</h2>
		        <hr>
				«entry('''
						icon_forum.png
					''','''
						Need Help?
					''','''
						http://www.eclipse.org/forums/index.php?t=thread&frm_id=27
					''','''
						The Xtext forum is the first source for getting answers in case you got stuck.
						The community is very friendly and you'll get help shortly if you ask your question
						clearly and in a way that other can easily follow or even reproduce the situation.
					''')»
				«entry('''
						icon_bugzilla.png
					''','''
						Found a Bug?
					''','''
						https://bugs.eclipse.org/bugs/buglist.cgi?query_format=advanced&short_desc_type=allwordssubstr&short_desc=&classification=Modeling&product=TMF&component=Xtext&long_desc_type=allwordssubstr&long_desc=&bug_file_loc_type=allwordssubstr&bug_file_loc=&status_whiteboard_type=allwordssubstr&status_whiteboard=&keywords_type=allwords&keywords=&bug_status=NEW&bug_status=ASSIGNED&bug_status=REOPENED&emailtype1=exact&email1=&emailtype2=substring&email2=&bugidtype=include&bug_id=&votes=&chfieldfrom=&chfieldto=Now&chfieldvalue=&cmdtype=doit&order=Reuse+same+sort+as+last+time&field0-0-0=noop&type0-0-0=noop&value0-0-0=
					''','''
						The Xtext forum is the first source for getting answers in case you got stuck.
						The community is very friendly and you'll get help shortly if you ask your question
						clearly and in a way that other can easily follow or even reproduce the situation.
					''')»
				«entry('''
						icon_twitter.png
					''','''
						Xtext on Twitter
					''','''
						http://www.eclipse.org/forums/index.php?t=thread&frm_id=27
					''','''
						The Xtext forum is the first source for getting answers in case you got stuck.
						The community is very friendly and you'll get help shortly if you ask your question
						clearly and in a way that other can easily follow or even reproduce the situation.
					''')»
				«entry('''
						icon_prof_support.png
					''','''
						Professional Support
					''','''
						http://xtext.itemis.com
					''','''
						The Xtext forum is the first source for getting answers in case you got stuck.
						The community is very friendly and you'll get help shortly if you ask your question
						clearly and in a way that other can easily follow or even reproduce the situation.
					''')»
			</div>
		</div>
	'''
	
	def entry(String img, String title, String link, String description) '''
		<div class="row">
			<div class="span1">&nbsp;</div>
			<a href="«link.trim»" >
			<div class="span9 team">
			   	<div class="span3">
			   		<img src="images/«img.trim»" alt="image" class="image_left">
			    	<h5 class="resourcelink">«title.trim»</h5>
			 	</div>
				<div class="span4">
					<p>«description»</p>
				</div>
			</div>
			</a>
			<div class="span1">&nbsp;</div>
		</div>
	'''
}
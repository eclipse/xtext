<?php  																														require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/app.class.php");	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/nav.class.php"); 	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/menu.class.php"); 	$App 	= new App();	$Nav	= new Nav();	$Menu 	= new Menu();		include($App->getProjectCommon());    # All on the same line to unclutter the user's desktop'
	$pageTitle 		= "Xtext - New & Noteworthy";

	# Add page-specific Nav bars here
	# Format is Link text, link URL (can be http://www.someothersite.com/), target (_self, _blank), level (1, 2 or 3)
	#$Nav->addNavSeparator("Documentation", null);
	#$Nav->addCustomNav("HTML", "latest/xtext.html", "_self", 3);
	#$Nav->addCustomNav("PDF", "latest/xtext.pdf", "_blank", 3);
	
	$html  = '<div id="midcolumn">';
	$html .= file_get_contents('_new_and_noteworthy.html');
	$html .= "</div>";

	# Generate the web page
	$App->generatePage($theme, $Menu, $Nav, $pageAuthor, $pageKeywords, $pageTitle, $html);
?>

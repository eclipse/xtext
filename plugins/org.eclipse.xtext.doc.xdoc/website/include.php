<?php


	# Set the theme for your project's web pages.
	# See the Committer Tools "How Do I" for list of themes
	# https://dev.eclipse.org/committers/
	# Optional: defaults to system theme 
	$theme = "Nova";
	
	# Define your project-wide Nav bars here.
	# Format is Link text, link URL (can be http://www.someothersite.com/), target (_self, _blank), level (1, 2 or 3)
	# these are optional
	# $Nav->setLinkList(array());

	$pageTitle 		= "Xtext 2.3 Documentation";

	$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="code.css"/>' . "\n\t");
	$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="book.css"/>' . "\n\t");
	$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="novaAddon.css"/>' . "\n\t");

	$App->Promotion = TRUE;
	?>

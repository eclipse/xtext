#!/bin/bash

cat <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-eclipse/') <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-maven/') <(cat locations.properties) | cut -d "=" -f2- | while read -r line
do
	directory=$(echo $line | tr -d '\r')
	upstream=$(echo $directory/gradle/upstream-repositories.gradle)
	if [[ -e $upstream ]]
	then
		pushd $directory > /dev/null
		git show-branch "$1" &> /dev/null
		if [[ $? = 0 ]]
		then
			echo "Redirecting maven repositories in $upstream to $1"
			popd > /dev/null
			cat <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-eclipse/') <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-maven/') <(cat locations.properties)  | cut -d "=" -f2- | while read -r repo
			do
				repository=$(echo $repo | tr -d '\r')
				if [[ $directory != $repository ]]
				then
					logicalname=$(echo $repo | sed 's/^.*\/\(xtext-[^/]*\)\/.*$/\1/')
					pushd $repository > /dev/null
					if [[ $? = 0 ]]
					then
						sed -i '' "s%'http://services.typefox.io/open-source/jenkins/job/$logicalname/job/[^/]*/lastSuccessfulBuild/artifact/build/maven-repository/'%jenkinsPipelineRepo('$logicalname')%" $upstream
						if [[ $1 != master ]]
						then
							git show-branch "$1" &> /dev/null
							if [[ $? = 0 ]]
							then
								sed -i '' "s%jenkinsPipelineRepo('$logicalname')%'http://services.typefox.io/open-source/jenkins/job/$logicalname/job/$1/lastSuccessfulBuild/artifact/build/maven-repository/'%" $upstream
							fi
						fi
						popd > /dev/null
					fi
				fi
			done
		else
			popd > /dev/null
		fi
	fi
	targets=$(echo $directory/releng/*.target)
	if [[ -d $targets ]]
	then
		pushd $directory > /dev/null
		git show-branch "$1" &> /dev/null
		if [[ $? = 0 ]]
		then
			echo "Redirecting target platforms in $targets to $1"
			popd > /dev/null
			cat <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-eclipse/') <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-maven/') <(cat locations.properties)  | cut -d "=" -f2- | while read -r repo
			do
				repository=$(echo $repo | tr -d '\r')
				if [[ $directory != $repository ]]
				then
					logicalname=$(echo $repo | sed 's/^.*\/\(xtext-[^/]*\)\/.*$/\1/')
					pushd $repository > /dev/null
					if [[ $? = 0 ]]
					then
						sed -i '' "s%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/[^/]*/lastStableBuild/artifact/build/p2-repository/%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/master/lastStableBuild/artifact/build/p2-repository/%" $targets/*.target
						if [[ $1 != master ]]
						then
							git show-branch "$1" &> /dev/null
							if [[ $? = 0 ]]
							then
								sed -i '' "s%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/master/lastStableBuild/artifact/build/p2-repository/%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/$1/lastStableBuild/artifact/build/p2-repository/%" $targets/*.target
							fi
						fi
						popd > /dev/null
					fi
				fi
			done
		else
			popd > /dev/null
		fi
	fi	
	if [[ -d $directory ]]
	then
		pushd $directory > /dev/null
		git show-branch "$1" &> /dev/null
		if [[ $? = 0 ]]
		then
			popd > /dev/null
			find $directory -name pom.xml -type f -path '*.maven.parent/*' -print | while read -r pom
			do
				echo "Redirecting parent pom.xml files in $pom to $1"
				cat <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-eclipse/') <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-maven/') <(cat locations.properties)  | cut -d "=" -f2- | while read -r repo
				do
					repository=$(echo $repo | tr -d '\r')
					if [[ $directory != $repository ]]
					then
						logicalname=$(echo $repo | sed 's/^.*\/\(xtext-[^/]*\)\/.*$/\1/')
						pushd $repository > /dev/null
						if [[ $? = 0 ]]
						then
							sed -i '' "s%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/[^/]*/lastStableBuild/artifact/build/maven-repository/%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/\${branch_url_segment}/lastStableBuild/artifact/build/maven-repository/%" $pom
							if [[ $1 != master ]]
							then
								git show-branch "$1" &> /dev/null
								if [[ $? = 0 ]]
								then
									sed -i '' "s%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/\${branch_url_segment}/lastStableBuild/artifact/build/maven-repository/%http://services.typefox.io/open-source/jenkins/job/$logicalname/job/$1/lastStableBuild/artifact/build/maven-repository/%" $pom
								fi
							fi
							popd > /dev/null
						fi
					fi
				done
			done
		else
			popd > /dev/null
		fi
	fi							
done 

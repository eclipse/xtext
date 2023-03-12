pipeline {
  agent {
    kubernetes {
      inheritFrom 'centos-8'
    }
  }

  parameters {
    // see https://wiki.eclipse.org/Jenkins#JDK
    choice(name: 'JDK_VERSION', description: 'Which JDK should be used?', choices: [
       'temurin-jdk17-latest', 'temurin-jdk11-latest'
    ])
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'15'))
    disableConcurrentBuilds()
    timeout(time: 90, unit: 'MINUTES')
  }

  triggers {
    // only on master branch / 30 minutes before nightly sign-and-deploy
    cron(env.BRANCH_NAME == 'master' ? '20 21 * * *' : '')
    githubPush()
  }
  
  tools {
     maven "apache-maven-3.8.6"
     jdk "${params.JDK_VERSION}"
  }

  stages {
    stage('Initialize') {
      steps {
        script {
          properties([
            [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/eclipse/xtext-core/'],
            [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false]
          ])
          currentBuild.displayName = String.format("#%s(%s)", BUILD_NUMBER, javaVersion("${params.JDK_VERSION}"))
        }

        sh '''
          if [ -d ".git" ]; then
            git reset --hard
          fi
        '''
        
        dir('build') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
        dir('.m2/repository/org/eclipse/xtend') { deleteDir() }

        sh '''
          sed_inplace() {
              if [[ "$OSTYPE" == "darwin"* ]]; then
                  sed -i '' "$@"
              else
                  sed -i "$@" 
              fi    
          }
          
          targetfiles="$(find releng -type f -iname '*.target')"
          for targetfile in $targetfiles
          do
              echo "Redirecting target platforms in $targetfile to $JENKINS_URL"
              sed_inplace "s?<repository location=\\".*/job/\\([^/]*\\)/job/\\([^/]*\\)/?<repository location=\\"$JENKINS_URL/job/\\1/job/\\2/?" $targetfile
          done
        '''
      }
    }

    stage('Maven Tycho P2 Repo and Sign') {
      steps {
        sh '''
          mvn \
            -f org.eclipse.xtext.p2.releng \
            clean package \
            -PuseJenkinsSnapshots \
            -P eclipse-sign,buildP2Repository \
            --batch-mode \
            --update-snapshots \
            -fae \
            -Dmaven.repo.local=$WORKSPACE/.m2/repository
        '''
      }
    }
  }

  post {
    success {
      archiveArtifacts artifacts: 'build/**'
      script {
        // For release builds trigger releng/sign-and-deploy
        def RELEASE_TYPE = getReleaseType ()
        if (RELEASE_TYPE != "Integration" ) {
          build job: 'releng/sign-and-deploy',
            parameters: [
              string(name: 'RELEASE_TYPE', value: "${RELEASE_TYPE}"),
              string(name: 'BRANCH_TO_DEPLOY', value: "${env.BRANCH_NAME}")
            ],
          wait: false
        }
      }
    }
    failure {
      archiveArtifacts artifacts: '**/target/work/data/.metadata/.log, **/hs_err_pid*.log'
    }
    cleanup {
      script {
        def curResult = currentBuild.currentResult
        def lastResult = 'NEW'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }

        if (curResult != 'SUCCESS' || lastResult != 'SUCCESS') {
          def color = ''
          switch (curResult) {
            case 'SUCCESS':
              color = '#00FF00'
              break
            case 'UNSTABLE':
              color = '#FFFF00'
              break
            case 'FAILURE':
              color = '#FF0000'
              break
            default: // e.g. ABORTED
              color = '#666666'
          }

          slackSend (
            message: "${lastResult} => ${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>",
            botUser: true,
            channel: 'xtext-builds',
            color: "${color}"
          )
        }
      }
    }
  }
}

/**
 * Determine the RELEASE_TYPE argument for downstream job releng/sign-and-deploy depending on current branch.
 */
def getReleaseType () {
  if (env.BRANCH_NAME.startsWith("release_")) {
    return "GA"
  } else if (env.BRANCH_NAME.startsWith("milestone_")) {
    return env.BRANCH_NAME.substring(env.BRANCH_NAME.lastIndexOf('.')+1)
  } else {
    return "Integration"
  }
}

def javaVersion(String version) {
  if (!version.contains('-jdk')) {
    return 'jdk15'
  } else {
    return version.replaceAll(".*-(jdk\\d+).*", "\$1")
  }
}

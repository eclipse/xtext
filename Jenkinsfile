pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr:'5'))
    disableConcurrentBuilds()
    timeout(time: 60, unit: 'MINUTES')
    timestamps()
  }

  // https://jenkins.io/doc/book/pipeline/syntax/#triggers
  triggers {
    pollSCM('H 2 * * *')
  }

  tools { 
    maven 'M3'
  }

  stages {
    stage('Prepare') {
      steps {
        sh '''
          if [ -d ".git" ]; then
          	git reset --hard
          fi
        '''
        checkout scm
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

    stage('Maven Build') {
      steps {
        sh '''
          mvn -f releng --batch-mode --update-snapshots -fae -Dtycho.disableP2Mirrors=true -Dmaven.repo.local=.m2/repository clean install
        '''
      }
    }
  }

  post {
    success {
      archiveArtifacts artifacts: 'build/**'
    }
    changed {
      script {
        def envName = ''
        if (env.JENKINS_URL.contains('ci.eclipse.org/xtext')) {
          envName = ' (JIPP)'
        } else if (env.JENKINS_URL.contains('typefox.io')) {
          envName = ' (TF)'
        }
        
        def curResult = currentBuild.currentResult
        def color = '#00FF00'
        if (curResult == 'SUCCESS') {
           if (currentBuild.previousBuild != null && currentBuild.previousBuild.result != 'SUCCESS') {
             curResult = 'FIXED'
           }
        } else if (curResult == 'UNSTABLE') {
          color = '#FFFF00'
        } else { // FAILURE, ABORTED, NOT_BUILD
          color = '#FF0000'
        }
        
        slackSend message: "${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}${envName}>", botUser: true, channel: 'xtext-builds', color: "${color}"
      }
    }
  }
}

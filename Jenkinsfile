// -------------------------------------------------------------------------------------------------------
// -- Mantenimiento: César Garcia - cgarciam@tigo.com.gt
//   -- Proyecto: WS Datos work order AS400
//   -- Recursos: Cesar Garcia
//   -- Empresa: CGM Soluciones
//   -- Arquitecto; Rony Ceron - rceron@tigo.com.gt
//
// -- Características:
//                     -- Obtiene el código del repositorio git
//                     -- Compila y Construye con Maven
//                     -- Almacena el artefacto de despliegue en Artifactory 
// -------------------------------------------------------------------------------------------------------

pipeline {
  agent any 
  tools {nodejs "NodeJS_14.4.0"}
  stages {
  
		stage('Git') {
		  steps {
			script {	  
			  echo 'Clonando Repositorio de WebServiceGetDataAS400 ' + env.BRANCH_NAME
			   git(url: 'https://gitlab-bsd.tigo.com.gt/BSD-APPS/Instalaciones-Tecnicas/WebServiceGetDataAS400/src.git', branch:  env.BRANCH_NAME, credentialsId: '47c6893c-a3cf-4190-9e9c-3eec2782d5d6')
			}
		  }
		}

		stage('Compilar') {
			steps {
				script {
					def mvnHome = tool 'MavenBSD'
					env.PATH = "${mvnHome}/bin:${env.PATH}"
					echo "var mvnHome='${mvnHome}'"
					echo "var env.PATH='${env.PATH}'"
					
					
					echo 'empaquetando WebServiceGetDataAS400...'
					
					dir('webservice') {
						sh 'pwd'
						sh 'mvn package'
						sh "ls target/"
					}
					
				}
			}
		}
		
		
		stage('SonarQube WebServiceGetDataAS400-api Analysis') {
			steps {
				script {
					// requires SonarQube Scanner 2.8+
					scannerHome = tool 'Sonar'
				}
				withSonarQubeEnv('SonarQube_BSD') {
				    sh "${scannerHome}/bin/sonar-scanner \
				    -Dsonar.projectKey=WebServiceGetDataAS400 \
				    -Dsonar.projectName=WebServiceGetDataAS400 \
				    -Dsonar.java.binaries=webservice/target/classes \
				    -Dsonar.projectVersion=1.4 \
				    -Dsonar.sources=webservice/"
				}
			}
		}
		

		stage('Save Artifactory') {
			steps {
				script {
					def server = Artifactory.server 'ArtifactoryBSD'			
					
					if (env.BRANCH_NAME=='dev') {
						echo 'Almacenando el artefacto para despliegue de '+env.BRANCH_NAME
							
						
						def uploadBackendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/nicas_WebServiceGetDataAS400_dev/webservice/target/*.war",
									"target": "BSD-INSTALACIONES-TECNICAS/"
								}
							]
						}"""
						server.upload(uploadBackendSpec)
					}
					
					if (env.BRANCH_NAME=='master') {
						echo 'Almacenando el artefacto para despliegue de '+env.BRANCH_NAME		   
							
						
						def uploadBackendSpec = """{
							"files": [
								{
									"pattern": "/var/jenkins_home/workspace/nicas_WebServiceGetDataAS400_dev/webservice/target/*.war",
									"target": "BSD-INSTALACIONES-TECNICAS/"
								}
							]
						}"""
						server.upload(uploadBackendSpec)
					}			   
				}
			}
		}



  }
	post {
		success {
			echo 'Exitoso!'
			mail to: 'cgarciam@tigo.com.gt,rceron@tigo.com.gt',
			subject: "Despliegue Exitoso: ${currentBuild.fullDisplayName}",
			body: "El despliegue en el ambiente de ${env.BRANCH_NAME} ha finalizado con éxito"			
		}
		unstable {
			echo 'I am unstable :/'
			mail to: 'cgarciam@tigo.com.gt,rceron@tigo.com.gt',
			subject: "unstable Pipeline: ${currentBuild.fullDisplayName}",
			body: "El despliegue en el ambiente ${env.BRANCH_NAME} ha generado un error"			
		}
		failure {
			echo 'Despliegue fallido: ${currentBuild.fullDisplayName}'
			mail to: 'cgarciam@tigo.com.gt,rceron@tigo.com.gt',
			subject: "failure Pipeline: ${currentBuild.fullDisplayName}",
			body: "El despliegue en el ambiente ${env.BRANCH_NAME} del proyecto ${env.PROJECT_NAME} ha generaro un error, favor repotarlo a cgarciam@tigo.com.gt o rceron@tigo.com.gt"				
		}
	}  
}

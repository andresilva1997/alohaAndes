# Tutorial Arquitectura y REST #
----
### ISIS2304 - Sistemas Transaccionales ###

***Departamento de Ingenieria de Sistemas***

***Universidad de los Andes, Bogotá, Colombia***

Autores:
* Santiago Cortes Fernandez
* Juan David Vega Guzman

----
## Objetivo ##

En este repositorio, se encuentra el esqueleto del tutorial sobre la infraestructura del proyecto del curso Sistemas Transaccionales. Dentro del tutorial, se realizan algunas actividades con el el fin de losgrar los siguientes objetivos:

* Entender la estructura y arquitectura del proyecto.
  * Comprender la funcionalidad de cada una de las clases, al igual que sus diferencias y responsabilidades.
  * Saber cómo ejecutar el proyecto utilizando plug-in's de Red Hat (JBoss, WildFly).
  
* Aprender los conocimientos básicos para utilizar servicios REST.
  * Entender convenciones y anotaciones para el uso de funcionalidades CRUD.
  * Realizar pruebas mediante el uso de la aplicación POSTMAN.

----
## Instalacion JBOSS DEVELOPER STUDIO en Eclipse ##

Debido a la necesidad de poder correr el proyecto en su computador personal, tanto para la realización del tutorial como la las iteraciones del curso, es necesario instalar el plug-in ***Jboss Developer Studio v 10.4.GA*** en el IDE de eclipse que esté utilizando, ya que este le permite ejecutar proyectos proveedores de servicios en alguno de los servidores de Red Hat (Jboss EAP, WildFLy, etc.). Para ello, se recomienda leer el [Capitulo 3.1 de la Guía de Instalación de Jboss Developer Studio](https://access.redhat.com/documentation/en-us/red_hat_jboss_developer_studio/10.4/html/installation_guide/in_eclipse#eclipse_online) para facilitar evitar deficultades tecnológicas durante el transcurso del semestre.

## Descarga del Servidor WildFly y Configuracion en el IDE ##
Luego de instalar el plugin de ***Jboss Developer Studio v 10.4.GA*** en el IDE de eclipse, también es necesario realizar la descarga del servidor ***WildFly v 10.1.0.Final*** para poder desplegar el proyecto correctamente. Para ello, se recomienda descargar dicho servidor del [siguiente vínculo](http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.zip) o leyendo el [Capítulo 2.1.3 de la guía de uso *Getting Started with JBoss Developer Studio Tools*](https://access.redhat.com/documentation/en-us/red_hat_jboss_developer_studio/10.4/html/getting_started_with_jboss_developer_studio_tools/developing_first_applications_with_jboss_developer_studio_tools#FromWithinJBDS).

**Recomendación:** Antes de configurar el servidor para sus ejecución en el IDE, ubique el servidor en una parte específica de su directorio y evite moverlo de dicho lugar, debido a que al modificar la ubicacion de este se pueden generar errores y dificultades para el despliegue del proyecto durante el semestre.
# alohaAndes

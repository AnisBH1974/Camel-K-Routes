
import groovy.json.JsonSlurper
import org.apache.camel.Exchange

def jsonSlurper = new JsonSlurper()
def json = jsonSlurper.parseText(exchange.getIn().getBody(String.class))

//def json = jsonSlurper.parse(new File( "./result_Paris.json"))


// Process result
//println "ex = " + exchange.getIn().getBody(String.class)
//println "name = ${json.name}"
//println "temp = ${json.main.temp}"
//println "weather = ${json.weather.main[0]}" // Rain, Clouds, Snow, Clear

def weather = "${json.weather.main[0]}"

if( weather=="Rain" )  weather = "rainy"  
if( weather == "Clouds" )  weather = "cloudy" 
if( weather == "Clear" ) weather = "sunny"

String payload = """
{
  "Country": {
    "countryName": "France"
  },
  "City": {
    "id": "Id_""" + "${json.name}" + """\",
    "name": \"""" + "${json.name}" + """\",
    "temperature": \"""" + "${json.main.temp}" + """°\",
    "color": "white",
    "condition": \"""" + weather + """\"
  }
}"""

exchange.getOut().setHeader(Exchange.HTTP_METHOD, HttpMethod.POST);
exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/json");
exchange.getOut().setHeader("Accept", "application/json");
/* this is one way, string representation of json, but maybe you can try to build Model and fill that model with data */
exchange.getIn().setBody(payload ); //

